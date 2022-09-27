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
/* loaded from: classes6.dex */
public class yz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948347353, "Lcom/baidu/tieba/yz1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948347353, "Lcom/baidu/tieba/yz1;");
                return;
            }
        }
        boolean z = vj1.a;
    }

    @Nullable
    public static <C extends az1> C a(bz1 bz1Var) {
        InterceptResult invokeL;
        C c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bz1Var)) == null) {
            if (bz1Var == null) {
                e02.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d = bz1Var.d();
            String str = bz1Var.c;
            if (TextUtils.isEmpty(str)) {
                l02.c("Component-Finder", "find a null " + d + " : slaveId is empty");
                return null;
            }
            b02 d2 = d(str);
            if (d2 == null) {
                l02.c("Component-Finder", "find a null " + d + " : null component context");
                return null;
            }
            String str2 = bz1Var.b;
            if (TextUtils.isEmpty(str2)) {
                l02.o("Component-Finder", "find " + d + " with a empty componentId");
                List<az1> list = d2.a().c.get(bz1Var.a);
                if (list == null) {
                    l02.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    l02.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    l02.o("Component-Finder", "find " + d + " with a empty componentId: fina a fallback component");
                    c = (C) list.get(0);
                }
            } else {
                c = (C) d2.a().b.get(str2);
            }
            if (c == null) {
                l02.c("Component-Finder", "find a null " + d + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends az1> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            b02 d = d(str);
            if (d == null) {
                l02.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c = (C) d.a().b.get(str2);
            if (c == null) {
                l02.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static b02 c(bz1 bz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bz1Var)) == null) {
            if (bz1Var == null) {
                e02.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(bz1Var.c);
        }
        return (b02) invokeL.objValue;
    }

    @Nullable
    public static b02 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                l02.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            tp1 A = yo2.U().A(str);
            if (A instanceof rp1) {
                return ((rp1) A).c0();
            }
            return null;
        }
        return (b02) invokeL.objValue;
    }
}
