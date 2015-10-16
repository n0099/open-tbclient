package com.baidu.tieba.myCollection;

import android.support.v4.view.ViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements ViewPager.OnPageChangeListener {
    final /* synthetic */ c cbx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cbx = cVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.cbx.iw(i);
        this.cbx.dW(false);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
