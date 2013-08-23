package com.baidu.tieba.recommend;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.view.ChildViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends ViewPager.SimpleOnPageChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f1685a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.f1685a = hVar;
    }

    @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.bq
    public void b(int i) {
        ChildViewPager childViewPager;
        ChildViewPager childViewPager2;
        DailyRecommendBannerPagerAdapter dailyRecommendBannerPagerAdapter;
        ChildViewPager childViewPager3;
        ChildViewPager childViewPager4;
        ChildViewPager childViewPager5;
        ChildViewPager childViewPager6;
        DailyRecommendBannerPagerAdapter dailyRecommendBannerPagerAdapter2;
        ChildViewPager childViewPager7;
        if (i == 0) {
            childViewPager2 = this.f1685a.f;
            int currentItem = childViewPager2.getCurrentItem();
            if (currentItem < 1) {
                childViewPager6 = this.f1685a.f;
                dailyRecommendBannerPagerAdapter2 = this.f1685a.g;
                childViewPager6.a(dailyRecommendBannerPagerAdapter2.getCount() - 2, false);
                childViewPager7 = this.f1685a.f;
                childViewPager7.invalidate();
            } else {
                dailyRecommendBannerPagerAdapter = this.f1685a.g;
                if (currentItem > dailyRecommendBannerPagerAdapter.getCount() - 2) {
                    childViewPager3 = this.f1685a.f;
                    childViewPager3.a(1, false);
                    childViewPager4 = this.f1685a.f;
                    childViewPager4.invalidate();
                }
            }
            childViewPager5 = this.f1685a.f;
            childViewPager5.requestDisallowInterceptTouchEvent(false);
        } else if (i == 1) {
            childViewPager = this.f1685a.f;
            childViewPager.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.bq
    public void a_(int i) {
        DailyRecommendBannerPagerAdapter dailyRecommendBannerPagerAdapter;
        DailyRecommendBannerPagerAdapter dailyRecommendBannerPagerAdapter2;
        ChildViewPager childViewPager;
        DailyRecommendBannerPagerAdapter dailyRecommendBannerPagerAdapter3;
        dailyRecommendBannerPagerAdapter = this.f1685a.g;
        if (dailyRecommendBannerPagerAdapter != null) {
            dailyRecommendBannerPagerAdapter2 = this.f1685a.g;
            int size = dailyRecommendBannerPagerAdapter2.f1670a.size();
            childViewPager = this.f1685a.f;
            if (size > childViewPager.getCurrentItem()) {
                dailyRecommendBannerPagerAdapter3 = this.f1685a.g;
                ((View) dailyRecommendBannerPagerAdapter3.f1670a.get(i)).invalidate();
            }
        }
    }
}
