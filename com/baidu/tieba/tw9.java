package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class tw9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(gi5 gi5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gi5Var)) == null) {
            if (gi5Var != null) {
                return gi5Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(gi5 gi5Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{gi5Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) && !a(gi5Var) && context != null && view2 != null) {
            if (gi5Var == null) {
                gi5Var = new gi5(context, onClickListener);
            }
            gi5Var.j(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            gi5Var.attachView(view2, z);
            gi5Var.o();
            gi5Var.onChangeSkinType();
        }
    }
}
