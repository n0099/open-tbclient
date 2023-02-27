package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class xi4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull gk4 gk4Var, @Nullable List<mi4> list, @Nullable List<ni4> list2, @NonNull hh4 hh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, gk4Var, list, list2, hh4Var) == null) {
            rj4 b = zi4.b(gk4Var, hh4Var);
            if (list != null && !list.isEmpty()) {
                zi4.a(b, qj4.h(list, hh4Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                zi4.a(b, qj4.e(list2, hh4Var));
            }
            b.e();
        }
    }

    public static void b(hk4 hk4Var, hh4 hh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, hk4Var, hh4Var) == null) {
            zi4.c(hk4Var, hh4Var);
        }
    }

    public static void c(ik4 ik4Var, hh4 hh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, ik4Var, hh4Var) == null) {
            zi4.d(ik4Var, hh4Var);
        }
    }

    public static void d(jk4 jk4Var, hh4 hh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, jk4Var, hh4Var) == null) {
            zi4.e(jk4Var, hh4Var);
        }
    }

    public static void e(em4 em4Var, hh4 hh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, em4Var, hh4Var) == null) {
            zi4.f(em4Var, hh4Var);
        }
    }

    public static synchronized void f(List<ni4> list, hh4 hh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, hh4Var) == null) {
            synchronized (xi4.class) {
                zi4.g(list, hh4Var);
            }
        }
    }
}
