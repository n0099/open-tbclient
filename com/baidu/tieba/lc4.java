package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.sd4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes4.dex */
public class lc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull dd4 dd4Var, @NonNull List<ad4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, dd4Var, list) == null) {
            for (ad4<T> ad4Var : list) {
                dd4Var.c(yc4.b().a(ad4Var));
            }
        }
    }

    @NonNull
    public static dd4 b(sd4 sd4Var, ta4 ta4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, sd4Var, ta4Var)) == null) {
            List<ad4<sd4.a>> f = cd4.f(sd4Var.a, ta4Var);
            dd4 dd4Var = new dd4(ta4Var);
            for (ad4<sd4.a> ad4Var : f) {
                dd4Var.c(yc4.b().a(ad4Var));
            }
            return dd4Var;
        }
        return (dd4) invokeLL.objValue;
    }

    public static synchronized void c(td4 td4Var, ta4 ta4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, td4Var, ta4Var) == null) {
            synchronized (lc4.class) {
                ad4<vb4> d = cd4.d(td4Var.d, ta4Var);
                ad4<xb4> g = cd4.g(td4Var.a, ta4Var);
                ad4<tb4> c = cd4.c(td4Var.f, ta4Var);
                List<ad4<yb4>> h = cd4.h(td4Var.b, ta4Var);
                List<ad4<zb4>> e = cd4.e(td4Var.c, ta4Var);
                dd4 dd4Var = new dd4(ta4Var);
                dd4Var.c(yc4.b().a(d));
                dd4Var.c(yc4.b().a(g));
                dd4Var.c(yc4.b().a(c));
                a(dd4Var, h);
                a(dd4Var, e);
                dd4Var.e();
            }
        }
    }

    public static synchronized void d(ud4 ud4Var, ta4 ta4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, ud4Var, ta4Var) == null) {
            synchronized (lc4.class) {
                ad4<zb4> i = cd4.i(ud4Var.a, ta4Var);
                dd4 dd4Var = new dd4(ta4Var);
                dd4Var.c(yc4.b().a(i));
                dd4Var.e();
            }
        }
    }

    public static synchronized void e(vd4 vd4Var, ta4 ta4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, vd4Var, ta4Var) == null) {
            synchronized (lc4.class) {
                List<ad4<yb4>> h = cd4.h(vd4Var.a, ta4Var);
                dd4 dd4Var = new dd4(ta4Var);
                for (ad4<yb4> ad4Var : h) {
                    dd4Var.c(yc4.b().a(ad4Var));
                }
                dd4Var.e();
            }
        }
    }

    public static synchronized void f(qf4 qf4Var, ta4 ta4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, qf4Var, ta4Var) == null) {
            synchronized (lc4.class) {
                ad4<vb4> d = cd4.d(qf4Var.b, ta4Var);
                ad4<vb4> d2 = cd4.d(qf4Var.a, ta4Var);
                ad4<tb4> c = cd4.c(qf4Var.c, ta4Var);
                dd4 dd4Var = new dd4(ta4Var);
                if (d != null) {
                    dd4Var.c(yc4.b().a(d));
                }
                if (d2 != null) {
                    dd4Var.c(yc4.b().a(d2));
                }
                if (c != null) {
                    dd4Var.c(yc4.b().a(c));
                }
                if (qf4Var.d != null) {
                    for (ac4 ac4Var : qf4Var.d) {
                        ad4<ac4> j = cd4.j(ac4Var, ta4Var);
                        if (j != null) {
                            dd4Var.c(yc4.b().a(j));
                        }
                    }
                }
                if (qf4Var.e != null) {
                    for (zb4 zb4Var : qf4Var.e) {
                        ad4<zb4> i = cd4.i(zb4Var, ta4Var);
                        if (i != null) {
                            dd4Var.c(yc4.b().a(i));
                        }
                    }
                }
                dd4Var.e();
            }
        }
    }

    public static synchronized void g(List<zb4> list, ta4 ta4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, ta4Var) == null) {
            synchronized (lc4.class) {
                List<ad4<zb4>> e = cd4.e(list, ta4Var);
                dd4 dd4Var = new dd4(ta4Var);
                a(dd4Var, e);
                dd4Var.e();
            }
        }
    }
}
