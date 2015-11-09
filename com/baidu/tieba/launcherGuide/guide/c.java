package com.baidu.tieba.launcherGuide.guide;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import com.baidu.tieba.launcherGuide.view.RightSlideViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ NewUserGuideActivity bRP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewUserGuideActivity newUserGuideActivity) {
        this.bRP = newUserGuideActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        RightSlideViewPager rightSlideViewPager;
        if (i == 1) {
            rightSlideViewPager = this.bRP.bRN;
            rightSlideViewPager.setTag(null);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        com.baidu.tieba.launcherGuide.a.a aVar;
        aVar = this.bRP.bRJ;
        if (aVar.aaW() && i == 0 && f > 0.0f) {
            this.bRP.aaR();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        RightSlideViewPager rightSlideViewPager;
        rightSlideViewPager = this.bRP.bRN;
        h hVar = (h) ((FragmentPagerAdapter) rightSlideViewPager.getAdapter()).getItem(0);
        if (i == 0) {
            hVar.aaT();
        } else {
            hVar.aaU();
        }
    }
}
