package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class tca {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (!(context instanceof Activity)) {
                return false;
            }
            Activity activity = (Activity) context;
            if ((Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) || activity.isFinishing()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(@Nullable View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            if (view2 != null && view2.getContext() != null) {
                if (view2.getContext() instanceof Activity) {
                    return a(view2.getContext());
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final TbPageContext c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context != null && (context instanceof TbPageContextSupport)) {
                return ((TbPageContextSupport) context).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    public static final void d(TbPageContextSupport tbPageContextSupport, Animatable animatable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, tbPageContextSupport, animatable) == null) && tbPageContextSupport != null) {
            tbPageContextSupport.getPageContext().startAnimatable(animatable);
        }
    }

    public static final void e(TbPageContextSupport tbPageContextSupport, View view2, Animation animation, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContextSupport, view2, animation, animationListener) == null) && tbPageContextSupport != null) {
            tbPageContextSupport.getPageContext().startAnimation(view2, animation, animationListener);
        }
    }
}
