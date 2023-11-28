package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.bh4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes8.dex */
public class uf4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull mg4 mg4Var, @NonNull List<jg4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, mg4Var, list) == null) {
            for (jg4<T> jg4Var : list) {
                mg4Var.c(hg4.b().a(jg4Var));
            }
        }
    }

    public static synchronized void d(dh4 dh4Var, ce4 ce4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, dh4Var, ce4Var) == null) {
            synchronized (uf4.class) {
                jg4<if4> i = lg4.i(dh4Var.a, ce4Var);
                mg4 mg4Var = new mg4(ce4Var);
                mg4Var.c(hg4.b().a(i));
                mg4Var.e();
            }
        }
    }

    public static synchronized void g(List<if4> list, ce4 ce4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, ce4Var) == null) {
            synchronized (uf4.class) {
                List<jg4<if4>> e = lg4.e(list, ce4Var);
                mg4 mg4Var = new mg4(ce4Var);
                a(mg4Var, e);
                mg4Var.e();
            }
        }
    }

    @NonNull
    public static mg4 b(bh4 bh4Var, ce4 ce4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bh4Var, ce4Var)) == null) {
            List<jg4<bh4.a>> f = lg4.f(bh4Var.a, ce4Var);
            mg4 mg4Var = new mg4(ce4Var);
            for (jg4<bh4.a> jg4Var : f) {
                mg4Var.c(hg4.b().a(jg4Var));
            }
            return mg4Var;
        }
        return (mg4) invokeLL.objValue;
    }

    public static synchronized void e(eh4 eh4Var, ce4 ce4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, eh4Var, ce4Var) == null) {
            synchronized (uf4.class) {
                List<jg4<hf4>> h = lg4.h(eh4Var.a, ce4Var);
                mg4 mg4Var = new mg4(ce4Var);
                for (jg4<hf4> jg4Var : h) {
                    mg4Var.c(hg4.b().a(jg4Var));
                }
                mg4Var.e();
            }
        }
    }

    public static synchronized void c(ch4 ch4Var, ce4 ce4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, ch4Var, ce4Var) == null) {
            synchronized (uf4.class) {
                jg4<ef4> d = lg4.d(ch4Var.d, ce4Var);
                jg4<gf4> g = lg4.g(ch4Var.a, ce4Var);
                jg4<cf4> c = lg4.c(ch4Var.f, ce4Var);
                List<jg4<hf4>> h = lg4.h(ch4Var.b, ce4Var);
                List<jg4<if4>> e = lg4.e(ch4Var.c, ce4Var);
                mg4 mg4Var = new mg4(ce4Var);
                mg4Var.c(hg4.b().a(d));
                mg4Var.c(hg4.b().a(g));
                mg4Var.c(hg4.b().a(c));
                a(mg4Var, h);
                a(mg4Var, e);
                mg4Var.e();
            }
        }
    }

    public static synchronized void f(zi4 zi4Var, ce4 ce4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, zi4Var, ce4Var) == null) {
            synchronized (uf4.class) {
                jg4<ef4> d = lg4.d(zi4Var.b, ce4Var);
                jg4<ef4> d2 = lg4.d(zi4Var.a, ce4Var);
                jg4<cf4> c = lg4.c(zi4Var.c, ce4Var);
                mg4 mg4Var = new mg4(ce4Var);
                if (d != null) {
                    mg4Var.c(hg4.b().a(d));
                }
                if (d2 != null) {
                    mg4Var.c(hg4.b().a(d2));
                }
                if (c != null) {
                    mg4Var.c(hg4.b().a(c));
                }
                if (zi4Var.d != null) {
                    for (jf4 jf4Var : zi4Var.d) {
                        jg4<jf4> j = lg4.j(jf4Var, ce4Var);
                        if (j != null) {
                            mg4Var.c(hg4.b().a(j));
                        }
                    }
                }
                if (zi4Var.e != null) {
                    for (if4 if4Var : zi4Var.e) {
                        jg4<if4> i = lg4.i(if4Var, ce4Var);
                        if (i != null) {
                            mg4Var.c(hg4.b().a(i));
                        }
                    }
                }
                mg4Var.e();
            }
        }
    }
}
