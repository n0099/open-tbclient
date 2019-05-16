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
    private static String[] jQl = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File jQm = null;
    private static RandomAccessFile jQn = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (cAL() && f(str2, str3)) {
                try {
                    jQm = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(jQm, "rwd");
                    jQn = randomAccessFile;
                    randomAccessFile.seek(jQm.length());
                    jQn.write((str + "\r\n").getBytes(HTTP.UTF_8));
                    jQn.close();
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
            if (cAL()) {
                if (Gv(str + str2)) {
                    try {
                        jQm = new File(str + str2);
                        jQn = new RandomAccessFile(jQm, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = jQn.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            jQn.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            jQn.close();
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

    private static boolean cAL() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.cAl().getContext().checkCallingOrSelfPermission(jQl[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean Gv(String str) {
        File file = new File(str);
        jQm = file;
        return file.exists();
    }

    public static boolean Gw(String str) {
        File file = new File(str);
        jQm = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            jQm = new File(str);
            if (!Gv(str)) {
                jQm.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            jQm = file;
            if (file.exists()) {
                return true;
            }
            return jQm.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
