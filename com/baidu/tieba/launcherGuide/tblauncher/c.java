package com.baidu.tieba.launcherGuide.tblauncher;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ GuideActivity dsR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GuideActivity guideActivity) {
        this.dsR = guideActivity;
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
        i2 = this.dsR.dsM;
        if (i != i2 - 1) {
            view = this.dsR.dsG;
            view.setVisibility(8);
            this.dsR.ms(w.f.ds120);
            i3 = this.dsR.dsL;
            switch (i3) {
                case 1:
                    indicatorView2 = this.dsR.dsF;
                    indicatorView2.setVisibility(0);
                    break;
                case 3:
                    indicatorView = this.dsR.dsF;
                    indicatorView.setVisibility(0);
                    break;
            }
        } else {
            i4 = this.dsR.dsL;
            switch (i4) {
                case 1:
                    this.dsR.ms(w.f.ds100);
                    view5 = this.dsR.dsG;
                    view5.setVisibility(0);
                    break;
                case 2:
                default:
                    view6 = this.dsR.dsG;
                    view6.setVisibility(8);
                    break;
                case 3:
                    view4 = this.dsR.dsG;
                    view4.setVisibility(8);
                    break;
            }
        }
        view2 = this.dsR.dsG;
        if (view2.getVisibility() == 0) {
            view3 = this.dsR.dsG;
            view3.requestFocus();
        }
        indicatorView3 = this.dsR.dsF;
        indicatorView3.setPosition(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }
}
