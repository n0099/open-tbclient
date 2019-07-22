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
    private static String[] jXq = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File jXr = null;
    private static RandomAccessFile jXs = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (cDL() && f(str2, str3)) {
                try {
                    jXr = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(jXr, "rwd");
                    jXs = randomAccessFile;
                    randomAccessFile.seek(jXr.length());
                    jXs.write((str + "\r\n").getBytes(HTTP.UTF_8));
                    jXs.close();
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
            if (cDL()) {
                if (Hr(str + str2)) {
                    try {
                        jXr = new File(str + str2);
                        jXs = new RandomAccessFile(jXr, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = jXs.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            jXs.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            jXs.close();
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

    private static boolean cDL() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.cDk().getContext().checkCallingOrSelfPermission(jXq[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean Hr(String str) {
        File file = new File(str);
        jXr = file;
        return file.exists();
    }

    public static boolean Hs(String str) {
        File file = new File(str);
        jXr = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            jXr = new File(str);
            if (!Hr(str)) {
                jXr.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            jXr = file;
            if (file.exists()) {
                return true;
            }
            return jXr.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
