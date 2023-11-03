package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class y9a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(vj5 vj5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, vj5Var)) == null) {
            if (vj5Var != null) {
                return vj5Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(vj5 vj5Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{vj5Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) && !a(vj5Var) && context != null && view2 != null) {
            if (vj5Var == null) {
                vj5Var = new vj5(context, onClickListener);
            }
            vj5Var.j(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            vj5Var.attachView(view2, z);
            vj5Var.o();
            vj5Var.onChangeSkinType();
        }
    }
}
