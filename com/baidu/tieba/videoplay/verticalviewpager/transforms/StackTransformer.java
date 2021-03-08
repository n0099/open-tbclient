package com.baidu.tieba.videoplay.verticalviewpager.transforms;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes7.dex */
public class StackTransformer implements ViewPager.PageTransformer {
    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f) {
        view.setTranslationX(view.getWidth() * (-f));
        view.setTranslationY(f < 0.0f ? view.getHeight() * f : 0.0f);
    }
}
