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
    private static String[] jxN = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File jxO = null;
    private static RandomAccessFile jxP = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (csL() && f(str2, str3)) {
                try {
                    jxO = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(jxO, "rwd");
                    jxP = randomAccessFile;
                    randomAccessFile.seek(jxO.length());
                    jxP.write((str + "\r\n").getBytes(HTTP.UTF_8));
                    jxP.close();
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
            if (csL()) {
                if (Fd(str + str2)) {
                    try {
                        jxO = new File(str + str2);
                        jxP = new RandomAccessFile(jxO, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = jxP.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            jxP.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            jxP.close();
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

    private static boolean csL() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.csn().getContext().checkCallingOrSelfPermission(jxN[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean Fd(String str) {
        File file = new File(str);
        jxO = file;
        return file.exists();
    }

    public static boolean Fe(String str) {
        File file = new File(str);
        jxO = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            jxO = new File(str);
            if (!Fd(str)) {
                jxO.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            jxO = file;
            if (file.exists()) {
                return true;
            }
            return jxO.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
