package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class ud4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull df4 df4Var, @Nullable List<jd4> list, @Nullable List<kd4> list2, @NonNull ec4 ec4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, df4Var, list, list2, ec4Var) == null) {
            oe4 b = wd4.b(df4Var, ec4Var);
            if (list != null && !list.isEmpty()) {
                wd4.a(b, ne4.h(list, ec4Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                wd4.a(b, ne4.e(list2, ec4Var));
            }
            b.e();
        }
    }

    public static void b(ef4 ef4Var, ec4 ec4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, ef4Var, ec4Var) == null) {
            wd4.c(ef4Var, ec4Var);
        }
    }

    public static void c(ff4 ff4Var, ec4 ec4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, ff4Var, ec4Var) == null) {
            wd4.d(ff4Var, ec4Var);
        }
    }

    public static void d(gf4 gf4Var, ec4 ec4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, gf4Var, ec4Var) == null) {
            wd4.e(gf4Var, ec4Var);
        }
    }

    public static void e(bh4 bh4Var, ec4 ec4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bh4Var, ec4Var) == null) {
            wd4.f(bh4Var, ec4Var);
        }
    }

    public static synchronized void f(List<kd4> list, ec4 ec4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, ec4Var) == null) {
            synchronized (ud4.class) {
                wd4.g(list, ec4Var);
            }
        }
    }
}
