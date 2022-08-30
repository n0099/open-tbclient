package com.baidu.tieba.videoplay.verticalviewpager.transforms;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ZoomOutTransformer implements ViewPager.PageTransformer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ZoomOutTransformer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view2, float f) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048576, this, view2, f) == null) {
            int width = view2.getWidth();
            int height = view2.getHeight();
            float f2 = 0.0f;
            if (0.0f <= f && f <= 1.0f) {
                f2 = 1.0f - f;
            } else if (-1.0f < f && f < 0.0f) {
                float max = Math.max(0.9f, 1.0f - Math.abs(f));
                float f3 = 1.0f - max;
                float f4 = (height * f3) / 2.0f;
                float f5 = (width * f3) / 2.0f;
                if (i < 0) {
                    view2.setTranslationX(f5 - (f4 / 2.0f));
                } else {
                    view2.setTranslationX((-f5) + (f4 / 2.0f));
                }
                view2.setScaleX(max);
                view2.setScaleY(max);
                f2 = f + 1.0f;
            }
            view2.setAlpha(f2);
            view2.setTranslationX(view2.getWidth() * (-f));
            view2.setTranslationY(f * view2.getHeight());
        }
    }
}
