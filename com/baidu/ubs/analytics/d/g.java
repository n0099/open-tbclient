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
    private static String[] jxF = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File jxG = null;
    private static RandomAccessFile jxH = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (csO() && f(str2, str3)) {
                try {
                    jxG = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(jxG, "rwd");
                    jxH = randomAccessFile;
                    randomAccessFile.seek(jxG.length());
                    jxH.write((str + "\r\n").getBytes(HTTP.UTF_8));
                    jxH.close();
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
                if (Fb(str + str2)) {
                    try {
                        jxG = new File(str + str2);
                        jxH = new RandomAccessFile(jxG, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = jxH.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            jxH.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            jxH.close();
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
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.csq().getContext().checkCallingOrSelfPermission(jxF[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean Fb(String str) {
        File file = new File(str);
        jxG = file;
        return file.exists();
    }

    public static boolean Fc(String str) {
        File file = new File(str);
        jxG = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            jxG = new File(str);
            if (!Fb(str)) {
                jxG.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            jxG = file;
            if (file.exists()) {
                return true;
            }
            return jxG.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
