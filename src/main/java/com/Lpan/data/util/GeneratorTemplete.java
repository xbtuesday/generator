package com.Lpan.data.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class GeneratorTemplete {
		public static void main(String[] args) {
			 List<String> warnings = new ArrayList<String>();
	           boolean overwrite = true;
	           
	           ConfigurationParser cp = new ConfigurationParser(warnings);
	            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
	            InputStream is = classloader.getResourceAsStream("mybatis-generator-config.xml");				//�����Ǽ���mybatis generator�Զ����ɵ������ļ���ע���ļ�����ҪŪ��
	           Configuration config;
	           try {
				config = cp.parseConfiguration(is);
				    DefaultShellCallback callback = new DefaultShellCallback(overwrite);
				       MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
				       myBatisGenerator.generate(null);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (XMLParserException e) {
				e.printStackTrace();
			} catch (InvalidConfigurationException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
}
