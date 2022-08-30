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
/* loaded from: classes5.dex */
public class nx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948017730, "Lcom/baidu/tieba/nx1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948017730, "Lcom/baidu/tieba/nx1;");
                return;
            }
        }
        boolean z = kh1.a;
    }

    @Nullable
    public static <C extends pw1> C a(qw1 qw1Var) {
        InterceptResult invokeL;
        C c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, qw1Var)) == null) {
            if (qw1Var == null) {
                tx1.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d = qw1Var.d();
            String str = qw1Var.c;
            if (TextUtils.isEmpty(str)) {
                ay1.c("Component-Finder", "find a null " + d + " : slaveId is empty");
                return null;
            }
            qx1 d2 = d(str);
            if (d2 == null) {
                ay1.c("Component-Finder", "find a null " + d + " : null component context");
                return null;
            }
            String str2 = qw1Var.b;
            if (TextUtils.isEmpty(str2)) {
                ay1.o("Component-Finder", "find " + d + " with a empty componentId");
                List<pw1> list = d2.a().c.get(qw1Var.a);
                if (list == null) {
                    ay1.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    ay1.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    ay1.o("Component-Finder", "find " + d + " with a empty componentId: fina a fallback component");
                    c = (C) list.get(0);
                }
            } else {
                c = (C) d2.a().b.get(str2);
            }
            if (c == null) {
                ay1.c("Component-Finder", "find a null " + d + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends pw1> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            qx1 d = d(str);
            if (d == null) {
                ay1.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c = (C) d.a().b.get(str2);
            if (c == null) {
                ay1.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static qx1 c(qw1 qw1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, qw1Var)) == null) {
            if (qw1Var == null) {
                tx1.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(qw1Var.c);
        }
        return (qx1) invokeL.objValue;
    }

    @Nullable
    public static qx1 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                ay1.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            in1 A = nm2.U().A(str);
            if (A instanceof gn1) {
                return ((gn1) A).c0();
            }
            return null;
        }
        return (qx1) invokeL.objValue;
    }
}
