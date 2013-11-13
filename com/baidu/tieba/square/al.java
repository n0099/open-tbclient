package com.baidu.tieba.square;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.forumdetail.ForumDetailData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements android.support.v4.view.bq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aj f2381a;

    private al(aj ajVar) {
        this.f2381a = ajVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ al(aj ajVar, ak akVar) {
        this(ajVar);
    }

    @Override // android.support.v4.view.bq
    public void onPageScrolled(int i, float f, int i2) {
        IndicatorView indicatorView;
        HotThreadPagerAdapter hotThreadPagerAdapter;
        ForumDetailData.ThreadInfo[] threadInfoArr;
        HotThreadPagerAdapter hotThreadPagerAdapter2;
        IndicatorView indicatorView2;
        IndicatorView indicatorView3;
        IndicatorView indicatorView4;
        indicatorView = this.f2381a.f;
        if (indicatorView != null) {
            hotThreadPagerAdapter = this.f2381a.g;
            if (hotThreadPagerAdapter != null) {
                threadInfoArr = this.f2381a.j;
                if (threadInfoArr.length > 1) {
                    hotThreadPagerAdapter2 = this.f2381a.g;
                    int count = hotThreadPagerAdapter2.getCount();
                    if (i == 0) {
                        indicatorView4 = this.f2381a.f;
                        indicatorView4.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        indicatorView3 = this.f2381a.f;
                        indicatorView3.setPosition(f);
                    } else {
                        indicatorView2 = this.f2381a.f;
                        indicatorView2.setPosition((i - 1) + f);
                    }
                }
            }
        }
    }

    @Override // android.support.v4.view.bq
    public void onPageSelected(int i) {
    }

    @Override // android.support.v4.view.bq
    public void onPageScrollStateChanged(int i) {
        ViewPager viewPager;
        HotThreadPagerAdapter hotThreadPagerAdapter;
        ForumDetailData.ThreadInfo[] threadInfoArr;
        ViewPager viewPager2;
        ViewPager viewPager3;
        HotThreadPagerAdapter hotThreadPagerAdapter2;
        ViewPager viewPager4;
        ViewPager viewPager5;
        ViewPager viewPager6;
        ViewPager viewPager7;
        HotThreadPagerAdapter hotThreadPagerAdapter3;
        ViewPager viewPager8;
        viewPager = this.f2381a.e;
        if (viewPager != null) {
            hotThreadPagerAdapter = this.f2381a.g;
            if (hotThreadPagerAdapter != null && i == 0) {
                threadInfoArr = this.f2381a.j;
                if (threadInfoArr.length > 1) {
                    viewPager3 = this.f2381a.e;
                    int currentItem = viewPager3.getCurrentItem();
                    if (currentItem < 1) {
                        viewPager7 = this.f2381a.e;
                        hotThreadPagerAdapter3 = this.f2381a.g;
                        viewPager7.a(hotThreadPagerAdapter3.getCount() - 2, false);
                        viewPager8 = this.f2381a.e;
                        viewPager8.invalidate();
                    } else {
                        hotThreadPagerAdapter2 = this.f2381a.g;
                        if (currentItem > hotThreadPagerAdapter2.getCount() - 2) {
                            viewPager4 = this.f2381a.e;
                            viewPager4.a(1, false);
                            viewPager5 = this.f2381a.e;
                            viewPager5.invalidate();
                        }
                    }
                    viewPager6 = this.f2381a.e;
                    viewPager6.requestDisallowInterceptTouchEvent(false);
                } else if (i == 1) {
                    viewPager2 = this.f2381a.e;
                    viewPager2.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
    }
}
