package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes6.dex */
public final class g {
    private static String[] kVY = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File kVZ = null;
    private static RandomAccessFile kWa = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (cWA() && f(str2, str3)) {
                try {
                    kVZ = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(kVZ, "rwd");
                    kWa = randomAccessFile;
                    randomAccessFile.seek(kVZ.length());
                    kWa.write((str + "\r\n").getBytes("UTF-8"));
                    kWa.close();
                    z = true;
                } catch (Exception e) {
                    j.b(e);
                }
            }
        }
        return z;
    }

    public static synchronized String K(String str, String str2) {
        String str3;
        synchronized (g.class) {
            if (cWA()) {
                if (Lj(str + str2)) {
                    try {
                        kVZ = new File(str + str2);
                        kWa = new RandomAccessFile(kVZ, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = kWa.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            kWa.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            kWa.close();
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

    private static boolean cWA() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.cVW().getContext().checkCallingOrSelfPermission(kVY[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean Lj(String str) {
        File file = new File(str);
        kVZ = file;
        return file.exists();
    }

    public static boolean Lk(String str) {
        File file = new File(str);
        kVZ = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            kVZ = new File(str);
            if (!Lj(str)) {
                kVZ.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            kVZ = file;
            if (file.exists()) {
                return true;
            }
            return kVZ.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
