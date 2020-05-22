package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes8.dex */
public final class g {
    private static String[] mix = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File miy = null;
    private static RandomAccessFile miz = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (dsM() && f(str2, str3)) {
                try {
                    miy = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(miy, "rwd");
                    miz = randomAccessFile;
                    randomAccessFile.seek(miy.length());
                    miz.write((str + "\r\n").getBytes("UTF-8"));
                    miz.close();
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
            if (dsM()) {
                if (Pv(str + str2)) {
                    try {
                        miy = new File(str + str2);
                        miz = new RandomAccessFile(miy, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = miz.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            miz.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            miz.close();
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

    private static boolean dsM() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.dsk().getContext().checkCallingOrSelfPermission(mix[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean Pv(String str) {
        File file = new File(str);
        miy = file;
        return file.exists();
    }

    public static boolean Pw(String str) {
        File file = new File(str);
        miy = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            miy = new File(str);
            if (!Pv(str)) {
                miy.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            miy = file;
            if (file.exists()) {
                return true;
            }
            return miy.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
