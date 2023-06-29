package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class tr7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static TBAlertBuilder a(TBAlertBuilder tBAlertBuilder, @StringRes int i, @StringRes int i2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{tBAlertBuilder, Integer.valueOf(i), Integer.valueOf(i2), onClickListener, onClickListener2})) == null) {
            if (tBAlertBuilder == null) {
                return null;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a(i, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a(i2, TBAlertConfig.OperateBtnStyle.SECONDARY);
            tBAlertBuilder.u(aVar2, aVar);
            tBAlertBuilder.i();
            aVar.a(onClickListener);
            aVar2.a(onClickListener2);
            return tBAlertBuilder;
        }
        return (TBAlertBuilder) invokeCommon.objValue;
    }

    public static TBAlertBuilder b(Activity activity, @StringRes int i, @StringRes int i2, View view2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{activity, Integer.valueOf(i), Integer.valueOf(i2), view2})) == null) {
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(activity);
            tBAlertBuilder.w(i);
            tBAlertBuilder.m(i2);
            tBAlertBuilder.o(true);
            tBAlertBuilder.j(false);
            if (view2 != null) {
                tBAlertBuilder.k(view2);
            }
            return tBAlertBuilder;
        }
        return (TBAlertBuilder) invokeCommon.objValue;
    }

    public static View c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            final LinearLayout linearLayout = new LinearLayout(activity);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X013);
            linearLayout.setPadding(dimenPixelSize, UtilHelper.getDimenPixelSize(R.dimen.tbds53), dimenPixelSize, 0);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            final ImageView imageView = new ImageView(activity);
            WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_check_normal24, R.color.CAM_X0108, null);
            int g = xi.g(activity, R.dimen.tbds53);
            linearLayout.addView(imageView, new LinearLayout.LayoutParams(g, g));
            TextView textView = new TextView(activity);
            textView.setText(R.string.obfuscated_res_0x7f0f0377);
            textView.setTextSize(0, UtilHelper.getDimenPixelSize(R.dimen.T_X07));
            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.vq7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        tr7.d(linearLayout, imageView, view2);
                    }
                }
            });
            return linearLayout;
        }
        return (View) invokeL.objValue;
    }

    public static /* synthetic */ void d(LinearLayout linearLayout, ImageView imageView, View view2) {
        if (vg.a(linearLayout.getTag(), false)) {
            r95.p().A("key_vpb_booster_disconnect_alert", true);
            WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_check_normal24, R.color.CAM_X0108, null);
            linearLayout.setTag(Boolean.FALSE);
            return;
        }
        r95.p().A("key_vpb_booster_disconnect_alert", false);
        WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_check_select24, R.color.CAM_X0304, null);
        linearLayout.setTag(Boolean.TRUE);
    }

    public static void e(Activity activity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, onClickListener) == null) {
            a(b(activity, R.string.obfuscated_res_0x7f0f0373, R.string.obfuscated_res_0x7f0f0371, null), R.string.obfuscated_res_0x7f0f04be, R.string.obfuscated_res_0x7f0f03cc, onClickListener, null).z();
        }
    }

    public static void f(Activity activity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, activity, onClickListener) == null) {
            a(b(activity, R.string.obfuscated_res_0x7f0f0373, R.string.obfuscated_res_0x7f0f0372, null), R.string.obfuscated_res_0x7f0f04be, R.string.obfuscated_res_0x7f0f03cc, onClickListener, null).z();
        }
    }

    public static void i(Activity activity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, activity, onClickListener) == null) {
            a(b(activity, R.string.obfuscated_res_0x7f0f0381, R.string.obfuscated_res_0x7f0f0380, null), R.string.obfuscated_res_0x7f0f037f, R.string.obfuscated_res_0x7f0f03cc, onClickListener, null).z();
        }
    }

    public static void g(Activity activity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, activity, onClickListener) != null) || !r95.p().l("key_vpb_booster_disconnect_alert", true)) {
            return;
        }
        a(b(activity, R.string.obfuscated_res_0x7f0f0378, R.string.obfuscated_res_0x7f0f0376, c(activity)), R.string.obfuscated_res_0x7f0f0375, R.string.obfuscated_res_0x7f0f0374, onClickListener, null).z();
    }

    public static void h(Activity activity, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, activity, onClickListener, onClickListener2) == null) {
            a(b(activity, R.string.obfuscated_res_0x7f0f037c, R.string.obfuscated_res_0x7f0f0379, null), R.string.obfuscated_res_0x7f0f037b, R.string.obfuscated_res_0x7f0f037a, onClickListener, onClickListener2).z();
        }
    }
}
