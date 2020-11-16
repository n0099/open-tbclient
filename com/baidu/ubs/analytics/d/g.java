package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes17.dex */
public final class g {
    private static String[] otC = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File otD = null;
    private static RandomAccessFile otE = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (edZ() && f(str2, str3)) {
                try {
                    otD = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(otD, "rwd");
                    otE = randomAccessFile;
                    randomAccessFile.seek(otD.length());
                    otE.write((str + "\r\n").getBytes("UTF-8"));
                    otE.close();
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
            if (edZ()) {
                if (WM(str + str2)) {
                    try {
                        otD = new File(str + str2);
                        otE = new RandomAccessFile(otD, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = otE.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            otE.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            otE.close();
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

    private static boolean edZ() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.edz().getContext().checkCallingOrSelfPermission(otC[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean WM(String str) {
        File file = new File(str);
        otD = file;
        return file.exists();
    }

    public static boolean WN(String str) {
        File file = new File(str);
        otD = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            otD = new File(str);
            if (!WM(str)) {
                otD.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            otD = file;
            if (file.exists()) {
                return true;
            }
            return otD.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
