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
public class nt2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<mt2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948013917, "Lcom/baidu/tieba/nt2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948013917, "Lcom/baidu/tieba/nt2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(fu1 fu1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, fu1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                mt2 mt2Var = a.get(size).get();
                if (mt2Var == null) {
                    a.remove(size);
                } else {
                    mt2Var.d(fu1Var);
                }
            }
        }
    }

    public static void b(fu1 fu1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, fu1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                mt2 mt2Var = a.get(size).get();
                if (mt2Var == null) {
                    a.remove(size);
                } else {
                    mt2Var.b(fu1Var);
                }
            }
        }
    }

    public static void c(fu1 fu1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, fu1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                mt2 mt2Var = a.get(size).get();
                if (mt2Var == null) {
                    a.remove(size);
                } else {
                    mt2Var.c(fu1Var);
                }
            }
        }
    }

    public static void d(fu1 fu1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fu1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                mt2 mt2Var = a.get(size).get();
                if (mt2Var == null) {
                    a.remove(size);
                } else {
                    mt2Var.a(fu1Var);
                }
            }
        }
    }

    public static void f(mt2 mt2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, mt2Var) != null) || mt2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            mt2 mt2Var2 = a.get(size).get();
            if (mt2Var2 == null || mt2Var == mt2Var2) {
                a.remove(size);
            }
        }
    }

    public static void e(mt2 mt2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, mt2Var) != null) || mt2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            mt2 mt2Var2 = a.get(size).get();
            if (mt2Var2 == null) {
                a.remove(size);
            } else if (mt2Var2 == mt2Var) {
                z = true;
            } else {
                z = false;
            }
        }
        if (!z) {
            a.add(new WeakReference<>(mt2Var));
        }
    }
}
