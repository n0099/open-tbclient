package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class rta {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"ObsoleteSdkInt"})
    public static final boolean d(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return view2.isAttachedToWindow();
            }
            if (view2.getWindowToken() != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final RectF c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            int[] iArr = {0, 0};
            view2.getLocationOnScreen(iArr);
            return new RectF(iArr[0], iArr[1], iArr[0] + view2.getWidth(), iArr[1] + view2.getHeight());
        }
        return (RectF) invokeL.objValue;
    }
}
