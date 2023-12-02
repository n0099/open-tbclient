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
/* loaded from: classes9.dex */
public class x22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948248401, "Lcom/baidu/tieba/x22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948248401, "Lcom/baidu/tieba/x22;");
                return;
            }
        }
        boolean z = vm1.a;
    }

    @Nullable
    public static <C extends a22> C a(b22 b22Var) {
        InterceptResult invokeL;
        C c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, b22Var)) == null) {
            if (b22Var == null) {
                d32.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d = b22Var.d();
            String str = b22Var.c;
            if (TextUtils.isEmpty(str)) {
                k32.c("Component-Finder", "find a null " + d + " : slaveId is empty");
                return null;
            }
            a32 d2 = d(str);
            if (d2 == null) {
                k32.c("Component-Finder", "find a null " + d + " : null component context");
                return null;
            }
            String str2 = b22Var.b;
            if (TextUtils.isEmpty(str2)) {
                k32.o("Component-Finder", "find " + d + " with a empty componentId");
                List<a22> list = d2.a().c.get(b22Var.a);
                if (list == null) {
                    k32.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    k32.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    k32.o("Component-Finder", "find " + d + " with a empty componentId: fina a fallback component");
                    c = (C) list.get(0);
                }
            } else {
                c = (C) d2.a().b.get(str2);
            }
            if (c == null) {
                k32.c("Component-Finder", "find a null " + d + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends a22> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            a32 d = d(str);
            if (d == null) {
                k32.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c = (C) d.a().b.get(str2);
            if (c == null) {
                k32.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static a32 c(b22 b22Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, b22Var)) == null) {
            if (b22Var == null) {
                d32.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(b22Var.c);
        }
        return (a32) invokeL.objValue;
    }

    @Nullable
    public static a32 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                k32.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            ts1 B = xr2.V().B(str);
            if (!(B instanceof rs1)) {
                return null;
            }
            return ((rs1) B).Z();
        }
        return (a32) invokeL.objValue;
    }
}
