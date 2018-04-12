package com.baidu.tieba.videoplay.verticalviewpager.transforms;

import android.support.v4.view.ViewPager;
import android.view.View;
/* loaded from: classes2.dex */
public class StackTransformer implements ViewPager.PageTransformer {
    @Override // android.support.v4.view.ViewPager.PageTransformer
    public void transformPage(View view2, float f) {
        view2.setTranslationX(view2.getWidth() * (-f));
        view2.setTranslationY(f < 0.0f ? view2.getHeight() * f : 0.0f);
    }
}
