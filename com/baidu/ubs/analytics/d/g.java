package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes6.dex */
public final class g {
    private static String[] kWd = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File kWe = null;
    private static RandomAccessFile kWf = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (cWC() && f(str2, str3)) {
                try {
                    kWe = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(kWe, "rwd");
                    kWf = randomAccessFile;
                    randomAccessFile.seek(kWe.length());
                    kWf.write((str + "\r\n").getBytes("UTF-8"));
                    kWf.close();
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
            if (cWC()) {
                if (Lj(str + str2)) {
                    try {
                        kWe = new File(str + str2);
                        kWf = new RandomAccessFile(kWe, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = kWf.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            kWf.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            kWf.close();
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

    private static boolean cWC() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.cVY().getContext().checkCallingOrSelfPermission(kWd[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean Lj(String str) {
        File file = new File(str);
        kWe = file;
        return file.exists();
    }

    public static boolean Lk(String str) {
        File file = new File(str);
        kWe = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            kWe = new File(str);
            if (!Lj(str)) {
                kWe.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            kWe = file;
            if (file.exists()) {
                return true;
            }
            return kWe.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
