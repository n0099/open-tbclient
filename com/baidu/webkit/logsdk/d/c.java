package com.baidu.webkit.logsdk.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.RC4;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileLock;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes7.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            String[] split = str.split("_");
            if (split.length > 0) {
                return Integer.parseInt(split[0]);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (TextUtils.isEmpty(a)) {
                Context d = com.baidu.webkit.logsdk.a.b.d();
                if (d == null || d.getFilesDir() == null) {
                    return "";
                }
                String str = d.getFilesDir().getAbsolutePath() + "/bdlogs";
                if (str.endsWith(File.separator)) {
                    str = str.substring(0, str.length() - 1);
                }
                a = str;
                new File(a).mkdirs();
                e("BdLogSDK", "Workspace = " + a);
                return a;
            }
            return a;
        }
        return (String) invokeV.objValue;
    }

    public static String a(com.baidu.webkit.logsdk.b.b bVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bVar, str)) == null) {
            String c = bVar.c(str);
            if (TextUtils.isEmpty(c)) {
                com.baidu.webkit.logsdk.b c2 = com.baidu.webkit.logsdk.a.b.a().c();
                d(com.baidu.webkit.logsdk.b.b.e());
                int d = d(str);
                d(com.baidu.webkit.logsdk.b.b.g());
                String a2 = c2.a(d);
                if (!TextUtils.isEmpty(a2)) {
                    bVar.a(str, a2);
                }
                return a2;
            }
            return c;
        }
        return (String) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(File file) {
        InterceptResult invokeL;
        DataInputStream dataInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        Exception e;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, file)) != null) {
            return (String) invokeL.objValue;
        }
        if (file == null || !file.exists()) {
            return "";
        }
        e("BdLogSDK", "readDataFromFile " + file.getName());
        try {
            dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = dataInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        String str = new String(Base64.decode(new String(RC4.kernelEncrypt(byteArrayOutputStream.toByteArray())), 0));
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e2) {
                            Log.w("BdLogSDK", "readStatisticsDataFromFile close Exception", e2);
                        }
                        try {
                            dataInputStream.close();
                        } catch (Exception e3) {
                            Log.w("BdLogSDK", "readUserBehaviorStatisticsDataFromFile close Exception", e3);
                        }
                        return str;
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
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                                return "";
                            } catch (Exception e6) {
                                Log.w("BdLogSDK", "readUserBehaviorStatisticsDataFromFile close Exception", e6);
                                return "";
                            }
                        }
                        return "";
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e7) {
                            Log.w("BdLogSDK", "readStatisticsDataFromFile close Exception", e7);
                        }
                    }
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (Exception e8) {
                            Log.w("BdLogSDK", "readUserBehaviorStatisticsDataFromFile close Exception", e8);
                        }
                    }
                    throw th;
                }
            } catch (Exception e9) {
                e = e9;
                byteArrayOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                if (byteArrayOutputStream != null) {
                }
                if (dataInputStream != null) {
                }
                throw th;
            }
        } catch (Exception e10) {
            dataInputStream = null;
            e = e10;
            byteArrayOutputStream = null;
        } catch (Throwable th4) {
            dataInputStream = null;
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            int a2 = a(str2);
            com.baidu.webkit.logsdk.b.b e = com.baidu.webkit.logsdk.a.b.a().e();
            if (a2 != 0) {
                if (a2 != 1) {
                    return null;
                }
                return "";
            }
            return b.a(str, a(e, str2));
        }
        return (String) invokeLL.objValue;
    }

    public static void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, str, str2, str3) == null) {
            if (!com.baidu.webkit.logsdk.a.b || TextUtils.isEmpty(str3)) {
                if (com.baidu.webkit.logsdk.a.a) {
                    Log.i(str, str2);
                    return;
                }
                return;
            }
            Log.d(str, str2 + " = " + str3);
        }
    }

    public static void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, th) == null) {
            th.printStackTrace();
            if (com.baidu.webkit.logsdk.a.b) {
                System.exit(0);
            }
        }
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            StringBuffer stringBuffer = new StringBuffer(a());
            stringBuffer.append(File.separator);
            stringBuffer.append(str);
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x006a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:56:0x00a4 */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r6v2, resolved type: java.nio.channels.FileChannel */
    /* JADX DEBUG: Multi-variable search result rejected for r6v3, resolved type: java.nio.channels.FileChannel */
    /* JADX DEBUG: Multi-variable search result rejected for r6v6, resolved type: java.nio.channels.FileChannel */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.nio.channels.FileChannel] */
    public static void b(String str, String str2) {
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2;
        byte[] encode;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            dataOutputStream = null;
            if (interceptable.invokeLL(65544, null, str, str2) != null) {
                return;
            }
        }
        FileLock fileLock = null;
        try {
            try {
                e("BdLogSDK", "writeDataToFile ".concat(String.valueOf(str)));
                encode = Base64.encode(str2.getBytes(), 0);
                fileOutputStream = new FileOutputStream(new File(str));
                str = fileOutputStream.getChannel();
            } catch (Throwable th) {
                th = th;
            }
            try {
                dataOutputStream2 = new DataOutputStream(fileOutputStream);
                do {
                    try {
                        fileLock = str.tryLock();
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
                        if (str != 0 && str.isOpen()) {
                            try {
                                str.close();
                            } catch (IOException e3) {
                                Log.w("BdLogSDK", "writeDataToFile IOException", e3);
                            }
                        }
                        if (dataOutputStream2 != null) {
                            try {
                                dataOutputStream2.close();
                                return;
                            } catch (Exception e4) {
                                Log.w("BdLogSDK", "writeDataToFile close Exception", e4);
                                return;
                            }
                        }
                        return;
                    }
                } while (fileLock == null);
                dataOutputStream2.write(RC4.kernelEncrypt(encode));
                dataOutputStream2.flush();
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (IOException e5) {
                        Log.w("BdLogSDK", "writeDataToFile IOException", e5);
                    }
                }
                if (str != 0 && str.isOpen()) {
                    try {
                        str.close();
                    } catch (IOException e6) {
                        Log.w("BdLogSDK", "writeDataToFile IOException", e6);
                    }
                }
                try {
                    dataOutputStream2.close();
                } catch (Exception e7) {
                    Log.w("BdLogSDK", "writeDataToFile close Exception", e7);
                }
            } catch (Exception e8) {
                e = e8;
                dataOutputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream = null;
                if (0 != 0) {
                    try {
                        fileLock.release();
                    } catch (IOException e9) {
                        Log.w("BdLogSDK", "writeDataToFile IOException", e9);
                    }
                }
                if (str != 0 && str.isOpen()) {
                    try {
                        str.close();
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
            str = 0;
            dataOutputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            str = 0;
            dataOutputStream = null;
        }
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            try {
                byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
                StringBuilder sb = new StringBuilder(digest.length * 2);
                for (byte b : digest) {
                    int i = b & 255;
                    if (i < 16) {
                        sb.append("0");
                    }
                    sb.append(Integer.toHexString(i));
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
        return (String) invokeL.objValue;
    }

    public static String c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, str2)) == null) {
            String str3 = str + "-" + str2;
            a("BdLogSDK", "getFilename realName", str3);
            return Base64.encodeToString(str3.getBytes(), 0);
        }
        return (String) invokeLL.objValue;
    }

    public static int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            String[] split = str.split("_");
            if (split.length > 1) {
                return Integer.parseInt(split[1]);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, str2) == null) {
            new File(b(c(str, str2))).delete();
        }
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, str, str2) == null) && com.baidu.webkit.logsdk.a.a) {
            Log.w(str, str2);
        }
    }
}
