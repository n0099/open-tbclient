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
public class u72 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948163833, "Lcom/baidu/tieba/u72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948163833, "Lcom/baidu/tieba/u72;");
                return;
            }
        }
        boolean z = rr1.a;
    }

    @Nullable
    public static <C extends w62> C a(x62 x62Var) {
        InterceptResult invokeL;
        C c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, x62Var)) == null) {
            if (x62Var == null) {
                a82.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d = x62Var.d();
            String str = x62Var.c;
            if (TextUtils.isEmpty(str)) {
                h82.c("Component-Finder", "find a null " + d + " : slaveId is empty");
                return null;
            }
            x72 d2 = d(str);
            if (d2 == null) {
                h82.c("Component-Finder", "find a null " + d + " : null component context");
                return null;
            }
            String str2 = x62Var.b;
            if (TextUtils.isEmpty(str2)) {
                h82.o("Component-Finder", "find " + d + " with a empty componentId");
                List<w62> list = d2.a().c.get(x62Var.a);
                if (list == null) {
                    h82.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    h82.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    h82.o("Component-Finder", "find " + d + " with a empty componentId: fina a fallback component");
                    c = (C) list.get(0);
                }
            } else {
                c = (C) d2.a().b.get(str2);
            }
            if (c == null) {
                h82.c("Component-Finder", "find a null " + d + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends w62> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            x72 d = d(str);
            if (d == null) {
                h82.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c = (C) d.a().b.get(str2);
            if (c == null) {
                h82.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static x72 c(x62 x62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, x62Var)) == null) {
            if (x62Var == null) {
                a82.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(x62Var.c);
        }
        return (x72) invokeL.objValue;
    }

    @Nullable
    public static x72 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                h82.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            px1 A = uw2.T().A(str);
            if (!(A instanceof nx1)) {
                return null;
            }
            return ((nx1) A).a0();
        }
        return (x72) invokeL.objValue;
    }
}
