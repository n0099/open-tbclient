package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes8.dex */
public final class g {
    private static String[] mjH = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File mjI = null;
    private static RandomAccessFile mjJ = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (dta() && f(str2, str3)) {
                try {
                    mjI = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(mjI, "rwd");
                    mjJ = randomAccessFile;
                    randomAccessFile.seek(mjI.length());
                    mjJ.write((str + "\r\n").getBytes("UTF-8"));
                    mjJ.close();
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
            if (dta()) {
                if (Pw(str + str2)) {
                    try {
                        mjI = new File(str + str2);
                        mjJ = new RandomAccessFile(mjI, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = mjJ.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            mjJ.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            mjJ.close();
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

    private static boolean dta() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.dsy().getContext().checkCallingOrSelfPermission(mjH[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean Pw(String str) {
        File file = new File(str);
        mjI = file;
        return file.exists();
    }

    public static boolean Px(String str) {
        File file = new File(str);
        mjI = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            mjI = new File(str);
            if (!Pw(str)) {
                mjI.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            mjI = file;
            if (file.exists()) {
                return true;
            }
            return mjI.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
