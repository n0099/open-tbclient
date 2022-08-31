package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class w98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(l65 l65Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, l65Var)) == null) {
            if (l65Var != null) {
                return l65Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(l65 l65Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{l65Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) || a(l65Var) || context == null || view2 == null) {
            return;
        }
        if (l65Var == null) {
            l65Var = new l65(context, onClickListener);
        }
        l65Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
        l65Var.attachView(view2, z);
        l65Var.p();
        l65Var.onChangeSkinType();
    }
}
