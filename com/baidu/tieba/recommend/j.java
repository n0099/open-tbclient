package com.baidu.tieba.recommend;

import android.support.v4.view.ViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends ViewPager.SimpleOnPageChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f2415a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.f2415a = hVar;
    }

    @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.bq
    public void onPageScrollStateChanged(int i) {
        if (i == 0) {
            int currentItem = this.f2415a.f.getCurrentItem();
            if (currentItem < 1) {
                this.f2415a.f.a(this.f2415a.g.getCount() - 2, false);
                this.f2415a.f.invalidate();
            } else if (currentItem > this.f2415a.g.getCount() - 2) {
                this.f2415a.f.a(1, false);
                this.f2415a.f.invalidate();
            }
            this.f2415a.f.requestDisallowInterceptTouchEvent(false);
        } else if (i == 1) {
            this.f2415a.f.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.bq
    public void onPageSelected(int i) {
        if (this.f2415a.g != null && this.f2415a.g.f2403a.size() > this.f2415a.f.getCurrentItem()) {
            this.f2415a.g.f2403a.get(i).invalidate();
        }
    }
}
