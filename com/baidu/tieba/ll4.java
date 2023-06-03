package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.sm4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class ll4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull dm4 dm4Var, @NonNull List<am4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, dm4Var, list) == null) {
            for (am4<T> am4Var : list) {
                dm4Var.c(yl4.b().a(am4Var));
            }
        }
    }

    public static synchronized void d(um4 um4Var, tj4 tj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, um4Var, tj4Var) == null) {
            synchronized (ll4.class) {
                am4<zk4> i = cm4.i(um4Var.a, tj4Var);
                dm4 dm4Var = new dm4(tj4Var);
                dm4Var.c(yl4.b().a(i));
                dm4Var.e();
            }
        }
    }

    public static synchronized void g(List<zk4> list, tj4 tj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, tj4Var) == null) {
            synchronized (ll4.class) {
                List<am4<zk4>> e = cm4.e(list, tj4Var);
                dm4 dm4Var = new dm4(tj4Var);
                a(dm4Var, e);
                dm4Var.e();
            }
        }
    }

    @NonNull
    public static dm4 b(sm4 sm4Var, tj4 tj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, sm4Var, tj4Var)) == null) {
            List<am4<sm4.a>> f = cm4.f(sm4Var.a, tj4Var);
            dm4 dm4Var = new dm4(tj4Var);
            for (am4<sm4.a> am4Var : f) {
                dm4Var.c(yl4.b().a(am4Var));
            }
            return dm4Var;
        }
        return (dm4) invokeLL.objValue;
    }

    public static synchronized void e(vm4 vm4Var, tj4 tj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, vm4Var, tj4Var) == null) {
            synchronized (ll4.class) {
                List<am4<yk4>> h = cm4.h(vm4Var.a, tj4Var);
                dm4 dm4Var = new dm4(tj4Var);
                for (am4<yk4> am4Var : h) {
                    dm4Var.c(yl4.b().a(am4Var));
                }
                dm4Var.e();
            }
        }
    }

    public static synchronized void c(tm4 tm4Var, tj4 tj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, tm4Var, tj4Var) == null) {
            synchronized (ll4.class) {
                am4<vk4> d = cm4.d(tm4Var.d, tj4Var);
                am4<xk4> g = cm4.g(tm4Var.a, tj4Var);
                am4<tk4> c = cm4.c(tm4Var.f, tj4Var);
                List<am4<yk4>> h = cm4.h(tm4Var.b, tj4Var);
                List<am4<zk4>> e = cm4.e(tm4Var.c, tj4Var);
                dm4 dm4Var = new dm4(tj4Var);
                dm4Var.c(yl4.b().a(d));
                dm4Var.c(yl4.b().a(g));
                dm4Var.c(yl4.b().a(c));
                a(dm4Var, h);
                a(dm4Var, e);
                dm4Var.e();
            }
        }
    }

    public static synchronized void f(qo4 qo4Var, tj4 tj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, qo4Var, tj4Var) == null) {
            synchronized (ll4.class) {
                am4<vk4> d = cm4.d(qo4Var.b, tj4Var);
                am4<vk4> d2 = cm4.d(qo4Var.a, tj4Var);
                am4<tk4> c = cm4.c(qo4Var.c, tj4Var);
                dm4 dm4Var = new dm4(tj4Var);
                if (d != null) {
                    dm4Var.c(yl4.b().a(d));
                }
                if (d2 != null) {
                    dm4Var.c(yl4.b().a(d2));
                }
                if (c != null) {
                    dm4Var.c(yl4.b().a(c));
                }
                if (qo4Var.d != null) {
                    for (al4 al4Var : qo4Var.d) {
                        am4<al4> j = cm4.j(al4Var, tj4Var);
                        if (j != null) {
                            dm4Var.c(yl4.b().a(j));
                        }
                    }
                }
                if (qo4Var.e != null) {
                    for (zk4 zk4Var : qo4Var.e) {
                        am4<zk4> i = cm4.i(zk4Var, tj4Var);
                        if (i != null) {
                            dm4Var.c(yl4.b().a(i));
                        }
                    }
                }
                dm4Var.e();
            }
        }
    }
}
