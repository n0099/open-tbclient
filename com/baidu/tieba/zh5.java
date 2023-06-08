package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
@ModifyClass
/* loaded from: classes8.dex */
public class zh5 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948359970, "Lcom/baidu/tieba/zh5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948359970, "Lcom/baidu/tieba/zh5;");
                return;
            }
        }
        a = TbConfig.TIEBA_ADDRESS + "mo/q/hybrid-main-service/creativeToolsList";
    }

    public static FrameLayout a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            FrameLayout frameLayout = new FrameLayout(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = vi.g(context, R.dimen.M_W_X006);
            frameLayout.setLayoutParams(layoutParams);
            o75 d = o75.d(frameLayout);
            d.m(R.dimen.L_X02);
            d.o(R.string.J_X06);
            d.f(R.color.CAM_X0209);
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(vi.g(context, R.dimen.tbds138), vi.g(context, R.dimen.tbds31));
            layoutParams2.setMargins(vi.g(context, R.dimen.M_W_X004), vi.g(context, R.dimen.M_H_X002), vi.g(context, R.dimen.M_W_X004), vi.g(context, R.dimen.M_H_X002));
            imageView.setLayoutParams(layoutParams2);
            SkinManager.setImageResource(imageView, R.drawable.icon_ai_write_rukou);
            frameLayout.addView(imageView);
            b(context, frameLayout);
            return frameLayout;
        }
        return (FrameLayout) invokeL.objValue;
    }

    public static void b(Context context, FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, context, frameLayout) == null) && hp5.a("key_ai_write_button_first_show_red_dot", true)) {
            if (hp5.e("key_ai_write_button_first_show_red_dot_time", 0L) == 0) {
                hp5.m("key_ai_write_button_first_show_red_dot_time", System.currentTimeMillis());
            }
            if (System.currentTimeMillis() - hp5.e("key_ai_write_button_first_show_red_dot_time", System.currentTimeMillis()) < 1209600000) {
                ImageView imageView = new ImageView(context);
                imageView.setId(R.id.ai_write_button_red_dot);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(vi.g(context, R.dimen.tbds18), vi.g(context, R.dimen.tbds18));
                layoutParams.setMargins((vi.g(context, R.dimen.tbds138) + (vi.g(context, R.dimen.M_W_X004) * 2)) - vi.g(context, R.dimen.tbds18), 0, 0, 0);
                SkinManager.setImageResource(imageView, R.drawable.icon_news_red_dot);
                frameLayout.addView(imageView, layoutParams);
            }
        }
    }

    @Modify(description = "设置AI发帖入口url")
    public static String c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            return a + "?customfullscreen=1&nonavigationbar=1&type=" + str + "&fid=" + str2;
        }
        return (String) invokeLL.objValue;
    }

    public static void d(@NonNull View view2) {
        View findViewById;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view2) == null) && (findViewById = view2.findViewById(R.id.ai_write_button_red_dot)) != null) {
            findViewById.setVisibility(8);
            hp5.k("key_ai_write_button_first_show_red_dot", false);
        }
    }
}
