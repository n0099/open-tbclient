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
public class mu2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<lu2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947985087, "Lcom/baidu/tieba/mu2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947985087, "Lcom/baidu/tieba/mu2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(ev1 ev1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, ev1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                lu2 lu2Var = a.get(size).get();
                if (lu2Var == null) {
                    a.remove(size);
                } else {
                    lu2Var.d(ev1Var);
                }
            }
        }
    }

    public static void b(ev1 ev1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, ev1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                lu2 lu2Var = a.get(size).get();
                if (lu2Var == null) {
                    a.remove(size);
                } else {
                    lu2Var.b(ev1Var);
                }
            }
        }
    }

    public static void c(ev1 ev1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, ev1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                lu2 lu2Var = a.get(size).get();
                if (lu2Var == null) {
                    a.remove(size);
                } else {
                    lu2Var.c(ev1Var);
                }
            }
        }
    }

    public static void d(ev1 ev1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ev1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                lu2 lu2Var = a.get(size).get();
                if (lu2Var == null) {
                    a.remove(size);
                } else {
                    lu2Var.a(ev1Var);
                }
            }
        }
    }

    public static void f(lu2 lu2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, lu2Var) != null) || lu2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            lu2 lu2Var2 = a.get(size).get();
            if (lu2Var2 == null || lu2Var == lu2Var2) {
                a.remove(size);
            }
        }
    }

    public static void e(lu2 lu2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, lu2Var) != null) || lu2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            lu2 lu2Var2 = a.get(size).get();
            if (lu2Var2 == null) {
                a.remove(size);
            } else if (lu2Var2 == lu2Var) {
                z = true;
            } else {
                z = false;
            }
        }
        if (!z) {
            a.add(new WeakReference<>(lu2Var));
        }
    }
}
