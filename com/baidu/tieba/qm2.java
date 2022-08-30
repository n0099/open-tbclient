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
public class qm2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<pm2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948096563, "Lcom/baidu/tieba/qm2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948096563, "Lcom/baidu/tieba/qm2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(in1 in1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, in1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                pm2 pm2Var = a.get(size).get();
                if (pm2Var == null) {
                    a.remove(size);
                } else {
                    pm2Var.d(in1Var);
                }
            }
        }
    }

    public static void b(in1 in1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, in1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                pm2 pm2Var = a.get(size).get();
                if (pm2Var == null) {
                    a.remove(size);
                } else {
                    pm2Var.b(in1Var);
                }
            }
        }
    }

    public static void c(in1 in1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, in1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                pm2 pm2Var = a.get(size).get();
                if (pm2Var == null) {
                    a.remove(size);
                } else {
                    pm2Var.c(in1Var);
                }
            }
        }
    }

    public static void d(in1 in1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, in1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                pm2 pm2Var = a.get(size).get();
                if (pm2Var == null) {
                    a.remove(size);
                } else {
                    pm2Var.a(in1Var);
                }
            }
        }
    }

    public static void e(pm2 pm2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, pm2Var) == null) || pm2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            pm2 pm2Var2 = a.get(size).get();
            if (pm2Var2 == null) {
                a.remove(size);
            } else {
                z = pm2Var2 == pm2Var;
            }
        }
        if (z) {
            return;
        }
        a.add(new WeakReference<>(pm2Var));
    }

    public static void f(pm2 pm2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, pm2Var) == null) || pm2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            pm2 pm2Var2 = a.get(size).get();
            if (pm2Var2 == null || pm2Var == pm2Var2) {
                a.remove(size);
            }
        }
    }
}
