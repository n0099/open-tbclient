package com.baidu.tieba;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wl3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull vl3 vl3Var, @NonNull mw2 mw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, vl3Var, mw2Var) == null) {
            vl3Var.f(mw2Var.d());
            vl3Var.g(mw2Var.e());
            if (mw2Var.g()) {
                vl3Var.a(1);
            } else {
                vl3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull os1 os1Var, @NonNull mw2 mw2Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, os1Var, mw2Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(mw2Var.f(), mw2Var.c());
            int i2 = 0;
            if (mw2Var.g()) {
                i2 = os1Var.getWebViewScrollX();
                i = os1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = mw2Var.d() + i2;
            layoutParams.topMargin = mw2Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
