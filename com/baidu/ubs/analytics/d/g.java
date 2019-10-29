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
    private static String[] jYT = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File jYU = null;
    private static RandomAccessFile jYV = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (cBH() && f(str2, str3)) {
                try {
                    jYU = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(jYU, "rwd");
                    jYV = randomAccessFile;
                    randomAccessFile.seek(jYU.length());
                    jYV.write((str + "\r\n").getBytes(HTTP.UTF_8));
                    jYV.close();
                    z = true;
                } catch (Exception e) {
                    j.b(e);
                }
            }
        }
        return z;
    }

    public static synchronized String E(String str, String str2) {
        String str3;
        synchronized (g.class) {
            if (cBH()) {
                if (Gj(str + str2)) {
                    try {
                        jYU = new File(str + str2);
                        jYV = new RandomAccessFile(jYU, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = jYV.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            jYV.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            jYV.close();
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

    private static boolean cBH() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.cBd().getContext().checkCallingOrSelfPermission(jYT[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean Gj(String str) {
        File file = new File(str);
        jYU = file;
        return file.exists();
    }

    public static boolean Gk(String str) {
        File file = new File(str);
        jYU = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            jYU = new File(str);
            if (!Gj(str)) {
                jYU.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            jYU = file;
            if (file.exists()) {
                return true;
            }
            return jYU.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
