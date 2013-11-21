package com.baidu.tieba.square;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.square.CarouselRecommendView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements android.support.v4.view.bq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CarouselRecommendView f2423a;

    private y(CarouselRecommendView carouselRecommendView) {
        this.f2423a = carouselRecommendView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ y(CarouselRecommendView carouselRecommendView, v vVar) {
        this(carouselRecommendView);
    }

    @Override // android.support.v4.view.bq
    public void onPageScrolled(int i, float f, int i2) {
        IndicatorView indicatorView;
        CarouselRecommendView.CarouselRecommendPagerAdapter carouselRecommendPagerAdapter;
        ArrayList arrayList;
        CarouselRecommendView.CarouselRecommendPagerAdapter carouselRecommendPagerAdapter2;
        IndicatorView indicatorView2;
        IndicatorView indicatorView3;
        IndicatorView indicatorView4;
        indicatorView = this.f2423a.d;
        if (indicatorView != null) {
            carouselRecommendPagerAdapter = this.f2423a.e;
            if (carouselRecommendPagerAdapter != null) {
                arrayList = this.f2423a.m;
                if (arrayList.size() > 1) {
                    carouselRecommendPagerAdapter2 = this.f2423a.e;
                    int count = carouselRecommendPagerAdapter2.getCount();
                    if (i == 0) {
                        indicatorView4 = this.f2423a.d;
                        indicatorView4.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        indicatorView3 = this.f2423a.d;
                        indicatorView3.setPosition(f);
                    } else {
                        indicatorView2 = this.f2423a.d;
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
        CarouselRecommendView.CarouselRecommendPagerAdapter carouselRecommendPagerAdapter;
        ViewPager viewPager2;
        ArrayList arrayList;
        ViewPager viewPager3;
        ViewPager viewPager4;
        CarouselRecommendView.CarouselRecommendPagerAdapter carouselRecommendPagerAdapter2;
        Handler handler;
        Handler handler2;
        int i2;
        ViewPager viewPager5;
        ViewPager viewPager6;
        Handler handler3;
        Handler handler4;
        int i3;
        ViewPager viewPager7;
        CarouselRecommendView.CarouselRecommendPagerAdapter carouselRecommendPagerAdapter3;
        ViewPager viewPager8;
        viewPager = this.f2423a.c;
        if (viewPager != null) {
            carouselRecommendPagerAdapter = this.f2423a.e;
            if (carouselRecommendPagerAdapter != null) {
                if (i == 0) {
                    arrayList = this.f2423a.m;
                    if (arrayList.size() > 1) {
                        viewPager4 = this.f2423a.c;
                        int currentItem = viewPager4.getCurrentItem();
                        if (currentItem < 1) {
                            viewPager7 = this.f2423a.c;
                            carouselRecommendPagerAdapter3 = this.f2423a.e;
                            viewPager7.a(carouselRecommendPagerAdapter3.getCount() - 2, false);
                            viewPager8 = this.f2423a.c;
                            viewPager8.invalidate();
                        } else {
                            carouselRecommendPagerAdapter2 = this.f2423a.e;
                            if (currentItem > carouselRecommendPagerAdapter2.getCount() - 2) {
                                viewPager5 = this.f2423a.c;
                                viewPager5.a(1, false);
                                viewPager6 = this.f2423a.c;
                                viewPager6.invalidate();
                                handler3 = this.f2423a.n;
                                handler3.removeMessages(0);
                                handler4 = this.f2423a.n;
                                i3 = CarouselRecommendView.l;
                                handler4.sendEmptyMessageDelayed(0, i3);
                            } else {
                                handler = this.f2423a.n;
                                handler.removeMessages(0);
                                handler2 = this.f2423a.n;
                                i2 = CarouselRecommendView.l;
                                handler2.sendEmptyMessageDelayed(0, i2);
                            }
                        }
                    }
                    viewPager3 = this.f2423a.c;
                    viewPager3.requestDisallowInterceptTouchEvent(false);
                } else if (i == 1) {
                    viewPager2 = this.f2423a.c;
                    viewPager2.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
    }
}
