package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.sb4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes4.dex */
public class la4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull db4 db4Var, @NonNull List<ab4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, db4Var, list) == null) {
            for (ab4<T> ab4Var : list) {
                db4Var.c(ya4.b().a(ab4Var));
            }
        }
    }

    @NonNull
    public static db4 b(sb4 sb4Var, t84 t84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, sb4Var, t84Var)) == null) {
            List<ab4<sb4.a>> f = cb4.f(sb4Var.a, t84Var);
            db4 db4Var = new db4(t84Var);
            for (ab4<sb4.a> ab4Var : f) {
                db4Var.c(ya4.b().a(ab4Var));
            }
            return db4Var;
        }
        return (db4) invokeLL.objValue;
    }

    public static synchronized void c(tb4 tb4Var, t84 t84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, tb4Var, t84Var) == null) {
            synchronized (la4.class) {
                ab4<v94> d = cb4.d(tb4Var.d, t84Var);
                ab4<x94> g = cb4.g(tb4Var.a, t84Var);
                ab4<t94> c = cb4.c(tb4Var.f, t84Var);
                List<ab4<y94>> h = cb4.h(tb4Var.b, t84Var);
                List<ab4<z94>> e = cb4.e(tb4Var.c, t84Var);
                db4 db4Var = new db4(t84Var);
                db4Var.c(ya4.b().a(d));
                db4Var.c(ya4.b().a(g));
                db4Var.c(ya4.b().a(c));
                a(db4Var, h);
                a(db4Var, e);
                db4Var.e();
            }
        }
    }

    public static synchronized void d(ub4 ub4Var, t84 t84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, ub4Var, t84Var) == null) {
            synchronized (la4.class) {
                ab4<z94> i = cb4.i(ub4Var.a, t84Var);
                db4 db4Var = new db4(t84Var);
                db4Var.c(ya4.b().a(i));
                db4Var.e();
            }
        }
    }

    public static synchronized void e(vb4 vb4Var, t84 t84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, vb4Var, t84Var) == null) {
            synchronized (la4.class) {
                List<ab4<y94>> h = cb4.h(vb4Var.a, t84Var);
                db4 db4Var = new db4(t84Var);
                for (ab4<y94> ab4Var : h) {
                    db4Var.c(ya4.b().a(ab4Var));
                }
                db4Var.e();
            }
        }
    }

    public static synchronized void f(qd4 qd4Var, t84 t84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, qd4Var, t84Var) == null) {
            synchronized (la4.class) {
                ab4<v94> d = cb4.d(qd4Var.b, t84Var);
                ab4<v94> d2 = cb4.d(qd4Var.a, t84Var);
                ab4<t94> c = cb4.c(qd4Var.c, t84Var);
                db4 db4Var = new db4(t84Var);
                if (d != null) {
                    db4Var.c(ya4.b().a(d));
                }
                if (d2 != null) {
                    db4Var.c(ya4.b().a(d2));
                }
                if (c != null) {
                    db4Var.c(ya4.b().a(c));
                }
                if (qd4Var.d != null) {
                    for (aa4 aa4Var : qd4Var.d) {
                        ab4<aa4> j = cb4.j(aa4Var, t84Var);
                        if (j != null) {
                            db4Var.c(ya4.b().a(j));
                        }
                    }
                }
                if (qd4Var.e != null) {
                    for (z94 z94Var : qd4Var.e) {
                        ab4<z94> i = cb4.i(z94Var, t84Var);
                        if (i != null) {
                            db4Var.c(ya4.b().a(i));
                        }
                    }
                }
                db4Var.e();
            }
        }
    }

    public static synchronized void g(List<z94> list, t84 t84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, t84Var) == null) {
            synchronized (la4.class) {
                List<ab4<z94>> e = cb4.e(list, t84Var);
                db4 db4Var = new db4(t84Var);
                a(db4Var, e);
                db4Var.e();
            }
        }
    }
}
