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
    private static String[] idy = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File idz = null;
    private static RandomAccessFile idA = null;

    public static synchronized boolean n(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (bSe() && f(str2, str3)) {
                try {
                    idz = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(idz, "rwd");
                    idA = randomAccessFile;
                    randomAccessFile.seek(idz.length());
                    idA.write((str + SystemInfoUtil.LINE_END).getBytes("UTF-8"));
                    idA.close();
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
            if (bSe()) {
                if (yF(str + str2)) {
                    try {
                        idz = new File(str + str2);
                        idA = new RandomAccessFile(idz, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = idA.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), IoUtils.UTF_8)).append(",");
                        }
                        str3 = stringBuffer.toString();
                        try {
                            idA.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            idA.close();
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

    private static boolean bSe() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.bRI().getContext().checkCallingOrSelfPermission(idy[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean yF(String str) {
        File file = new File(str);
        idz = file;
        return file.exists();
    }

    public static boolean yG(String str) {
        File file = new File(str);
        idz = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            idz = new File(str);
            if (!yF(str)) {
                idz.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            idz = file;
            if (file.exists()) {
                return true;
            }
            return idz.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
