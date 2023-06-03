package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class jl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull sm4 sm4Var, @Nullable List<yk4> list, @Nullable List<zk4> list2, @NonNull tj4 tj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, sm4Var, list, list2, tj4Var) == null) {
            dm4 b = ll4.b(sm4Var, tj4Var);
            if (list != null && !list.isEmpty()) {
                ll4.a(b, cm4.h(list, tj4Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                ll4.a(b, cm4.e(list2, tj4Var));
            }
            b.e();
        }
    }

    public static void b(tm4 tm4Var, tj4 tj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, tm4Var, tj4Var) == null) {
            ll4.c(tm4Var, tj4Var);
        }
    }

    public static void c(um4 um4Var, tj4 tj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, um4Var, tj4Var) == null) {
            ll4.d(um4Var, tj4Var);
        }
    }

    public static void d(vm4 vm4Var, tj4 tj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, vm4Var, tj4Var) == null) {
            ll4.e(vm4Var, tj4Var);
        }
    }

    public static void e(qo4 qo4Var, tj4 tj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, qo4Var, tj4Var) == null) {
            ll4.f(qo4Var, tj4Var);
        }
    }

    public static synchronized void f(List<zk4> list, tj4 tj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, tj4Var) == null) {
            synchronized (jl4.class) {
                ll4.g(list, tj4Var);
            }
        }
    }
}
