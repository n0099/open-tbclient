package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.xl4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes7.dex */
public class qk4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull il4 il4Var, @NonNull List<fl4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, il4Var, list) == null) {
            for (fl4<T> fl4Var : list) {
                il4Var.c(dl4.b().a(fl4Var));
            }
        }
    }

    public static synchronized void d(zl4 zl4Var, yi4 yi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, zl4Var, yi4Var) == null) {
            synchronized (qk4.class) {
                fl4<ek4> i = hl4.i(zl4Var.a, yi4Var);
                il4 il4Var = new il4(yi4Var);
                il4Var.c(dl4.b().a(i));
                il4Var.e();
            }
        }
    }

    public static synchronized void g(List<ek4> list, yi4 yi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, yi4Var) == null) {
            synchronized (qk4.class) {
                List<fl4<ek4>> e = hl4.e(list, yi4Var);
                il4 il4Var = new il4(yi4Var);
                a(il4Var, e);
                il4Var.e();
            }
        }
    }

    @NonNull
    public static il4 b(xl4 xl4Var, yi4 yi4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, xl4Var, yi4Var)) == null) {
            List<fl4<xl4.a>> f = hl4.f(xl4Var.a, yi4Var);
            il4 il4Var = new il4(yi4Var);
            for (fl4<xl4.a> fl4Var : f) {
                il4Var.c(dl4.b().a(fl4Var));
            }
            return il4Var;
        }
        return (il4) invokeLL.objValue;
    }

    public static synchronized void e(am4 am4Var, yi4 yi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, am4Var, yi4Var) == null) {
            synchronized (qk4.class) {
                List<fl4<dk4>> h = hl4.h(am4Var.a, yi4Var);
                il4 il4Var = new il4(yi4Var);
                for (fl4<dk4> fl4Var : h) {
                    il4Var.c(dl4.b().a(fl4Var));
                }
                il4Var.e();
            }
        }
    }

    public static synchronized void c(yl4 yl4Var, yi4 yi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, yl4Var, yi4Var) == null) {
            synchronized (qk4.class) {
                fl4<ak4> d = hl4.d(yl4Var.d, yi4Var);
                fl4<ck4> g = hl4.g(yl4Var.a, yi4Var);
                fl4<yj4> c = hl4.c(yl4Var.f, yi4Var);
                List<fl4<dk4>> h = hl4.h(yl4Var.b, yi4Var);
                List<fl4<ek4>> e = hl4.e(yl4Var.c, yi4Var);
                il4 il4Var = new il4(yi4Var);
                il4Var.c(dl4.b().a(d));
                il4Var.c(dl4.b().a(g));
                il4Var.c(dl4.b().a(c));
                a(il4Var, h);
                a(il4Var, e);
                il4Var.e();
            }
        }
    }

    public static synchronized void f(vn4 vn4Var, yi4 yi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, vn4Var, yi4Var) == null) {
            synchronized (qk4.class) {
                fl4<ak4> d = hl4.d(vn4Var.b, yi4Var);
                fl4<ak4> d2 = hl4.d(vn4Var.a, yi4Var);
                fl4<yj4> c = hl4.c(vn4Var.c, yi4Var);
                il4 il4Var = new il4(yi4Var);
                if (d != null) {
                    il4Var.c(dl4.b().a(d));
                }
                if (d2 != null) {
                    il4Var.c(dl4.b().a(d2));
                }
                if (c != null) {
                    il4Var.c(dl4.b().a(c));
                }
                if (vn4Var.d != null) {
                    for (fk4 fk4Var : vn4Var.d) {
                        fl4<fk4> j = hl4.j(fk4Var, yi4Var);
                        if (j != null) {
                            il4Var.c(dl4.b().a(j));
                        }
                    }
                }
                if (vn4Var.e != null) {
                    for (ek4 ek4Var : vn4Var.e) {
                        fl4<ek4> i = hl4.i(ek4Var, yi4Var);
                        if (i != null) {
                            il4Var.c(dl4.b().a(i));
                        }
                    }
                }
                il4Var.e();
            }
        }
    }
}
