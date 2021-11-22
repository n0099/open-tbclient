package com.bytedance.sdk.openadsdk.api.plugin;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.MessageDigest;
/* loaded from: classes11.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f62561a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1462304075, "Lcom/bytedance/sdk/openadsdk/api/plugin/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1462304075, "Lcom/bytedance/sdk/openadsdk/api/plugin/b;");
                return;
            }
        }
        f62561a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            if (bArr != null) {
                return a(bArr, 0, bArr.length);
            }
            throw new NullPointerException("bytes is null");
        }
        return (String) invokeL.objValue;
    }

    public static String a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, bArr, i2, i3)) == null) {
            if (bArr != null) {
                if (i2 >= 0 && i2 + i3 <= bArr.length) {
                    int i4 = i3 * 2;
                    char[] cArr = new char[i4];
                    int i5 = 0;
                    for (int i6 = 0; i6 < i3; i6++) {
                        int i7 = bArr[i6 + i2] & 255;
                        int i8 = i5 + 1;
                        char[] cArr2 = f62561a;
                        cArr[i5] = cArr2[i7 >> 4];
                        i5 = i8 + 1;
                        cArr[i8] = cArr2[i7 & 15];
                    }
                    return new String(cArr, 0, i4);
                }
                throw new IndexOutOfBoundsException();
            }
            throw new NullPointerException("bytes is null");
        }
        return (String) invokeLII.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str != null) {
                try {
                    if (str.length() != 0) {
                        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                        messageDigest.update(str.getBytes("UTF-8"));
                        return a(messageDigest.digest());
                    }
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
