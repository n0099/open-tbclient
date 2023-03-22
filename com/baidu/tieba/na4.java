package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class na4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(View view2, zx2 zx2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, view2, zx2Var)) == null) {
            kp1 X = gt2.U().X();
            if (X != null && X.c(view2, zx2Var)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean f(View view2, zx2 zx2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, view2, zx2Var)) == null) {
            kp1 X = gt2.U().X();
            if (X != null && X.a(view2, zx2Var)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            kp1 X = gt2.U().X();
            if (X != null) {
                return X.getContext();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    public static void c(sm3 sm3Var) {
        kp1 X;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, sm3Var) == null) && (X = gt2.U().X()) != null) {
            X.e(sm3Var);
        }
    }

    public static boolean d(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view2)) == null) {
            kp1 X = gt2.U().X();
            if (X != null && X.removeView(view2)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void e(sm3 sm3Var) {
        kp1 X;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, sm3Var) == null) && (X = gt2.U().X()) != null) {
            X.f(sm3Var);
        }
    }
}
