package com.baidu.tieba.launcherGuide.tblauncher;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ GuideActivity bSz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GuideActivity guideActivity) {
        this.bSz = guideActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int[] iArr;
        View view;
        IndicatorView indicatorView;
        View view2;
        iArr = this.bSz.bSu;
        if (i == iArr.length - 1) {
            view2 = this.bSz.bSr;
            view2.setVisibility(0);
        } else {
            view = this.bSz.bSr;
            view.setVisibility(8);
        }
        indicatorView = this.bSz.bSq;
        indicatorView.setPosition(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }
}
