package com.baidu.webkit.logsdk.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.webkit.internal.e;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes9.dex */
public final class c {
    private static String a;

    public static int a(String str) {
        String[] split = str.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        if (split.length > 0) {
            return Integer.parseInt(split[0]);
        }
        return 0;
    }

    public static String a() {
        if (TextUtils.isEmpty(a)) {
            Context d = com.baidu.webkit.logsdk.a.b.d();
            if (d == null || d.getFilesDir() == null) {
                return "";
            }
            String str = d.getFilesDir().getAbsolutePath() + "/bdlogs";
            if (str.endsWith(File.separator)) {
                a = str.substring(0, str.length() - 1);
            } else {
                a = str;
            }
            new File(a).mkdirs();
            e("BdLogSDK", "Workspace = " + a);
            return a;
        }
        return a;
    }

    public static String a(com.baidu.webkit.logsdk.b.b bVar, String str) {
        String str2 = bVar.e.get(str);
        if (TextUtils.isEmpty(str2)) {
            com.baidu.webkit.logsdk.b c = com.baidu.webkit.logsdk.a.b.a().c();
            d(com.baidu.webkit.logsdk.b.b.e());
            int d = d(str);
            d(com.baidu.webkit.logsdk.b.b.g());
            str2 = c.a(d);
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str2)) {
                bVar.e.put(str, str2);
            }
        }
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(File file) {
        ByteArrayOutputStream byteArrayOutputStream;
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2 = null;
        if (file != null && file.exists()) {
            e("BdLogSDK", "readDataFromFile " + file.getName());
            try {
                dataInputStream = new DataInputStream(new FileInputStream(file));
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Exception e) {
                    e = e;
                    byteArrayOutputStream = null;
                    dataInputStream2 = dataInputStream;
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = null;
                }
            } catch (Exception e2) {
                e = e2;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                dataInputStream = null;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = dataInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                String str = new String(Base64.decode(new String(e.b(byteArrayOutputStream.toByteArray())), 0));
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e3) {
                    Log.w("BdLogSDK", "readStatisticsDataFromFile close Exception", e3);
                }
                try {
                    dataInputStream.close();
                    return str;
                } catch (Exception e4) {
                    Log.w("BdLogSDK", "readUserBehaviorStatisticsDataFromFile close Exception", e4);
                    return str;
                }
            } catch (Exception e5) {
                e = e5;
                dataInputStream2 = dataInputStream;
                try {
                    Log.w("BdLogSDK", "readStatisticsDataFromFile Exception", e);
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e6) {
                            Log.w("BdLogSDK", "readStatisticsDataFromFile close Exception", e6);
                        }
                    }
                    if (dataInputStream2 != null) {
                        try {
                            dataInputStream2.close();
                        } catch (Exception e7) {
                            Log.w("BdLogSDK", "readUserBehaviorStatisticsDataFromFile close Exception", e7);
                        }
                    }
                    return "";
                } catch (Throwable th3) {
                    th = th3;
                    dataInputStream = dataInputStream2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e8) {
                            Log.w("BdLogSDK", "readStatisticsDataFromFile close Exception", e8);
                        }
                    }
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (Exception e9) {
                            Log.w("BdLogSDK", "readUserBehaviorStatisticsDataFromFile close Exception", e9);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                if (byteArrayOutputStream != null) {
                }
                if (dataInputStream != null) {
                }
                throw th;
            }
        }
        return "";
    }

    public static String a(String str, String str2) {
        int a2 = a(str2);
        com.baidu.webkit.logsdk.b.b e = com.baidu.webkit.logsdk.a.b.a().e();
        switch (a2) {
            case 0:
                return b.a(str, a(e, str2));
            case 1:
                return "";
            default:
                return null;
        }
    }

    public static void a(String str, String str2, String str3) {
        if (com.baidu.webkit.logsdk.a.b && !TextUtils.isEmpty(str3)) {
            Log.d(str, str2 + " = " + str3);
        } else if (com.baidu.webkit.logsdk.a.a) {
            Log.i(str, str2);
        }
    }

    public static void a(Throwable th) {
        com.a.a.a.a.a.a.a.a(th);
        if (com.baidu.webkit.logsdk.a.b) {
            System.exit(0);
        }
    }

    public static String b(String str) {
        return new StringBuffer(a()).append(File.separator).append(str).toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x00d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(String str, String str2) {
        FileChannel fileChannel;
        DataOutputStream dataOutputStream;
        byte[] encode;
        FileOutputStream fileOutputStream;
        FileLock fileLock = null;
        try {
            e("BdLogSDK", "writeDataToFile " + str);
            encode = Base64.encode(str2.getBytes(), 0);
            fileOutputStream = new FileOutputStream(new File(str));
            fileChannel = fileOutputStream.getChannel();
        } catch (Exception e) {
            e = e;
            fileChannel = null;
            dataOutputStream = null;
        } catch (Throwable th) {
            th = th;
            fileChannel = null;
            dataOutputStream = null;
        }
        try {
            dataOutputStream = new DataOutputStream(fileOutputStream);
            do {
                try {
                    try {
                        fileLock = fileChannel.tryLock();
                    } catch (Exception e2) {
                        e = e2;
                        Log.w("BdLogSDK", "writeDataToFile Exception", e);
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (IOException e3) {
                                Log.w("BdLogSDK", "writeDataToFile IOException", e3);
                            }
                        }
                        if (fileChannel != null && fileChannel.isOpen()) {
                            try {
                                fileChannel.close();
                            } catch (IOException e4) {
                                Log.w("BdLogSDK", "writeDataToFile IOException", e4);
                            }
                        }
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                                return;
                            } catch (Exception e5) {
                                Log.w("BdLogSDK", "writeDataToFile close Exception", e5);
                                return;
                            }
                        }
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (IOException e6) {
                            Log.w("BdLogSDK", "writeDataToFile IOException", e6);
                        }
                    }
                    if (fileChannel != null && fileChannel.isOpen()) {
                        try {
                            fileChannel.close();
                        } catch (IOException e7) {
                            Log.w("BdLogSDK", "writeDataToFile IOException", e7);
                        }
                    }
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (Exception e8) {
                            Log.w("BdLogSDK", "writeDataToFile close Exception", e8);
                        }
                    }
                    throw th;
                }
            } while (fileLock == null);
            dataOutputStream.write(e.b(encode));
            dataOutputStream.flush();
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (IOException e9) {
                    Log.w("BdLogSDK", "writeDataToFile IOException", e9);
                }
            }
            if (fileChannel != null && fileChannel.isOpen()) {
                try {
                    fileChannel.close();
                } catch (IOException e10) {
                    Log.w("BdLogSDK", "writeDataToFile IOException", e10);
                }
            }
            try {
                dataOutputStream.close();
            } catch (Exception e11) {
                Log.w("BdLogSDK", "writeDataToFile close Exception", e11);
            }
        } catch (Exception e12) {
            e = e12;
            dataOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
            if (fileLock != null) {
            }
            if (fileChannel != null) {
                fileChannel.close();
            }
            if (dataOutputStream != null) {
            }
            throw th;
        }
    }

    public static String c(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                if ((b & 255) < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(b & 255));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            com.a.a.a.a.a.a.a.a(e);
            return null;
        } catch (NoSuchAlgorithmException e2) {
            com.a.a.a.a.a.a.a.a(e2);
            return null;
        }
    }

    public static String c(String str, String str2) {
        String str3 = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2;
        a("BdLogSDK", "getFilename realName", str3);
        return Base64.encodeToString(str3.getBytes(), 0);
    }

    private static int d(String str) {
        String[] split = str.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        if (split.length > 1) {
            return Integer.parseInt(split[1]);
        }
        return 0;
    }

    public static void d(String str, String str2) {
        new File(b(c(str, str2))).delete();
    }

    public static void e(String str, String str2) {
        if (com.baidu.webkit.logsdk.a.a) {
            Log.w(str, str2);
        }
    }
}
