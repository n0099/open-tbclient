package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.qj4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class ji4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull bj4 bj4Var, @NonNull List<yi4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, bj4Var, list) == null) {
            for (yi4<T> yi4Var : list) {
                bj4Var.c(wi4.b().a(yi4Var));
            }
        }
    }

    public static synchronized void d(sj4 sj4Var, rg4 rg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, sj4Var, rg4Var) == null) {
            synchronized (ji4.class) {
                yi4<xh4> i = aj4.i(sj4Var.a, rg4Var);
                bj4 bj4Var = new bj4(rg4Var);
                bj4Var.c(wi4.b().a(i));
                bj4Var.e();
            }
        }
    }

    public static synchronized void g(List<xh4> list, rg4 rg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, rg4Var) == null) {
            synchronized (ji4.class) {
                List<yi4<xh4>> e = aj4.e(list, rg4Var);
                bj4 bj4Var = new bj4(rg4Var);
                a(bj4Var, e);
                bj4Var.e();
            }
        }
    }

    @NonNull
    public static bj4 b(qj4 qj4Var, rg4 rg4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, qj4Var, rg4Var)) == null) {
            List<yi4<qj4.a>> f = aj4.f(qj4Var.a, rg4Var);
            bj4 bj4Var = new bj4(rg4Var);
            for (yi4<qj4.a> yi4Var : f) {
                bj4Var.c(wi4.b().a(yi4Var));
            }
            return bj4Var;
        }
        return (bj4) invokeLL.objValue;
    }

    public static synchronized void e(tj4 tj4Var, rg4 rg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tj4Var, rg4Var) == null) {
            synchronized (ji4.class) {
                List<yi4<wh4>> h = aj4.h(tj4Var.a, rg4Var);
                bj4 bj4Var = new bj4(rg4Var);
                for (yi4<wh4> yi4Var : h) {
                    bj4Var.c(wi4.b().a(yi4Var));
                }
                bj4Var.e();
            }
        }
    }

    public static synchronized void c(rj4 rj4Var, rg4 rg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, rj4Var, rg4Var) == null) {
            synchronized (ji4.class) {
                yi4<th4> d = aj4.d(rj4Var.d, rg4Var);
                yi4<vh4> g = aj4.g(rj4Var.a, rg4Var);
                yi4<rh4> c = aj4.c(rj4Var.f, rg4Var);
                List<yi4<wh4>> h = aj4.h(rj4Var.b, rg4Var);
                List<yi4<xh4>> e = aj4.e(rj4Var.c, rg4Var);
                bj4 bj4Var = new bj4(rg4Var);
                bj4Var.c(wi4.b().a(d));
                bj4Var.c(wi4.b().a(g));
                bj4Var.c(wi4.b().a(c));
                a(bj4Var, h);
                a(bj4Var, e);
                bj4Var.e();
            }
        }
    }

    public static synchronized void f(ol4 ol4Var, rg4 rg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, ol4Var, rg4Var) == null) {
            synchronized (ji4.class) {
                yi4<th4> d = aj4.d(ol4Var.b, rg4Var);
                yi4<th4> d2 = aj4.d(ol4Var.a, rg4Var);
                yi4<rh4> c = aj4.c(ol4Var.c, rg4Var);
                bj4 bj4Var = new bj4(rg4Var);
                if (d != null) {
                    bj4Var.c(wi4.b().a(d));
                }
                if (d2 != null) {
                    bj4Var.c(wi4.b().a(d2));
                }
                if (c != null) {
                    bj4Var.c(wi4.b().a(c));
                }
                if (ol4Var.d != null) {
                    for (yh4 yh4Var : ol4Var.d) {
                        yi4<yh4> j = aj4.j(yh4Var, rg4Var);
                        if (j != null) {
                            bj4Var.c(wi4.b().a(j));
                        }
                    }
                }
                if (ol4Var.e != null) {
                    for (xh4 xh4Var : ol4Var.e) {
                        yi4<xh4> i = aj4.i(xh4Var, rg4Var);
                        if (i != null) {
                            bj4Var.c(wi4.b().a(i));
                        }
                    }
                }
                bj4Var.e();
            }
        }
    }
}
