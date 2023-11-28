package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vea {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(ck5 ck5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ck5Var)) == null) {
            if (ck5Var != null) {
                return ck5Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(ck5 ck5Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{ck5Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) && !a(ck5Var) && context != null && view2 != null) {
            if (ck5Var == null) {
                ck5Var = new ck5(context, onClickListener);
            }
            ck5Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            ck5Var.attachView(view2, z);
            ck5Var.q();
            ck5Var.onChangeSkinType();
        }
    }
}
