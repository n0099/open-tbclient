package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes10.dex */
public final class g {
    private static String[] orZ = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File osa = null;
    private static RandomAccessFile osb = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (eea() && f(str2, str3)) {
                try {
                    osa = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(osa, "rwd");
                    osb = randomAccessFile;
                    randomAccessFile.seek(osa.length());
                    osb.write((str + "\r\n").getBytes("UTF-8"));
                    osb.close();
                    z = true;
                } catch (Exception e) {
                    j.b(e);
                }
            }
        }
        return z;
    }

    public static synchronized String X(String str, String str2) {
        String str3;
        synchronized (g.class) {
            if (eea()) {
                if (Xb(str + str2)) {
                    try {
                        osa = new File(str + str2);
                        osb = new RandomAccessFile(osa, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = osb.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            osb.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            osb.close();
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

    private static boolean eea() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.edA().getContext().checkCallingOrSelfPermission(orZ[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean Xb(String str) {
        File file = new File(str);
        osa = file;
        return file.exists();
    }

    public static boolean Xc(String str) {
        File file = new File(str);
        osa = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            osa = new File(str);
            if (!Xb(str)) {
                osa.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            osa = file;
            if (file.exists()) {
                return true;
            }
            return osa.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
