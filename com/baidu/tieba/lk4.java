package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.sl4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class lk4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull dl4 dl4Var, @NonNull List<al4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, dl4Var, list) == null) {
            for (al4<T> al4Var : list) {
                dl4Var.c(yk4.b().a(al4Var));
            }
        }
    }

    public static synchronized void d(ul4 ul4Var, ti4 ti4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, ul4Var, ti4Var) == null) {
            synchronized (lk4.class) {
                al4<zj4> i = cl4.i(ul4Var.a, ti4Var);
                dl4 dl4Var = new dl4(ti4Var);
                dl4Var.c(yk4.b().a(i));
                dl4Var.e();
            }
        }
    }

    public static synchronized void g(List<zj4> list, ti4 ti4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, ti4Var) == null) {
            synchronized (lk4.class) {
                List<al4<zj4>> e = cl4.e(list, ti4Var);
                dl4 dl4Var = new dl4(ti4Var);
                a(dl4Var, e);
                dl4Var.e();
            }
        }
    }

    @NonNull
    public static dl4 b(sl4 sl4Var, ti4 ti4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, sl4Var, ti4Var)) == null) {
            List<al4<sl4.a>> f = cl4.f(sl4Var.a, ti4Var);
            dl4 dl4Var = new dl4(ti4Var);
            for (al4<sl4.a> al4Var : f) {
                dl4Var.c(yk4.b().a(al4Var));
            }
            return dl4Var;
        }
        return (dl4) invokeLL.objValue;
    }

    public static synchronized void e(vl4 vl4Var, ti4 ti4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, vl4Var, ti4Var) == null) {
            synchronized (lk4.class) {
                List<al4<yj4>> h = cl4.h(vl4Var.a, ti4Var);
                dl4 dl4Var = new dl4(ti4Var);
                for (al4<yj4> al4Var : h) {
                    dl4Var.c(yk4.b().a(al4Var));
                }
                dl4Var.e();
            }
        }
    }

    public static synchronized void c(tl4 tl4Var, ti4 ti4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, tl4Var, ti4Var) == null) {
            synchronized (lk4.class) {
                al4<vj4> d = cl4.d(tl4Var.d, ti4Var);
                al4<xj4> g = cl4.g(tl4Var.a, ti4Var);
                al4<tj4> c = cl4.c(tl4Var.f, ti4Var);
                List<al4<yj4>> h = cl4.h(tl4Var.b, ti4Var);
                List<al4<zj4>> e = cl4.e(tl4Var.c, ti4Var);
                dl4 dl4Var = new dl4(ti4Var);
                dl4Var.c(yk4.b().a(d));
                dl4Var.c(yk4.b().a(g));
                dl4Var.c(yk4.b().a(c));
                a(dl4Var, h);
                a(dl4Var, e);
                dl4Var.e();
            }
        }
    }

    public static synchronized void f(qn4 qn4Var, ti4 ti4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, qn4Var, ti4Var) == null) {
            synchronized (lk4.class) {
                al4<vj4> d = cl4.d(qn4Var.b, ti4Var);
                al4<vj4> d2 = cl4.d(qn4Var.a, ti4Var);
                al4<tj4> c = cl4.c(qn4Var.c, ti4Var);
                dl4 dl4Var = new dl4(ti4Var);
                if (d != null) {
                    dl4Var.c(yk4.b().a(d));
                }
                if (d2 != null) {
                    dl4Var.c(yk4.b().a(d2));
                }
                if (c != null) {
                    dl4Var.c(yk4.b().a(c));
                }
                if (qn4Var.d != null) {
                    for (ak4 ak4Var : qn4Var.d) {
                        al4<ak4> j = cl4.j(ak4Var, ti4Var);
                        if (j != null) {
                            dl4Var.c(yk4.b().a(j));
                        }
                    }
                }
                if (qn4Var.e != null) {
                    for (zj4 zj4Var : qn4Var.e) {
                        al4<zj4> i = cl4.i(zj4Var, ti4Var);
                        if (i != null) {
                            dl4Var.c(yk4.b().a(i));
                        }
                    }
                }
                dl4Var.e();
            }
        }
    }
}
