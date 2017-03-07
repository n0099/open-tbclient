package com.baidu.tieba.launcherGuide.tblauncher;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ GuideActivity dsb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GuideActivity guideActivity) {
        this.dsb = guideActivity;
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
        i2 = this.dsb.drW;
        if (i != i2 - 1) {
            view = this.dsb.drQ;
            view.setVisibility(8);
            this.dsb.ml(w.f.ds120);
            i3 = this.dsb.drV;
            switch (i3) {
                case 1:
                    indicatorView2 = this.dsb.drP;
                    indicatorView2.setVisibility(0);
                    break;
                case 3:
                    indicatorView = this.dsb.drP;
                    indicatorView.setVisibility(0);
                    break;
            }
        } else {
            i4 = this.dsb.drV;
            switch (i4) {
                case 1:
                    this.dsb.ml(w.f.ds100);
                    view5 = this.dsb.drQ;
                    view5.setVisibility(0);
                    break;
                case 2:
                default:
                    view6 = this.dsb.drQ;
                    view6.setVisibility(8);
                    break;
                case 3:
                    view4 = this.dsb.drQ;
                    view4.setVisibility(8);
                    break;
            }
        }
        view2 = this.dsb.drQ;
        if (view2.getVisibility() == 0) {
            view3 = this.dsb.drQ;
            view3.requestFocus();
        }
        indicatorView3 = this.dsb.drP;
        indicatorView3.setPosition(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }
}
