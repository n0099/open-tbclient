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
public class kt2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<jt2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947924544, "Lcom/baidu/tieba/kt2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947924544, "Lcom/baidu/tieba/kt2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(cu1 cu1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, cu1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                jt2 jt2Var = a.get(size).get();
                if (jt2Var == null) {
                    a.remove(size);
                } else {
                    jt2Var.d(cu1Var);
                }
            }
        }
    }

    public static void b(cu1 cu1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, cu1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                jt2 jt2Var = a.get(size).get();
                if (jt2Var == null) {
                    a.remove(size);
                } else {
                    jt2Var.b(cu1Var);
                }
            }
        }
    }

    public static void c(cu1 cu1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, cu1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                jt2 jt2Var = a.get(size).get();
                if (jt2Var == null) {
                    a.remove(size);
                } else {
                    jt2Var.c(cu1Var);
                }
            }
        }
    }

    public static void d(cu1 cu1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cu1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                jt2 jt2Var = a.get(size).get();
                if (jt2Var == null) {
                    a.remove(size);
                } else {
                    jt2Var.a(cu1Var);
                }
            }
        }
    }

    public static void f(jt2 jt2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, jt2Var) != null) || jt2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            jt2 jt2Var2 = a.get(size).get();
            if (jt2Var2 == null || jt2Var == jt2Var2) {
                a.remove(size);
            }
        }
    }

    public static void e(jt2 jt2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, jt2Var) != null) || jt2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            jt2 jt2Var2 = a.get(size).get();
            if (jt2Var2 == null) {
                a.remove(size);
            } else if (jt2Var2 == jt2Var) {
                z = true;
            } else {
                z = false;
            }
        }
        if (!z) {
            a.add(new WeakReference<>(jt2Var));
        }
    }
}
