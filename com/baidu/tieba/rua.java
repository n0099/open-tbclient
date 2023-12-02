package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class rua {
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

    public static boolean d(@Nullable Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, activity)) == null) {
            return h(activity, PbActivityConfig.VALUE_FROM_FRS_NEW);
        }
        return invokeL.booleanValue;
    }

    public static boolean e(@Nullable Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity)) == null) {
            return h(activity, PbActivityConfig.VALUE_FROM_FRS);
        }
        return invokeL.booleanValue;
    }

    public static boolean f(@Nullable Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, activity)) == null) {
            if (!e(activity) && !d(activity)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean g(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (!TextUtils.equals(PbActivityConfig.VALUE_FROM_FRS, str) && !TextUtils.equals(PbActivityConfig.VALUE_FROM_FRS_NEW, str)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean h(@Nullable Activity activity, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, activity, str)) == null) {
            if (activity != null && !TextUtils.isEmpty(str)) {
                return TextUtils.equals(activity.getClass().getSimpleName(), str);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static final void i(TbPageContextSupport tbPageContextSupport, Animatable animatable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, tbPageContextSupport, animatable) == null) && tbPageContextSupport != null) {
            tbPageContextSupport.getPageContext().startAnimatable(animatable);
        }
    }

    public static final void j(TbPageContextSupport tbPageContextSupport, View view2, Animation animation, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65545, null, tbPageContextSupport, view2, animation, animationListener) == null) && tbPageContextSupport != null) {
            tbPageContextSupport.getPageContext().startAnimation(view2, animation, animationListener);
        }
    }
}
