package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.fe4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class yc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull qd4 qd4Var, @NonNull List<nd4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, qd4Var, list) == null) {
            for (nd4<T> nd4Var : list) {
                qd4Var.c(ld4.b().a(nd4Var));
            }
        }
    }

    @NonNull
    public static qd4 b(fe4 fe4Var, gb4 gb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, fe4Var, gb4Var)) == null) {
            List<nd4<fe4.a>> f = pd4.f(fe4Var.a, gb4Var);
            qd4 qd4Var = new qd4(gb4Var);
            for (nd4<fe4.a> nd4Var : f) {
                qd4Var.c(ld4.b().a(nd4Var));
            }
            return qd4Var;
        }
        return (qd4) invokeLL.objValue;
    }

    public static synchronized void c(ge4 ge4Var, gb4 gb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, ge4Var, gb4Var) == null) {
            synchronized (yc4.class) {
                nd4<ic4> d = pd4.d(ge4Var.d, gb4Var);
                nd4<kc4> g = pd4.g(ge4Var.a, gb4Var);
                nd4<gc4> c = pd4.c(ge4Var.f, gb4Var);
                List<nd4<lc4>> h = pd4.h(ge4Var.b, gb4Var);
                List<nd4<mc4>> e = pd4.e(ge4Var.c, gb4Var);
                qd4 qd4Var = new qd4(gb4Var);
                qd4Var.c(ld4.b().a(d));
                qd4Var.c(ld4.b().a(g));
                qd4Var.c(ld4.b().a(c));
                a(qd4Var, h);
                a(qd4Var, e);
                qd4Var.e();
            }
        }
    }

    public static synchronized void d(he4 he4Var, gb4 gb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, he4Var, gb4Var) == null) {
            synchronized (yc4.class) {
                nd4<mc4> i = pd4.i(he4Var.a, gb4Var);
                qd4 qd4Var = new qd4(gb4Var);
                qd4Var.c(ld4.b().a(i));
                qd4Var.e();
            }
        }
    }

    public static synchronized void e(ie4 ie4Var, gb4 gb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ie4Var, gb4Var) == null) {
            synchronized (yc4.class) {
                List<nd4<lc4>> h = pd4.h(ie4Var.a, gb4Var);
                qd4 qd4Var = new qd4(gb4Var);
                for (nd4<lc4> nd4Var : h) {
                    qd4Var.c(ld4.b().a(nd4Var));
                }
                qd4Var.e();
            }
        }
    }

    public static synchronized void f(dg4 dg4Var, gb4 gb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, dg4Var, gb4Var) == null) {
            synchronized (yc4.class) {
                nd4<ic4> d = pd4.d(dg4Var.b, gb4Var);
                nd4<ic4> d2 = pd4.d(dg4Var.a, gb4Var);
                nd4<gc4> c = pd4.c(dg4Var.c, gb4Var);
                qd4 qd4Var = new qd4(gb4Var);
                if (d != null) {
                    qd4Var.c(ld4.b().a(d));
                }
                if (d2 != null) {
                    qd4Var.c(ld4.b().a(d2));
                }
                if (c != null) {
                    qd4Var.c(ld4.b().a(c));
                }
                if (dg4Var.d != null) {
                    for (nc4 nc4Var : dg4Var.d) {
                        nd4<nc4> j = pd4.j(nc4Var, gb4Var);
                        if (j != null) {
                            qd4Var.c(ld4.b().a(j));
                        }
                    }
                }
                if (dg4Var.e != null) {
                    for (mc4 mc4Var : dg4Var.e) {
                        nd4<mc4> i = pd4.i(mc4Var, gb4Var);
                        if (i != null) {
                            qd4Var.c(ld4.b().a(i));
                        }
                    }
                }
                qd4Var.e();
            }
        }
    }

    public static synchronized void g(List<mc4> list, gb4 gb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, gb4Var) == null) {
            synchronized (yc4.class) {
                List<nd4<mc4>> e = pd4.e(list, gb4Var);
                qd4 qd4Var = new qd4(gb4Var);
                a(qd4Var, e);
                qd4Var.e();
            }
        }
    }
}
