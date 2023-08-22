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
/* loaded from: classes8.dex */
public class tw2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<sw2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948195546, "Lcom/baidu/tieba/tw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948195546, "Lcom/baidu/tieba/tw2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(lx1 lx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, lx1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                sw2 sw2Var = a.get(size).get();
                if (sw2Var == null) {
                    a.remove(size);
                } else {
                    sw2Var.d(lx1Var);
                }
            }
        }
    }

    public static void b(lx1 lx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, lx1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                sw2 sw2Var = a.get(size).get();
                if (sw2Var == null) {
                    a.remove(size);
                } else {
                    sw2Var.b(lx1Var);
                }
            }
        }
    }

    public static void c(lx1 lx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, lx1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                sw2 sw2Var = a.get(size).get();
                if (sw2Var == null) {
                    a.remove(size);
                } else {
                    sw2Var.c(lx1Var);
                }
            }
        }
    }

    public static void d(lx1 lx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, lx1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                sw2 sw2Var = a.get(size).get();
                if (sw2Var == null) {
                    a.remove(size);
                } else {
                    sw2Var.a(lx1Var);
                }
            }
        }
    }

    public static void f(sw2 sw2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, sw2Var) != null) || sw2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            sw2 sw2Var2 = a.get(size).get();
            if (sw2Var2 == null || sw2Var == sw2Var2) {
                a.remove(size);
            }
        }
    }

    public static void e(sw2 sw2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, sw2Var) != null) || sw2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            sw2 sw2Var2 = a.get(size).get();
            if (sw2Var2 == null) {
                a.remove(size);
            } else if (sw2Var2 == sw2Var) {
                z = true;
            } else {
                z = false;
            }
        }
        if (!z) {
            a.add(new WeakReference<>(sw2Var));
        }
    }
}
