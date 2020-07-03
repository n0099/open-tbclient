package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes8.dex */
public final class g {
    private static String[] mFD = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File mFE = null;
    private static RandomAccessFile mFF = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (dxD() && f(str2, str3)) {
                try {
                    mFE = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(mFE, "rwd");
                    mFF = randomAccessFile;
                    randomAccessFile.seek(mFE.length());
                    mFF.write((str + "\r\n").getBytes("UTF-8"));
                    mFF.close();
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
            if (dxD()) {
                if (Qi(str + str2)) {
                    try {
                        mFE = new File(str + str2);
                        mFF = new RandomAccessFile(mFE, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = mFF.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            mFF.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            mFF.close();
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

    private static boolean dxD() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.dxd().getContext().checkCallingOrSelfPermission(mFD[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean Qi(String str) {
        File file = new File(str);
        mFE = file;
        return file.exists();
    }

    public static boolean Qj(String str) {
        File file = new File(str);
        mFE = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            mFE = new File(str);
            if (!Qi(str)) {
                mFE.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            mFE = file;
            if (file.exists()) {
                return true;
            }
            return mFE.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
