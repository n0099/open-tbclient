package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class m89 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(pg5 pg5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pg5Var)) == null) {
            if (pg5Var != null) {
                return pg5Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(pg5 pg5Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{pg5Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) && !a(pg5Var) && context != null && view2 != null) {
            if (pg5Var == null) {
                pg5Var = new pg5(context, onClickListener);
            }
            pg5Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            pg5Var.attachView(view2, z);
            pg5Var.p();
            pg5Var.onChangeSkinType();
        }
    }
}
