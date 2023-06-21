package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class te4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(View view2, f23 f23Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, view2, f23Var)) == null) {
            qt1 W = mx2.T().W();
            if (W != null && W.c(view2, f23Var)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean f(View view2, f23 f23Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, view2, f23Var)) == null) {
            qt1 W = mx2.T().W();
            if (W != null && W.a(view2, f23Var)) {
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
            qt1 W = mx2.T().W();
            if (W != null) {
                return W.getContext();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    public static void c(yq3 yq3Var) {
        qt1 W;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, yq3Var) == null) && (W = mx2.T().W()) != null) {
            W.e(yq3Var);
        }
    }

    public static boolean d(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view2)) == null) {
            qt1 W = mx2.T().W();
            if (W != null && W.removeView(view2)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void e(yq3 yq3Var) {
        qt1 W;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, yq3Var) == null) && (W = mx2.T().W()) != null) {
            W.f(yq3Var);
        }
    }
}
