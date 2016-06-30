package com.baidu.tieba.launcherGuide.tblauncher;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ GuideActivity djY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GuideActivity guideActivity) {
        this.djY = guideActivity;
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
        i2 = this.djY.djT;
        if (i != i2 - 1) {
            view = this.djY.djM;
            view.setVisibility(8);
            this.djY.lM(u.e.ds120);
            i3 = this.djY.djS;
            switch (i3) {
                case 1:
                    indicatorView3 = this.djY.djL;
                    indicatorView3.setVisibility(8);
                    break;
                case 2:
                    indicatorView2 = this.djY.djL;
                    indicatorView2.setVisibility(0);
                    break;
                case 3:
                    indicatorView = this.djY.djL;
                    indicatorView.setVisibility(0);
                    break;
            }
        } else {
            i4 = this.djY.djS;
            switch (i4) {
                case 1:
                    this.djY.lM(u.e.ds60);
                    view6 = this.djY.djM;
                    view6.setVisibility(0);
                    indicatorView5 = this.djY.djL;
                    indicatorView5.setVisibility(8);
                    break;
                case 2:
                    view5 = this.djY.djM;
                    view5.setVisibility(0);
                    break;
                case 3:
                    view4 = this.djY.djM;
                    view4.setVisibility(8);
                    break;
                default:
                    view7 = this.djY.djM;
                    view7.setVisibility(8);
                    break;
            }
        }
        view2 = this.djY.djM;
        if (view2.getVisibility() == 0) {
            view3 = this.djY.djM;
            view3.requestFocus();
        }
        indicatorView4 = this.djY.djL;
        indicatorView4.setPosition(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }
}
