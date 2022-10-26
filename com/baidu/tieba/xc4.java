package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class xc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ge4 ge4Var, List list, List list2, hb4 hb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, ge4Var, list, list2, hb4Var) == null) {
            rd4 b = zc4.b(ge4Var, hb4Var);
            if (list != null && !list.isEmpty()) {
                zc4.a(b, qd4.h(list, hb4Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                zc4.a(b, qd4.e(list2, hb4Var));
            }
            b.e();
        }
    }

    public static void b(he4 he4Var, hb4 hb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, he4Var, hb4Var) == null) {
            zc4.c(he4Var, hb4Var);
        }
    }

    public static void c(ie4 ie4Var, hb4 hb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, ie4Var, hb4Var) == null) {
            zc4.d(ie4Var, hb4Var);
        }
    }

    public static void d(je4 je4Var, hb4 hb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, je4Var, hb4Var) == null) {
            zc4.e(je4Var, hb4Var);
        }
    }

    public static void e(eg4 eg4Var, hb4 hb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, eg4Var, hb4Var) == null) {
            zc4.f(eg4Var, hb4Var);
        }
    }

    public static synchronized void f(List list, hb4 hb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, hb4Var) == null) {
            synchronized (xc4.class) {
                zc4.g(list, hb4Var);
            }
        }
    }
}
