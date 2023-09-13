package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes8.dex */
public class sk4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull bm4 bm4Var, @Nullable List<hk4> list, @Nullable List<ik4> list2, @NonNull cj4 cj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, bm4Var, list, list2, cj4Var) == null) {
            ml4 b = uk4.b(bm4Var, cj4Var);
            if (list != null && !list.isEmpty()) {
                uk4.a(b, ll4.h(list, cj4Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                uk4.a(b, ll4.e(list2, cj4Var));
            }
            b.e();
        }
    }

    public static void b(cm4 cm4Var, cj4 cj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, cm4Var, cj4Var) == null) {
            uk4.c(cm4Var, cj4Var);
        }
    }

    public static void c(dm4 dm4Var, cj4 cj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, dm4Var, cj4Var) == null) {
            uk4.d(dm4Var, cj4Var);
        }
    }

    public static void d(em4 em4Var, cj4 cj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, em4Var, cj4Var) == null) {
            uk4.e(em4Var, cj4Var);
        }
    }

    public static void e(zn4 zn4Var, cj4 cj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, zn4Var, cj4Var) == null) {
            uk4.f(zn4Var, cj4Var);
        }
    }

    public static synchronized void f(List<ik4> list, cj4 cj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, cj4Var) == null) {
            synchronized (sk4.class) {
                uk4.g(list, cj4Var);
            }
        }
    }
}
