package com.baidu.tieba;

import android.app.Activity;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public final class jn0 {
    public static /* synthetic */ Interceptable $ic;
    public static on0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static mn0 a(on0 on0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, on0Var)) == null) {
            if (on0Var instanceof mn0) {
                return (mn0) on0Var;
            }
            return null;
        }
        return (mn0) invokeL.objValue;
    }

    public static pn0 b(on0 on0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, on0Var)) == null) {
            if (on0Var instanceof pn0) {
                return (pn0) on0Var;
            }
            return null;
        }
        return (pn0) invokeL.objValue;
    }

    public static void c(on0 on0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, on0Var) == null) {
            synchronized (on0.class) {
                if (a != null) {
                    return;
                }
                a = on0Var;
            }
        }
    }

    public static void f(nn0 nn0Var) {
        pn0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, nn0Var) == null) && (b = b(a)) != null) {
            b.b(nn0Var);
        }
    }

    public static void g(nn0 nn0Var) {
        pn0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, nn0Var) == null) && (b = b(a)) != null) {
            b.d(nn0Var);
        }
    }

    public static Activity d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            mn0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.a();
        }
        return (Activity) invokeV.objValue;
    }

    public static Activity e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            mn0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.c();
        }
        return (Activity) invokeV.objValue;
    }
}
