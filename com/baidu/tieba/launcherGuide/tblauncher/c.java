package com.baidu.tieba.launcherGuide.tblauncher;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ GuideActivity dyF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GuideActivity guideActivity) {
        this.dyF = guideActivity;
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
        i2 = this.dyF.dyA;
        if (i != i2 - 1) {
            view = this.dyF.dyt;
            view.setVisibility(8);
            this.dyF.mv(t.e.ds120);
            i3 = this.dyF.dyz;
            switch (i3) {
                case 1:
                    indicatorView3 = this.dyF.dys;
                    indicatorView3.setVisibility(0);
                    break;
                case 2:
                    indicatorView2 = this.dyF.dys;
                    indicatorView2.setVisibility(0);
                    break;
                case 3:
                    indicatorView = this.dyF.dys;
                    indicatorView.setVisibility(0);
                    break;
            }
        } else {
            i4 = this.dyF.dyz;
            switch (i4) {
                case 1:
                    this.dyF.mv(t.e.ds60);
                    view6 = this.dyF.dyt;
                    view6.setVisibility(0);
                    indicatorView5 = this.dyF.dys;
                    indicatorView5.setVisibility(4);
                    break;
                case 2:
                    view5 = this.dyF.dyt;
                    view5.setVisibility(0);
                    break;
                case 3:
                    view4 = this.dyF.dyt;
                    view4.setVisibility(8);
                    break;
                default:
                    view7 = this.dyF.dyt;
                    view7.setVisibility(8);
                    break;
            }
        }
        view2 = this.dyF.dyt;
        if (view2.getVisibility() == 0) {
            view3 = this.dyF.dyt;
            view3.requestFocus();
        }
        indicatorView4 = this.dyF.dys;
        indicatorView4.setPosition(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }
}
