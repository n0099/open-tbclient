package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public final class io0 {
    public static /* synthetic */ Interceptable $ic;
    public static no0 a;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static lo0 a(no0 no0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, no0Var)) == null) {
            if (no0Var instanceof lo0) {
                return (lo0) no0Var;
            }
            return null;
        }
        return (lo0) invokeL.objValue;
    }

    public static oo0 b(no0 no0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, no0Var)) == null) {
            if (no0Var instanceof oo0) {
                return (oo0) no0Var;
            }
            return null;
        }
        return (oo0) invokeL.objValue;
    }

    public static void c(@NonNull no0 no0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, no0Var) == null) {
            synchronized (no0.class) {
                if (a != null) {
                    return;
                }
                a = no0Var;
            }
        }
    }

    public static void g(mo0 mo0Var) {
        oo0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, mo0Var) == null) && (b = b(a)) != null) {
            b.c(mo0Var);
        }
    }

    public static void h(mo0 mo0Var) {
        oo0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, mo0Var) == null) && (b = b(a)) != null) {
            b.e(mo0Var);
        }
    }

    @Nullable
    public static LinkedList<WeakReference<Activity>> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            lo0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.a();
        }
        return (LinkedList) invokeV.objValue;
    }

    @Nullable
    public static Activity e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            lo0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.b();
        }
        return (Activity) invokeV.objValue;
    }

    @Nullable
    public static Activity f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            lo0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.d();
        }
        return (Activity) invokeV.objValue;
    }
}
