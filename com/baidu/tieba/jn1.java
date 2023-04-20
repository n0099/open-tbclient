package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.MessageDigest;
/* loaded from: classes5.dex */
public final class jn1 {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947888956, "Lcom/baidu/tieba/jn1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947888956, "Lcom/baidu/tieba/jn1;");
                return;
            }
        }
        a = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:4:0x0004 */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: byte */
    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [int] */
    public static String a(byte b) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(65537, null, b)) == null) {
            if (b < 0) {
                b += 256;
            }
            return a[b / 16] + a[b % 16];
        }
        return (String) invokeB.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String str2 = "";
            try {
                if (TextUtils.isEmpty(str)) {
                    return "";
                }
                String str3 = new String(str);
                try {
                    return c(MessageDigest.getInstance("MD5").digest(str3.getBytes()));
                } catch (Throwable th) {
                    th = th;
                    str2 = str3;
                    en1.d(th);
                    return str2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    public static String c(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArr) {
                stringBuffer.append(a(b));
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String d(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) {
            if (bArr == null || bArr.length <= 0) {
                return "";
            }
            try {
                return c(MessageDigest.getInstance("MD5").digest(bArr));
            } catch (Throwable th) {
                en1.d(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static byte[] e(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) {
            if (bArr == null || bArr.length <= 0) {
                return null;
            }
            try {
                return MessageDigest.getInstance("MD5").digest(bArr);
            } catch (Throwable th) {
                en1.d(th);
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }
}
