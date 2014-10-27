package com.baidu.tieba.square;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import com.baidu.tieba.square.CarouselRecommendView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends Handler {
    final /* synthetic */ CarouselRecommendView bMm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(CarouselRecommendView carouselRecommendView) {
        this.bMm = carouselRecommendView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        ViewPager viewPager;
        ViewPager viewPager2;
        CarouselRecommendView.n nVar;
        List list;
        CarouselRecommendView.n nVar2;
        ViewPager viewPager3;
        ViewPager viewPager4;
        ViewPager viewPager5;
        ViewPager viewPager6;
        ViewPager viewPager7;
        CarouselRecommendView.n nVar3;
        ViewPager viewPager8;
        viewPager = this.bMm.mPager;
        int currentItem = viewPager.getCurrentItem();
        if (message.what == 0) {
            viewPager2 = this.bMm.mPager;
            if (viewPager2 != null) {
                nVar = this.bMm.mPageAdapter;
                if (nVar != null) {
                    list = this.bMm.dataCache;
                    if (list.size() > 1) {
                        if (currentItem < 1) {
                            viewPager7 = this.bMm.mPager;
                            nVar3 = this.bMm.mPageAdapter;
                            viewPager7.setCurrentItem(nVar3.getCount() - 2, false);
                            viewPager8 = this.bMm.mPager;
                            viewPager8.invalidate();
                            return;
                        }
                        nVar2 = this.bMm.mPageAdapter;
                        if (currentItem > nVar2.getCount() - 2) {
                            viewPager5 = this.bMm.mPager;
                            viewPager5.setCurrentItem(1, false);
                            viewPager6 = this.bMm.mPager;
                            viewPager6.invalidate();
                            return;
                        }
                        viewPager3 = this.bMm.mPager;
                        viewPager3.setCurrentItem(currentItem + 1);
                        viewPager4 = this.bMm.mPager;
                        viewPager4.invalidate();
                    }
                }
            }
        }
    }
}
