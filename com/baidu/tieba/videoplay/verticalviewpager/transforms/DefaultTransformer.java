package com.baidu.tieba.videoplay.verticalviewpager.transforms;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes5.dex */
public class DefaultTransformer implements ViewPager.PageTransformer {
    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f2) {
        float f3 = 0.0f;
        if (0.0f <= f2 && f2 <= 1.0f) {
            f3 = 1.0f - f2;
        } else if (-1.0f < f2 && f2 < 0.0f) {
            f3 = f2 + 1.0f;
        }
        view.setAlpha(f3);
        view.setTranslationX(view.getWidth() * (-f2));
        view.setTranslationY(f2 * view.getHeight());
    }
}
