package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class pd4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull ye4 ye4Var, @Nullable List<ed4> list, @Nullable List<fd4> list2, @NonNull zb4 zb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, ye4Var, list, list2, zb4Var) == null) {
            je4 b = rd4.b(ye4Var, zb4Var);
            if (list != null && !list.isEmpty()) {
                rd4.a(b, ie4.h(list, zb4Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                rd4.a(b, ie4.e(list2, zb4Var));
            }
            b.e();
        }
    }

    public static void b(ze4 ze4Var, zb4 zb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, ze4Var, zb4Var) == null) {
            rd4.c(ze4Var, zb4Var);
        }
    }

    public static void c(af4 af4Var, zb4 zb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, af4Var, zb4Var) == null) {
            rd4.d(af4Var, zb4Var);
        }
    }

    public static void d(bf4 bf4Var, zb4 zb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, bf4Var, zb4Var) == null) {
            rd4.e(bf4Var, zb4Var);
        }
    }

    public static void e(wg4 wg4Var, zb4 zb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, wg4Var, zb4Var) == null) {
            rd4.f(wg4Var, zb4Var);
        }
    }

    public static synchronized void f(List<fd4> list, zb4 zb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, zb4Var) == null) {
            synchronized (pd4.class) {
                rd4.g(list, zb4Var);
            }
        }
    }
}
