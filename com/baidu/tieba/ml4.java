package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.tm4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class ml4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull em4 em4Var, @NonNull List<bm4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, em4Var, list) == null) {
            for (bm4<T> bm4Var : list) {
                em4Var.c(zl4.b().a(bm4Var));
            }
        }
    }

    public static synchronized void d(vm4 vm4Var, uj4 uj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, vm4Var, uj4Var) == null) {
            synchronized (ml4.class) {
                bm4<al4> i = dm4.i(vm4Var.a, uj4Var);
                em4 em4Var = new em4(uj4Var);
                em4Var.c(zl4.b().a(i));
                em4Var.e();
            }
        }
    }

    public static synchronized void g(List<al4> list, uj4 uj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, uj4Var) == null) {
            synchronized (ml4.class) {
                List<bm4<al4>> e = dm4.e(list, uj4Var);
                em4 em4Var = new em4(uj4Var);
                a(em4Var, e);
                em4Var.e();
            }
        }
    }

    @NonNull
    public static em4 b(tm4 tm4Var, uj4 uj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tm4Var, uj4Var)) == null) {
            List<bm4<tm4.a>> f = dm4.f(tm4Var.a, uj4Var);
            em4 em4Var = new em4(uj4Var);
            for (bm4<tm4.a> bm4Var : f) {
                em4Var.c(zl4.b().a(bm4Var));
            }
            return em4Var;
        }
        return (em4) invokeLL.objValue;
    }

    public static synchronized void e(wm4 wm4Var, uj4 uj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, wm4Var, uj4Var) == null) {
            synchronized (ml4.class) {
                List<bm4<zk4>> h = dm4.h(wm4Var.a, uj4Var);
                em4 em4Var = new em4(uj4Var);
                for (bm4<zk4> bm4Var : h) {
                    em4Var.c(zl4.b().a(bm4Var));
                }
                em4Var.e();
            }
        }
    }

    public static synchronized void c(um4 um4Var, uj4 uj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, um4Var, uj4Var) == null) {
            synchronized (ml4.class) {
                bm4<wk4> d = dm4.d(um4Var.d, uj4Var);
                bm4<yk4> g = dm4.g(um4Var.a, uj4Var);
                bm4<uk4> c = dm4.c(um4Var.f, uj4Var);
                List<bm4<zk4>> h = dm4.h(um4Var.b, uj4Var);
                List<bm4<al4>> e = dm4.e(um4Var.c, uj4Var);
                em4 em4Var = new em4(uj4Var);
                em4Var.c(zl4.b().a(d));
                em4Var.c(zl4.b().a(g));
                em4Var.c(zl4.b().a(c));
                a(em4Var, h);
                a(em4Var, e);
                em4Var.e();
            }
        }
    }

    public static synchronized void f(ro4 ro4Var, uj4 uj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, ro4Var, uj4Var) == null) {
            synchronized (ml4.class) {
                bm4<wk4> d = dm4.d(ro4Var.b, uj4Var);
                bm4<wk4> d2 = dm4.d(ro4Var.a, uj4Var);
                bm4<uk4> c = dm4.c(ro4Var.c, uj4Var);
                em4 em4Var = new em4(uj4Var);
                if (d != null) {
                    em4Var.c(zl4.b().a(d));
                }
                if (d2 != null) {
                    em4Var.c(zl4.b().a(d2));
                }
                if (c != null) {
                    em4Var.c(zl4.b().a(c));
                }
                if (ro4Var.d != null) {
                    for (bl4 bl4Var : ro4Var.d) {
                        bm4<bl4> j = dm4.j(bl4Var, uj4Var);
                        if (j != null) {
                            em4Var.c(zl4.b().a(j));
                        }
                    }
                }
                if (ro4Var.e != null) {
                    for (al4 al4Var : ro4Var.e) {
                        bm4<al4> i = dm4.i(al4Var, uj4Var);
                        if (i != null) {
                            em4Var.c(zl4.b().a(i));
                        }
                    }
                }
                em4Var.e();
            }
        }
    }
}
