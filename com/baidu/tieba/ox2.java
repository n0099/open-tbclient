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
public class ox2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<nx2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948047552, "Lcom/baidu/tieba/ox2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948047552, "Lcom/baidu/tieba/ox2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(gy1 gy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, gy1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                nx2 nx2Var = a.get(size).get();
                if (nx2Var == null) {
                    a.remove(size);
                } else {
                    nx2Var.d(gy1Var);
                }
            }
        }
    }

    public static void b(gy1 gy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, gy1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                nx2 nx2Var = a.get(size).get();
                if (nx2Var == null) {
                    a.remove(size);
                } else {
                    nx2Var.b(gy1Var);
                }
            }
        }
    }

    public static void c(gy1 gy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, gy1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                nx2 nx2Var = a.get(size).get();
                if (nx2Var == null) {
                    a.remove(size);
                } else {
                    nx2Var.c(gy1Var);
                }
            }
        }
    }

    public static void d(gy1 gy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, gy1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                nx2 nx2Var = a.get(size).get();
                if (nx2Var == null) {
                    a.remove(size);
                } else {
                    nx2Var.a(gy1Var);
                }
            }
        }
    }

    public static void f(nx2 nx2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, nx2Var) != null) || nx2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            nx2 nx2Var2 = a.get(size).get();
            if (nx2Var2 == null || nx2Var == nx2Var2) {
                a.remove(size);
            }
        }
    }

    public static void e(nx2 nx2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, nx2Var) != null) || nx2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            nx2 nx2Var2 = a.get(size).get();
            if (nx2Var2 == null) {
                a.remove(size);
            } else if (nx2Var2 == nx2Var) {
                z = true;
            } else {
                z = false;
            }
        }
        if (!z) {
            a.add(new WeakReference<>(nx2Var));
        }
    }
}
