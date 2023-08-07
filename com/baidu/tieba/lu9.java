package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class lu9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(om5 om5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, om5Var)) == null) {
            if (om5Var != null) {
                return om5Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(om5 om5Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{om5Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) && !a(om5Var) && context != null && view2 != null) {
            if (om5Var == null) {
                om5Var = new om5(context, onClickListener);
            }
            om5Var.j(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            om5Var.attachView(view2, z);
            om5Var.o();
            om5Var.onChangeSkinType();
        }
    }
}
