package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes5.dex */
public final class g {
    private static String[] kSx = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File kSy = null;
    private static RandomAccessFile kSz = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (cVx() && f(str2, str3)) {
                try {
                    kSy = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(kSy, "rwd");
                    kSz = randomAccessFile;
                    randomAccessFile.seek(kSy.length());
                    kSz.write((str + "\r\n").getBytes("UTF-8"));
                    kSz.close();
                    z = true;
                } catch (Exception e) {
                    j.b(e);
                }
            }
        }
        return z;
    }

    public static synchronized String L(String str, String str2) {
        String str3;
        synchronized (g.class) {
            if (cVx()) {
                if (KZ(str + str2)) {
                    try {
                        kSy = new File(str + str2);
                        kSz = new RandomAccessFile(kSy, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = kSz.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            kSz.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            kSz.close();
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

    private static boolean cVx() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.cUT().getContext().checkCallingOrSelfPermission(kSx[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean KZ(String str) {
        File file = new File(str);
        kSy = file;
        return file.exists();
    }

    public static boolean La(String str) {
        File file = new File(str);
        kSy = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            kSy = new File(str);
            if (!KZ(str)) {
                kSy.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            kSy = file;
            if (file.exists()) {
                return true;
            }
            return kSy.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
