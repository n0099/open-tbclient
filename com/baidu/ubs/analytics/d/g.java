package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes8.dex */
public final class g {
    private static String[] kWJ = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File kWK = null;
    private static RandomAccessFile kWL = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (cXQ() && f(str2, str3)) {
                try {
                    kWK = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(kWK, "rwd");
                    kWL = randomAccessFile;
                    randomAccessFile.seek(kWK.length());
                    kWL.write((str + "\r\n").getBytes("UTF-8"));
                    kWL.close();
                    z = true;
                } catch (Exception e) {
                    j.b(e);
                }
            }
        }
        return z;
    }

    public static synchronized String P(String str, String str2) {
        String str3;
        synchronized (g.class) {
            if (cXQ()) {
                if (Lw(str + str2)) {
                    try {
                        kWK = new File(str + str2);
                        kWL = new RandomAccessFile(kWK, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = kWL.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            kWL.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            kWL.close();
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

    private static boolean cXQ() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.cXm().getContext().checkCallingOrSelfPermission(kWJ[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean Lw(String str) {
        File file = new File(str);
        kWK = file;
        return file.exists();
    }

    public static boolean Lx(String str) {
        File file = new File(str);
        kWK = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            kWK = new File(str);
            if (!Lw(str)) {
                kWK.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            kWK = file;
            if (file.exists()) {
                return true;
            }
            return kWK.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
