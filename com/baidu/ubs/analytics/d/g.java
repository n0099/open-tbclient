package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes6.dex */
public final class g {
    private static String[] mNK = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File mNL = null;
    private static RandomAccessFile mNM = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (dAT() && f(str2, str3)) {
                try {
                    mNL = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(mNL, "rwd");
                    mNM = randomAccessFile;
                    randomAccessFile.seek(mNL.length());
                    mNM.write((str + "\r\n").getBytes("UTF-8"));
                    mNM.close();
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
            if (dAT()) {
                if (QU(str + str2)) {
                    try {
                        mNL = new File(str + str2);
                        mNM = new RandomAccessFile(mNL, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = mNM.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            mNM.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            mNM.close();
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

    private static boolean dAT() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.dAu().getContext().checkCallingOrSelfPermission(mNK[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean QU(String str) {
        File file = new File(str);
        mNL = file;
        return file.exists();
    }

    public static boolean QV(String str) {
        File file = new File(str);
        mNL = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            mNL = new File(str);
            if (!QU(str)) {
                mNL.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            mNL = file;
            if (file.exists()) {
                return true;
            }
            return mNL.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
