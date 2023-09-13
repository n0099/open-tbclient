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
public class xw2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<ww2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948314710, "Lcom/baidu/tieba/xw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948314710, "Lcom/baidu/tieba/xw2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(px1 px1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, px1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                ww2 ww2Var = a.get(size).get();
                if (ww2Var == null) {
                    a.remove(size);
                } else {
                    ww2Var.d(px1Var);
                }
            }
        }
    }

    public static void b(px1 px1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, px1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                ww2 ww2Var = a.get(size).get();
                if (ww2Var == null) {
                    a.remove(size);
                } else {
                    ww2Var.b(px1Var);
                }
            }
        }
    }

    public static void c(px1 px1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, px1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                ww2 ww2Var = a.get(size).get();
                if (ww2Var == null) {
                    a.remove(size);
                } else {
                    ww2Var.c(px1Var);
                }
            }
        }
    }

    public static void d(px1 px1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, px1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                ww2 ww2Var = a.get(size).get();
                if (ww2Var == null) {
                    a.remove(size);
                } else {
                    ww2Var.a(px1Var);
                }
            }
        }
    }

    public static void f(ww2 ww2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, ww2Var) != null) || ww2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            ww2 ww2Var2 = a.get(size).get();
            if (ww2Var2 == null || ww2Var == ww2Var2) {
                a.remove(size);
            }
        }
    }

    public static void e(ww2 ww2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, ww2Var) != null) || ww2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            ww2 ww2Var2 = a.get(size).get();
            if (ww2Var2 == null) {
                a.remove(size);
            } else if (ww2Var2 == ww2Var) {
                z = true;
            } else {
                z = false;
            }
        }
        if (!z) {
            a.add(new WeakReference<>(ww2Var));
        }
    }
}
