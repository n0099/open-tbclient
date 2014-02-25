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

    @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        com.baidu.tieba.view.q qVar;
        com.baidu.tieba.view.q qVar2;
        t tVar;
        com.baidu.tieba.view.q qVar3;
        com.baidu.tieba.view.q qVar4;
        com.baidu.tieba.view.q qVar5;
        com.baidu.tieba.view.q qVar6;
        t tVar2;
        com.baidu.tieba.view.q qVar7;
        if (i == 0) {
            qVar2 = this.a.f;
            int currentItem = qVar2.getCurrentItem();
            if (currentItem < 1) {
                qVar6 = this.a.f;
                tVar2 = this.a.g;
                qVar6.setCurrentItem(tVar2.getCount() - 2, false);
                qVar7 = this.a.f;
                qVar7.invalidate();
            } else {
                tVar = this.a.g;
                if (currentItem > tVar.getCount() - 2) {
                    qVar3 = this.a.f;
                    qVar3.setCurrentItem(1, false);
                    qVar4 = this.a.f;
                    qVar4.invalidate();
                }
            }
            qVar5 = this.a.f;
            qVar5.requestDisallowInterceptTouchEvent(false);
        } else if (i == 1) {
            qVar = this.a.f;
            qVar.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        t tVar;
        t tVar2;
        com.baidu.tieba.view.q qVar;
        t tVar3;
        tVar = this.a.g;
        if (tVar != null) {
            tVar2 = this.a.g;
            int size = tVar2.a.size();
            qVar = this.a.f;
            if (size > qVar.getCurrentItem()) {
                tVar3 = this.a.g;
                tVar3.a.get(i).invalidate();
            }
        }
    }
}
