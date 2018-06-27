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
    private static String[] hCE = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File hCF = null;
    private static RandomAccessFile hCG = null;

    public static synchronized boolean J(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (bKP() && cA(str2, str3)) {
                try {
                    hCF = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(hCF, "rwd");
                    hCG = randomAccessFile;
                    randomAccessFile.seek(hCF.length());
                    hCG.write((str + SystemInfoUtil.LINE_END).getBytes("UTF-8"));
                    hCG.close();
                    z = true;
                } catch (Exception e) {
                    j.b(e);
                }
            }
        }
        return z;
    }

    public static synchronized String M(String str, String str2) {
        String str3;
        synchronized (g.class) {
            if (bKP()) {
                if (wh(str + str2)) {
                    try {
                        hCF = new File(str + str2);
                        hCG = new RandomAccessFile(hCF, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = hCG.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), IoUtils.UTF_8)).append(",");
                        }
                        str3 = stringBuffer.toString();
                        try {
                            hCG.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            hCG.close();
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

    private static boolean bKP() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.bKq().getContext().checkCallingOrSelfPermission(hCE[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean wh(String str) {
        File file = new File(str);
        hCF = file;
        return file.exists();
    }

    public static boolean wi(String str) {
        File file = new File(str);
        hCF = file;
        return file.delete();
    }

    private static boolean cA(String str, String str2) {
        try {
            hCF = new File(str);
            if (!wh(str)) {
                hCF.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            hCF = file;
            if (file.exists()) {
                return true;
            }
            return hCF.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
