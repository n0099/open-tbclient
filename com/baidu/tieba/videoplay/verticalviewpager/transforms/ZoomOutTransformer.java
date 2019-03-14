package com.baidu.tieba.videoplay.verticalviewpager.transforms;

import android.support.v4.view.ViewPager;
import android.view.View;
/* loaded from: classes6.dex */
public class ZoomOutTransformer implements ViewPager.PageTransformer {
    @Override // android.support.v4.view.ViewPager.PageTransformer
    public void transformPage(View view, float f) {
        float f2 = 0.0f;
        int width = view.getWidth();
        int height = view.getHeight();
        if (0.0f <= f && f <= 1.0f) {
            f2 = 1.0f - f;
        } else if (-1.0f < f && f < 0.0f) {
            float max = Math.max(0.9f, 1.0f - Math.abs(f));
            float f3 = (height * (1.0f - max)) / 2.0f;
            float f4 = (width * (1.0f - max)) / 2.0f;
            if (f < 0.0f) {
                view.setTranslationX(f4 - (f3 / 2.0f));
            } else {
                view.setTranslationX((-f4) + (f3 / 2.0f));
            }
            view.setScaleX(max);
            view.setScaleY(max);
            f2 = f + 1.0f;
        }
        view.setAlpha(f2);
        view.setTranslationX(view.getWidth() * (-f));
        view.setTranslationY(view.getHeight() * f);
    }
}
