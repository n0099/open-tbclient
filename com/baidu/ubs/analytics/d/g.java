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
    private static String[] jxv = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File jxw = null;
    private static RandomAccessFile jxx = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (csO() && f(str2, str3)) {
                try {
                    jxw = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(jxw, "rwd");
                    jxx = randomAccessFile;
                    randomAccessFile.seek(jxw.length());
                    jxx.write((str + "\r\n").getBytes(HTTP.UTF_8));
                    jxx.close();
                    z = true;
                } catch (Exception e) {
                    j.b(e);
                }
            }
        }
        return z;
    }

    public static synchronized String S(String str, String str2) {
        String str3;
        synchronized (g.class) {
            if (csO()) {
                if (Fa(str + str2)) {
                    try {
                        jxw = new File(str + str2);
                        jxx = new RandomAccessFile(jxw, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = jxx.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            jxx.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            jxx.close();
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

    private static boolean csO() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.cso().getContext().checkCallingOrSelfPermission(jxv[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean Fa(String str) {
        File file = new File(str);
        jxw = file;
        return file.exists();
    }

    public static boolean Fb(String str) {
        File file = new File(str);
        jxw = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            jxw = new File(str);
            if (!Fa(str)) {
                jxw.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            jxw = file;
            if (file.exists()) {
                return true;
            }
            return jxw.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
