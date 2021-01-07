package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes6.dex */
public final class g {
    private static String[] oOS = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File oOT = null;
    private static RandomAccessFile oOU = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (ejT() && f(str2, str3)) {
                try {
                    oOT = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(oOT, "rwd");
                    oOU = randomAccessFile;
                    randomAccessFile.seek(oOT.length());
                    oOU.write((str + "\r\n").getBytes("UTF-8"));
                    oOU.close();
                    z = true;
                } catch (Exception e) {
                    j.b(e);
                }
            }
        }
        return z;
    }

    public static synchronized String e(String str, String str2) {
        String str3;
        synchronized (g.class) {
            if (ejT()) {
                if (XP(str + str2)) {
                    try {
                        oOT = new File(str + str2);
                        oOU = new RandomAccessFile(oOT, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = oOU.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(",");
                        }
                        str3 = stringBuffer.toString();
                        try {
                            oOU.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            oOU.close();
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

    private static boolean ejT() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.ejz().getContext().checkCallingOrSelfPermission(oOS[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean XP(String str) {
        File file = new File(str);
        oOT = file;
        return file.exists();
    }

    public static boolean XQ(String str) {
        File file = new File(str);
        oOT = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            oOT = new File(str);
            if (!XP(str)) {
                oOT.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            oOT = file;
            if (file.exists()) {
                return true;
            }
            return oOT.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
