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
public class up2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<tp2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948218610, "Lcom/baidu/tieba/up2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948218610, "Lcom/baidu/tieba/up2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(mq1 mq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, mq1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                tp2 tp2Var = a.get(size).get();
                if (tp2Var == null) {
                    a.remove(size);
                } else {
                    tp2Var.d(mq1Var);
                }
            }
        }
    }

    public static void b(mq1 mq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, mq1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                tp2 tp2Var = a.get(size).get();
                if (tp2Var == null) {
                    a.remove(size);
                } else {
                    tp2Var.b(mq1Var);
                }
            }
        }
    }

    public static void c(mq1 mq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, mq1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                tp2 tp2Var = a.get(size).get();
                if (tp2Var == null) {
                    a.remove(size);
                } else {
                    tp2Var.c(mq1Var);
                }
            }
        }
    }

    public static void d(mq1 mq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, mq1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                tp2 tp2Var = a.get(size).get();
                if (tp2Var == null) {
                    a.remove(size);
                } else {
                    tp2Var.a(mq1Var);
                }
            }
        }
    }

    public static void f(tp2 tp2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, tp2Var) != null) || tp2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            tp2 tp2Var2 = a.get(size).get();
            if (tp2Var2 == null || tp2Var == tp2Var2) {
                a.remove(size);
            }
        }
    }

    public static void e(tp2 tp2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, tp2Var) != null) || tp2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            tp2 tp2Var2 = a.get(size).get();
            if (tp2Var2 == null) {
                a.remove(size);
            } else if (tp2Var2 == tp2Var) {
                z = true;
            } else {
                z = false;
            }
        }
        if (!z) {
            a.add(new WeakReference<>(tp2Var));
        }
    }
}
