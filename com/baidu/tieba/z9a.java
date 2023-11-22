package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class z9a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(wj5 wj5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, wj5Var)) == null) {
            if (wj5Var != null) {
                return wj5Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(wj5 wj5Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{wj5Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) && !a(wj5Var) && context != null && view2 != null) {
            if (wj5Var == null) {
                wj5Var = new wj5(context, onClickListener);
            }
            wj5Var.j(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            wj5Var.attachView(view2, z);
            wj5Var.o();
            wj5Var.onChangeSkinType();
        }
    }
}
