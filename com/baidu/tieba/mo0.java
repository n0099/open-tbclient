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
/* loaded from: classes7.dex */
public final class mo0 {
    public static /* synthetic */ Interceptable $ic;
    public static ro0 a;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static po0 a(ro0 ro0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ro0Var)) == null) {
            if (ro0Var instanceof po0) {
                return (po0) ro0Var;
            }
            return null;
        }
        return (po0) invokeL.objValue;
    }

    public static so0 b(ro0 ro0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ro0Var)) == null) {
            if (ro0Var instanceof so0) {
                return (so0) ro0Var;
            }
            return null;
        }
        return (so0) invokeL.objValue;
    }

    public static void c(@NonNull ro0 ro0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, ro0Var) == null) {
            synchronized (ro0.class) {
                if (a != null) {
                    return;
                }
                a = ro0Var;
            }
        }
    }

    public static void g(qo0 qo0Var) {
        so0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, qo0Var) == null) && (b = b(a)) != null) {
            b.c(qo0Var);
        }
    }

    public static void h(qo0 qo0Var) {
        so0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, qo0Var) == null) && (b = b(a)) != null) {
            b.e(qo0Var);
        }
    }

    @Nullable
    public static LinkedList<WeakReference<Activity>> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            po0 a2 = a(a);
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
            po0 a2 = a(a);
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
            po0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.d();
        }
        return (Activity) invokeV.objValue;
    }
}
