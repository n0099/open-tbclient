package com.baidu.webkit.logsdk.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
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
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes9.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f64245a;
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
            if (TextUtils.isEmpty(f64245a)) {
                Context d2 = com.baidu.webkit.logsdk.a.b.d();
                if (d2 == null || d2.getFilesDir() == null) {
                    return "";
                }
                String str = d2.getFilesDir().getAbsolutePath() + "/bdlogs";
                if (str.endsWith(File.separator)) {
                    str = str.substring(0, str.length() - 1);
                }
                f64245a = str;
                new File(f64245a).mkdirs();
                e("BdLogSDK", "Workspace = " + f64245a);
                return f64245a;
            }
            return f64245a;
        }
        return (String) invokeV.objValue;
    }

    public static String a(com.baidu.webkit.logsdk.b.b bVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bVar, str)) == null) {
            String c2 = bVar.c(str);
            if (TextUtils.isEmpty(c2)) {
                com.baidu.webkit.logsdk.b c3 = com.baidu.webkit.logsdk.a.b.a().c();
                d(com.baidu.webkit.logsdk.b.b.e());
                int d2 = d(str);
                d(com.baidu.webkit.logsdk.b.b.g());
                String a2 = c3.a(d2);
                if (!TextUtils.isEmpty(a2)) {
                    bVar.a(str, a2);
                }
                return a2;
            }
            return c2;
        }
        return (String) invokeLL.objValue;
    }

    public static String a(File file) {
        InterceptResult invokeL;
        DataInputStream dataInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, file)) != null) {
            return (String) invokeL.objValue;
        }
        if (file == null || !file.exists()) {
            return "";
        }
        e("BdLogSDK", "readDataFromFile " + file.getName());
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
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
                    } catch (Exception unused) {
                    }
                    try {
                        dataInputStream.close();
                    } catch (Exception unused2) {
                    }
                    return str;
                } catch (Exception unused3) {
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception unused4) {
                        }
                    }
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                            return "";
                        } catch (Exception unused5) {
                            return "";
                        }
                    }
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused6) {
                        }
                    }
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (Exception unused7) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused8) {
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
        } catch (Exception unused9) {
            dataInputStream = null;
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
            com.baidu.webkit.logsdk.b.b e2 = com.baidu.webkit.logsdk.a.b.a().e();
            if (a2 != 0) {
                if (a2 != 1) {
                    return null;
                }
                return "";
            }
            return b.a(str, a(e2, str2));
        }
        return (String) invokeLL.objValue;
    }

    public static void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, str, str2, str3) == null) {
            if (!com.baidu.webkit.logsdk.a.f64182b || TextUtils.isEmpty(str3)) {
                boolean z = com.baidu.webkit.logsdk.a.f64181a;
                return;
            }
            String str4 = str2 + " = " + str3;
        }
    }

    public static void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, th) == null) {
            th.printStackTrace();
            if (com.baidu.webkit.logsdk.a.f64182b) {
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

    public static void b(String str, String str2) {
        FileChannel fileChannel;
        DataOutputStream dataOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65544, null, str, str2) != null) {
            return;
        }
        FileLock fileLock = null;
        try {
            e("BdLogSDK", "writeDataToFile ".concat(String.valueOf(str)));
            byte[] encode = Base64.encode(str2.getBytes(), 0);
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
            fileChannel = fileOutputStream.getChannel();
            try {
                dataOutputStream = new DataOutputStream(fileOutputStream);
                do {
                    try {
                        fileLock = fileChannel.tryLock();
                    } catch (Exception unused) {
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (IOException unused2) {
                            }
                        }
                        if (fileChannel != null && fileChannel.isOpen()) {
                            try {
                                fileChannel.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                                return;
                            } catch (Exception unused4) {
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (IOException unused5) {
                            }
                        }
                        if (fileChannel != null && fileChannel.isOpen()) {
                            try {
                                fileChannel.close();
                            } catch (IOException unused6) {
                            }
                        }
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (Exception unused7) {
                            }
                        }
                        throw th;
                    }
                } while (fileLock == null);
                dataOutputStream.write(RC4.kernelEncrypt(encode));
                dataOutputStream.flush();
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (IOException unused8) {
                    }
                }
                if (fileChannel != null && fileChannel.isOpen()) {
                    try {
                        fileChannel.close();
                    } catch (IOException unused9) {
                    }
                }
                try {
                    dataOutputStream.close();
                } catch (Exception unused10) {
                }
            } catch (Exception unused11) {
                dataOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream = null;
            }
        } catch (Exception unused12) {
            fileChannel = null;
            dataOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
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
                for (byte b2 : digest) {
                    int i2 = b2 & 255;
                    if (i2 < 16) {
                        sb.append("0");
                    }
                    sb.append(Integer.toHexString(i2));
                }
                return sb.toString();
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return null;
            } catch (NoSuchAlgorithmException e3) {
                e3.printStackTrace();
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
        if (interceptable == null || interceptable.invokeLL(65549, null, str, str2) == null) {
            boolean z = com.baidu.webkit.logsdk.a.f64181a;
        }
    }
}
