package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class u89 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(qg5 qg5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, qg5Var)) == null) {
            if (qg5Var != null) {
                return qg5Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(qg5 qg5Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{qg5Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) && !a(qg5Var) && context != null && view2 != null) {
            if (qg5Var == null) {
                qg5Var = new qg5(context, onClickListener);
            }
            qg5Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            qg5Var.attachView(view2, z);
            qg5Var.p();
            qg5Var.onChangeSkinType();
        }
    }
}
