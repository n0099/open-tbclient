package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class zc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(rd4 rd4Var, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, rd4Var, list) == null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                rd4Var.c(md4.b().a((od4) it.next()));
            }
        }
    }

    public static synchronized void d(ie4 ie4Var, hb4 hb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, ie4Var, hb4Var) == null) {
            synchronized (zc4.class) {
                od4 i = qd4.i(ie4Var.a, hb4Var);
                rd4 rd4Var = new rd4(hb4Var);
                rd4Var.c(md4.b().a(i));
                rd4Var.e();
            }
        }
    }

    public static synchronized void g(List list, hb4 hb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, hb4Var) == null) {
            synchronized (zc4.class) {
                List e = qd4.e(list, hb4Var);
                rd4 rd4Var = new rd4(hb4Var);
                a(rd4Var, e);
                rd4Var.e();
            }
        }
    }

    public static rd4 b(ge4 ge4Var, hb4 hb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, ge4Var, hb4Var)) == null) {
            List<od4> f = qd4.f(ge4Var.a, hb4Var);
            rd4 rd4Var = new rd4(hb4Var);
            for (od4 od4Var : f) {
                rd4Var.c(md4.b().a(od4Var));
            }
            return rd4Var;
        }
        return (rd4) invokeLL.objValue;
    }

    public static synchronized void e(je4 je4Var, hb4 hb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, je4Var, hb4Var) == null) {
            synchronized (zc4.class) {
                List<od4> h = qd4.h(je4Var.a, hb4Var);
                rd4 rd4Var = new rd4(hb4Var);
                for (od4 od4Var : h) {
                    rd4Var.c(md4.b().a(od4Var));
                }
                rd4Var.e();
            }
        }
    }

    public static synchronized void c(he4 he4Var, hb4 hb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, he4Var, hb4Var) == null) {
            synchronized (zc4.class) {
                od4 d = qd4.d(he4Var.d, hb4Var);
                od4 g = qd4.g(he4Var.a, hb4Var);
                od4 c = qd4.c(he4Var.f, hb4Var);
                List h = qd4.h(he4Var.b, hb4Var);
                List e = qd4.e(he4Var.c, hb4Var);
                rd4 rd4Var = new rd4(hb4Var);
                rd4Var.c(md4.b().a(d));
                rd4Var.c(md4.b().a(g));
                rd4Var.c(md4.b().a(c));
                a(rd4Var, h);
                a(rd4Var, e);
                rd4Var.e();
            }
        }
    }

    public static synchronized void f(eg4 eg4Var, hb4 hb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, eg4Var, hb4Var) == null) {
            synchronized (zc4.class) {
                od4 d = qd4.d(eg4Var.b, hb4Var);
                od4 d2 = qd4.d(eg4Var.a, hb4Var);
                od4 c = qd4.c(eg4Var.c, hb4Var);
                rd4 rd4Var = new rd4(hb4Var);
                if (d != null) {
                    rd4Var.c(md4.b().a(d));
                }
                if (d2 != null) {
                    rd4Var.c(md4.b().a(d2));
                }
                if (c != null) {
                    rd4Var.c(md4.b().a(c));
                }
                if (eg4Var.d != null) {
                    for (oc4 oc4Var : eg4Var.d) {
                        od4 j = qd4.j(oc4Var, hb4Var);
                        if (j != null) {
                            rd4Var.c(md4.b().a(j));
                        }
                    }
                }
                if (eg4Var.e != null) {
                    for (nc4 nc4Var : eg4Var.e) {
                        od4 i = qd4.i(nc4Var, hb4Var);
                        if (i != null) {
                            rd4Var.c(md4.b().a(i));
                        }
                    }
                }
                rd4Var.e();
            }
        }
    }
}
