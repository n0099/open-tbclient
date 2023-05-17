package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.ak4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes7.dex */
public class ti4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull lj4 lj4Var, @NonNull List<ij4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, lj4Var, list) == null) {
            for (ij4<T> ij4Var : list) {
                lj4Var.c(gj4.b().a(ij4Var));
            }
        }
    }

    public static synchronized void d(ck4 ck4Var, bh4 bh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, ck4Var, bh4Var) == null) {
            synchronized (ti4.class) {
                ij4<hi4> i = kj4.i(ck4Var.a, bh4Var);
                lj4 lj4Var = new lj4(bh4Var);
                lj4Var.c(gj4.b().a(i));
                lj4Var.e();
            }
        }
    }

    public static synchronized void g(List<hi4> list, bh4 bh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, bh4Var) == null) {
            synchronized (ti4.class) {
                List<ij4<hi4>> e = kj4.e(list, bh4Var);
                lj4 lj4Var = new lj4(bh4Var);
                a(lj4Var, e);
                lj4Var.e();
            }
        }
    }

    @NonNull
    public static lj4 b(ak4 ak4Var, bh4 bh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, ak4Var, bh4Var)) == null) {
            List<ij4<ak4.a>> f = kj4.f(ak4Var.a, bh4Var);
            lj4 lj4Var = new lj4(bh4Var);
            for (ij4<ak4.a> ij4Var : f) {
                lj4Var.c(gj4.b().a(ij4Var));
            }
            return lj4Var;
        }
        return (lj4) invokeLL.objValue;
    }

    public static synchronized void e(dk4 dk4Var, bh4 bh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, dk4Var, bh4Var) == null) {
            synchronized (ti4.class) {
                List<ij4<gi4>> h = kj4.h(dk4Var.a, bh4Var);
                lj4 lj4Var = new lj4(bh4Var);
                for (ij4<gi4> ij4Var : h) {
                    lj4Var.c(gj4.b().a(ij4Var));
                }
                lj4Var.e();
            }
        }
    }

    public static synchronized void c(bk4 bk4Var, bh4 bh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, bk4Var, bh4Var) == null) {
            synchronized (ti4.class) {
                ij4<di4> d = kj4.d(bk4Var.d, bh4Var);
                ij4<fi4> g = kj4.g(bk4Var.a, bh4Var);
                ij4<bi4> c = kj4.c(bk4Var.f, bh4Var);
                List<ij4<gi4>> h = kj4.h(bk4Var.b, bh4Var);
                List<ij4<hi4>> e = kj4.e(bk4Var.c, bh4Var);
                lj4 lj4Var = new lj4(bh4Var);
                lj4Var.c(gj4.b().a(d));
                lj4Var.c(gj4.b().a(g));
                lj4Var.c(gj4.b().a(c));
                a(lj4Var, h);
                a(lj4Var, e);
                lj4Var.e();
            }
        }
    }

    public static synchronized void f(yl4 yl4Var, bh4 bh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, yl4Var, bh4Var) == null) {
            synchronized (ti4.class) {
                ij4<di4> d = kj4.d(yl4Var.b, bh4Var);
                ij4<di4> d2 = kj4.d(yl4Var.a, bh4Var);
                ij4<bi4> c = kj4.c(yl4Var.c, bh4Var);
                lj4 lj4Var = new lj4(bh4Var);
                if (d != null) {
                    lj4Var.c(gj4.b().a(d));
                }
                if (d2 != null) {
                    lj4Var.c(gj4.b().a(d2));
                }
                if (c != null) {
                    lj4Var.c(gj4.b().a(c));
                }
                if (yl4Var.d != null) {
                    for (ii4 ii4Var : yl4Var.d) {
                        ij4<ii4> j = kj4.j(ii4Var, bh4Var);
                        if (j != null) {
                            lj4Var.c(gj4.b().a(j));
                        }
                    }
                }
                if (yl4Var.e != null) {
                    for (hi4 hi4Var : yl4Var.e) {
                        ij4<hi4> i = kj4.i(hi4Var, bh4Var);
                        if (i != null) {
                            lj4Var.c(gj4.b().a(i));
                        }
                    }
                }
                lj4Var.e();
            }
        }
    }
}
