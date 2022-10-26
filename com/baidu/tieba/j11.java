package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class j11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Runnable runnable, String str, int i, long j) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{runnable, str, Integer.valueOf(i), Long.valueOf(j)}) != null) || runnable == null) {
            return;
        }
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            i2 = 3;
        } else {
            i2 = i;
        }
        r11.b().a().a(runnable, str, i2, j);
    }

    public static void b(Runnable runnable, String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65537, null, new Object[]{runnable, str, Long.valueOf(j)}) != null) || runnable == null) {
            return;
        }
        r11.b().a().b(runnable, str, j);
    }

    public static void c(Runnable runnable, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65538, null, runnable, str, i) == null) {
            a(runnable, str, i, 0L);
        }
    }

    public static void d(Runnable runnable, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, runnable, str) == null) {
            b(runnable, str, 0L);
        }
    }
}
