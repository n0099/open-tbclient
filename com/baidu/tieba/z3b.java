package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class z3b {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] a;
    public static final int[] b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948310432, "Lcom/baidu/tieba/z3b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948310432, "Lcom/baidu/tieba/z3b;");
                return;
            }
        }
        a = new byte[1024];
        b = new int[1024];
    }

    public static void a(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65537, null, bArr, i, i2) == null) {
            int i3 = 0;
            while (i3 < i2) {
                int min = Math.min(i3 + 1024, i2) - i3;
                System.arraycopy(a, 0, bArr, i + i3, min);
                i3 += min;
            }
        }
    }

    public static void b(int[] iArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, iArr, i, i2) == null) {
            int i3 = 0;
            while (i3 < i2) {
                int min = Math.min(i3 + 1024, i2) - i3;
                System.arraycopy(b, 0, iArr, i + i3, min);
                i3 += min;
            }
        }
    }
}
