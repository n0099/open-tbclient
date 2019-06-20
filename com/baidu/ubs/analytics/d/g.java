package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public final class g {
    private static String[] jQp = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File jQq = null;
    private static RandomAccessFile jQr = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (cAM() && f(str2, str3)) {
                try {
                    jQq = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(jQq, "rwd");
                    jQr = randomAccessFile;
                    randomAccessFile.seek(jQq.length());
                    jQr.write((str + "\r\n").getBytes(HTTP.UTF_8));
                    jQr.close();
                    z = true;
                } catch (Exception e) {
                    j.b(e);
                }
            }
        }
        return z;
    }

    public static synchronized String M(String str, String str2) {
        String str3;
        synchronized (g.class) {
            if (cAM()) {
                if (Gx(str + str2)) {
                    try {
                        jQq = new File(str + str2);
                        jQr = new RandomAccessFile(jQq, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = jQr.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            jQr.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            jQr.close();
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

    private static boolean cAM() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.cAm().getContext().checkCallingOrSelfPermission(jQp[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean Gx(String str) {
        File file = new File(str);
        jQq = file;
        return file.exists();
    }

    public static boolean Gy(String str) {
        File file = new File(str);
        jQq = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            jQq = new File(str);
            if (!Gx(str)) {
                jQq.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            jQq = file;
            if (file.exists()) {
                return true;
            }
            return jQq.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
