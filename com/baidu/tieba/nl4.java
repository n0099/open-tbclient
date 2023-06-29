package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes7.dex */
public class nl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull wm4 wm4Var, @Nullable List<cl4> list, @Nullable List<dl4> list2, @NonNull xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, wm4Var, list, list2, xj4Var) == null) {
            hm4 b = pl4.b(wm4Var, xj4Var);
            if (list != null && !list.isEmpty()) {
                pl4.a(b, gm4.h(list, xj4Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                pl4.a(b, gm4.e(list2, xj4Var));
            }
            b.e();
        }
    }

    public static void b(xm4 xm4Var, xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, xm4Var, xj4Var) == null) {
            pl4.c(xm4Var, xj4Var);
        }
    }

    public static void c(ym4 ym4Var, xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, ym4Var, xj4Var) == null) {
            pl4.d(ym4Var, xj4Var);
        }
    }

    public static void d(zm4 zm4Var, xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, zm4Var, xj4Var) == null) {
            pl4.e(zm4Var, xj4Var);
        }
    }

    public static void e(uo4 uo4Var, xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, uo4Var, xj4Var) == null) {
            pl4.f(uo4Var, xj4Var);
        }
    }

    public static synchronized void f(List<dl4> list, xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, xj4Var) == null) {
            synchronized (nl4.class) {
                pl4.g(list, xj4Var);
            }
        }
    }
}
