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
    private static String[] igI = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File igJ = null;
    private static RandomAccessFile igK = null;

    public static synchronized boolean n(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (bSV() && f(str2, str3)) {
                try {
                    igJ = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(igJ, "rwd");
                    igK = randomAccessFile;
                    randomAccessFile.seek(igJ.length());
                    igK.write((str + SystemInfoUtil.LINE_END).getBytes("UTF-8"));
                    igK.close();
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
            if (bSV()) {
                if (yI(str + str2)) {
                    try {
                        igJ = new File(str + str2);
                        igK = new RandomAccessFile(igJ, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = igK.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), IoUtils.UTF_8)).append(",");
                        }
                        str3 = stringBuffer.toString();
                        try {
                            igK.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            igK.close();
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

    private static boolean bSV() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.bSz().getContext().checkCallingOrSelfPermission(igI[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean yI(String str) {
        File file = new File(str);
        igJ = file;
        return file.exists();
    }

    public static boolean yJ(String str) {
        File file = new File(str);
        igJ = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            igJ = new File(str);
            if (!yI(str)) {
                igJ.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            igJ = file;
            if (file.exists()) {
                return true;
            }
            return igJ.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
