package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes8.dex */
public final class g {
    private static String[] kYB = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File kYC = null;
    private static RandomAccessFile kYD = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (cYq() && f(str2, str3)) {
                try {
                    kYC = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(kYC, "rwd");
                    kYD = randomAccessFile;
                    randomAccessFile.seek(kYC.length());
                    kYD.write((str + "\r\n").getBytes("UTF-8"));
                    kYD.close();
                    z = true;
                } catch (Exception e) {
                    j.b(e);
                }
            }
        }
        return z;
    }

    public static synchronized String O(String str, String str2) {
        String str3;
        synchronized (g.class) {
            if (cYq()) {
                if (Lx(str + str2)) {
                    try {
                        kYC = new File(str + str2);
                        kYD = new RandomAccessFile(kYC, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = kYD.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            kYD.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            kYD.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
                str3 = "";
            } else {
                str3 = "";
            }
        }
        return str3;
    }

    private static boolean cYq() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.cXN().getContext().checkCallingOrSelfPermission(kYB[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean Lx(String str) {
        File file = new File(str);
        kYC = file;
        return file.exists();
    }

    public static boolean Ly(String str) {
        File file = new File(str);
        kYC = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            kYC = new File(str);
            if (!Lx(str)) {
                kYC.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            kYC = file;
            if (file.exists()) {
                return true;
            }
            return kYC.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
