package com.baidu.tieba.tblauncher;

import android.support.v4.view.ViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements ViewPager.OnPageChangeListener {
    final /* synthetic */ am cVq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(am amVar) {
        this.cVq = amVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        com.baidu.adp.lib.g.h.hf().postDelayed(new ay(this), 200L);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
