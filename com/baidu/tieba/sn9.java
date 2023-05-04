package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.animation.Animation;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class sn9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final TbPageContext a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context != null && (context instanceof TbPageContextSupport)) {
                return ((TbPageContextSupport) context).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    public static final void b(TbPageContextSupport tbPageContextSupport, Animatable animatable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, tbPageContextSupport, animatable) == null) && tbPageContextSupport != null) {
            tbPageContextSupport.getPageContext().startAnimatable(animatable);
        }
    }

    public static final void c(TbPageContextSupport tbPageContextSupport, View view2, Animation animation, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65538, null, tbPageContextSupport, view2, animation, animationListener) == null) && tbPageContextSupport != null) {
            tbPageContextSupport.getPageContext().startAnimation(view2, animation, animationListener);
        }
    }
}
