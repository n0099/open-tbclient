package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class jk4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull sl4 sl4Var, @Nullable List<yj4> list, @Nullable List<zj4> list2, @NonNull ti4 ti4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, sl4Var, list, list2, ti4Var) == null) {
            dl4 b = lk4.b(sl4Var, ti4Var);
            if (list != null && !list.isEmpty()) {
                lk4.a(b, cl4.h(list, ti4Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                lk4.a(b, cl4.e(list2, ti4Var));
            }
            b.e();
        }
    }

    public static void b(tl4 tl4Var, ti4 ti4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, tl4Var, ti4Var) == null) {
            lk4.c(tl4Var, ti4Var);
        }
    }

    public static void c(ul4 ul4Var, ti4 ti4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, ul4Var, ti4Var) == null) {
            lk4.d(ul4Var, ti4Var);
        }
    }

    public static void d(vl4 vl4Var, ti4 ti4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, vl4Var, ti4Var) == null) {
            lk4.e(vl4Var, ti4Var);
        }
    }

    public static void e(qn4 qn4Var, ti4 ti4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, qn4Var, ti4Var) == null) {
            lk4.f(qn4Var, ti4Var);
        }
    }

    public static synchronized void f(List<zj4> list, ti4 ti4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, ti4Var) == null) {
            synchronized (jk4.class) {
                lk4.g(list, ti4Var);
            }
        }
    }
}
