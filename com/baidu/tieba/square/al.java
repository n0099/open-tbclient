package com.baidu.tieba.square;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.forumdetail.ForumDetailData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements android.support.v4.view.bq {
    final /* synthetic */ aj a;

    private al(aj ajVar) {
        this.a = ajVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ al(aj ajVar, ak akVar) {
        this(ajVar);
    }

    @Override // android.support.v4.view.bq
    public void a(int i, float f, int i2) {
        IndicatorView indicatorView;
        HotThreadPagerAdapter hotThreadPagerAdapter;
        ForumDetailData.ThreadInfo[] threadInfoArr;
        HotThreadPagerAdapter hotThreadPagerAdapter2;
        IndicatorView indicatorView2;
        IndicatorView indicatorView3;
        IndicatorView indicatorView4;
        indicatorView = this.a.f;
        if (indicatorView != null) {
            hotThreadPagerAdapter = this.a.g;
            if (hotThreadPagerAdapter != null) {
                threadInfoArr = this.a.j;
                if (threadInfoArr.length > 1) {
                    hotThreadPagerAdapter2 = this.a.g;
                    int count = hotThreadPagerAdapter2.getCount();
                    if (i == 0) {
                        indicatorView4 = this.a.f;
                        indicatorView4.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        indicatorView3 = this.a.f;
                        indicatorView3.setPosition(f);
                    } else {
                        indicatorView2 = this.a.f;
                        indicatorView2.setPosition((i - 1) + f);
                    }
                }
            }
        }
    }

    @Override // android.support.v4.view.bq
    public void a_(int i) {
    }

    @Override // android.support.v4.view.bq
    public void b(int i) {
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
        viewPager = this.a.e;
        if (viewPager != null) {
            hotThreadPagerAdapter = this.a.g;
            if (hotThreadPagerAdapter != null && i == 0) {
                threadInfoArr = this.a.j;
                if (threadInfoArr.length > 1) {
                    viewPager3 = this.a.e;
                    int currentItem = viewPager3.getCurrentItem();
                    if (currentItem < 1) {
                        viewPager7 = this.a.e;
                        hotThreadPagerAdapter3 = this.a.g;
                        viewPager7.a(hotThreadPagerAdapter3.getCount() - 2, false);
                        viewPager8 = this.a.e;
                        viewPager8.invalidate();
                    } else {
                        hotThreadPagerAdapter2 = this.a.g;
                        if (currentItem > hotThreadPagerAdapter2.getCount() - 2) {
                            viewPager4 = this.a.e;
                            viewPager4.a(1, false);
                            viewPager5 = this.a.e;
                            viewPager5.invalidate();
                        }
                    }
                    viewPager6 = this.a.e;
                    viewPager6.requestDisallowInterceptTouchEvent(false);
                } else if (i == 1) {
                    viewPager2 = this.a.e;
                    viewPager2.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
    }
}
