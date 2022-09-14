package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes4.dex */
public class jc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull sd4 sd4Var, @Nullable List<yb4> list, @Nullable List<zb4> list2, @NonNull ta4 ta4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, sd4Var, list, list2, ta4Var) == null) {
            dd4 b = lc4.b(sd4Var, ta4Var);
            if (list != null && !list.isEmpty()) {
                lc4.a(b, cd4.h(list, ta4Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                lc4.a(b, cd4.e(list2, ta4Var));
            }
            b.e();
        }
    }

    public static void b(td4 td4Var, ta4 ta4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, td4Var, ta4Var) == null) {
            lc4.c(td4Var, ta4Var);
        }
    }

    public static void c(ud4 ud4Var, ta4 ta4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, ud4Var, ta4Var) == null) {
            lc4.d(ud4Var, ta4Var);
        }
    }

    public static void d(vd4 vd4Var, ta4 ta4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, vd4Var, ta4Var) == null) {
            lc4.e(vd4Var, ta4Var);
        }
    }

    public static void e(qf4 qf4Var, ta4 ta4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, qf4Var, ta4Var) == null) {
            lc4.f(qf4Var, ta4Var);
        }
    }

    public static synchronized void f(List<zb4> list, ta4 ta4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, ta4Var) == null) {
            synchronized (jc4.class) {
                lc4.g(list, ta4Var);
            }
        }
    }
}
