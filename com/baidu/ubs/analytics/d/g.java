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
    private static String[] hDl = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File hDm = null;
    private static RandomAccessFile hDn = null;

    public static synchronized boolean k(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (bJx() && cw(str2, str3)) {
                try {
                    hDm = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(hDm, "rwd");
                    hDn = randomAccessFile;
                    randomAccessFile.seek(hDm.length());
                    hDn.write((str + SystemInfoUtil.LINE_END).getBytes("UTF-8"));
                    hDn.close();
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
            if (bJx()) {
                if (wm(str + str2)) {
                    try {
                        hDm = new File(str + str2);
                        hDn = new RandomAccessFile(hDm, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = hDn.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), IoUtils.UTF_8)).append(",");
                        }
                        str3 = stringBuffer.toString();
                        try {
                            hDn.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            hDn.close();
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

    private static boolean bJx() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.bIY().getContext().checkCallingOrSelfPermission(hDl[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean wm(String str) {
        File file = new File(str);
        hDm = file;
        return file.exists();
    }

    public static boolean wn(String str) {
        File file = new File(str);
        hDm = file;
        return file.delete();
    }

    private static boolean cw(String str, String str2) {
        try {
            hDm = new File(str);
            if (!wm(str)) {
                hDm.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            hDm = file;
            if (file.exists()) {
                return true;
            }
            return hDm.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
