package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public final class g {
    private static String[] hlx = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File hly = null;
    private static RandomAccessFile hlz = null;

    public static synchronized boolean K(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (bFm() && cp(str2, str3)) {
                try {
                    hly = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(hly, "rwd");
                    hlz = randomAccessFile;
                    randomAccessFile.seek(hly.length());
                    hlz.write((str + "\r\n").getBytes("UTF-8"));
                    hlz.close();
                    z = true;
                } catch (Exception e) {
                    j.b(e);
                }
            }
        }
        return z;
    }

    public static synchronized String co(String str, String str2) {
        String str3;
        synchronized (g.class) {
            if (bFm()) {
                if (vo(str + str2)) {
                    try {
                        hly = new File(str + str2);
                        hlz = new RandomAccessFile(hly, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = hlz.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            hlz.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            hlz.close();
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

    private static boolean bFm() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.bEN().getContext().checkCallingOrSelfPermission(hlx[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean vo(String str) {
        File file = new File(str);
        hly = file;
        return file.exists();
    }

    public static boolean vp(String str) {
        File file = new File(str);
        hly = file;
        return file.delete();
    }

    private static boolean cp(String str, String str2) {
        try {
            hly = new File(str);
            if (!vo(str)) {
                hly.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            hly = file;
            if (file.exists()) {
                return true;
            }
            return hly.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
