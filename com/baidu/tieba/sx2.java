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
public class sx2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<rx2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948166716, "Lcom/baidu/tieba/sx2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948166716, "Lcom/baidu/tieba/sx2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(ky1 ky1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, ky1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                rx2 rx2Var = a.get(size).get();
                if (rx2Var == null) {
                    a.remove(size);
                } else {
                    rx2Var.d(ky1Var);
                }
            }
        }
    }

    public static void b(ky1 ky1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, ky1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                rx2 rx2Var = a.get(size).get();
                if (rx2Var == null) {
                    a.remove(size);
                } else {
                    rx2Var.b(ky1Var);
                }
            }
        }
    }

    public static void c(ky1 ky1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, ky1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                rx2 rx2Var = a.get(size).get();
                if (rx2Var == null) {
                    a.remove(size);
                } else {
                    rx2Var.c(ky1Var);
                }
            }
        }
    }

    public static void d(ky1 ky1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ky1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                rx2 rx2Var = a.get(size).get();
                if (rx2Var == null) {
                    a.remove(size);
                } else {
                    rx2Var.a(ky1Var);
                }
            }
        }
    }

    public static void f(rx2 rx2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, rx2Var) != null) || rx2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            rx2 rx2Var2 = a.get(size).get();
            if (rx2Var2 == null || rx2Var == rx2Var2) {
                a.remove(size);
            }
        }
    }

    public static void e(rx2 rx2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, rx2Var) != null) || rx2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            rx2 rx2Var2 = a.get(size).get();
            if (rx2Var2 == null) {
                a.remove(size);
            } else if (rx2Var2 == rx2Var) {
                z = true;
            } else {
                z = false;
            }
        }
        if (!z) {
            a.add(new WeakReference<>(rx2Var));
        }
    }
}
