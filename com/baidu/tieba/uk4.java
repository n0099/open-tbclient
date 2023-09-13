package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.bm4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes8.dex */
public class uk4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull ml4 ml4Var, @NonNull List<jl4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, ml4Var, list) == null) {
            for (jl4<T> jl4Var : list) {
                ml4Var.c(hl4.b().a(jl4Var));
            }
        }
    }

    public static synchronized void d(dm4 dm4Var, cj4 cj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, dm4Var, cj4Var) == null) {
            synchronized (uk4.class) {
                jl4<ik4> i = ll4.i(dm4Var.a, cj4Var);
                ml4 ml4Var = new ml4(cj4Var);
                ml4Var.c(hl4.b().a(i));
                ml4Var.e();
            }
        }
    }

    public static synchronized void g(List<ik4> list, cj4 cj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, cj4Var) == null) {
            synchronized (uk4.class) {
                List<jl4<ik4>> e = ll4.e(list, cj4Var);
                ml4 ml4Var = new ml4(cj4Var);
                a(ml4Var, e);
                ml4Var.e();
            }
        }
    }

    @NonNull
    public static ml4 b(bm4 bm4Var, cj4 cj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bm4Var, cj4Var)) == null) {
            List<jl4<bm4.a>> f = ll4.f(bm4Var.a, cj4Var);
            ml4 ml4Var = new ml4(cj4Var);
            for (jl4<bm4.a> jl4Var : f) {
                ml4Var.c(hl4.b().a(jl4Var));
            }
            return ml4Var;
        }
        return (ml4) invokeLL.objValue;
    }

    public static synchronized void e(em4 em4Var, cj4 cj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, em4Var, cj4Var) == null) {
            synchronized (uk4.class) {
                List<jl4<hk4>> h = ll4.h(em4Var.a, cj4Var);
                ml4 ml4Var = new ml4(cj4Var);
                for (jl4<hk4> jl4Var : h) {
                    ml4Var.c(hl4.b().a(jl4Var));
                }
                ml4Var.e();
            }
        }
    }

    public static synchronized void c(cm4 cm4Var, cj4 cj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, cm4Var, cj4Var) == null) {
            synchronized (uk4.class) {
                jl4<ek4> d = ll4.d(cm4Var.d, cj4Var);
                jl4<gk4> g = ll4.g(cm4Var.a, cj4Var);
                jl4<ck4> c = ll4.c(cm4Var.f, cj4Var);
                List<jl4<hk4>> h = ll4.h(cm4Var.b, cj4Var);
                List<jl4<ik4>> e = ll4.e(cm4Var.c, cj4Var);
                ml4 ml4Var = new ml4(cj4Var);
                ml4Var.c(hl4.b().a(d));
                ml4Var.c(hl4.b().a(g));
                ml4Var.c(hl4.b().a(c));
                a(ml4Var, h);
                a(ml4Var, e);
                ml4Var.e();
            }
        }
    }

    public static synchronized void f(zn4 zn4Var, cj4 cj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, zn4Var, cj4Var) == null) {
            synchronized (uk4.class) {
                jl4<ek4> d = ll4.d(zn4Var.b, cj4Var);
                jl4<ek4> d2 = ll4.d(zn4Var.a, cj4Var);
                jl4<ck4> c = ll4.c(zn4Var.c, cj4Var);
                ml4 ml4Var = new ml4(cj4Var);
                if (d != null) {
                    ml4Var.c(hl4.b().a(d));
                }
                if (d2 != null) {
                    ml4Var.c(hl4.b().a(d2));
                }
                if (c != null) {
                    ml4Var.c(hl4.b().a(c));
                }
                if (zn4Var.d != null) {
                    for (jk4 jk4Var : zn4Var.d) {
                        jl4<jk4> j = ll4.j(jk4Var, cj4Var);
                        if (j != null) {
                            ml4Var.c(hl4.b().a(j));
                        }
                    }
                }
                if (zn4Var.e != null) {
                    for (ik4 ik4Var : zn4Var.e) {
                        jl4<ik4> i = ll4.i(ik4Var, cj4Var);
                        if (i != null) {
                            ml4Var.c(hl4.b().a(i));
                        }
                    }
                }
                ml4Var.e();
            }
        }
    }
}
