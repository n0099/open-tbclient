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
    private static String[] jQm = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File jQn = null;
    private static RandomAccessFile jQo = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (cAN() && f(str2, str3)) {
                try {
                    jQn = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(jQn, "rwd");
                    jQo = randomAccessFile;
                    randomAccessFile.seek(jQn.length());
                    jQo.write((str + "\r\n").getBytes(HTTP.UTF_8));
                    jQo.close();
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
            if (cAN()) {
                if (Gv(str + str2)) {
                    try {
                        jQn = new File(str + str2);
                        jQo = new RandomAccessFile(jQn, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = jQo.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            jQo.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            jQo.close();
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

    private static boolean cAN() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.cAn().getContext().checkCallingOrSelfPermission(jQm[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean Gv(String str) {
        File file = new File(str);
        jQn = file;
        return file.exists();
    }

    public static boolean Gw(String str) {
        File file = new File(str);
        jQn = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            jQn = new File(str);
            if (!Gv(str)) {
                jQn.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            jQn = file;
            if (file.exists()) {
                return true;
            }
            return jQn.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
