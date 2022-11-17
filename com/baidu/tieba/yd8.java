package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class yd8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(ka5 ka5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ka5Var)) == null) {
            if (ka5Var != null) {
                return ka5Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(ka5 ka5Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{ka5Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) && !a(ka5Var) && context != null && view2 != null) {
            if (ka5Var == null) {
                ka5Var = new ka5(context, onClickListener);
            }
            ka5Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            ka5Var.attachView(view2, z);
            ka5Var.p();
            ka5Var.onChangeSkinType();
        }
    }
}
