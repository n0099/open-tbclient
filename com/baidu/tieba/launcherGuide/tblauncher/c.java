package com.baidu.tieba.launcherGuide.tblauncher;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ GuideActivity cEy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GuideActivity guideActivity) {
        this.cEy = guideActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        View view;
        IndicatorView indicatorView;
        View view2;
        IndicatorView indicatorView2;
        View view3;
        int i3;
        View view4;
        View view5;
        View view6;
        IndicatorView indicatorView3;
        View view7;
        i2 = this.cEy.cEt;
        if (i != i2 - 1) {
            view = this.cEy.cEm;
            view.setVisibility(8);
            this.cEy.kl(t.e.ds120);
            indicatorView = this.cEy.cEl;
            indicatorView.setVisibility(0);
        } else {
            i3 = this.cEy.cEs;
            switch (i3) {
                case 1:
                    this.cEy.kl(t.e.ds60);
                    view6 = this.cEy.cEm;
                    view6.setVisibility(0);
                    indicatorView3 = this.cEy.cEl;
                    indicatorView3.setVisibility(8);
                    break;
                case 2:
                    view5 = this.cEy.cEm;
                    view5.setVisibility(0);
                    break;
                case 3:
                    view4 = this.cEy.cEm;
                    view4.setVisibility(8);
                    break;
                default:
                    view7 = this.cEy.cEm;
                    view7.setVisibility(8);
                    break;
            }
        }
        view2 = this.cEy.cEm;
        if (view2.getVisibility() == 0) {
            view3 = this.cEy.cEm;
            view3.requestFocus();
        }
        indicatorView2 = this.cEy.cEl;
        indicatorView2.setPosition(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }
}
