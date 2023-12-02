package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.view.View;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jz3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(View view2, qw2 qw2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, view2, qw2Var)) == null) {
            co1 X = xr2.V().X();
            if (X != null && X.c(view2, qw2Var)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            co1 X = xr2.V().X();
            if (X == null || !X.b() || X.h()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            co1 X = xr2.V().X();
            if (X != null && X.d(view2)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static boolean d(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view2)) == null) {
            co1 X = xr2.V().X();
            if (X == null) {
                return false;
            }
            if (X.h()) {
                SwanAppActivity activity = xr2.V().getActivity();
                if (activity != null) {
                    activity.setRequestedOrientation(0);
                }
                X.g(false);
            }
            return X.removeView(view2);
        }
        return invokeL.booleanValue;
    }
}
