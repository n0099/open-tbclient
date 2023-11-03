package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.ah4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes8.dex */
public class tf4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull lg4 lg4Var, @NonNull List<ig4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, lg4Var, list) == null) {
            for (ig4<T> ig4Var : list) {
                lg4Var.c(gg4.b().a(ig4Var));
            }
        }
    }

    public static synchronized void d(ch4 ch4Var, be4 be4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, ch4Var, be4Var) == null) {
            synchronized (tf4.class) {
                ig4<hf4> i = kg4.i(ch4Var.a, be4Var);
                lg4 lg4Var = new lg4(be4Var);
                lg4Var.c(gg4.b().a(i));
                lg4Var.e();
            }
        }
    }

    public static synchronized void g(List<hf4> list, be4 be4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, be4Var) == null) {
            synchronized (tf4.class) {
                List<ig4<hf4>> e = kg4.e(list, be4Var);
                lg4 lg4Var = new lg4(be4Var);
                a(lg4Var, e);
                lg4Var.e();
            }
        }
    }

    @NonNull
    public static lg4 b(ah4 ah4Var, be4 be4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, ah4Var, be4Var)) == null) {
            List<ig4<ah4.a>> f = kg4.f(ah4Var.a, be4Var);
            lg4 lg4Var = new lg4(be4Var);
            for (ig4<ah4.a> ig4Var : f) {
                lg4Var.c(gg4.b().a(ig4Var));
            }
            return lg4Var;
        }
        return (lg4) invokeLL.objValue;
    }

    public static synchronized void e(dh4 dh4Var, be4 be4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, dh4Var, be4Var) == null) {
            synchronized (tf4.class) {
                List<ig4<gf4>> h = kg4.h(dh4Var.a, be4Var);
                lg4 lg4Var = new lg4(be4Var);
                for (ig4<gf4> ig4Var : h) {
                    lg4Var.c(gg4.b().a(ig4Var));
                }
                lg4Var.e();
            }
        }
    }

    public static synchronized void c(bh4 bh4Var, be4 be4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, bh4Var, be4Var) == null) {
            synchronized (tf4.class) {
                ig4<df4> d = kg4.d(bh4Var.d, be4Var);
                ig4<ff4> g = kg4.g(bh4Var.a, be4Var);
                ig4<bf4> c = kg4.c(bh4Var.f, be4Var);
                List<ig4<gf4>> h = kg4.h(bh4Var.b, be4Var);
                List<ig4<hf4>> e = kg4.e(bh4Var.c, be4Var);
                lg4 lg4Var = new lg4(be4Var);
                lg4Var.c(gg4.b().a(d));
                lg4Var.c(gg4.b().a(g));
                lg4Var.c(gg4.b().a(c));
                a(lg4Var, h);
                a(lg4Var, e);
                lg4Var.e();
            }
        }
    }

    public static synchronized void f(yi4 yi4Var, be4 be4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, yi4Var, be4Var) == null) {
            synchronized (tf4.class) {
                ig4<df4> d = kg4.d(yi4Var.b, be4Var);
                ig4<df4> d2 = kg4.d(yi4Var.a, be4Var);
                ig4<bf4> c = kg4.c(yi4Var.c, be4Var);
                lg4 lg4Var = new lg4(be4Var);
                if (d != null) {
                    lg4Var.c(gg4.b().a(d));
                }
                if (d2 != null) {
                    lg4Var.c(gg4.b().a(d2));
                }
                if (c != null) {
                    lg4Var.c(gg4.b().a(c));
                }
                if (yi4Var.d != null) {
                    for (if4 if4Var : yi4Var.d) {
                        ig4<if4> j = kg4.j(if4Var, be4Var);
                        if (j != null) {
                            lg4Var.c(gg4.b().a(j));
                        }
                    }
                }
                if (yi4Var.e != null) {
                    for (hf4 hf4Var : yi4Var.e) {
                        ig4<hf4> i = kg4.i(hf4Var, be4Var);
                        if (i != null) {
                            lg4Var.c(gg4.b().a(i));
                        }
                    }
                }
                lg4Var.e();
            }
        }
    }
}
