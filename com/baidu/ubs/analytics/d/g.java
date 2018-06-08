package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import com.baidu.ar.util.IoUtils;
import com.baidu.ar.util.SystemInfoUtil;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public final class g {
    private static String[] hyx = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File hyy = null;
    private static RandomAccessFile hyz = null;

    public static synchronized boolean L(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (bKo() && cw(str2, str3)) {
                try {
                    hyy = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(hyy, "rwd");
                    hyz = randomAccessFile;
                    randomAccessFile.seek(hyy.length());
                    hyz.write((str + SystemInfoUtil.LINE_END).getBytes("UTF-8"));
                    hyz.close();
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
            if (bKo()) {
                if (wl(str + str2)) {
                    try {
                        hyy = new File(str + str2);
                        hyz = new RandomAccessFile(hyy, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = hyz.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), IoUtils.UTF_8)).append(",");
                        }
                        str3 = stringBuffer.toString();
                        try {
                            hyz.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            hyz.close();
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

    private static boolean bKo() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.bJP().getContext().checkCallingOrSelfPermission(hyx[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean wl(String str) {
        File file = new File(str);
        hyy = file;
        return file.exists();
    }

    public static boolean wm(String str) {
        File file = new File(str);
        hyy = file;
        return file.delete();
    }

    private static boolean cw(String str, String str2) {
        try {
            hyy = new File(str);
            if (!wl(str)) {
                hyy.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            hyy = file;
            if (file.exists()) {
                return true;
            }
            return hyy.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
