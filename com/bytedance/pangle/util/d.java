package com.bytedance.pangle.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes4.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "DES/ECB/NoPadding";
    public static String b = "DESede/ECB/NoPadding";
    public static String c = "AES/ECB/NoPadding";
    public static final char[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1401945046, "Lcom/bytedance/pangle/util/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1401945046, "Lcom/bytedance/pangle/util/d;");
                return;
            }
        }
        d = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static String a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) ? a(b(file)) : (String) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0032 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.Closeable] */
    public static byte[] b(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file)) != null) {
            return (byte[]) invokeL.objValue;
        }
        ?? r0 = 0;
        try {
            if (file == null) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    DigestInputStream digestInputStream = new DigestInputStream(fileInputStream, MessageDigest.getInstance("MD5"));
                    do {
                    } while (digestInputStream.read(new byte[262144]) > 0);
                    byte[] digest = digestInputStream.getMessageDigest().digest();
                    f.a(fileInputStream);
                    return digest;
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                    f.a(fileInputStream);
                    return null;
                } catch (NoSuchAlgorithmException e2) {
                    e = e2;
                    e.printStackTrace();
                    f.a(fileInputStream);
                    return null;
                }
            } catch (IOException e3) {
                e = e3;
                fileInputStream = null;
                e.printStackTrace();
                f.a(fileInputStream);
                return null;
            } catch (NoSuchAlgorithmException e4) {
                e = e4;
                fileInputStream = null;
                e.printStackTrace();
                f.a(fileInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                f.a(r0);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            r0 = interceptable;
        }
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            if (bArr != null && (length = bArr.length) > 0) {
                char[] cArr = new char[length << 1];
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = i + 1;
                    char[] cArr2 = d;
                    cArr[i] = cArr2[(bArr[i2] >>> 4) & 15];
                    i = i3 + 1;
                    cArr[i3] = cArr2[bArr[i2] & 15];
                }
                return new String(cArr);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            boolean z = false;
            if (str != null) {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    if (!Character.isWhitespace(str.charAt(i))) {
                        break;
                    }
                }
            }
            z = true;
            return a(z ? null : new File(str));
        }
        return (String) invokeL.objValue;
    }
}
