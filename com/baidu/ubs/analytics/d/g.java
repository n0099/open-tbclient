package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes3.dex */
public final class g {
    private static String[] oKr = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File oKs = null;
    private static RandomAccessFile oKt = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (efZ() && f(str2, str3)) {
                try {
                    oKs = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(oKs, "rwd");
                    oKt = randomAccessFile;
                    randomAccessFile.seek(oKs.length());
                    oKt.write((str + "\r\n").getBytes("UTF-8"));
                    oKt.close();
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
            if (efZ()) {
                if (WI(str + str2)) {
                    try {
                        oKs = new File(str + str2);
                        oKt = new RandomAccessFile(oKs, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = oKt.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(",");
                        }
                        str3 = stringBuffer.toString();
                        try {
                            oKt.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            oKt.close();
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

    private static boolean efZ() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.efH().getContext().checkCallingOrSelfPermission(oKr[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean WI(String str) {
        File file = new File(str);
        oKs = file;
        return file.exists();
    }

    public static boolean WJ(String str) {
        File file = new File(str);
        oKs = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            oKs = new File(str);
            if (!WI(str)) {
                oKs.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            oKs = file;
            if (file.exists()) {
                return true;
            }
            return oKs.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
