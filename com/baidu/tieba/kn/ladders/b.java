package com.baidu.tieba.kn.ladders;

import android.support.v4.view.ViewPager;
import android.support.v4.view.bq;
import android.view.ViewParent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements bq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1742a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f1742a = aVar;
    }

    @Override // android.support.v4.view.bq
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.bq
    public void onPageSelected(int i) {
    }

    @Override // android.support.v4.view.bq
    public void onPageScrollStateChanged(int i) {
        l lVar;
        l lVar2;
        KnLaddersBannerAdapter knLaddersBannerAdapter;
        l lVar3;
        KnLaddersBannerAdapter knLaddersBannerAdapter2;
        l lVar4;
        l lVar5;
        KnLaddersBannerAdapter knLaddersBannerAdapter3;
        KnLaddersBannerAdapter knLaddersBannerAdapter4;
        if (i == 0) {
            lVar2 = this.f1742a.h;
            int currentItem = lVar2.f1751a.getCurrentItem();
            if (currentItem == 0) {
                lVar5 = this.f1742a.h;
                ViewPager viewPager = lVar5.f1751a;
                knLaddersBannerAdapter3 = this.f1742a.i;
                viewPager.a(knLaddersBannerAdapter3.getCount() - 2, false);
                knLaddersBannerAdapter4 = this.f1742a.i;
                knLaddersBannerAdapter4.notifyDataSetChanged();
            } else {
                knLaddersBannerAdapter = this.f1742a.i;
                if (currentItem == knLaddersBannerAdapter.getCount() - 1) {
                    lVar3 = this.f1742a.h;
                    lVar3.f1751a.a(1, false);
                    knLaddersBannerAdapter2 = this.f1742a.i;
                    knLaddersBannerAdapter2.notifyDataSetChanged();
                }
            }
            lVar4 = this.f1742a.h;
            ViewParent parent = lVar4.f1751a.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        } else if (i == 1) {
            lVar = this.f1742a.h;
            ViewParent parent2 = lVar.f1751a.getParent();
            if (parent2 != null) {
                parent2.requestDisallowInterceptTouchEvent(true);
            }
        }
    }
}
