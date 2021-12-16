package com.baidu.tieba.videoplay.verticalviewpager.transforms;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class ZoomOutTransformer implements ViewPager.PageTransformer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ZoomOutTransformer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048576, this, view, f2) == null) {
            int width = view.getWidth();
            int height = view.getHeight();
            float f3 = 0.0f;
            if (0.0f <= f2 && f2 <= 1.0f) {
                f3 = 1.0f - f2;
            } else if (-1.0f < f2 && f2 < 0.0f) {
                float max = Math.max(0.9f, 1.0f - Math.abs(f2));
                float f4 = 1.0f - max;
                float f5 = (height * f4) / 2.0f;
                float f6 = (width * f4) / 2.0f;
                if (i2 < 0) {
                    view.setTranslationX(f6 - (f5 / 2.0f));
                } else {
                    view.setTranslationX((-f6) + (f5 / 2.0f));
                }
                view.setScaleX(max);
                view.setScaleY(max);
                f3 = f2 + 1.0f;
            }
            view.setAlpha(f3);
            view.setTranslationX(view.getWidth() * (-f2));
            view.setTranslationY(f2 * view.getHeight());
        }
    }
}
