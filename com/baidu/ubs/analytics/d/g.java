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
    private static String[] ihQ = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File ihR = null;
    private static RandomAccessFile ihS = null;

    public static synchronized boolean n(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (bTD() && f(str2, str3)) {
                try {
                    ihR = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(ihR, "rwd");
                    ihS = randomAccessFile;
                    randomAccessFile.seek(ihR.length());
                    ihS.write((str + SystemInfoUtil.LINE_END).getBytes("UTF-8"));
                    ihS.close();
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
                        ihR = new File(str + str2);
                        ihS = new RandomAccessFile(ihR, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = ihS.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), IoUtils.UTF_8)).append(",");
                        }
                        str3 = stringBuffer.toString();
                        try {
                            ihS.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            ihS.close();
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
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.bTh().getContext().checkCallingOrSelfPermission(ihQ[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean yY(String str) {
        File file = new File(str);
        ihR = file;
        return file.exists();
    }

    public static boolean yZ(String str) {
        File file = new File(str);
        ihR = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            ihR = new File(str);
            if (!yY(str)) {
                ihR.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            ihR = file;
            if (file.exists()) {
                return true;
            }
            return ihR.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
