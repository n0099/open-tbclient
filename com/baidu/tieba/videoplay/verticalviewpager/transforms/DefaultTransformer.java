package com.baidu.tieba.videoplay.verticalviewpager.transforms;

import android.support.v4.view.ViewPager;
import android.view.View;
/* loaded from: classes9.dex */
public class DefaultTransformer implements ViewPager.PageTransformer {
    @Override // android.support.v4.view.ViewPager.PageTransformer
    public void transformPage(View view, float f) {
        float f2 = 0.0f;
        if (0.0f <= f && f <= 1.0f) {
            f2 = 1.0f - f;
        } else if (-1.0f < f && f < 0.0f) {
            f2 = f + 1.0f;
        }
        view.setAlpha(f2);
        view.setTranslationX(view.getWidth() * (-f));
        view.setTranslationY(view.getHeight() * f);
    }
}
