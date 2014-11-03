package com.baidu.tieba.square;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends Handler {
    final /* synthetic */ CarouselRecommendView bMB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(CarouselRecommendView carouselRecommendView) {
        this.bMB = carouselRecommendView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int currentItem = this.bMB.mPager.getCurrentItem();
        if (message.what == 0 && this.bMB.mPager != null && this.bMB.mPageAdapter != null && this.bMB.dataCache.size() > 1) {
            if (currentItem < 1) {
                this.bMB.mPager.setCurrentItem(this.bMB.mPageAdapter.getCount() - 2, false);
                this.bMB.mPager.invalidate();
            } else if (currentItem > this.bMB.mPageAdapter.getCount() - 2) {
                this.bMB.mPager.setCurrentItem(1, false);
                this.bMB.mPager.invalidate();
            } else {
                this.bMB.mPager.setCurrentItem(currentItem + 1);
                this.bMB.mPager.invalidate();
            }
        }
    }
}
