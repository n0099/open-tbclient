package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public final class in0 {
    public static /* synthetic */ Interceptable $ic;
    public static nn0 a;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static ln0 a(nn0 nn0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, nn0Var)) == null) {
            if (nn0Var instanceof ln0) {
                return (ln0) nn0Var;
            }
            return null;
        }
        return (ln0) invokeL.objValue;
    }

    public static on0 b(nn0 nn0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, nn0Var)) == null) {
            if (nn0Var instanceof on0) {
                return (on0) nn0Var;
            }
            return null;
        }
        return (on0) invokeL.objValue;
    }

    public static void c(@NonNull nn0 nn0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, nn0Var) == null) {
            synchronized (nn0.class) {
                if (a != null) {
                    return;
                }
                a = nn0Var;
            }
        }
    }

    @Nullable
    public static Activity d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            ln0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.a();
        }
        return (Activity) invokeV.objValue;
    }

    @Nullable
    public static Activity e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            ln0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.c();
        }
        return (Activity) invokeV.objValue;
    }

    public static void f(mn0 mn0Var) {
        on0 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, mn0Var) == null) || (b = b(a)) == null) {
            return;
        }
        b.b(mn0Var);
    }

    public static void g(mn0 mn0Var) {
        on0 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, mn0Var) == null) || (b = b(a)) == null) {
            return;
        }
        b.d(mn0Var);
    }
}
