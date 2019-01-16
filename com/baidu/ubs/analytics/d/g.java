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
    private static String[] ihP = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File ihQ = null;
    private static RandomAccessFile ihR = null;

    public static synchronized boolean n(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (bTD() && f(str2, str3)) {
                try {
                    ihQ = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(ihQ, "rwd");
                    ihR = randomAccessFile;
                    randomAccessFile.seek(ihQ.length());
                    ihR.write((str + SystemInfoUtil.LINE_END).getBytes("UTF-8"));
                    ihR.close();
                    z = true;
                } catch (Exception e) {
                    j.b(e);
                }
            }
        }
        return z;
    }

    public static synchronized String Z(String str, String str2) {
        String str3;
        synchronized (g.class) {
            if (bTD()) {
                if (yY(str + str2)) {
                    try {
                        ihQ = new File(str + str2);
                        ihR = new RandomAccessFile(ihQ, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = ihR.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), IoUtils.UTF_8)).append(",");
                        }
                        str3 = stringBuffer.toString();
                        try {
                            ihR.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            ihR.close();
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

    private static boolean bTD() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.bTh().getContext().checkCallingOrSelfPermission(ihP[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean yY(String str) {
        File file = new File(str);
        ihQ = file;
        return file.exists();
    }

    public static boolean yZ(String str) {
        File file = new File(str);
        ihQ = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            ihQ = new File(str);
            if (!yY(str)) {
                ihQ.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            ihQ = file;
            if (file.exists()) {
                return true;
            }
            return ihQ.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
