package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class zp2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<yp2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948367565, "Lcom/baidu/tieba/zp2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948367565, "Lcom/baidu/tieba/zp2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(rq1 rq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, rq1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                yp2 yp2Var = a.get(size).get();
                if (yp2Var == null) {
                    a.remove(size);
                } else {
                    yp2Var.d(rq1Var);
                }
            }
        }
    }

    public static void b(rq1 rq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, rq1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                yp2 yp2Var = a.get(size).get();
                if (yp2Var == null) {
                    a.remove(size);
                } else {
                    yp2Var.b(rq1Var);
                }
            }
        }
    }

    public static void c(rq1 rq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, rq1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                yp2 yp2Var = a.get(size).get();
                if (yp2Var == null) {
                    a.remove(size);
                } else {
                    yp2Var.c(rq1Var);
                }
            }
        }
    }

    public static void d(rq1 rq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, rq1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                yp2 yp2Var = a.get(size).get();
                if (yp2Var == null) {
                    a.remove(size);
                } else {
                    yp2Var.a(rq1Var);
                }
            }
        }
    }

    public static void f(yp2 yp2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, yp2Var) != null) || yp2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            yp2 yp2Var2 = a.get(size).get();
            if (yp2Var2 == null || yp2Var == yp2Var2) {
                a.remove(size);
            }
        }
    }

    public static void e(yp2 yp2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, yp2Var) != null) || yp2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            yp2 yp2Var2 = a.get(size).get();
            if (yp2Var2 == null) {
                a.remove(size);
            } else if (yp2Var2 == yp2Var) {
                z = true;
            } else {
                z = false;
            }
        }
        if (!z) {
            a.add(new WeakReference<>(yp2Var));
        }
    }
}
