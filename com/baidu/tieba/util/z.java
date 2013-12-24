package com.baidu.tieba.util;

import com.baidu.tieba.TiebaApplication;
import java.io.File;
/* loaded from: classes.dex */
public class z {
    public static final String a = TiebaApplication.h().getFileStreamPath("").getAbsolutePath();

    public static boolean a(String str) {
        try {
            return new File(new StringBuilder().append(a).append("/").append(str).toString()).exists();
        } catch (Exception e) {
            be.b("FileHelper", "checkFile", "error = " + e.getMessage());
            return false;
        }
    }

    public static boolean b(String str) {
        try {
            File file = new File(a + "/" + str);
            if (file.exists()) {
                return false;
            }
            return file.createNewFile();
        } catch (Exception e) {
            be.b("FileHelper", "createFile", "error = " + e.getMessage());
            return false;
        }
    }

    public static void a(File file) {
        try {
            if (file.exists()) {
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    int length = listFiles.length;
                    for (int i = 0; i < length; i++) {
                        if (listFiles[i].isFile()) {
                            listFiles[i].delete();
                        } else {
                            a(listFiles[i]);
                        }
                    }
                }
                file.delete();
            }
        } catch (Exception e) {
            be.b("FileHelper", "deleteFileOrDir", "error = " + e.getMessage());
        }
    }

    public static boolean c(String str) {
        try {
            File file = new File(a + "/" + str);
            if (file.exists()) {
                if (!file.isDirectory()) {
                    return false;
                }
                a(file);
            }
            return file.mkdirs();
        } catch (Exception e) {
            be.b("FileHelper", "cleanDirectory", "error = " + e.getMessage());
            return false;
        }
    }

    public static String d(String str) {
        String str2 = null;
        try {
            File file = new File(a + "/" + str);
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                int length = listFiles.length;
                long j = 0;
                for (int i = 0; i < length; i++) {
                    if (j > listFiles[i].lastModified()) {
                        j = listFiles[i].lastModified();
                        str2 = listFiles[i].getName();
                    }
                }
            }
        } catch (Exception e) {
            be.b("FileHelper", "getLatestFileName", "error = " + e.getMessage());
        }
        return str2;
    }
}
