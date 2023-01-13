package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.df4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class wd4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull oe4 oe4Var, @NonNull List<le4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, oe4Var, list) == null) {
            for (le4<T> le4Var : list) {
                oe4Var.c(je4.b().a(le4Var));
            }
        }
    }

    public static synchronized void d(ff4 ff4Var, ec4 ec4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, ff4Var, ec4Var) == null) {
            synchronized (wd4.class) {
                le4<kd4> i = ne4.i(ff4Var.a, ec4Var);
                oe4 oe4Var = new oe4(ec4Var);
                oe4Var.c(je4.b().a(i));
                oe4Var.e();
            }
        }
    }

    public static synchronized void g(List<kd4> list, ec4 ec4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, ec4Var) == null) {
            synchronized (wd4.class) {
                List<le4<kd4>> e = ne4.e(list, ec4Var);
                oe4 oe4Var = new oe4(ec4Var);
                a(oe4Var, e);
                oe4Var.e();
            }
        }
    }

    @NonNull
    public static oe4 b(df4 df4Var, ec4 ec4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, df4Var, ec4Var)) == null) {
            List<le4<df4.a>> f = ne4.f(df4Var.a, ec4Var);
            oe4 oe4Var = new oe4(ec4Var);
            for (le4<df4.a> le4Var : f) {
                oe4Var.c(je4.b().a(le4Var));
            }
            return oe4Var;
        }
        return (oe4) invokeLL.objValue;
    }

    public static synchronized void e(gf4 gf4Var, ec4 ec4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, gf4Var, ec4Var) == null) {
            synchronized (wd4.class) {
                List<le4<jd4>> h = ne4.h(gf4Var.a, ec4Var);
                oe4 oe4Var = new oe4(ec4Var);
                for (le4<jd4> le4Var : h) {
                    oe4Var.c(je4.b().a(le4Var));
                }
                oe4Var.e();
            }
        }
    }

    public static synchronized void c(ef4 ef4Var, ec4 ec4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, ef4Var, ec4Var) == null) {
            synchronized (wd4.class) {
                le4<gd4> d = ne4.d(ef4Var.d, ec4Var);
                le4<id4> g = ne4.g(ef4Var.a, ec4Var);
                le4<ed4> c = ne4.c(ef4Var.f, ec4Var);
                List<le4<jd4>> h = ne4.h(ef4Var.b, ec4Var);
                List<le4<kd4>> e = ne4.e(ef4Var.c, ec4Var);
                oe4 oe4Var = new oe4(ec4Var);
                oe4Var.c(je4.b().a(d));
                oe4Var.c(je4.b().a(g));
                oe4Var.c(je4.b().a(c));
                a(oe4Var, h);
                a(oe4Var, e);
                oe4Var.e();
            }
        }
    }

    public static synchronized void f(bh4 bh4Var, ec4 ec4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, bh4Var, ec4Var) == null) {
            synchronized (wd4.class) {
                le4<gd4> d = ne4.d(bh4Var.b, ec4Var);
                le4<gd4> d2 = ne4.d(bh4Var.a, ec4Var);
                le4<ed4> c = ne4.c(bh4Var.c, ec4Var);
                oe4 oe4Var = new oe4(ec4Var);
                if (d != null) {
                    oe4Var.c(je4.b().a(d));
                }
                if (d2 != null) {
                    oe4Var.c(je4.b().a(d2));
                }
                if (c != null) {
                    oe4Var.c(je4.b().a(c));
                }
                if (bh4Var.d != null) {
                    for (ld4 ld4Var : bh4Var.d) {
                        le4<ld4> j = ne4.j(ld4Var, ec4Var);
                        if (j != null) {
                            oe4Var.c(je4.b().a(j));
                        }
                    }
                }
                if (bh4Var.e != null) {
                    for (kd4 kd4Var : bh4Var.e) {
                        le4<kd4> i = ne4.i(kd4Var, ec4Var);
                        if (i != null) {
                            oe4Var.c(je4.b().a(i));
                        }
                    }
                }
                oe4Var.e();
            }
        }
    }
}
