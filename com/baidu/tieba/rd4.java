package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.ye4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class rd4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull je4 je4Var, @NonNull List<ge4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, je4Var, list) == null) {
            for (ge4<T> ge4Var : list) {
                je4Var.c(ee4.b().a(ge4Var));
            }
        }
    }

    public static synchronized void d(af4 af4Var, zb4 zb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, af4Var, zb4Var) == null) {
            synchronized (rd4.class) {
                ge4<fd4> i = ie4.i(af4Var.a, zb4Var);
                je4 je4Var = new je4(zb4Var);
                je4Var.c(ee4.b().a(i));
                je4Var.e();
            }
        }
    }

    public static synchronized void g(List<fd4> list, zb4 zb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, zb4Var) == null) {
            synchronized (rd4.class) {
                List<ge4<fd4>> e = ie4.e(list, zb4Var);
                je4 je4Var = new je4(zb4Var);
                a(je4Var, e);
                je4Var.e();
            }
        }
    }

    @NonNull
    public static je4 b(ye4 ye4Var, zb4 zb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, ye4Var, zb4Var)) == null) {
            List<ge4<ye4.a>> f = ie4.f(ye4Var.a, zb4Var);
            je4 je4Var = new je4(zb4Var);
            for (ge4<ye4.a> ge4Var : f) {
                je4Var.c(ee4.b().a(ge4Var));
            }
            return je4Var;
        }
        return (je4) invokeLL.objValue;
    }

    public static synchronized void e(bf4 bf4Var, zb4 zb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bf4Var, zb4Var) == null) {
            synchronized (rd4.class) {
                List<ge4<ed4>> h = ie4.h(bf4Var.a, zb4Var);
                je4 je4Var = new je4(zb4Var);
                for (ge4<ed4> ge4Var : h) {
                    je4Var.c(ee4.b().a(ge4Var));
                }
                je4Var.e();
            }
        }
    }

    public static synchronized void c(ze4 ze4Var, zb4 zb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, ze4Var, zb4Var) == null) {
            synchronized (rd4.class) {
                ge4<bd4> d = ie4.d(ze4Var.d, zb4Var);
                ge4<dd4> g = ie4.g(ze4Var.a, zb4Var);
                ge4<zc4> c = ie4.c(ze4Var.f, zb4Var);
                List<ge4<ed4>> h = ie4.h(ze4Var.b, zb4Var);
                List<ge4<fd4>> e = ie4.e(ze4Var.c, zb4Var);
                je4 je4Var = new je4(zb4Var);
                je4Var.c(ee4.b().a(d));
                je4Var.c(ee4.b().a(g));
                je4Var.c(ee4.b().a(c));
                a(je4Var, h);
                a(je4Var, e);
                je4Var.e();
            }
        }
    }

    public static synchronized void f(wg4 wg4Var, zb4 zb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, wg4Var, zb4Var) == null) {
            synchronized (rd4.class) {
                ge4<bd4> d = ie4.d(wg4Var.b, zb4Var);
                ge4<bd4> d2 = ie4.d(wg4Var.a, zb4Var);
                ge4<zc4> c = ie4.c(wg4Var.c, zb4Var);
                je4 je4Var = new je4(zb4Var);
                if (d != null) {
                    je4Var.c(ee4.b().a(d));
                }
                if (d2 != null) {
                    je4Var.c(ee4.b().a(d2));
                }
                if (c != null) {
                    je4Var.c(ee4.b().a(c));
                }
                if (wg4Var.d != null) {
                    for (gd4 gd4Var : wg4Var.d) {
                        ge4<gd4> j = ie4.j(gd4Var, zb4Var);
                        if (j != null) {
                            je4Var.c(ee4.b().a(j));
                        }
                    }
                }
                if (wg4Var.e != null) {
                    for (fd4 fd4Var : wg4Var.e) {
                        ge4<fd4> i = ie4.i(fd4Var, zb4Var);
                        if (i != null) {
                            je4Var.c(ee4.b().a(i));
                        }
                    }
                }
                je4Var.e();
            }
        }
    }
}
