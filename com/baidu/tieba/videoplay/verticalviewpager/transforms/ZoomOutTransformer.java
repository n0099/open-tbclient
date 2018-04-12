package com.baidu.tieba.videoplay.verticalviewpager.transforms;

import android.support.v4.view.ViewPager;
import android.view.View;
/* loaded from: classes2.dex */
public class ZoomOutTransformer implements ViewPager.PageTransformer {
    @Override // android.support.v4.view.ViewPager.PageTransformer
    public void transformPage(View view2, float f) {
        float f2 = 0.0f;
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (0.0f <= f && f <= 1.0f) {
            f2 = 1.0f - f;
        } else if (-1.0f < f && f < 0.0f) {
            float max = Math.max(0.9f, 1.0f - Math.abs(f));
            float f3 = (height * (1.0f - max)) / 2.0f;
            float f4 = (width * (1.0f - max)) / 2.0f;
            if (f < 0.0f) {
                view2.setTranslationX(f4 - (f3 / 2.0f));
            } else {
                view2.setTranslationX((-f4) + (f3 / 2.0f));
            }
            view2.setScaleX(max);
            view2.setScaleY(max);
            f2 = f + 1.0f;
        }
        view2.setAlpha(f2);
        view2.setTranslationX(view2.getWidth() * (-f));
        view2.setTranslationY(view2.getHeight() * f);
    }
}
