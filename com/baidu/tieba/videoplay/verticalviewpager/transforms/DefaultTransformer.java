package com.baidu.tieba.videoplay.verticalviewpager.transforms;

import android.support.v4.view.ViewPager;
import android.view.View;
/* loaded from: classes2.dex */
public class DefaultTransformer implements ViewPager.PageTransformer {
    @Override // android.support.v4.view.ViewPager.PageTransformer
    public void transformPage(View view2, float f) {
        float f2 = 0.0f;
        if (0.0f <= f && f <= 1.0f) {
            f2 = 1.0f - f;
        } else if (-1.0f < f && f < 0.0f) {
            f2 = f + 1.0f;
        }
        view2.setAlpha(f2);
        view2.setTranslationX(view2.getWidth() * (-f));
        view2.setTranslationY(view2.getHeight() * f);
    }
}
