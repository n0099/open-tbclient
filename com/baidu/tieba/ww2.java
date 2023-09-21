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
public class ww2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<vw2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948284919, "Lcom/baidu/tieba/ww2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948284919, "Lcom/baidu/tieba/ww2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(ox1 ox1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, ox1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                vw2 vw2Var = a.get(size).get();
                if (vw2Var == null) {
                    a.remove(size);
                } else {
                    vw2Var.d(ox1Var);
                }
            }
        }
    }

    public static void b(ox1 ox1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, ox1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                vw2 vw2Var = a.get(size).get();
                if (vw2Var == null) {
                    a.remove(size);
                } else {
                    vw2Var.b(ox1Var);
                }
            }
        }
    }

    public static void c(ox1 ox1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, ox1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                vw2 vw2Var = a.get(size).get();
                if (vw2Var == null) {
                    a.remove(size);
                } else {
                    vw2Var.c(ox1Var);
                }
            }
        }
    }

    public static void d(ox1 ox1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ox1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                vw2 vw2Var = a.get(size).get();
                if (vw2Var == null) {
                    a.remove(size);
                } else {
                    vw2Var.a(ox1Var);
                }
            }
        }
    }

    public static void f(vw2 vw2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, vw2Var) != null) || vw2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            vw2 vw2Var2 = a.get(size).get();
            if (vw2Var2 == null || vw2Var == vw2Var2) {
                a.remove(size);
            }
        }
    }

    public static void e(vw2 vw2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, vw2Var) != null) || vw2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            vw2 vw2Var2 = a.get(size).get();
            if (vw2Var2 == null) {
                a.remove(size);
            } else if (vw2Var2 == vw2Var) {
                z = true;
            } else {
                z = false;
            }
        }
        if (!z) {
            a.add(new WeakReference<>(vw2Var));
        }
    }
}
