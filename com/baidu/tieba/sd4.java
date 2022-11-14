package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.ze4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class sd4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull ke4 ke4Var, @NonNull List<he4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, ke4Var, list) == null) {
            for (he4<T> he4Var : list) {
                ke4Var.c(fe4.b().a(he4Var));
            }
        }
    }

    public static synchronized void d(bf4 bf4Var, ac4 ac4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, bf4Var, ac4Var) == null) {
            synchronized (sd4.class) {
                he4<gd4> i = je4.i(bf4Var.a, ac4Var);
                ke4 ke4Var = new ke4(ac4Var);
                ke4Var.c(fe4.b().a(i));
                ke4Var.e();
            }
        }
    }

    public static synchronized void g(List<gd4> list, ac4 ac4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, ac4Var) == null) {
            synchronized (sd4.class) {
                List<he4<gd4>> e = je4.e(list, ac4Var);
                ke4 ke4Var = new ke4(ac4Var);
                a(ke4Var, e);
                ke4Var.e();
            }
        }
    }

    @NonNull
    public static ke4 b(ze4 ze4Var, ac4 ac4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, ze4Var, ac4Var)) == null) {
            List<he4<ze4.a>> f = je4.f(ze4Var.a, ac4Var);
            ke4 ke4Var = new ke4(ac4Var);
            for (he4<ze4.a> he4Var : f) {
                ke4Var.c(fe4.b().a(he4Var));
            }
            return ke4Var;
        }
        return (ke4) invokeLL.objValue;
    }

    public static synchronized void e(cf4 cf4Var, ac4 ac4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cf4Var, ac4Var) == null) {
            synchronized (sd4.class) {
                List<he4<fd4>> h = je4.h(cf4Var.a, ac4Var);
                ke4 ke4Var = new ke4(ac4Var);
                for (he4<fd4> he4Var : h) {
                    ke4Var.c(fe4.b().a(he4Var));
                }
                ke4Var.e();
            }
        }
    }

    public static synchronized void c(af4 af4Var, ac4 ac4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, af4Var, ac4Var) == null) {
            synchronized (sd4.class) {
                he4<cd4> d = je4.d(af4Var.d, ac4Var);
                he4<ed4> g = je4.g(af4Var.a, ac4Var);
                he4<ad4> c = je4.c(af4Var.f, ac4Var);
                List<he4<fd4>> h = je4.h(af4Var.b, ac4Var);
                List<he4<gd4>> e = je4.e(af4Var.c, ac4Var);
                ke4 ke4Var = new ke4(ac4Var);
                ke4Var.c(fe4.b().a(d));
                ke4Var.c(fe4.b().a(g));
                ke4Var.c(fe4.b().a(c));
                a(ke4Var, h);
                a(ke4Var, e);
                ke4Var.e();
            }
        }
    }

    public static synchronized void f(xg4 xg4Var, ac4 ac4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, xg4Var, ac4Var) == null) {
            synchronized (sd4.class) {
                he4<cd4> d = je4.d(xg4Var.b, ac4Var);
                he4<cd4> d2 = je4.d(xg4Var.a, ac4Var);
                he4<ad4> c = je4.c(xg4Var.c, ac4Var);
                ke4 ke4Var = new ke4(ac4Var);
                if (d != null) {
                    ke4Var.c(fe4.b().a(d));
                }
                if (d2 != null) {
                    ke4Var.c(fe4.b().a(d2));
                }
                if (c != null) {
                    ke4Var.c(fe4.b().a(c));
                }
                if (xg4Var.d != null) {
                    for (hd4 hd4Var : xg4Var.d) {
                        he4<hd4> j = je4.j(hd4Var, ac4Var);
                        if (j != null) {
                            ke4Var.c(fe4.b().a(j));
                        }
                    }
                }
                if (xg4Var.e != null) {
                    for (gd4 gd4Var : xg4Var.e) {
                        he4<gd4> i = je4.i(gd4Var, ac4Var);
                        if (i != null) {
                            ke4Var.c(fe4.b().a(i));
                        }
                    }
                }
                ke4Var.e();
            }
        }
    }
}
