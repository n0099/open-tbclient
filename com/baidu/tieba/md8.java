package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class md8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(da5 da5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, da5Var)) == null) {
            if (da5Var != null) {
                return da5Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(da5 da5Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{da5Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) && !a(da5Var) && context != null && view2 != null) {
            if (da5Var == null) {
                da5Var = new da5(context, onClickListener);
            }
            da5Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            da5Var.attachView(view2, z);
            da5Var.p();
            da5Var.onChangeSkinType();
        }
    }
}
