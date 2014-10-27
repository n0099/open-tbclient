package com.baidu.tieba.square;

import android.support.v4.view.ViewPager;
/* loaded from: classes.dex */
class p implements ViewPager.OnPageChangeListener {
    final /* synthetic */ CarouselRecommendView bMm;

    private p(CarouselRecommendView carouselRecommendView) {
        this.bMm = carouselRecommendView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(CarouselRecommendView carouselRecommendView, p pVar) {
        this(carouselRecommendView);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (CarouselRecommendView.access$10(this.bMm) != null && CarouselRecommendView.access$1(this.bMm) != null && CarouselRecommendView.access$2(this.bMm).size() > 1) {
            int count = CarouselRecommendView.access$1(this.bMm).getCount();
            if (i == 0) {
                CarouselRecommendView.access$10(this.bMm).setPosition((count - 3) + f);
            } else if (i == count - 1) {
                CarouselRecommendView.access$10(this.bMm).setPosition(f);
            } else {
                CarouselRecommendView.access$10(this.bMm).setPosition((i - 1) + f);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (CarouselRecommendView.access$0(this.bMm) != null && CarouselRecommendView.access$1(this.bMm) != null) {
            if (i == 0) {
                if (CarouselRecommendView.access$2(this.bMm).size() > 1) {
                    int currentItem = CarouselRecommendView.access$0(this.bMm).getCurrentItem();
                    if (currentItem < 1) {
                        CarouselRecommendView.access$0(this.bMm).setCurrentItem(CarouselRecommendView.access$1(this.bMm).getCount() - 2, false);
                        CarouselRecommendView.access$0(this.bMm).invalidate();
                    } else if (currentItem > CarouselRecommendView.access$1(this.bMm).getCount() - 2) {
                        CarouselRecommendView.access$0(this.bMm).setCurrentItem(1, false);
                        CarouselRecommendView.access$0(this.bMm).invalidate();
                        CarouselRecommendView.access$11(this.bMm).removeMessages(0);
                        CarouselRecommendView.access$11(this.bMm).sendEmptyMessageDelayed(0, CarouselRecommendView.access$12());
                    } else {
                        CarouselRecommendView.access$11(this.bMm).removeMessages(0);
                        CarouselRecommendView.access$11(this.bMm).sendEmptyMessageDelayed(0, CarouselRecommendView.access$12());
                    }
                }
                CarouselRecommendView.access$0(this.bMm).requestDisallowInterceptTouchEvent(false);
            } else if (i == 1) {
                CarouselRecommendView.access$0(this.bMm).requestDisallowInterceptTouchEvent(true);
            }
        }
    }
}
