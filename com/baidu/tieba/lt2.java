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
public class lt2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<kt2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947954335, "Lcom/baidu/tieba/lt2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947954335, "Lcom/baidu/tieba/lt2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(du1 du1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, du1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                kt2 kt2Var = a.get(size).get();
                if (kt2Var == null) {
                    a.remove(size);
                } else {
                    kt2Var.d(du1Var);
                }
            }
        }
    }

    public static void b(du1 du1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, du1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                kt2 kt2Var = a.get(size).get();
                if (kt2Var == null) {
                    a.remove(size);
                } else {
                    kt2Var.b(du1Var);
                }
            }
        }
    }

    public static void c(du1 du1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, du1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                kt2 kt2Var = a.get(size).get();
                if (kt2Var == null) {
                    a.remove(size);
                } else {
                    kt2Var.c(du1Var);
                }
            }
        }
    }

    public static void d(du1 du1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, du1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                kt2 kt2Var = a.get(size).get();
                if (kt2Var == null) {
                    a.remove(size);
                } else {
                    kt2Var.a(du1Var);
                }
            }
        }
    }

    public static void f(kt2 kt2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, kt2Var) != null) || kt2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            kt2 kt2Var2 = a.get(size).get();
            if (kt2Var2 == null || kt2Var == kt2Var2) {
                a.remove(size);
            }
        }
    }

    public static void e(kt2 kt2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, kt2Var) != null) || kt2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            kt2 kt2Var2 = a.get(size).get();
            if (kt2Var2 == null) {
                a.remove(size);
            } else if (kt2Var2 == kt2Var) {
                z = true;
            } else {
                z = false;
            }
        }
        if (!z) {
            a.add(new WeakReference<>(kt2Var));
        }
    }
}
