package com.baidu.tieba.tblauncher;

import android.support.v4.view.ViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ao ddy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ao aoVar) {
        this.ddy = aoVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        com.baidu.adp.lib.g.h.hg().postDelayed(new ba(this), 200L);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
