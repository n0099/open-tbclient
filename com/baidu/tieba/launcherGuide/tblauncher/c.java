package com.baidu.tieba.launcherGuide.tblauncher;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ GuideActivity dpI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GuideActivity guideActivity) {
        this.dpI = guideActivity;
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
        i2 = this.dpI.dpD;
        if (i != i2 - 1) {
            view = this.dpI.dpw;
            view.setVisibility(8);
            this.dpI.mv(r.f.ds120);
            i3 = this.dpI.dpC;
            switch (i3) {
                case 1:
                    indicatorView3 = this.dpI.dpv;
                    indicatorView3.setVisibility(0);
                    break;
                case 2:
                    indicatorView2 = this.dpI.dpv;
                    indicatorView2.setVisibility(0);
                    break;
                case 3:
                    indicatorView = this.dpI.dpv;
                    indicatorView.setVisibility(0);
                    break;
            }
        } else {
            i4 = this.dpI.dpC;
            switch (i4) {
                case 1:
                    view5 = this.dpI.dpw;
                    view5.setVisibility(8);
                    break;
                case 2:
                default:
                    view6 = this.dpI.dpw;
                    view6.setVisibility(8);
                    break;
                case 3:
                    view4 = this.dpI.dpw;
                    view4.setVisibility(8);
                    break;
            }
        }
        view2 = this.dpI.dpw;
        if (view2.getVisibility() == 0) {
            view3 = this.dpI.dpw;
            view3.requestFocus();
        }
        indicatorView4 = this.dpI.dpv;
        indicatorView4.setPosition(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }
}
