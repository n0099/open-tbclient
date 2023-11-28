package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes8.dex */
public class u22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948159028, "Lcom/baidu/tieba/u22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948159028, "Lcom/baidu/tieba/u22;");
                return;
            }
        }
        boolean z = sm1.a;
    }

    @Nullable
    public static <C extends x12> C a(y12 y12Var) {
        InterceptResult invokeL;
        C c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, y12Var)) == null) {
            if (y12Var == null) {
                a32.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d = y12Var.d();
            String str = y12Var.c;
            if (TextUtils.isEmpty(str)) {
                h32.c("Component-Finder", "find a null " + d + " : slaveId is empty");
                return null;
            }
            x22 d2 = d(str);
            if (d2 == null) {
                h32.c("Component-Finder", "find a null " + d + " : null component context");
                return null;
            }
            String str2 = y12Var.b;
            if (TextUtils.isEmpty(str2)) {
                h32.o("Component-Finder", "find " + d + " with a empty componentId");
                List<x12> list = d2.a().c.get(y12Var.a);
                if (list == null) {
                    h32.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    h32.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    h32.o("Component-Finder", "find " + d + " with a empty componentId: fina a fallback component");
                    c = (C) list.get(0);
                }
            } else {
                c = (C) d2.a().b.get(str2);
            }
            if (c == null) {
                h32.c("Component-Finder", "find a null " + d + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends x12> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            x22 d = d(str);
            if (d == null) {
                h32.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c = (C) d.a().b.get(str2);
            if (c == null) {
                h32.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static x22 c(y12 y12Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, y12Var)) == null) {
            if (y12Var == null) {
                a32.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(y12Var.c);
        }
        return (x22) invokeL.objValue;
    }

    @Nullable
    public static x22 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                h32.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            qs1 B = ur2.V().B(str);
            if (!(B instanceof os1)) {
                return null;
            }
            return ((os1) B).Z();
        }
        return (x22) invokeL.objValue;
    }
}
