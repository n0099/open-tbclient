package com.baidu.tieba.recommend;

import android.support.v4.view.ViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends ViewPager.SimpleOnPageChangeListener {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.a = hVar;
    }

    @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.bq
    public void onPageScrollStateChanged(int i) {
        if (i == 0) {
            int currentItem = this.a.f.getCurrentItem();
            if (currentItem < 1) {
                this.a.f.a(this.a.g.getCount() - 2, false);
                this.a.f.invalidate();
            } else if (currentItem > this.a.g.getCount() - 2) {
                this.a.f.a(1, false);
                this.a.f.invalidate();
            }
            this.a.f.requestDisallowInterceptTouchEvent(false);
        } else if (i == 1) {
            this.a.f.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.bq
    public void onPageSelected(int i) {
        if (this.a.g != null && this.a.g.a.size() > this.a.f.getCurrentItem()) {
            this.a.g.a.get(i).invalidate();
        }
    }
}
