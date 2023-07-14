package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class pe4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(View view2, b23 b23Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, view2, b23Var)) == null) {
            mt1 W = ix2.T().W();
            if (W != null && W.c(view2, b23Var)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean f(View view2, b23 b23Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, view2, b23Var)) == null) {
            mt1 W = ix2.T().W();
            if (W != null && W.a(view2, b23Var)) {
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
            mt1 W = ix2.T().W();
            if (W != null) {
                return W.getContext();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    public static void c(uq3 uq3Var) {
        mt1 W;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, uq3Var) == null) && (W = ix2.T().W()) != null) {
            W.e(uq3Var);
        }
    }

    public static boolean d(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view2)) == null) {
            mt1 W = ix2.T().W();
            if (W != null && W.removeView(view2)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void e(uq3 uq3Var) {
        mt1 W;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, uq3Var) == null) && (W = ix2.T().W()) != null) {
            W.f(uq3Var);
        }
    }
}
