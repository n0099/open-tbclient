package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.ri4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class kh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull ci4 ci4Var, @NonNull List<zh4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, ci4Var, list) == null) {
            for (zh4<T> zh4Var : list) {
                ci4Var.c(xh4.b().a(zh4Var));
            }
        }
    }

    public static synchronized void d(ti4 ti4Var, sf4 sf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, ti4Var, sf4Var) == null) {
            synchronized (kh4.class) {
                zh4<yg4> i = bi4.i(ti4Var.a, sf4Var);
                ci4 ci4Var = new ci4(sf4Var);
                ci4Var.c(xh4.b().a(i));
                ci4Var.e();
            }
        }
    }

    public static synchronized void g(List<yg4> list, sf4 sf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, sf4Var) == null) {
            synchronized (kh4.class) {
                List<zh4<yg4>> e = bi4.e(list, sf4Var);
                ci4 ci4Var = new ci4(sf4Var);
                a(ci4Var, e);
                ci4Var.e();
            }
        }
    }

    @NonNull
    public static ci4 b(ri4 ri4Var, sf4 sf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, ri4Var, sf4Var)) == null) {
            List<zh4<ri4.a>> f = bi4.f(ri4Var.a, sf4Var);
            ci4 ci4Var = new ci4(sf4Var);
            for (zh4<ri4.a> zh4Var : f) {
                ci4Var.c(xh4.b().a(zh4Var));
            }
            return ci4Var;
        }
        return (ci4) invokeLL.objValue;
    }

    public static synchronized void e(ui4 ui4Var, sf4 sf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ui4Var, sf4Var) == null) {
            synchronized (kh4.class) {
                List<zh4<xg4>> h = bi4.h(ui4Var.a, sf4Var);
                ci4 ci4Var = new ci4(sf4Var);
                for (zh4<xg4> zh4Var : h) {
                    ci4Var.c(xh4.b().a(zh4Var));
                }
                ci4Var.e();
            }
        }
    }

    public static synchronized void c(si4 si4Var, sf4 sf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, si4Var, sf4Var) == null) {
            synchronized (kh4.class) {
                zh4<ug4> d = bi4.d(si4Var.d, sf4Var);
                zh4<wg4> g = bi4.g(si4Var.a, sf4Var);
                zh4<sg4> c = bi4.c(si4Var.f, sf4Var);
                List<zh4<xg4>> h = bi4.h(si4Var.b, sf4Var);
                List<zh4<yg4>> e = bi4.e(si4Var.c, sf4Var);
                ci4 ci4Var = new ci4(sf4Var);
                ci4Var.c(xh4.b().a(d));
                ci4Var.c(xh4.b().a(g));
                ci4Var.c(xh4.b().a(c));
                a(ci4Var, h);
                a(ci4Var, e);
                ci4Var.e();
            }
        }
    }

    public static synchronized void f(pk4 pk4Var, sf4 sf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, pk4Var, sf4Var) == null) {
            synchronized (kh4.class) {
                zh4<ug4> d = bi4.d(pk4Var.b, sf4Var);
                zh4<ug4> d2 = bi4.d(pk4Var.a, sf4Var);
                zh4<sg4> c = bi4.c(pk4Var.c, sf4Var);
                ci4 ci4Var = new ci4(sf4Var);
                if (d != null) {
                    ci4Var.c(xh4.b().a(d));
                }
                if (d2 != null) {
                    ci4Var.c(xh4.b().a(d2));
                }
                if (c != null) {
                    ci4Var.c(xh4.b().a(c));
                }
                if (pk4Var.d != null) {
                    for (zg4 zg4Var : pk4Var.d) {
                        zh4<zg4> j = bi4.j(zg4Var, sf4Var);
                        if (j != null) {
                            ci4Var.c(xh4.b().a(j));
                        }
                    }
                }
                if (pk4Var.e != null) {
                    for (yg4 yg4Var : pk4Var.e) {
                        zh4<yg4> i = bi4.i(yg4Var, sf4Var);
                        if (i != null) {
                            ci4Var.c(xh4.b().a(i));
                        }
                    }
                }
                ci4Var.e();
            }
        }
    }
}
