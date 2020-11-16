package com.baidu.tieba.videoplay.verticalviewpager.transforms;

import android.support.v4.view.ViewPager;
import android.view.View;
/* loaded from: classes23.dex */
public class StackTransformer implements ViewPager.PageTransformer {
    @Override // android.support.v4.view.ViewPager.PageTransformer
    public void transformPage(View view, float f) {
        view.setTranslationX(view.getWidth() * (-f));
        view.setTranslationY(f < 0.0f ? view.getHeight() * f : 0.0f);
    }
}
