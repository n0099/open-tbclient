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
public class jt2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<it2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947894753, "Lcom/baidu/tieba/jt2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947894753, "Lcom/baidu/tieba/jt2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(bu1 bu1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, bu1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                it2 it2Var = a.get(size).get();
                if (it2Var == null) {
                    a.remove(size);
                } else {
                    it2Var.d(bu1Var);
                }
            }
        }
    }

    public static void b(bu1 bu1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, bu1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                it2 it2Var = a.get(size).get();
                if (it2Var == null) {
                    a.remove(size);
                } else {
                    it2Var.b(bu1Var);
                }
            }
        }
    }

    public static void c(bu1 bu1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, bu1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                it2 it2Var = a.get(size).get();
                if (it2Var == null) {
                    a.remove(size);
                } else {
                    it2Var.c(bu1Var);
                }
            }
        }
    }

    public static void d(bu1 bu1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bu1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                it2 it2Var = a.get(size).get();
                if (it2Var == null) {
                    a.remove(size);
                } else {
                    it2Var.a(bu1Var);
                }
            }
        }
    }

    public static void f(it2 it2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, it2Var) != null) || it2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            it2 it2Var2 = a.get(size).get();
            if (it2Var2 == null || it2Var == it2Var2) {
                a.remove(size);
            }
        }
    }

    public static void e(it2 it2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, it2Var) != null) || it2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            it2 it2Var2 = a.get(size).get();
            if (it2Var2 == null) {
                a.remove(size);
            } else if (it2Var2 == it2Var) {
                z = true;
            } else {
                z = false;
            }
        }
        if (!z) {
            a.add(new WeakReference<>(it2Var));
        }
    }
}
