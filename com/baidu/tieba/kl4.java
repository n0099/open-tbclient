package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class kl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull tm4 tm4Var, @Nullable List<zk4> list, @Nullable List<al4> list2, @NonNull uj4 uj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, tm4Var, list, list2, uj4Var) == null) {
            em4 b = ml4.b(tm4Var, uj4Var);
            if (list != null && !list.isEmpty()) {
                ml4.a(b, dm4.h(list, uj4Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                ml4.a(b, dm4.e(list2, uj4Var));
            }
            b.e();
        }
    }

    public static void b(um4 um4Var, uj4 uj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, um4Var, uj4Var) == null) {
            ml4.c(um4Var, uj4Var);
        }
    }

    public static void c(vm4 vm4Var, uj4 uj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, vm4Var, uj4Var) == null) {
            ml4.d(vm4Var, uj4Var);
        }
    }

    public static void d(wm4 wm4Var, uj4 uj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, wm4Var, uj4Var) == null) {
            ml4.e(wm4Var, uj4Var);
        }
    }

    public static void e(ro4 ro4Var, uj4 uj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ro4Var, uj4Var) == null) {
            ml4.f(ro4Var, uj4Var);
        }
    }

    public static synchronized void f(List<al4> list, uj4 uj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, uj4Var) == null) {
            synchronized (kl4.class) {
                ml4.g(list, uj4Var);
            }
        }
    }
}
