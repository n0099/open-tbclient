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
/* loaded from: classes9.dex */
public class xr2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<wr2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948309905, "Lcom/baidu/tieba/xr2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948309905, "Lcom/baidu/tieba/xr2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(qs1 qs1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, qs1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                wr2 wr2Var = a.get(size).get();
                if (wr2Var == null) {
                    a.remove(size);
                } else {
                    wr2Var.d(qs1Var);
                }
            }
        }
    }

    public static void b(qs1 qs1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, qs1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                wr2 wr2Var = a.get(size).get();
                if (wr2Var == null) {
                    a.remove(size);
                } else {
                    wr2Var.b(qs1Var);
                }
            }
        }
    }

    public static void c(qs1 qs1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, qs1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                wr2 wr2Var = a.get(size).get();
                if (wr2Var == null) {
                    a.remove(size);
                } else {
                    wr2Var.c(qs1Var);
                }
            }
        }
    }

    public static void d(qs1 qs1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, qs1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                wr2 wr2Var = a.get(size).get();
                if (wr2Var == null) {
                    a.remove(size);
                } else {
                    wr2Var.a(qs1Var);
                }
            }
        }
    }

    public static void f(wr2 wr2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, wr2Var) != null) || wr2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            wr2 wr2Var2 = a.get(size).get();
            if (wr2Var2 == null || wr2Var == wr2Var2) {
                a.remove(size);
            }
        }
    }

    public static void e(wr2 wr2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, wr2Var) != null) || wr2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            wr2 wr2Var2 = a.get(size).get();
            if (wr2Var2 == null) {
                a.remove(size);
            } else if (wr2Var2 == wr2Var) {
                z = true;
            } else {
                z = false;
            }
        }
        if (!z) {
            a.add(new WeakReference<>(wr2Var));
        }
    }
}
