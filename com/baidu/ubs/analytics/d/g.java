package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes8.dex */
public final class g {
    private static String[] lPh = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File lPi = null;
    private static RandomAccessFile lPj = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (dlx() && f(str2, str3)) {
                try {
                    lPi = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(lPi, "rwd");
                    lPj = randomAccessFile;
                    randomAccessFile.seek(lPi.length());
                    lPj.write((str + "\r\n").getBytes("UTF-8"));
                    lPj.close();
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
            if (dlx()) {
                if (NI(str + str2)) {
                    try {
                        lPi = new File(str + str2);
                        lPj = new RandomAccessFile(lPi, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = lPj.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            lPj.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            lPj.close();
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

    private static boolean dlx() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.dkU().getContext().checkCallingOrSelfPermission(lPh[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean NI(String str) {
        File file = new File(str);
        lPi = file;
        return file.exists();
    }

    public static boolean NJ(String str) {
        File file = new File(str);
        lPi = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            lPi = new File(str);
            if (!NI(str)) {
                lPi.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            lPi = file;
            if (file.exists()) {
                return true;
            }
            return lPi.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
