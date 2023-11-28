package com.baidu.tieba;

import android.annotation.SuppressLint;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wcc {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "BaseKeyUtil";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948267218, "Lcom/baidu/tieba/wcc;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948267218, "Lcom/baidu/tieba/wcc;");
        }
    }

    public static int a(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65537, null, i, i2, i3)) == null) {
            if (i2 < i) {
                i = i2;
            }
            return i3 < i ? i3 : i;
        }
        return invokeIII.intValue;
    }

    public static boolean b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? i >= 16 : invokeI.booleanValue;
    }

    public static boolean c(int i, byte[] bArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i, bArr)) == null) {
            return b(i) & d(bArr);
        }
        return invokeIL.booleanValue;
    }

    public static boolean d(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) {
            if (bArr.length >= 16) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static byte[] e(String str, String str2, String str3, String str4, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            return g(str, str2, str3, ycc.b(str4), i, z);
        }
        return (byte[]) invokeCommon.objValue;
    }

    @SuppressLint({"NewApi"})
    public static byte[] g(String str, String str2, String str3, byte[] bArr, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{str, str2, str3, bArr, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            return f(str, str2, str3, bArr, 10000, i, z);
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static byte[] f(String str, String str2, String str3, byte[] bArr, int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{str, str2, str3, bArr, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            byte[] b = ycc.b(str);
            byte[] b2 = ycc.b(str2);
            byte[] b3 = ycc.b(str3);
            int a2 = a(b.length, b2.length, b3.length);
            if (c(a2, bArr)) {
                char[] cArr = new char[a2];
                for (int i3 = 0; i3 < a2; i3++) {
                    cArr[i3] = (char) ((b[i3] ^ b2[i3]) ^ b3[i3]);
                }
                if (!z) {
                    bdc.d(a, "exportRootKey: sha1");
                    return tcc.b(cArr, bArr, i, i2 * 8);
                }
                bdc.d(a, "exportRootKey: sha256");
                return tcc.c(cArr, bArr, i, i2 * 8);
            }
            throw new IllegalArgumentException("key length must be more than 128bit.");
        }
        return (byte[]) invokeCommon.objValue;
    }

    @SuppressLint({"NewApi"})
    public static byte[] h(String str, String str2, String str3, byte[] bArr, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{str, str2, str3, bArr, Boolean.valueOf(z)})) == null) {
            return g(str, str2, str3, bArr, 16, z);
        }
        return (byte[]) invokeCommon.objValue;
    }
}
