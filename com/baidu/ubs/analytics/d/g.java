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
    private static String[] jxu = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File jxv = null;
    private static RandomAccessFile jxw = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (csO() && f(str2, str3)) {
                try {
                    jxv = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(jxv, "rwd");
                    jxw = randomAccessFile;
                    randomAccessFile.seek(jxv.length());
                    jxw.write((str + "\r\n").getBytes(HTTP.UTF_8));
                    jxw.close();
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
                        jxv = new File(str + str2);
                        jxw = new RandomAccessFile(jxv, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = jxw.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            jxw.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            jxw.close();
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
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.cso().getContext().checkCallingOrSelfPermission(jxu[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean Fa(String str) {
        File file = new File(str);
        jxv = file;
        return file.exists();
    }

    public static boolean Fb(String str) {
        File file = new File(str);
        jxv = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            jxv = new File(str);
            if (!Fa(str)) {
                jxv.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            jxv = file;
            if (file.exists()) {
                return true;
            }
            return jxv.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
