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
/* loaded from: classes9.dex */
public final class zj0 {
    public static /* synthetic */ Interceptable $ic;
    public static ek0 a;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static ck0 a(ek0 ek0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ek0Var)) == null) {
            if (ek0Var instanceof ck0) {
                return (ck0) ek0Var;
            }
            return null;
        }
        return (ck0) invokeL.objValue;
    }

    public static fk0 b(ek0 ek0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ek0Var)) == null) {
            if (ek0Var instanceof fk0) {
                return (fk0) ek0Var;
            }
            return null;
        }
        return (fk0) invokeL.objValue;
    }

    public static void c(@NonNull ek0 ek0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, ek0Var) == null) {
            synchronized (ek0.class) {
                if (a != null) {
                    return;
                }
                a = ek0Var;
            }
        }
    }

    public static void g(dk0 dk0Var) {
        fk0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, dk0Var) == null) && (b = b(a)) != null) {
            b.c(dk0Var);
        }
    }

    public static void h(dk0 dk0Var) {
        fk0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, dk0Var) == null) && (b = b(a)) != null) {
            b.e(dk0Var);
        }
    }

    @Nullable
    public static LinkedList<WeakReference<Activity>> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            ck0 a2 = a(a);
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
            ck0 a2 = a(a);
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
            ck0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.d();
        }
        return (Activity) invokeV.objValue;
    }
}
