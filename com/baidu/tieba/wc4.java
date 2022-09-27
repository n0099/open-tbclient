package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class wc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull fe4 fe4Var, @Nullable List<lc4> list, @Nullable List<mc4> list2, @NonNull gb4 gb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, fe4Var, list, list2, gb4Var) == null) {
            qd4 b = yc4.b(fe4Var, gb4Var);
            if (list != null && !list.isEmpty()) {
                yc4.a(b, pd4.h(list, gb4Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                yc4.a(b, pd4.e(list2, gb4Var));
            }
            b.e();
        }
    }

    public static void b(ge4 ge4Var, gb4 gb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, ge4Var, gb4Var) == null) {
            yc4.c(ge4Var, gb4Var);
        }
    }

    public static void c(he4 he4Var, gb4 gb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, he4Var, gb4Var) == null) {
            yc4.d(he4Var, gb4Var);
        }
    }

    public static void d(ie4 ie4Var, gb4 gb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, ie4Var, gb4Var) == null) {
            yc4.e(ie4Var, gb4Var);
        }
    }

    public static void e(dg4 dg4Var, gb4 gb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, dg4Var, gb4Var) == null) {
            yc4.f(dg4Var, gb4Var);
        }
    }

    public static synchronized void f(List<mc4> list, gb4 gb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, gb4Var) == null) {
            synchronized (wc4.class) {
                yc4.g(list, gb4Var);
            }
        }
    }
}
