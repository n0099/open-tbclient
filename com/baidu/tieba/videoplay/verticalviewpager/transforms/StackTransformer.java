package com.baidu.tieba.videoplay.verticalviewpager.transforms;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes5.dex */
public class StackTransformer implements ViewPager.PageTransformer {
    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f2) {
        view.setTranslationX(view.getWidth() * (-f2));
        view.setTranslationY(f2 < 0.0f ? view.getHeight() * f2 : 0.0f);
    }
}
