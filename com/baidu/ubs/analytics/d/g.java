package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes15.dex */
public final class g {
    private static String[] oUZ = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File oVa = null;
    private static RandomAccessFile oVb = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (eiz() && f(str2, str3)) {
                try {
                    oVa = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(oVa, "rwd");
                    oVb = randomAccessFile;
                    randomAccessFile.seek(oVa.length());
                    oVb.write((str + "\r\n").getBytes("UTF-8"));
                    oVb.close();
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
            if (eiz()) {
                if (XT(str + str2)) {
                    try {
                        oVa = new File(str + str2);
                        oVb = new RandomAccessFile(oVa, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = oVb.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(",");
                        }
                        str3 = stringBuffer.toString();
                        try {
                            oVb.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            oVb.close();
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

    private static boolean eiz() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.eih().getContext().checkCallingOrSelfPermission(oUZ[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean XT(String str) {
        File file = new File(str);
        oVa = file;
        return file.exists();
    }

    public static boolean XU(String str) {
        File file = new File(str);
        oVa = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            oVa = new File(str);
            if (!XT(str)) {
                oVa.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            oVa = file;
            if (file.exists()) {
                return true;
            }
            return oVa.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
