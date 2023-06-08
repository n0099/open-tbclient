package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wj9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(wm5 wm5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, wm5Var)) == null) {
            if (wm5Var != null) {
                return wm5Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(wm5 wm5Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{wm5Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) && !a(wm5Var) && context != null && view2 != null) {
            if (wm5Var == null) {
                wm5Var = new wm5(context, onClickListener);
            }
            wm5Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            wm5Var.attachView(view2, z);
            wm5Var.p();
            wm5Var.onChangeSkinType();
        }
    }
}
