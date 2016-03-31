package com.baidu.tieba.launcherGuide.tblauncher;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ GuideActivity cEG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GuideActivity guideActivity) {
        this.cEG = guideActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        View view;
        IndicatorView indicatorView;
        int i3;
        View view2;
        View view3;
        View view4;
        View view5;
        i2 = this.cEG.cEB;
        if (i != i2 - 1) {
            view = this.cEG.cEu;
            view.setVisibility(8);
        } else {
            i3 = this.cEG.cEA;
            switch (i3) {
                case 1:
                    view4 = this.cEG.cEu;
                    view4.setVisibility(8);
                    break;
                case 2:
                    view3 = this.cEG.cEu;
                    view3.setVisibility(0);
                    break;
                case 3:
                    view2 = this.cEG.cEu;
                    view2.setVisibility(8);
                    break;
                default:
                    view5 = this.cEG.cEu;
                    view5.setVisibility(8);
                    break;
            }
        }
        indicatorView = this.cEG.cEt;
        indicatorView.setPosition(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }
}
