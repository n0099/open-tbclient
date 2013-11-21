package com.baidu.tieba.square;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import com.baidu.tieba.square.CarouselRecommendView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CarouselRecommendView f2420a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(CarouselRecommendView carouselRecommendView) {
        this.f2420a = carouselRecommendView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        ViewPager viewPager;
        ViewPager viewPager2;
        CarouselRecommendView.CarouselRecommendPagerAdapter carouselRecommendPagerAdapter;
        ArrayList arrayList;
        CarouselRecommendView.CarouselRecommendPagerAdapter carouselRecommendPagerAdapter2;
        ViewPager viewPager3;
        ViewPager viewPager4;
        ViewPager viewPager5;
        ViewPager viewPager6;
        ViewPager viewPager7;
        CarouselRecommendView.CarouselRecommendPagerAdapter carouselRecommendPagerAdapter3;
        ViewPager viewPager8;
        viewPager = this.f2420a.c;
        int currentItem = viewPager.getCurrentItem();
        if (message.what == 0) {
            viewPager2 = this.f2420a.c;
            if (viewPager2 != null) {
                carouselRecommendPagerAdapter = this.f2420a.e;
                if (carouselRecommendPagerAdapter != null) {
                    arrayList = this.f2420a.m;
                    if (arrayList.size() > 1) {
                        if (currentItem < 1) {
                            viewPager7 = this.f2420a.c;
                            carouselRecommendPagerAdapter3 = this.f2420a.e;
                            viewPager7.a(carouselRecommendPagerAdapter3.getCount() - 2, false);
                            viewPager8 = this.f2420a.c;
                            viewPager8.invalidate();
                            return;
                        }
                        carouselRecommendPagerAdapter2 = this.f2420a.e;
                        if (currentItem > carouselRecommendPagerAdapter2.getCount() - 2) {
                            viewPager5 = this.f2420a.c;
                            viewPager5.a(1, false);
                            viewPager6 = this.f2420a.c;
                            viewPager6.invalidate();
                            return;
                        }
                        viewPager3 = this.f2420a.c;
                        viewPager3.setCurrentItem(currentItem + 1);
                        viewPager4 = this.f2420a.c;
                        viewPager4.invalidate();
                    }
                }
            }
        }
    }
}
