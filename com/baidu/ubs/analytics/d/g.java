package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import com.baidu.ar.util.IoUtils;
import com.baidu.ar.util.SystemInfoUtil;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes2.dex */
public final class g {
    private static String[] hDj = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File hDk = null;
    private static RandomAccessFile hDl = null;

    public static synchronized boolean k(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (bJt() && cw(str2, str3)) {
                try {
                    hDk = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(hDk, "rwd");
                    hDl = randomAccessFile;
                    randomAccessFile.seek(hDk.length());
                    hDl.write((str + SystemInfoUtil.LINE_END).getBytes("UTF-8"));
                    hDl.close();
                    z = true;
                } catch (Exception e) {
                    j.b(e);
                }
            }
        }
        return z;
    }

    public static synchronized String L(String str, String str2) {
        String str3;
        synchronized (g.class) {
            if (bJt()) {
                if (wi(str + str2)) {
                    try {
                        hDk = new File(str + str2);
                        hDl = new RandomAccessFile(hDk, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = hDl.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), IoUtils.UTF_8)).append(",");
                        }
                        str3 = stringBuffer.toString();
                        try {
                            hDl.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            hDl.close();
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

    private static boolean bJt() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.bIU().getContext().checkCallingOrSelfPermission(hDj[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean wi(String str) {
        File file = new File(str);
        hDk = file;
        return file.exists();
    }

    public static boolean wj(String str) {
        File file = new File(str);
        hDk = file;
        return file.delete();
    }

    private static boolean cw(String str, String str2) {
        try {
            hDk = new File(str);
            if (!wi(str)) {
                hDk.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            hDk = file;
            if (file.exists()) {
                return true;
            }
            return hDk.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
