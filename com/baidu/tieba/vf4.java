package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes8.dex */
public class vf4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull eh4 eh4Var, @Nullable List<kf4> list, @Nullable List<lf4> list2, @NonNull fe4 fe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, eh4Var, list, list2, fe4Var) == null) {
            pg4 b = xf4.b(eh4Var, fe4Var);
            if (list != null && !list.isEmpty()) {
                xf4.a(b, og4.h(list, fe4Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                xf4.a(b, og4.e(list2, fe4Var));
            }
            b.e();
        }
    }

    public static void b(fh4 fh4Var, fe4 fe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, fh4Var, fe4Var) == null) {
            xf4.c(fh4Var, fe4Var);
        }
    }

    public static void c(gh4 gh4Var, fe4 fe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, gh4Var, fe4Var) == null) {
            xf4.d(gh4Var, fe4Var);
        }
    }

    public static void d(hh4 hh4Var, fe4 fe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, hh4Var, fe4Var) == null) {
            xf4.e(hh4Var, fe4Var);
        }
    }

    public static void e(cj4 cj4Var, fe4 fe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cj4Var, fe4Var) == null) {
            xf4.f(cj4Var, fe4Var);
        }
    }

    public static synchronized void f(List<lf4> list, fe4 fe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, fe4Var) == null) {
            synchronized (vf4.class) {
                xf4.g(list, fe4Var);
            }
        }
    }
}
