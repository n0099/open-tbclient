package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes17.dex */
public final class g {
    private static String[] oIL = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File oIM = null;
    private static RandomAccessFile oIN = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (ejN() && f(str2, str3)) {
                try {
                    oIM = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(oIM, "rwd");
                    oIN = randomAccessFile;
                    randomAccessFile.seek(oIM.length());
                    oIN.write((str + "\r\n").getBytes("UTF-8"));
                    oIN.close();
                    z = true;
                } catch (Exception e) {
                    j.b(e);
                }
            }
        }
        return z;
    }

    public static synchronized String W(String str, String str2) {
        String str3;
        synchronized (g.class) {
            if (ejN()) {
                if (Yh(str + str2)) {
                    try {
                        oIM = new File(str + str2);
                        oIN = new RandomAccessFile(oIM, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = oIN.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(",");
                        }
                        str3 = stringBuffer.toString();
                        try {
                            oIN.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            oIN.close();
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

    private static boolean ejN() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.ejo().getContext().checkCallingOrSelfPermission(oIL[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean Yh(String str) {
        File file = new File(str);
        oIM = file;
        return file.exists();
    }

    public static boolean Yi(String str) {
        File file = new File(str);
        oIM = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            oIM = new File(str);
            if (!Yh(str)) {
                oIM.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            oIM = file;
            if (file.exists()) {
                return true;
            }
            return oIM.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
