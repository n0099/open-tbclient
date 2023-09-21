package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.am4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes8.dex */
public class tk4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull ll4 ll4Var, @NonNull List<il4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, ll4Var, list) == null) {
            for (il4<T> il4Var : list) {
                ll4Var.c(gl4.b().a(il4Var));
            }
        }
    }

    public static synchronized void d(cm4 cm4Var, bj4 bj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, cm4Var, bj4Var) == null) {
            synchronized (tk4.class) {
                il4<hk4> i = kl4.i(cm4Var.a, bj4Var);
                ll4 ll4Var = new ll4(bj4Var);
                ll4Var.c(gl4.b().a(i));
                ll4Var.e();
            }
        }
    }

    public static synchronized void g(List<hk4> list, bj4 bj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, bj4Var) == null) {
            synchronized (tk4.class) {
                List<il4<hk4>> e = kl4.e(list, bj4Var);
                ll4 ll4Var = new ll4(bj4Var);
                a(ll4Var, e);
                ll4Var.e();
            }
        }
    }

    @NonNull
    public static ll4 b(am4 am4Var, bj4 bj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, am4Var, bj4Var)) == null) {
            List<il4<am4.a>> f = kl4.f(am4Var.a, bj4Var);
            ll4 ll4Var = new ll4(bj4Var);
            for (il4<am4.a> il4Var : f) {
                ll4Var.c(gl4.b().a(il4Var));
            }
            return ll4Var;
        }
        return (ll4) invokeLL.objValue;
    }

    public static synchronized void e(dm4 dm4Var, bj4 bj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, dm4Var, bj4Var) == null) {
            synchronized (tk4.class) {
                List<il4<gk4>> h = kl4.h(dm4Var.a, bj4Var);
                ll4 ll4Var = new ll4(bj4Var);
                for (il4<gk4> il4Var : h) {
                    ll4Var.c(gl4.b().a(il4Var));
                }
                ll4Var.e();
            }
        }
    }

    public static synchronized void c(bm4 bm4Var, bj4 bj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, bm4Var, bj4Var) == null) {
            synchronized (tk4.class) {
                il4<dk4> d = kl4.d(bm4Var.d, bj4Var);
                il4<fk4> g = kl4.g(bm4Var.a, bj4Var);
                il4<bk4> c = kl4.c(bm4Var.f, bj4Var);
                List<il4<gk4>> h = kl4.h(bm4Var.b, bj4Var);
                List<il4<hk4>> e = kl4.e(bm4Var.c, bj4Var);
                ll4 ll4Var = new ll4(bj4Var);
                ll4Var.c(gl4.b().a(d));
                ll4Var.c(gl4.b().a(g));
                ll4Var.c(gl4.b().a(c));
                a(ll4Var, h);
                a(ll4Var, e);
                ll4Var.e();
            }
        }
    }

    public static synchronized void f(yn4 yn4Var, bj4 bj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, yn4Var, bj4Var) == null) {
            synchronized (tk4.class) {
                il4<dk4> d = kl4.d(yn4Var.b, bj4Var);
                il4<dk4> d2 = kl4.d(yn4Var.a, bj4Var);
                il4<bk4> c = kl4.c(yn4Var.c, bj4Var);
                ll4 ll4Var = new ll4(bj4Var);
                if (d != null) {
                    ll4Var.c(gl4.b().a(d));
                }
                if (d2 != null) {
                    ll4Var.c(gl4.b().a(d2));
                }
                if (c != null) {
                    ll4Var.c(gl4.b().a(c));
                }
                if (yn4Var.d != null) {
                    for (ik4 ik4Var : yn4Var.d) {
                        il4<ik4> j = kl4.j(ik4Var, bj4Var);
                        if (j != null) {
                            ll4Var.c(gl4.b().a(j));
                        }
                    }
                }
                if (yn4Var.e != null) {
                    for (hk4 hk4Var : yn4Var.e) {
                        il4<hk4> i = kl4.i(hk4Var, bj4Var);
                        if (i != null) {
                            ll4Var.c(gl4.b().a(i));
                        }
                    }
                }
                ll4Var.e();
            }
        }
    }
}
