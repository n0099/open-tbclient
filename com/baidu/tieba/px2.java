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
public class px2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<ox2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948077343, "Lcom/baidu/tieba/px2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948077343, "Lcom/baidu/tieba/px2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(hy1 hy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, hy1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                ox2 ox2Var = a.get(size).get();
                if (ox2Var == null) {
                    a.remove(size);
                } else {
                    ox2Var.d(hy1Var);
                }
            }
        }
    }

    public static void b(hy1 hy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, hy1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                ox2 ox2Var = a.get(size).get();
                if (ox2Var == null) {
                    a.remove(size);
                } else {
                    ox2Var.b(hy1Var);
                }
            }
        }
    }

    public static void c(hy1 hy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, hy1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                ox2 ox2Var = a.get(size).get();
                if (ox2Var == null) {
                    a.remove(size);
                } else {
                    ox2Var.c(hy1Var);
                }
            }
        }
    }

    public static void d(hy1 hy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, hy1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                ox2 ox2Var = a.get(size).get();
                if (ox2Var == null) {
                    a.remove(size);
                } else {
                    ox2Var.a(hy1Var);
                }
            }
        }
    }

    public static void f(ox2 ox2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, ox2Var) != null) || ox2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            ox2 ox2Var2 = a.get(size).get();
            if (ox2Var2 == null || ox2Var == ox2Var2) {
                a.remove(size);
            }
        }
    }

    public static void e(ox2 ox2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, ox2Var) != null) || ox2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            ox2 ox2Var2 = a.get(size).get();
            if (ox2Var2 == null) {
                a.remove(size);
            } else if (ox2Var2 == ox2Var) {
                z = true;
            } else {
                z = false;
            }
        }
        if (!z) {
            a.add(new WeakReference<>(ox2Var));
        }
    }
}
