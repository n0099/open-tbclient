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
    private static String[] jYw = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File jYx = null;
    private static RandomAccessFile jYy = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (cEg() && f(str2, str3)) {
                try {
                    jYx = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(jYx, "rwd");
                    jYy = randomAccessFile;
                    randomAccessFile.seek(jYx.length());
                    jYy.write((str + "\r\n").getBytes(HTTP.UTF_8));
                    jYy.close();
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
            if (cEg()) {
                if (Hs(str + str2)) {
                    try {
                        jYx = new File(str + str2);
                        jYy = new RandomAccessFile(jYx, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = jYy.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            jYy.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            jYy.close();
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

    private static boolean cEg() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.cDF().getContext().checkCallingOrSelfPermission(jYw[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean Hs(String str) {
        File file = new File(str);
        jYx = file;
        return file.exists();
    }

    public static boolean Ht(String str) {
        File file = new File(str);
        jYx = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            jYx = new File(str);
            if (!Hs(str)) {
                jYx.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            jYx = file;
            if (file.exists()) {
                return true;
            }
            return jYx.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
