package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes4.dex */
public class ja4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull sb4 sb4Var, @Nullable List<y94> list, @Nullable List<z94> list2, @NonNull t84 t84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, sb4Var, list, list2, t84Var) == null) {
            db4 b = la4.b(sb4Var, t84Var);
            if (list != null && !list.isEmpty()) {
                la4.a(b, cb4.h(list, t84Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                la4.a(b, cb4.e(list2, t84Var));
            }
            b.e();
        }
    }

    public static void b(tb4 tb4Var, t84 t84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, tb4Var, t84Var) == null) {
            la4.c(tb4Var, t84Var);
        }
    }

    public static void c(ub4 ub4Var, t84 t84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, ub4Var, t84Var) == null) {
            la4.d(ub4Var, t84Var);
        }
    }

    public static void d(vb4 vb4Var, t84 t84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, vb4Var, t84Var) == null) {
            la4.e(vb4Var, t84Var);
        }
    }

    public static void e(qd4 qd4Var, t84 t84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, qd4Var, t84Var) == null) {
            la4.f(qd4Var, t84Var);
        }
    }

    public static synchronized void f(List<z94> list, t84 t84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, t84Var) == null) {
            synchronized (ja4.class) {
                la4.g(list, t84Var);
            }
        }
    }
}
