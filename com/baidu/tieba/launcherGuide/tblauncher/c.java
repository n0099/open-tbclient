package com.baidu.tieba.launcherGuide.tblauncher;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ GuideActivity dmX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GuideActivity guideActivity) {
        this.dmX = guideActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        View view;
        int i3;
        IndicatorView indicatorView;
        IndicatorView indicatorView2;
        IndicatorView indicatorView3;
        View view2;
        IndicatorView indicatorView4;
        View view3;
        int i4;
        View view4;
        View view5;
        View view6;
        IndicatorView indicatorView5;
        View view7;
        i2 = this.dmX.dmS;
        if (i != i2 - 1) {
            view = this.dmX.dmL;
            view.setVisibility(8);
            this.dmX.lS(u.e.ds120);
            i3 = this.dmX.dmR;
            switch (i3) {
                case 1:
                    indicatorView3 = this.dmX.dmK;
                    indicatorView3.setVisibility(8);
                    break;
                case 2:
                    indicatorView2 = this.dmX.dmK;
                    indicatorView2.setVisibility(0);
                    break;
                case 3:
                    indicatorView = this.dmX.dmK;
                    indicatorView.setVisibility(0);
                    break;
            }
        } else {
            i4 = this.dmX.dmR;
            switch (i4) {
                case 1:
                    this.dmX.lS(u.e.ds60);
                    view6 = this.dmX.dmL;
                    view6.setVisibility(0);
                    indicatorView5 = this.dmX.dmK;
                    indicatorView5.setVisibility(8);
                    break;
                case 2:
                    view5 = this.dmX.dmL;
                    view5.setVisibility(0);
                    break;
                case 3:
                    view4 = this.dmX.dmL;
                    view4.setVisibility(8);
                    break;
                default:
                    view7 = this.dmX.dmL;
                    view7.setVisibility(8);
                    break;
            }
        }
        view2 = this.dmX.dmL;
        if (view2.getVisibility() == 0) {
            view3 = this.dmX.dmL;
            view3.requestFocus();
        }
        indicatorView4 = this.dmX.dmK;
        indicatorView4.setPosition(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }
}
