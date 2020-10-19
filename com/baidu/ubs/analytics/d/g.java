package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes10.dex */
public final class g {
    private static String[] nGr = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File nGs = null;
    private static RandomAccessFile nGt = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (dUA() && f(str2, str3)) {
                try {
                    nGs = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(nGs, "rwd");
                    nGt = randomAccessFile;
                    randomAccessFile.seek(nGs.length());
                    nGt.write((str + "\r\n").getBytes("UTF-8"));
                    nGt.close();
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
            if (dUA()) {
                if (Vk(str + str2)) {
                    try {
                        nGs = new File(str + str2);
                        nGt = new RandomAccessFile(nGs, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = nGt.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            nGt.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            nGt.close();
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

    private static boolean dUA() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.dUa().getContext().checkCallingOrSelfPermission(nGr[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean Vk(String str) {
        File file = new File(str);
        nGs = file;
        return file.exists();
    }

    public static boolean Vl(String str) {
        File file = new File(str);
        nGs = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            nGs = new File(str);
            if (!Vk(str)) {
                nGs.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            nGs = file;
            if (file.exists()) {
                return true;
            }
            return nGs.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
