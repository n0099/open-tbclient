package com.baidu.tieba;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class kn3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull jn3 jn3Var, @NonNull ay2 ay2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, jn3Var, ay2Var) == null) {
            jn3Var.f(ay2Var.d());
            jn3Var.g(ay2Var.e());
            if (ay2Var.g()) {
                jn3Var.a(1);
            } else {
                jn3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull bu1 bu1Var, @NonNull ay2 ay2Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bu1Var, ay2Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ay2Var.f(), ay2Var.c());
            int i2 = 0;
            if (ay2Var.g()) {
                i2 = bu1Var.getWebViewScrollX();
                i = bu1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = ay2Var.d() + i2;
            layoutParams.topMargin = ay2Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
