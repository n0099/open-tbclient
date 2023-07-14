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
/* loaded from: classes6.dex */
public class lx2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<kx2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947958179, "Lcom/baidu/tieba/lx2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947958179, "Lcom/baidu/tieba/lx2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(dy1 dy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, dy1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                kx2 kx2Var = a.get(size).get();
                if (kx2Var == null) {
                    a.remove(size);
                } else {
                    kx2Var.d(dy1Var);
                }
            }
        }
    }

    public static void b(dy1 dy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, dy1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                kx2 kx2Var = a.get(size).get();
                if (kx2Var == null) {
                    a.remove(size);
                } else {
                    kx2Var.b(dy1Var);
                }
            }
        }
    }

    public static void c(dy1 dy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, dy1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                kx2 kx2Var = a.get(size).get();
                if (kx2Var == null) {
                    a.remove(size);
                } else {
                    kx2Var.c(dy1Var);
                }
            }
        }
    }

    public static void d(dy1 dy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, dy1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                kx2 kx2Var = a.get(size).get();
                if (kx2Var == null) {
                    a.remove(size);
                } else {
                    kx2Var.a(dy1Var);
                }
            }
        }
    }

    public static void f(kx2 kx2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, kx2Var) != null) || kx2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            kx2 kx2Var2 = a.get(size).get();
            if (kx2Var2 == null || kx2Var == kx2Var2) {
                a.remove(size);
            }
        }
    }

    public static void e(kx2 kx2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, kx2Var) != null) || kx2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            kx2 kx2Var2 = a.get(size).get();
            if (kx2Var2 == null) {
                a.remove(size);
            } else if (kx2Var2 == kx2Var) {
                z = true;
            } else {
                z = false;
            }
        }
        if (!z) {
            a.add(new WeakReference<>(kx2Var));
        }
    }
}
