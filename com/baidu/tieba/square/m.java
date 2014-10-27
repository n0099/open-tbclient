package com.baidu.tieba.square;

import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnTouchListener {
    final /* synthetic */ CarouselRecommendView bMm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(CarouselRecommendView carouselRecommendView) {
        this.bMm = carouselRecommendView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ViewPager viewPager;
        viewPager = this.bMm.mPager;
        if (view == viewPager) {
            if (motionEvent.getAction() == 0) {
                this.bMm.stopMarqueen();
                return false;
            } else if (motionEvent.getAction() == 1) {
                this.bMm.startMarqueen();
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
