package com.baidu.webkit.logsdk.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import com.baidu.webkit.internal.d;
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
/* loaded from: classes14.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static String f5713a;

    public static int a(String str) {
        String[] split = str.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        if (split.length > 0) {
            return Integer.parseInt(split[0]);
        }
        return 0;
    }

    public static String a() {
        if (TextUtils.isEmpty(f5713a)) {
            Context d = com.baidu.webkit.logsdk.a.b.d();
            if (d == null || d.getFilesDir() == null) {
                return "";
            }
            String str = d.getFilesDir().getAbsolutePath() + "/bdlogs";
            if (str.endsWith(File.separator)) {
                f5713a = str.substring(0, str.length() - 1);
            } else {
                f5713a = str;
            }
            new File(f5713a).mkdirs();
            e("BdLogSDK", "Workspace = " + f5713a);
            return f5713a;
        }
        return f5713a;
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x0042 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:48:0x00cb */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.DataInputStream] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.DataInputStream] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.DataInputStream] */
    public static String a(File file) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (file != null && file.exists()) {
            ?? sb = new StringBuilder("readDataFromFile ");
            ?? name = file.getName();
            ?? sb2 = sb.append(name).toString();
            e("BdLogSDK", sb2);
            try {
                try {
                    name = new DataInputStream(new FileInputStream(file));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
                byteArrayOutputStream = null;
                name = 0;
            } catch (Throwable th2) {
                th = th2;
                sb2 = 0;
                name = 0;
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = name.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    String str = new String(Base64.decode(new String(d.b(byteArrayOutputStream.toByteArray())), 0));
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e2) {
                        Log.w("BdLogSDK", "readStatisticsDataFromFile close Exception", e2);
                    }
                    try {
                        name.close();
                        return str;
                    } catch (Exception e3) {
                        Log.w("BdLogSDK", "readUserBehaviorStatisticsDataFromFile close Exception", e3);
                        return str;
                    }
                } catch (Exception e4) {
                    e = e4;
                    Log.w("BdLogSDK", "readStatisticsDataFromFile Exception", e);
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e5) {
                            Log.w("BdLogSDK", "readStatisticsDataFromFile close Exception", e5);
                        }
                    }
                    if (name != 0) {
                        try {
                            name.close();
                        } catch (Exception e6) {
                            Log.w("BdLogSDK", "readUserBehaviorStatisticsDataFromFile close Exception", e6);
                        }
                    }
                    return "";
                }
            } catch (Exception e7) {
                e = e7;
                byteArrayOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                sb2 = 0;
                if (sb2 != 0) {
                    try {
                        sb2.close();
                    } catch (Exception e8) {
                        Log.w("BdLogSDK", "readStatisticsDataFromFile close Exception", e8);
                    }
                }
                if (name != 0) {
                    try {
                        name.close();
                    } catch (Exception e9) {
                        Log.w("BdLogSDK", "readUserBehaviorStatisticsDataFromFile close Exception", e9);
                    }
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
        if (com.baidu.webkit.logsdk.a.f5685b && !TextUtils.isEmpty(str3)) {
            Log.d(str, str2 + " = " + str3);
        } else if (com.baidu.webkit.logsdk.a.f5684a) {
            Log.i(str, str2);
        }
    }

    public static void a(Throwable th) {
        th.printStackTrace();
        if (com.baidu.webkit.logsdk.a.f5685b) {
            System.exit(0);
        }
    }

    public static String b(String str) {
        return new StringBuffer(a()).append(File.separator).append(str).toString();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:11:0x0049 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:60:0x00fc */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x0103 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:86:0x0034 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v27, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r1v31 */
    public static void b(String str, String str2) {
        String str3;
        FileChannel fileChannel;
        DataOutputStream dataOutputStream;
        FileLock fileLock;
        byte[] encode;
        FileOutputStream fileOutputStream;
        try {
            try {
                e("BdLogSDK", "writeDataToFile " + str);
                encode = Base64.encode(str2.getBytes(), 0);
                fileOutputStream = new FileOutputStream(new File(str));
                fileChannel = fileOutputStream.getChannel();
            } catch (Throwable th) {
                th = th;
            }
            try {
                dataOutputStream = new DataOutputStream(fileOutputStream);
                fileLock = null;
                do {
                    try {
                        fileLock = fileChannel.tryLock();
                        fileLock = fileLock;
                    } catch (Exception e) {
                        e = e;
                        Log.w("BdLogSDK", "writeDataToFile Exception", e);
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (IOException e2) {
                                Log.w("BdLogSDK", "writeDataToFile IOException", e2);
                            }
                        }
                        if (fileChannel != null && fileChannel.isOpen()) {
                            try {
                                fileChannel.close();
                            } catch (IOException e3) {
                                Log.w("BdLogSDK", "writeDataToFile IOException", e3);
                            }
                        }
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                                return;
                            } catch (Exception e4) {
                                Log.w("BdLogSDK", "writeDataToFile close Exception", e4);
                                return;
                            }
                        }
                        return;
                    }
                } while (fileLock == null);
                dataOutputStream.write(d.b(encode));
                dataOutputStream.flush();
                str3 = fileLock;
                if (fileLock != null) {
                    try {
                        fileLock.release();
                        str3 = fileLock;
                    } catch (IOException e5) {
                        Log.w("BdLogSDK", "writeDataToFile IOException", e5);
                        str3 = "BdLogSDK";
                    }
                }
                if (fileChannel != null && fileChannel.isOpen()) {
                    try {
                        fileChannel.close();
                    } catch (IOException e6) {
                        str3 = "BdLogSDK";
                        Log.w("BdLogSDK", "writeDataToFile IOException", e6);
                    }
                }
                try {
                    dataOutputStream.close();
                } catch (Exception e7) {
                    Log.w("BdLogSDK", "writeDataToFile close Exception", e7);
                }
            } catch (Exception e8) {
                e = e8;
                fileLock = null;
                dataOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                str3 = 0;
                dataOutputStream = null;
                if (str3 != 0) {
                    try {
                        str3.release();
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
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (Exception e11) {
                        Log.w("BdLogSDK", "writeDataToFile close Exception", e11);
                    }
                }
                throw th;
            }
        } catch (Exception e12) {
            e = e12;
            fileLock = null;
            fileChannel = null;
            dataOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            str3 = 0;
            fileChannel = null;
            dataOutputStream = null;
        }
    }

    public static String c(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5).digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b2 : digest) {
                if ((b2 & 255) < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(b2 & 255));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
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
        if (com.baidu.webkit.logsdk.a.f5684a) {
            Log.w(str, str2);
        }
    }
}
