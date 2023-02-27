package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class tt8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(yg5 yg5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, yg5Var)) == null) {
            if (yg5Var != null) {
                return yg5Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(yg5 yg5Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{yg5Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) && !a(yg5Var) && context != null && view2 != null) {
            if (yg5Var == null) {
                yg5Var = new yg5(context, onClickListener);
            }
            yg5Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            yg5Var.attachView(view2, z);
            yg5Var.p();
            yg5Var.onChangeSkinType();
        }
    }
}
