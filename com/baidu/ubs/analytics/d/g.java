package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes14.dex */
public final class g {
    private static String[] oXe = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File oXf = null;
    private static RandomAccessFile oXg = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (eiJ() && f(str2, str3)) {
                try {
                    oXf = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(oXf, "rwd");
                    oXg = randomAccessFile;
                    randomAccessFile.seek(oXf.length());
                    oXg.write((str + "\r\n").getBytes("UTF-8"));
                    oXg.close();
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
            if (eiJ()) {
                if (Ya(str + str2)) {
                    try {
                        oXf = new File(str + str2);
                        oXg = new RandomAccessFile(oXf, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = oXg.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(",");
                        }
                        str3 = stringBuffer.toString();
                        try {
                            oXg.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            oXg.close();
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

    private static boolean eiJ() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.eip().getContext().checkCallingOrSelfPermission(oXe[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean Ya(String str) {
        File file = new File(str);
        oXf = file;
        return file.exists();
    }

    public static boolean Yb(String str) {
        File file = new File(str);
        oXf = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            oXf = new File(str);
            if (!Ya(str)) {
                oXf.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            oXf = file;
            if (file.exists()) {
                return true;
            }
            return oXf.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
