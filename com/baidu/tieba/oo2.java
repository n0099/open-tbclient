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
/* loaded from: classes5.dex */
public class oo2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<no2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948038903, "Lcom/baidu/tieba/oo2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948038903, "Lcom/baidu/tieba/oo2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(gp1 gp1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, gp1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                no2 no2Var = a.get(size).get();
                if (no2Var == null) {
                    a.remove(size);
                } else {
                    no2Var.d(gp1Var);
                }
            }
        }
    }

    public static void b(gp1 gp1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, gp1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                no2 no2Var = a.get(size).get();
                if (no2Var == null) {
                    a.remove(size);
                } else {
                    no2Var.b(gp1Var);
                }
            }
        }
    }

    public static void c(gp1 gp1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, gp1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                no2 no2Var = a.get(size).get();
                if (no2Var == null) {
                    a.remove(size);
                } else {
                    no2Var.c(gp1Var);
                }
            }
        }
    }

    public static void d(gp1 gp1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, gp1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                no2 no2Var = a.get(size).get();
                if (no2Var == null) {
                    a.remove(size);
                } else {
                    no2Var.a(gp1Var);
                }
            }
        }
    }

    public static void e(no2 no2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, no2Var) == null) || no2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            no2 no2Var2 = a.get(size).get();
            if (no2Var2 == null) {
                a.remove(size);
            } else {
                z = no2Var2 == no2Var;
            }
        }
        if (z) {
            return;
        }
        a.add(new WeakReference<>(no2Var));
    }

    public static void f(no2 no2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, no2Var) == null) || no2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            no2 no2Var2 = a.get(size).get();
            if (no2Var2 == null || no2Var == no2Var2) {
                a.remove(size);
            }
        }
    }
}
