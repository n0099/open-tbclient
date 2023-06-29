package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.wm4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes7.dex */
public class pl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull hm4 hm4Var, @NonNull List<em4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, hm4Var, list) == null) {
            for (em4<T> em4Var : list) {
                hm4Var.c(cm4.b().a(em4Var));
            }
        }
    }

    public static synchronized void d(ym4 ym4Var, xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, ym4Var, xj4Var) == null) {
            synchronized (pl4.class) {
                em4<dl4> i = gm4.i(ym4Var.a, xj4Var);
                hm4 hm4Var = new hm4(xj4Var);
                hm4Var.c(cm4.b().a(i));
                hm4Var.e();
            }
        }
    }

    public static synchronized void g(List<dl4> list, xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, xj4Var) == null) {
            synchronized (pl4.class) {
                List<em4<dl4>> e = gm4.e(list, xj4Var);
                hm4 hm4Var = new hm4(xj4Var);
                a(hm4Var, e);
                hm4Var.e();
            }
        }
    }

    @NonNull
    public static hm4 b(wm4 wm4Var, xj4 xj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, wm4Var, xj4Var)) == null) {
            List<em4<wm4.a>> f = gm4.f(wm4Var.a, xj4Var);
            hm4 hm4Var = new hm4(xj4Var);
            for (em4<wm4.a> em4Var : f) {
                hm4Var.c(cm4.b().a(em4Var));
            }
            return hm4Var;
        }
        return (hm4) invokeLL.objValue;
    }

    public static synchronized void e(zm4 zm4Var, xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, zm4Var, xj4Var) == null) {
            synchronized (pl4.class) {
                List<em4<cl4>> h = gm4.h(zm4Var.a, xj4Var);
                hm4 hm4Var = new hm4(xj4Var);
                for (em4<cl4> em4Var : h) {
                    hm4Var.c(cm4.b().a(em4Var));
                }
                hm4Var.e();
            }
        }
    }

    public static synchronized void c(xm4 xm4Var, xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, xm4Var, xj4Var) == null) {
            synchronized (pl4.class) {
                em4<zk4> d = gm4.d(xm4Var.d, xj4Var);
                em4<bl4> g = gm4.g(xm4Var.a, xj4Var);
                em4<xk4> c = gm4.c(xm4Var.f, xj4Var);
                List<em4<cl4>> h = gm4.h(xm4Var.b, xj4Var);
                List<em4<dl4>> e = gm4.e(xm4Var.c, xj4Var);
                hm4 hm4Var = new hm4(xj4Var);
                hm4Var.c(cm4.b().a(d));
                hm4Var.c(cm4.b().a(g));
                hm4Var.c(cm4.b().a(c));
                a(hm4Var, h);
                a(hm4Var, e);
                hm4Var.e();
            }
        }
    }

    public static synchronized void f(uo4 uo4Var, xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, uo4Var, xj4Var) == null) {
            synchronized (pl4.class) {
                em4<zk4> d = gm4.d(uo4Var.b, xj4Var);
                em4<zk4> d2 = gm4.d(uo4Var.a, xj4Var);
                em4<xk4> c = gm4.c(uo4Var.c, xj4Var);
                hm4 hm4Var = new hm4(xj4Var);
                if (d != null) {
                    hm4Var.c(cm4.b().a(d));
                }
                if (d2 != null) {
                    hm4Var.c(cm4.b().a(d2));
                }
                if (c != null) {
                    hm4Var.c(cm4.b().a(c));
                }
                if (uo4Var.d != null) {
                    for (el4 el4Var : uo4Var.d) {
                        em4<el4> j = gm4.j(el4Var, xj4Var);
                        if (j != null) {
                            hm4Var.c(cm4.b().a(j));
                        }
                    }
                }
                if (uo4Var.e != null) {
                    for (dl4 dl4Var : uo4Var.e) {
                        em4<dl4> i = gm4.i(dl4Var, xj4Var);
                        if (i != null) {
                            hm4Var.c(cm4.b().a(i));
                        }
                    }
                }
                hm4Var.e();
            }
        }
    }
}
