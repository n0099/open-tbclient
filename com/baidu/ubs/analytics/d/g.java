package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes10.dex */
public final class g {
    private static String[] oiT = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File oiU = null;
    private static RandomAccessFile oiV = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (eas() && f(str2, str3)) {
                try {
                    oiU = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(oiU, "rwd");
                    oiV = randomAccessFile;
                    randomAccessFile.seek(oiU.length());
                    oiV.write((str + "\r\n").getBytes("UTF-8"));
                    oiV.close();
                    z = true;
                } catch (Exception e) {
                    j.b(e);
                }
            }
        }
        return z;
    }

    public static synchronized String X(String str, String str2) {
        String str3;
        synchronized (g.class) {
            if (eas()) {
                if (Wy(str + str2)) {
                    try {
                        oiU = new File(str + str2);
                        oiV = new RandomAccessFile(oiU, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = oiV.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            oiV.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            oiV.close();
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

    private static boolean eas() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.dZS().getContext().checkCallingOrSelfPermission(oiT[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean Wy(String str) {
        File file = new File(str);
        oiU = file;
        return file.exists();
    }

    public static boolean Wz(String str) {
        File file = new File(str);
        oiU = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            oiU = new File(str);
            if (!Wy(str)) {
                oiU.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            oiU = file;
            if (file.exists()) {
                return true;
            }
            return oiU.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
