package com.baidu.tieba.launcherGuide.tblauncher;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ GuideActivity dzW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GuideActivity guideActivity) {
        this.dzW = guideActivity;
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
        View view6;
        i2 = this.dzW.dzR;
        if (i != i2 - 1) {
            view = this.dzW.dzL;
            view.setVisibility(8);
            this.dzW.mD(r.e.ds120);
            i3 = this.dzW.dzQ;
            switch (i3) {
                case 1:
                    indicatorView2 = this.dzW.dzK;
                    indicatorView2.setVisibility(0);
                    break;
                case 3:
                    indicatorView = this.dzW.dzK;
                    indicatorView.setVisibility(0);
                    break;
            }
        } else {
            i4 = this.dzW.dzQ;
            switch (i4) {
                case 1:
                    this.dzW.mD(r.e.ds160);
                    view5 = this.dzW.dzL;
                    view5.setVisibility(0);
                    break;
                case 2:
                default:
                    view6 = this.dzW.dzL;
                    view6.setVisibility(8);
                    break;
                case 3:
                    view4 = this.dzW.dzL;
                    view4.setVisibility(8);
                    break;
            }
        }
        view2 = this.dzW.dzL;
        if (view2.getVisibility() == 0) {
            view3 = this.dzW.dzL;
            view3.requestFocus();
        }
        indicatorView3 = this.dzW.dzK;
        indicatorView3.setPosition(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }
}
