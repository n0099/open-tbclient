package com.baidu.tieba.launcherGuide.guide;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import com.baidu.tieba.launcherGuide.view.RightSlideViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ NewUserGuideActivity bwm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewUserGuideActivity newUserGuideActivity) {
        this.bwm = newUserGuideActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        RightSlideViewPager rightSlideViewPager;
        if (i == 1) {
            rightSlideViewPager = this.bwm.bwk;
            rightSlideViewPager.setTag(null);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        com.baidu.tieba.launcherGuide.a.a aVar;
        aVar = this.bwm.bwg;
        if (aVar.Wg() && i == 0 && f > 0.0f) {
            this.bwm.Wb();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        RightSlideViewPager rightSlideViewPager;
        rightSlideViewPager = this.bwm.bwk;
        j jVar = (j) ((FragmentPagerAdapter) rightSlideViewPager.getAdapter()).getItem(0);
        if (i == 0) {
            jVar.Wd();
        } else {
            jVar.We();
        }
    }
}
