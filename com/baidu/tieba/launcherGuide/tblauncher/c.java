package com.baidu.tieba.launcherGuide.tblauncher;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ GuideActivity dBc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GuideActivity guideActivity) {
        this.dBc = guideActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        View view;
        int i3;
        IndicatorView indicatorView;
        IndicatorView indicatorView2;
        View view2;
        IndicatorView indicatorView3;
        View view3;
        int i4;
        View view4;
        View view5;
        IndicatorView indicatorView4;
        View view6;
        i2 = this.dBc.dAX;
        if (i != i2 - 1) {
            view = this.dBc.dAR;
            view.setVisibility(8);
            this.dBc.mL(w.f.ds120);
            i3 = this.dBc.dAW;
            switch (i3) {
                case 1:
                    indicatorView2 = this.dBc.dAQ;
                    indicatorView2.setVisibility(0);
                    break;
                case 3:
                    indicatorView = this.dBc.dAQ;
                    indicatorView.setVisibility(0);
                    break;
            }
        } else {
            i4 = this.dBc.dAW;
            switch (i4) {
                case 1:
                    this.dBc.mL(w.f.ds110);
                    view5 = this.dBc.dAR;
                    view5.setVisibility(0);
                    indicatorView4 = this.dBc.dAQ;
                    indicatorView4.setVisibility(0);
                    break;
                case 2:
                default:
                    view6 = this.dBc.dAR;
                    view6.setVisibility(8);
                    break;
                case 3:
                    view4 = this.dBc.dAR;
                    view4.setVisibility(8);
                    break;
            }
        }
        view2 = this.dBc.dAR;
        if (view2.getVisibility() == 0) {
            view3 = this.dBc.dAR;
            view3.requestFocus();
        }
        indicatorView3 = this.dBc.dAQ;
        indicatorView3.setPosition(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }
}
