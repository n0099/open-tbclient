package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes7.dex */
public class ri4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull ak4 ak4Var, @Nullable List<gi4> list, @Nullable List<hi4> list2, @NonNull bh4 bh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, ak4Var, list, list2, bh4Var) == null) {
            lj4 b = ti4.b(ak4Var, bh4Var);
            if (list != null && !list.isEmpty()) {
                ti4.a(b, kj4.h(list, bh4Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                ti4.a(b, kj4.e(list2, bh4Var));
            }
            b.e();
        }
    }

    public static void b(bk4 bk4Var, bh4 bh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, bk4Var, bh4Var) == null) {
            ti4.c(bk4Var, bh4Var);
        }
    }

    public static void c(ck4 ck4Var, bh4 bh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, ck4Var, bh4Var) == null) {
            ti4.d(ck4Var, bh4Var);
        }
    }

    public static void d(dk4 dk4Var, bh4 bh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, dk4Var, bh4Var) == null) {
            ti4.e(dk4Var, bh4Var);
        }
    }

    public static void e(yl4 yl4Var, bh4 bh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, yl4Var, bh4Var) == null) {
            ti4.f(yl4Var, bh4Var);
        }
    }

    public static synchronized void f(List<hi4> list, bh4 bh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, bh4Var) == null) {
            synchronized (ri4.class) {
                ti4.g(list, bh4Var);
            }
        }
    }
}
