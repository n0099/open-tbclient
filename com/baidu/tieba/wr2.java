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
public class wr2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<vr2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948280114, "Lcom/baidu/tieba/wr2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948280114, "Lcom/baidu/tieba/wr2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(ps1 ps1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, ps1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                vr2 vr2Var = a.get(size).get();
                if (vr2Var == null) {
                    a.remove(size);
                } else {
                    vr2Var.d(ps1Var);
                }
            }
        }
    }

    public static void b(ps1 ps1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, ps1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                vr2 vr2Var = a.get(size).get();
                if (vr2Var == null) {
                    a.remove(size);
                } else {
                    vr2Var.b(ps1Var);
                }
            }
        }
    }

    public static void c(ps1 ps1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, ps1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                vr2 vr2Var = a.get(size).get();
                if (vr2Var == null) {
                    a.remove(size);
                } else {
                    vr2Var.c(ps1Var);
                }
            }
        }
    }

    public static void d(ps1 ps1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ps1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                vr2 vr2Var = a.get(size).get();
                if (vr2Var == null) {
                    a.remove(size);
                } else {
                    vr2Var.a(ps1Var);
                }
            }
        }
    }

    public static void f(vr2 vr2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, vr2Var) != null) || vr2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            vr2 vr2Var2 = a.get(size).get();
            if (vr2Var2 == null || vr2Var == vr2Var2) {
                a.remove(size);
            }
        }
    }

    public static void e(vr2 vr2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, vr2Var) != null) || vr2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            vr2 vr2Var2 = a.get(size).get();
            if (vr2Var2 == null) {
                a.remove(size);
            } else if (vr2Var2 == vr2Var) {
                z = true;
            } else {
                z = false;
            }
        }
        if (!z) {
            a.add(new WeakReference<>(vr2Var));
        }
    }
}
