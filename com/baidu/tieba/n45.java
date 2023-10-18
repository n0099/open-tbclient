package com.baidu.tieba;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class n45 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ImageView imageView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65536, null, imageView, i) == null) && imageView != null) {
            WebPManager.setPureDrawable(imageView, i, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds52);
                layoutParams.height = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds52);
                imageView.setLayoutParams(layoutParams);
            }
        }
    }

    public static void b(ViewGroup viewGroup) {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, viewGroup) == null) && viewGroup != null && (layoutParams = viewGroup.getLayoutParams()) != null) {
            layoutParams.height = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds120);
            viewGroup.setLayoutParams(layoutParams);
        }
    }

    public static void c(TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, textView) == null) && textView != null) {
            EMManager.from(textView).setTextColor(R.color.CAM_X0107);
        }
    }

    public static void d(TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, textView) == null) && textView != null) {
            EMManager.from(textView).setTextSize(R.dimen.tbds36);
        }
    }

    public static void e(TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, textView) == null) && textView != null) {
            EMManager.from(textView).setTextSize(R.dimen.tbds36).setTextColor(R.color.CAM_X0107);
        }
    }

    public static void f(TBLottieAnimationView tBLottieAnimationView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65541, null, tBLottieAnimationView, i) == null) && tBLottieAnimationView != null) {
            if (i == 4) {
                SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.lottie_agree_night);
            } else {
                SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.lottie_agree_day);
            }
            tBLottieAnimationView.setColorFilter(SkinManager.getColor(R.color.CAM_X0107));
        }
    }

    public static void h(TextView textView, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65543, null, textView, z) != null) || textView == null) {
            return;
        }
        if (z) {
            i = R.color.CAM_X0110;
        } else {
            i = R.color.CAM_X0107;
        }
        textView.setTextColor(vca.a(SkinManager.getColor(i), SkinManager.RESOURCE_ALPHA_NORMAL));
    }

    public static void g(ImageView imageView, int i, boolean z) {
        float f;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65542, null, new Object[]{imageView, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || imageView == null) {
            return;
        }
        int color = SkinManager.getColor(R.color.CAM_X0107);
        if (z) {
            f = SkinManager.RESOURCE_ALPHA_DISABLE;
        } else {
            f = SkinManager.RESOURCE_ALPHA_NORMAL;
        }
        imageView.setImageDrawable(WebPManager.getPureDrawable(i, vca.a(color, f), WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE));
    }
}
