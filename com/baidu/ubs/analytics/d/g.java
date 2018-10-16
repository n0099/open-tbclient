package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import com.baidu.ar.util.IoUtils;
import com.baidu.ar.util.SystemInfoUtil;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes6.dex */
public final class g {
    private static String[] hUA = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File hUB = null;
    private static RandomAccessFile hUC = null;

    public static synchronized boolean n(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (bQE() && cV(str2, str3)) {
                try {
                    hUB = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(hUB, "rwd");
                    hUC = randomAccessFile;
                    randomAccessFile.seek(hUB.length());
                    hUC.write((str + SystemInfoUtil.LINE_END).getBytes("UTF-8"));
                    hUC.close();
                    z = true;
                } catch (Exception e) {
                    j.b(e);
                }
            }
        }
        return z;
    }

    public static synchronized String Y(String str, String str2) {
        String str3;
        synchronized (g.class) {
            if (bQE()) {
                if (xX(str + str2)) {
                    try {
                        hUB = new File(str + str2);
                        hUC = new RandomAccessFile(hUB, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = hUC.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), IoUtils.UTF_8)).append(",");
                        }
                        str3 = stringBuffer.toString();
                        try {
                            hUC.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            hUC.close();
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

    private static boolean bQE() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.bQf().getContext().checkCallingOrSelfPermission(hUA[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean xX(String str) {
        File file = new File(str);
        hUB = file;
        return file.exists();
    }

    public static boolean xY(String str) {
        File file = new File(str);
        hUB = file;
        return file.delete();
    }

    private static boolean cV(String str, String str2) {
        try {
            hUB = new File(str);
            if (!xX(str)) {
                hUB.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            hUB = file;
            if (file.exists()) {
                return true;
            }
            return hUB.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
