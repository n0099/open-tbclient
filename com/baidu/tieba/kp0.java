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
public final class kp0 {
    public static /* synthetic */ Interceptable $ic;
    public static pp0 a;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static np0 a(pp0 pp0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pp0Var)) == null) {
            if (pp0Var instanceof np0) {
                return (np0) pp0Var;
            }
            return null;
        }
        return (np0) invokeL.objValue;
    }

    public static qp0 b(pp0 pp0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pp0Var)) == null) {
            if (pp0Var instanceof qp0) {
                return (qp0) pp0Var;
            }
            return null;
        }
        return (qp0) invokeL.objValue;
    }

    public static void c(@NonNull pp0 pp0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, pp0Var) == null) {
            synchronized (pp0.class) {
                if (a != null) {
                    return;
                }
                a = pp0Var;
            }
        }
    }

    public static void g(op0 op0Var) {
        qp0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, op0Var) == null) && (b = b(a)) != null) {
            b.c(op0Var);
        }
    }

    public static void h(op0 op0Var) {
        qp0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, op0Var) == null) && (b = b(a)) != null) {
            b.e(op0Var);
        }
    }

    @Nullable
    public static LinkedList<WeakReference<Activity>> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            np0 a2 = a(a);
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
            np0 a2 = a(a);
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
            np0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.d();
        }
        return (Activity) invokeV.objValue;
    }
}
