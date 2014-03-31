package com.baidu.tieba.recommend;

import android.support.v4.view.ViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l extends ViewPager.SimpleOnPageChangeListener {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.a = jVar;
    }

    @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int i) {
        com.baidu.tieba.view.e eVar;
        com.baidu.tieba.view.e eVar2;
        v vVar;
        com.baidu.tieba.view.e eVar3;
        com.baidu.tieba.view.e eVar4;
        com.baidu.tieba.view.e eVar5;
        com.baidu.tieba.view.e eVar6;
        v vVar2;
        com.baidu.tieba.view.e eVar7;
        if (i == 0) {
            eVar2 = this.a.f;
            int currentItem = eVar2.getCurrentItem();
            if (currentItem <= 0) {
                eVar6 = this.a.f;
                vVar2 = this.a.g;
                eVar6.setCurrentItem(vVar2.getCount() - 2, false);
                eVar7 = this.a.f;
                eVar7.invalidate();
            } else {
                vVar = this.a.g;
                if (currentItem > vVar.getCount() - 2) {
                    eVar3 = this.a.f;
                    eVar3.setCurrentItem(1, false);
                    eVar4 = this.a.f;
                    eVar4.invalidate();
                }
            }
            eVar5 = this.a.f;
            eVar5.requestDisallowInterceptTouchEvent(false);
        } else if (i == 1) {
            eVar = this.a.f;
            eVar.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageSelected(int i) {
        v vVar;
        v vVar2;
        com.baidu.tieba.view.e eVar;
        v vVar3;
        vVar = this.a.g;
        if (vVar != null) {
            vVar2 = this.a.g;
            int size = vVar2.a.size();
            eVar = this.a.f;
            if (size > eVar.getCurrentItem()) {
                vVar3 = this.a.g;
                vVar3.a.get(i).invalidate();
            }
        }
    }
}
