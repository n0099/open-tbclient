package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.eh4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes9.dex */
public class xf4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull pg4 pg4Var, @NonNull List<mg4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, pg4Var, list) == null) {
            for (mg4<T> mg4Var : list) {
                pg4Var.c(kg4.b().a(mg4Var));
            }
        }
    }

    public static synchronized void d(gh4 gh4Var, fe4 fe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, gh4Var, fe4Var) == null) {
            synchronized (xf4.class) {
                mg4<lf4> i = og4.i(gh4Var.a, fe4Var);
                pg4 pg4Var = new pg4(fe4Var);
                pg4Var.c(kg4.b().a(i));
                pg4Var.e();
            }
        }
    }

    public static synchronized void g(List<lf4> list, fe4 fe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, fe4Var) == null) {
            synchronized (xf4.class) {
                List<mg4<lf4>> e = og4.e(list, fe4Var);
                pg4 pg4Var = new pg4(fe4Var);
                a(pg4Var, e);
                pg4Var.e();
            }
        }
    }

    @NonNull
    public static pg4 b(eh4 eh4Var, fe4 fe4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, eh4Var, fe4Var)) == null) {
            List<mg4<eh4.a>> f = og4.f(eh4Var.a, fe4Var);
            pg4 pg4Var = new pg4(fe4Var);
            for (mg4<eh4.a> mg4Var : f) {
                pg4Var.c(kg4.b().a(mg4Var));
            }
            return pg4Var;
        }
        return (pg4) invokeLL.objValue;
    }

    public static synchronized void e(hh4 hh4Var, fe4 fe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, hh4Var, fe4Var) == null) {
            synchronized (xf4.class) {
                List<mg4<kf4>> h = og4.h(hh4Var.a, fe4Var);
                pg4 pg4Var = new pg4(fe4Var);
                for (mg4<kf4> mg4Var : h) {
                    pg4Var.c(kg4.b().a(mg4Var));
                }
                pg4Var.e();
            }
        }
    }

    public static synchronized void c(fh4 fh4Var, fe4 fe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, fh4Var, fe4Var) == null) {
            synchronized (xf4.class) {
                mg4<hf4> d = og4.d(fh4Var.d, fe4Var);
                mg4<jf4> g = og4.g(fh4Var.a, fe4Var);
                mg4<ff4> c = og4.c(fh4Var.f, fe4Var);
                List<mg4<kf4>> h = og4.h(fh4Var.b, fe4Var);
                List<mg4<lf4>> e = og4.e(fh4Var.c, fe4Var);
                pg4 pg4Var = new pg4(fe4Var);
                pg4Var.c(kg4.b().a(d));
                pg4Var.c(kg4.b().a(g));
                pg4Var.c(kg4.b().a(c));
                a(pg4Var, h);
                a(pg4Var, e);
                pg4Var.e();
            }
        }
    }

    public static synchronized void f(cj4 cj4Var, fe4 fe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, cj4Var, fe4Var) == null) {
            synchronized (xf4.class) {
                mg4<hf4> d = og4.d(cj4Var.b, fe4Var);
                mg4<hf4> d2 = og4.d(cj4Var.a, fe4Var);
                mg4<ff4> c = og4.c(cj4Var.c, fe4Var);
                pg4 pg4Var = new pg4(fe4Var);
                if (d != null) {
                    pg4Var.c(kg4.b().a(d));
                }
                if (d2 != null) {
                    pg4Var.c(kg4.b().a(d2));
                }
                if (c != null) {
                    pg4Var.c(kg4.b().a(c));
                }
                if (cj4Var.d != null) {
                    for (mf4 mf4Var : cj4Var.d) {
                        mg4<mf4> j = og4.j(mf4Var, fe4Var);
                        if (j != null) {
                            pg4Var.c(kg4.b().a(j));
                        }
                    }
                }
                if (cj4Var.e != null) {
                    for (lf4 lf4Var : cj4Var.e) {
                        mg4<lf4> i = og4.i(lf4Var, fe4Var);
                        if (i != null) {
                            pg4Var.c(kg4.b().a(i));
                        }
                    }
                }
                pg4Var.e();
            }
        }
    }
}
