package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class qd4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull ze4 ze4Var, @Nullable List<fd4> list, @Nullable List<gd4> list2, @NonNull ac4 ac4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, ze4Var, list, list2, ac4Var) == null) {
            ke4 b = sd4.b(ze4Var, ac4Var);
            if (list != null && !list.isEmpty()) {
                sd4.a(b, je4.h(list, ac4Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                sd4.a(b, je4.e(list2, ac4Var));
            }
            b.e();
        }
    }

    public static void b(af4 af4Var, ac4 ac4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, af4Var, ac4Var) == null) {
            sd4.c(af4Var, ac4Var);
        }
    }

    public static void c(bf4 bf4Var, ac4 ac4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, bf4Var, ac4Var) == null) {
            sd4.d(bf4Var, ac4Var);
        }
    }

    public static void d(cf4 cf4Var, ac4 ac4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, cf4Var, ac4Var) == null) {
            sd4.e(cf4Var, ac4Var);
        }
    }

    public static void e(xg4 xg4Var, ac4 ac4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, xg4Var, ac4Var) == null) {
            sd4.f(xg4Var, ac4Var);
        }
    }

    public static synchronized void f(List<gd4> list, ac4 ac4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, ac4Var) == null) {
            synchronized (qd4.class) {
                sd4.g(list, ac4Var);
            }
        }
    }
}
