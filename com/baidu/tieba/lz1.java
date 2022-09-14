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
/* loaded from: classes4.dex */
public class lz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947960070, "Lcom/baidu/tieba/lz1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947960070, "Lcom/baidu/tieba/lz1;");
                return;
            }
        }
        boolean z = ij1.a;
    }

    @Nullable
    public static <C extends ny1> C a(oy1 oy1Var) {
        InterceptResult invokeL;
        C c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, oy1Var)) == null) {
            if (oy1Var == null) {
                rz1.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d = oy1Var.d();
            String str = oy1Var.c;
            if (TextUtils.isEmpty(str)) {
                yz1.c("Component-Finder", "find a null " + d + " : slaveId is empty");
                return null;
            }
            oz1 d2 = d(str);
            if (d2 == null) {
                yz1.c("Component-Finder", "find a null " + d + " : null component context");
                return null;
            }
            String str2 = oy1Var.b;
            if (TextUtils.isEmpty(str2)) {
                yz1.o("Component-Finder", "find " + d + " with a empty componentId");
                List<ny1> list = d2.a().c.get(oy1Var.a);
                if (list == null) {
                    yz1.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    yz1.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    yz1.o("Component-Finder", "find " + d + " with a empty componentId: fina a fallback component");
                    c = (C) list.get(0);
                }
            } else {
                c = (C) d2.a().b.get(str2);
            }
            if (c == null) {
                yz1.c("Component-Finder", "find a null " + d + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends ny1> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            oz1 d = d(str);
            if (d == null) {
                yz1.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c = (C) d.a().b.get(str2);
            if (c == null) {
                yz1.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static oz1 c(oy1 oy1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, oy1Var)) == null) {
            if (oy1Var == null) {
                rz1.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(oy1Var.c);
        }
        return (oz1) invokeL.objValue;
    }

    @Nullable
    public static oz1 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                yz1.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            gp1 A = lo2.U().A(str);
            if (A instanceof ep1) {
                return ((ep1) A).c0();
            }
            return null;
        }
        return (oz1) invokeL.objValue;
    }
}
