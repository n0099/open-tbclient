package com.baidu.ubs.analytics.d;

import android.os.Build;
import android.os.Environment;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public final class g {
    private static String[] kaT = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static File kaU = null;
    private static RandomAccessFile kaV = null;

    public static synchronized boolean b(String str, String str2, String str3) {
        boolean z = false;
        synchronized (g.class) {
            if (cEU() && f(str2, str3)) {
                try {
                    kaU = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(kaU, "rwd");
                    kaV = randomAccessFile;
                    randomAccessFile.seek(kaU.length());
                    kaV.write((str + "\r\n").getBytes(HTTP.UTF_8));
                    kaV.close();
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
            if (cEU()) {
                if (HS(str + str2)) {
                    try {
                        kaU = new File(str + str2);
                        kaV = new RandomAccessFile(kaU, "r");
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = kaV.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8")).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        str3 = stringBuffer.toString();
                        try {
                            kaV.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            kaV.close();
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

    private static boolean cEU() {
        String externalStorageState = Environment.getExternalStorageState();
        return Build.VERSION.SDK_INT >= 23 ? com.baidu.ubs.analytics.d.cEt().getContext().checkCallingOrSelfPermission(kaT[0]) == 0 && externalStorageState.equals("mounted") : externalStorageState.equals("mounted");
    }

    public static boolean HS(String str) {
        File file = new File(str);
        kaU = file;
        return file.exists();
    }

    public static boolean HT(String str) {
        File file = new File(str);
        kaU = file;
        return file.delete();
    }

    private static boolean f(String str, String str2) {
        try {
            kaU = new File(str);
            if (!HS(str)) {
                kaU.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            kaU = file;
            if (file.exists()) {
                return true;
            }
            return kaU.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
