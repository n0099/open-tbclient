package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes7.dex */
public final class g {
    private static String[] nqX = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File nqY = null;
    private static RandomAccessFile nqZ = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (dQP() && f(str2, str3)) {
                try {
                    nqY = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(nqY, "rwd");
                    nqZ = randomAccessFile;
                    randomAccessFile.seek(nqY.length());
                    nqZ.write((str + "\r\n").getBytes("UTF-8"));
                    nqZ.close();
                    z = true;
                } catch (Exception e) {
                    j.b(e);
                }
            }
        }
        return z;
    }

    public static synchronized String V(String str, String str2) {
        String str3;
        synchronized (g.class) {
            if (dQP()) {
                if (Uw(str + str2)) {
                    try {
                        nqY = new File(str + str2);
                        nqZ = new RandomAccessFile(nqY, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = nqZ.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            nqZ.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            nqZ.close();
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

    private static boolean dQP() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.dQp().getContext().checkCallingOrSelfPermission(nqX[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean Uw(String str) {
        File file = new File(str);
        nqY = file;
        return file.exists();
    }

    public static boolean Ux(String str) {
        File file = new File(str);
        nqY = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            nqY = new File(str);
            if (!Uw(str)) {
                nqY.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            nqY = file;
            if (file.exists()) {
                return true;
            }
            return nqY.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
