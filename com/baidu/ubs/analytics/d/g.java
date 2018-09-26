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
    private static String[] hLG = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File hLH = null;
    private static RandomAccessFile hLI = null;

    public static synchronized boolean k(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (bMo() && cI(str2, str3)) {
                try {
                    hLH = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(hLH, "rwd");
                    hLI = randomAccessFile;
                    randomAccessFile.seek(hLH.length());
                    hLI.write((str + SystemInfoUtil.LINE_END).getBytes("UTF-8"));
                    hLI.close();
                    z = true;
                } catch (Exception e) {
                    j.b(e);
                }
            }
        }
        return z;
    }

    public static synchronized String S(String str, String str2) {
        String str3;
        synchronized (g.class) {
            if (bMo()) {
                if (wX(str + str2)) {
                    try {
                        hLH = new File(str + str2);
                        hLI = new RandomAccessFile(hLH, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = hLI.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), IoUtils.UTF_8)).append(",");
                        }
                        str3 = stringBuffer.toString();
                        try {
                            hLI.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            hLI.close();
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

    private static boolean bMo() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.bLP().getContext().checkCallingOrSelfPermission(hLG[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean wX(String str) {
        File file = new File(str);
        hLH = file;
        return file.exists();
    }

    public static boolean wY(String str) {
        File file = new File(str);
        hLH = file;
        return file.delete();
    }

    private static boolean cI(String str, String str2) {
        try {
            hLH = new File(str);
            if (!wX(str)) {
                hLH.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            hLH = file;
            if (file.exists()) {
                return true;
            }
            return hLH.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
