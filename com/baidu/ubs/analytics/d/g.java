package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes8.dex */
public final class g {
    private static String[] lPd = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File lPe = null;
    private static RandomAccessFile lPf = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (dlz() && f(str2, str3)) {
                try {
                    lPe = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(lPe, "rwd");
                    lPf = randomAccessFile;
                    randomAccessFile.seek(lPe.length());
                    lPf.write((str + "\r\n").getBytes("UTF-8"));
                    lPf.close();
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
            if (dlz()) {
                if (NF(str + str2)) {
                    try {
                        lPe = new File(str + str2);
                        lPf = new RandomAccessFile(lPe, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = lPf.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            lPf.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            lPf.close();
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

    private static boolean dlz() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.dkW().getContext().checkCallingOrSelfPermission(lPd[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean NF(String str) {
        File file = new File(str);
        lPe = file;
        return file.exists();
    }

    public static boolean NG(String str) {
        File file = new File(str);
        lPe = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            lPe = new File(str);
            if (!NF(str)) {
                lPe.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            lPe = file;
            if (file.exists()) {
                return true;
            }
            return lPe.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
