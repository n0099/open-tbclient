package com.baidu.tieba.launcherGuide.guide;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import com.baidu.tieba.launcherGuide.view.RightSlideViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ NewUserGuideActivity cDm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewUserGuideActivity newUserGuideActivity) {
        this.cDm = newUserGuideActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        RightSlideViewPager rightSlideViewPager;
        if (i == 1) {
            rightSlideViewPager = this.cDm.cDk;
            rightSlideViewPager.setTag(null);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        com.baidu.tieba.launcherGuide.a.a aVar;
        aVar = this.cDm.cDg;
        if (aVar.ang() && i == 0 && f > 0.0f) {
            this.cDm.anb();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        RightSlideViewPager rightSlideViewPager;
        rightSlideViewPager = this.cDm.cDk;
        h hVar = (h) ((FragmentPagerAdapter) rightSlideViewPager.getAdapter()).getItem(0);
        if (i == 0) {
            hVar.and();
        } else {
            hVar.ane();
        }
    }
}
