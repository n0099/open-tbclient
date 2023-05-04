package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class j40 {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] a;
    public static final char[] b;
    public static final byte[] c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947833187, "Lcom/baidu/tieba/j40;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947833187, "Lcom/baidu/tieba/j40;");
                return;
            }
        }
        a = "0123456789ABCDEF".toCharArray();
        b = "0123456789abcdef".toCharArray();
        c = new byte[128];
        for (int i = 0; i < 10; i++) {
            byte[] bArr = c;
            bArr[i + 48] = (byte) i;
            byte b2 = (byte) (i + 10);
            bArr[i + 65] = b2;
            bArr[i + 97] = b2;
        }
    }

    public static char[] a(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        char[] cArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, bArr, z)) == null) {
            if (z) {
                cArr = a;
            } else {
                cArr = b;
            }
            char[] cArr2 = new char[bArr.length * 2];
            int i = 0;
            for (byte b2 : bArr) {
                int i2 = i + 1;
                cArr2[i] = cArr[(b2 & 240) >>> 4];
                i = i2 + 1;
                cArr2[i2] = cArr[b2 & 15];
            }
            return cArr2;
        }
        return (char[]) invokeLZ.objValue;
    }

    public static String b(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, bArr, z)) == null) {
            return new String(a(bArr, z));
        }
        return (String) invokeLZ.objValue;
    }
}
