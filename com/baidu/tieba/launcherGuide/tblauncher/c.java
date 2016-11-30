package com.baidu.tieba.launcherGuide.tblauncher;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ GuideActivity dFA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GuideActivity guideActivity) {
        this.dFA = guideActivity;
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
        i2 = this.dFA.dFv;
        if (i != i2 - 1) {
            view = this.dFA.dFp;
            view.setVisibility(8);
            this.dFA.mL(r.e.ds120);
            i3 = this.dFA.dFu;
            switch (i3) {
                case 1:
                    indicatorView2 = this.dFA.dFo;
                    indicatorView2.setVisibility(0);
                    break;
                case 3:
                    indicatorView = this.dFA.dFo;
                    indicatorView.setVisibility(0);
                    break;
            }
        } else {
            i4 = this.dFA.dFu;
            switch (i4) {
                case 1:
                    this.dFA.mL(r.e.ds90);
                    view5 = this.dFA.dFp;
                    view5.setVisibility(0);
                    break;
                case 2:
                default:
                    view6 = this.dFA.dFp;
                    view6.setVisibility(8);
                    break;
                case 3:
                    view4 = this.dFA.dFp;
                    view4.setVisibility(8);
                    break;
            }
        }
        view2 = this.dFA.dFp;
        if (view2.getVisibility() == 0) {
            view3 = this.dFA.dFp;
            view3.requestFocus();
        }
        indicatorView3 = this.dFA.dFo;
        indicatorView3.setPosition(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }
}
