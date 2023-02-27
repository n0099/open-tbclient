package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.gk4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes7.dex */
public class zi4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull rj4 rj4Var, @NonNull List<oj4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, rj4Var, list) == null) {
            for (oj4<T> oj4Var : list) {
                rj4Var.c(mj4.b().a(oj4Var));
            }
        }
    }

    public static synchronized void d(ik4 ik4Var, hh4 hh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, ik4Var, hh4Var) == null) {
            synchronized (zi4.class) {
                oj4<ni4> i = qj4.i(ik4Var.a, hh4Var);
                rj4 rj4Var = new rj4(hh4Var);
                rj4Var.c(mj4.b().a(i));
                rj4Var.e();
            }
        }
    }

    public static synchronized void g(List<ni4> list, hh4 hh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, hh4Var) == null) {
            synchronized (zi4.class) {
                List<oj4<ni4>> e = qj4.e(list, hh4Var);
                rj4 rj4Var = new rj4(hh4Var);
                a(rj4Var, e);
                rj4Var.e();
            }
        }
    }

    @NonNull
    public static rj4 b(gk4 gk4Var, hh4 hh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, gk4Var, hh4Var)) == null) {
            List<oj4<gk4.a>> f = qj4.f(gk4Var.a, hh4Var);
            rj4 rj4Var = new rj4(hh4Var);
            for (oj4<gk4.a> oj4Var : f) {
                rj4Var.c(mj4.b().a(oj4Var));
            }
            return rj4Var;
        }
        return (rj4) invokeLL.objValue;
    }

    public static synchronized void e(jk4 jk4Var, hh4 hh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jk4Var, hh4Var) == null) {
            synchronized (zi4.class) {
                List<oj4<mi4>> h = qj4.h(jk4Var.a, hh4Var);
                rj4 rj4Var = new rj4(hh4Var);
                for (oj4<mi4> oj4Var : h) {
                    rj4Var.c(mj4.b().a(oj4Var));
                }
                rj4Var.e();
            }
        }
    }

    public static synchronized void c(hk4 hk4Var, hh4 hh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, hk4Var, hh4Var) == null) {
            synchronized (zi4.class) {
                oj4<ji4> d = qj4.d(hk4Var.d, hh4Var);
                oj4<li4> g = qj4.g(hk4Var.a, hh4Var);
                oj4<hi4> c = qj4.c(hk4Var.f, hh4Var);
                List<oj4<mi4>> h = qj4.h(hk4Var.b, hh4Var);
                List<oj4<ni4>> e = qj4.e(hk4Var.c, hh4Var);
                rj4 rj4Var = new rj4(hh4Var);
                rj4Var.c(mj4.b().a(d));
                rj4Var.c(mj4.b().a(g));
                rj4Var.c(mj4.b().a(c));
                a(rj4Var, h);
                a(rj4Var, e);
                rj4Var.e();
            }
        }
    }

    public static synchronized void f(em4 em4Var, hh4 hh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, em4Var, hh4Var) == null) {
            synchronized (zi4.class) {
                oj4<ji4> d = qj4.d(em4Var.b, hh4Var);
                oj4<ji4> d2 = qj4.d(em4Var.a, hh4Var);
                oj4<hi4> c = qj4.c(em4Var.c, hh4Var);
                rj4 rj4Var = new rj4(hh4Var);
                if (d != null) {
                    rj4Var.c(mj4.b().a(d));
                }
                if (d2 != null) {
                    rj4Var.c(mj4.b().a(d2));
                }
                if (c != null) {
                    rj4Var.c(mj4.b().a(c));
                }
                if (em4Var.d != null) {
                    for (oi4 oi4Var : em4Var.d) {
                        oj4<oi4> j = qj4.j(oi4Var, hh4Var);
                        if (j != null) {
                            rj4Var.c(mj4.b().a(j));
                        }
                    }
                }
                if (em4Var.e != null) {
                    for (ni4 ni4Var : em4Var.e) {
                        oj4<ni4> i = qj4.i(ni4Var, hh4Var);
                        if (i != null) {
                            rj4Var.c(mj4.b().a(i));
                        }
                    }
                }
                rj4Var.e();
            }
        }
    }
}
