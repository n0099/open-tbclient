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
public class vp2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<up2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948248401, "Lcom/baidu/tieba/vp2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948248401, "Lcom/baidu/tieba/vp2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(nq1 nq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, nq1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                up2 up2Var = a.get(size).get();
                if (up2Var == null) {
                    a.remove(size);
                } else {
                    up2Var.d(nq1Var);
                }
            }
        }
    }

    public static void b(nq1 nq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, nq1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                up2 up2Var = a.get(size).get();
                if (up2Var == null) {
                    a.remove(size);
                } else {
                    up2Var.b(nq1Var);
                }
            }
        }
    }

    public static void c(nq1 nq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, nq1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                up2 up2Var = a.get(size).get();
                if (up2Var == null) {
                    a.remove(size);
                } else {
                    up2Var.c(nq1Var);
                }
            }
        }
    }

    public static void d(nq1 nq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, nq1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                up2 up2Var = a.get(size).get();
                if (up2Var == null) {
                    a.remove(size);
                } else {
                    up2Var.a(nq1Var);
                }
            }
        }
    }

    public static void f(up2 up2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, up2Var) != null) || up2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            up2 up2Var2 = a.get(size).get();
            if (up2Var2 == null || up2Var == up2Var2) {
                a.remove(size);
            }
        }
    }

    public static void e(up2 up2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, up2Var) != null) || up2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            up2 up2Var2 = a.get(size).get();
            if (up2Var2 == null) {
                a.remove(size);
            } else if (up2Var2 == up2Var) {
                z = true;
            } else {
                z = false;
            }
        }
        if (!z) {
            a.add(new WeakReference<>(up2Var));
        }
    }
}
