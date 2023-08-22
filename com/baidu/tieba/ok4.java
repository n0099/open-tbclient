package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes7.dex */
public class ok4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull xl4 xl4Var, @Nullable List<dk4> list, @Nullable List<ek4> list2, @NonNull yi4 yi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, xl4Var, list, list2, yi4Var) == null) {
            il4 b = qk4.b(xl4Var, yi4Var);
            if (list != null && !list.isEmpty()) {
                qk4.a(b, hl4.h(list, yi4Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                qk4.a(b, hl4.e(list2, yi4Var));
            }
            b.e();
        }
    }

    public static void b(yl4 yl4Var, yi4 yi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, yl4Var, yi4Var) == null) {
            qk4.c(yl4Var, yi4Var);
        }
    }

    public static void c(zl4 zl4Var, yi4 yi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, zl4Var, yi4Var) == null) {
            qk4.d(zl4Var, yi4Var);
        }
    }

    public static void d(am4 am4Var, yi4 yi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, am4Var, yi4Var) == null) {
            qk4.e(am4Var, yi4Var);
        }
    }

    public static void e(vn4 vn4Var, yi4 yi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, vn4Var, yi4Var) == null) {
            qk4.f(vn4Var, yi4Var);
        }
    }

    public static synchronized void f(List<ek4> list, yi4 yi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, yi4Var) == null) {
            synchronized (ok4.class) {
                qk4.g(list, yi4Var);
            }
        }
    }
}
