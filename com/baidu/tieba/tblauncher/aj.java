package com.baidu.tieba.tblauncher;

import android.support.v4.view.ViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ai cdv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar) {
        this.cdv = aiVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        com.baidu.adp.lib.g.i.ej().postDelayed(new ak(this), 200L);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
