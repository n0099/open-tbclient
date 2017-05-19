package com.baidu.tieba.launcherGuide.tblauncher;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ GuideActivity dmV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GuideActivity guideActivity) {
        this.dmV = guideActivity;
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
        i2 = this.dmV.dmQ;
        if (i != i2 - 1) {
            view = this.dmV.dmK;
            view.setVisibility(8);
            this.dmV.mf(w.f.ds120);
            i3 = this.dmV.dmP;
            switch (i3) {
                case 1:
                    indicatorView2 = this.dmV.dmJ;
                    indicatorView2.setVisibility(0);
                    break;
                case 3:
                    indicatorView = this.dmV.dmJ;
                    indicatorView.setVisibility(0);
                    break;
            }
        } else {
            i4 = this.dmV.dmP;
            switch (i4) {
                case 1:
                    this.dmV.mf(w.f.ds120);
                    view5 = this.dmV.dmK;
                    view5.setVisibility(0);
                    indicatorView4 = this.dmV.dmJ;
                    indicatorView4.setVisibility(8);
                    break;
                case 2:
                default:
                    view6 = this.dmV.dmK;
                    view6.setVisibility(8);
                    break;
                case 3:
                    view4 = this.dmV.dmK;
                    view4.setVisibility(8);
                    break;
            }
        }
        view2 = this.dmV.dmK;
        if (view2.getVisibility() == 0) {
            view3 = this.dmV.dmK;
            view3.requestFocus();
        }
        indicatorView3 = this.dmV.dmJ;
        indicatorView3.setPosition(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }
}
