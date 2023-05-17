package com.baidu.webkit.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
/* loaded from: classes8.dex */
public class FileUtils {
    public static final String TAG = "FileUtils";
    public static String sFileRwErrorDetail;

    static {
        try {
            System.loadLibrary("zeuslzma");
        } catch (Throwable th) {
            Log.e("FileUtils", "failed to load lzma library: ".concat(String.valueOf(th)));
        }
        sFileRwErrorDetail = "none";
    }

    public static String checkTimestamp(Context context, String str, String str2) {
        if (str == null) {
            return str2;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo == null) {
                return str2;
            }
            return checkTimestamp(str, str2, packageInfo.versionCode + "-" + packageInfo.lastUpdateTime);
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return str2;
        }
    }

    public static String checkTimestamp(String str, final String str2, String str3) {
        String[] list;
        String str4 = str2 + str3;
        File file = new File(str);
        if (file.exists() && file.isDirectory() && (list = file.list(new FilenameFilter() { // from class: com.baidu.webkit.sdk.FileUtils.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str5) {
                return str5.startsWith(str2);
            }
        })) != null) {
            for (int i = 0; i < list.length; i++) {
                if (str4.equals(list[i])) {
                    return null;
                }
                new File(file, list[i]).delete();
            }
            return str4;
        }
        return str4;
    }

    public static void clearTimestamp(Context context, String str, final String str2) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            String[] list = file.list(new FilenameFilter() { // from class: com.baidu.webkit.sdk.FileUtils.2
                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str3) {
                    return str3.startsWith(str2);
                }
            });
            for (String str3 : list) {
                new File(file, str3).delete();
            }
        }
    }

    public static boolean copyFile(String str, String str2) {
        FileOutputStream fileOutputStream;
        File parentFile;
        byte[] bArr = new byte[4096];
        if (str == null || str2 == null) {
            setFileRwErrorDetail("copy file fail, from = " + str + ", to = " + str2);
            return false;
        }
        FileInputStream fileInputStream = null;
        try {
            File file = new File(str);
            File file2 = new File(str2);
            if (file.exists() && !file.isDirectory() && !file2.isDirectory()) {
                if (!file2.exists() && (parentFile = file2.getParentFile()) != null && !parentFile.exists() && !parentFile.mkdirs()) {
                    setFileRwErrorDetail("cannot mkdirs, path = " + parentFile.getAbsolutePath());
                    return false;
                }
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(str2);
                    while (true) {
                        try {
                            int read = fileInputStream2.read(bArr);
                            if (read > 0) {
                                fileOutputStream2.write(bArr, 0, read);
                            } else {
                                try {
                                    break;
                                } catch (Throwable unused) {
                                }
                            }
                        } catch (Throwable th) {
                            fileInputStream = fileInputStream2;
                            fileOutputStream = fileOutputStream2;
                            th = th;
                            try {
                                setFileRwErrorDetail(th.toString());
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                        return false;
                                    } catch (Throwable unused2) {
                                        return false;
                                    }
                                }
                                return false;
                            } finally {
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Throwable unused3) {
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Throwable unused4) {
                                    }
                                }
                            }
                        }
                    }
                    fileInputStream2.close();
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable unused5) {
                    }
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    fileInputStream = fileInputStream2;
                }
            }
            setFileRwErrorDetail("copy file fail, fileFrom.exists = " + file.exists() + ", fileFrom.isDirectory = " + file.isDirectory() + ", fileTo.isDirectory = " + file2.isDirectory());
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public static boolean deleteDir(File file, File file2) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            for (String str : file.list()) {
                if (!deleteDir(new File(file, str), file2)) {
                    return false;
                }
            }
        }
        if (file.equals(file2)) {
            return true;
        }
        return file.delete();
    }

    public static String getFileRwErrorDetailAndReset() {
        String str = sFileRwErrorDetail;
        sFileRwErrorDetail = "none";
        return str == null ? "none" : str;
    }

    public static boolean link(String str, String str2) {
        File parentFile;
        File file = new File(str2);
        return (file.isDirectory() || str2 == null || ((parentFile = file.getParentFile()) != null && !parentFile.exists() && !parentFile.mkdirs()) || nativeSymlink(str, str2) != 0) ? false : true;
    }

    public static native int nativeSymlink(String str, String str2);

    public static void setFileRwErrorDetail(String str) {
        sFileRwErrorDetail = str;
    }
}
