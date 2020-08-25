package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes5.dex */
public final class g {
    private static String[] ngE = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File ngF = null;
    private static RandomAccessFile ngG = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (dMI() && f(str2, str3)) {
                try {
                    ngF = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(ngF, "rwd");
                    ngG = randomAccessFile;
                    randomAccessFile.seek(ngF.length());
                    ngG.write((str + "\r\n").getBytes("UTF-8"));
                    ngG.close();
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
            if (dMI()) {
                if (TU(str + str2)) {
                    try {
                        ngF = new File(str + str2);
                        ngG = new RandomAccessFile(ngF, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = ngG.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            ngG.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            ngG.close();
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

    private static boolean dMI() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.dMi().getContext().checkCallingOrSelfPermission(ngE[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean TU(String str) {
        File file = new File(str);
        ngF = file;
        return file.exists();
    }

    public static boolean TV(String str) {
        File file = new File(str);
        ngF = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            ngF = new File(str);
            if (!TU(str)) {
                ngF.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            ngF = file;
            if (file.exists()) {
                return true;
            }
            return ngF.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
