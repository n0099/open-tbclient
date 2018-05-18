package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public final class g {
    private static String[] hmB = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File hmC = null;
    private static RandomAccessFile hmD = null;

    public static synchronized boolean K(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (bFk() && cp(str2, str3)) {
                try {
                    hmC = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(hmC, "rwd");
                    hmD = randomAccessFile;
                    randomAccessFile.seek(hmC.length());
                    hmD.write((str + "\r\n").getBytes("UTF-8"));
                    hmD.close();
                    z = true;
                } catch (Exception e) {
                    j.b(e);
                }
            }
        }
        return z;
    }

    public static synchronized String co(String str, String str2) {
        String str3;
        synchronized (g.class) {
            if (bFk()) {
                if (vr(str + str2)) {
                    try {
                        hmC = new File(str + str2);
                        hmD = new RandomAccessFile(hmC, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = hmD.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            hmD.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            hmD.close();
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

    private static boolean bFk() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.bEL().getContext().checkCallingOrSelfPermission(hmB[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean vr(String str) {
        File file = new File(str);
        hmC = file;
        return file.exists();
    }

    public static boolean vs(String str) {
        File file = new File(str);
        hmC = file;
        return file.delete();
    }

    private static boolean cp(String str, String str2) {
        try {
            hmC = new File(str);
            if (!vr(str)) {
                hmC.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            hmC = file;
            if (file.exists()) {
                return true;
            }
            return hmC.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
