package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes6.dex */
public final class g {
    private static String[] mNM = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File mNN = null;
    private static RandomAccessFile mNO = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (dAU() && f(str2, str3)) {
                try {
                    mNN = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(mNN, "rwd");
                    mNO = randomAccessFile;
                    randomAccessFile.seek(mNN.length());
                    mNO.write((str + "\r\n").getBytes("UTF-8"));
                    mNO.close();
                    z = true;
                } catch (Exception e) {
                    j.b(e);
                }
            }
        }
        return z;
    }

    public static synchronized String R(String str, String str2) {
        String str3;
        synchronized (g.class) {
            if (dAU()) {
                if (QU(str + str2)) {
                    try {
                        mNN = new File(str + str2);
                        mNO = new RandomAccessFile(mNN, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = mNO.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            mNO.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            mNO.close();
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

    private static boolean dAU() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.dAv().getContext().checkCallingOrSelfPermission(mNM[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean QU(String str) {
        File file = new File(str);
        mNN = file;
        return file.exists();
    }

    public static boolean QV(String str) {
        File file = new File(str);
        mNN = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            mNN = new File(str);
            if (!QU(str)) {
                mNN.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            mNN = file;
            if (file.exists()) {
                return true;
            }
            return mNN.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
