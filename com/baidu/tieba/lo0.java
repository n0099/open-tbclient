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
public final class lo0 {
    public static /* synthetic */ Interceptable $ic;
    public static qo0 a;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static oo0 a(qo0 qo0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, qo0Var)) == null) {
            if (qo0Var instanceof oo0) {
                return (oo0) qo0Var;
            }
            return null;
        }
        return (oo0) invokeL.objValue;
    }

    public static ro0 b(qo0 qo0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, qo0Var)) == null) {
            if (qo0Var instanceof ro0) {
                return (ro0) qo0Var;
            }
            return null;
        }
        return (ro0) invokeL.objValue;
    }

    public static void c(@NonNull qo0 qo0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, qo0Var) == null) {
            synchronized (qo0.class) {
                if (a != null) {
                    return;
                }
                a = qo0Var;
            }
        }
    }

    public static void g(po0 po0Var) {
        ro0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, po0Var) == null) && (b = b(a)) != null) {
            b.c(po0Var);
        }
    }

    public static void h(po0 po0Var) {
        ro0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, po0Var) == null) && (b = b(a)) != null) {
            b.e(po0Var);
        }
    }

    @Nullable
    public static LinkedList<WeakReference<Activity>> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            oo0 a2 = a(a);
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
            oo0 a2 = a(a);
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
            oo0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.d();
        }
        return (Activity) invokeV.objValue;
    }
}
