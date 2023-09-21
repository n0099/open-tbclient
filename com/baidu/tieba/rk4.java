package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes7.dex */
public class rk4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull am4 am4Var, @Nullable List<gk4> list, @Nullable List<hk4> list2, @NonNull bj4 bj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, am4Var, list, list2, bj4Var) == null) {
            ll4 b = tk4.b(am4Var, bj4Var);
            if (list != null && !list.isEmpty()) {
                tk4.a(b, kl4.h(list, bj4Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                tk4.a(b, kl4.e(list2, bj4Var));
            }
            b.e();
        }
    }

    public static void b(bm4 bm4Var, bj4 bj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, bm4Var, bj4Var) == null) {
            tk4.c(bm4Var, bj4Var);
        }
    }

    public static void c(cm4 cm4Var, bj4 bj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, cm4Var, bj4Var) == null) {
            tk4.d(cm4Var, bj4Var);
        }
    }

    public static void d(dm4 dm4Var, bj4 bj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, dm4Var, bj4Var) == null) {
            tk4.e(dm4Var, bj4Var);
        }
    }

    public static void e(yn4 yn4Var, bj4 bj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, yn4Var, bj4Var) == null) {
            tk4.f(yn4Var, bj4Var);
        }
    }

    public static synchronized void f(List<hk4> list, bj4 bj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, bj4Var) == null) {
            synchronized (rk4.class) {
                tk4.g(list, bj4Var);
            }
        }
    }
}
