package com.baidu.tieba.videoplay.verticalviewpager.transforms;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes5.dex */
public class ZoomOutTransformer implements ViewPager.PageTransformer {
    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f2) {
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
            if (f2 < 0.0f) {
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
