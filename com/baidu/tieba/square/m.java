package com.baidu.tieba.square;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnTouchListener {
    final /* synthetic */ CarouselRecommendView bMB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(CarouselRecommendView carouselRecommendView) {
        this.bMB = carouselRecommendView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.bMB.mPager) {
            if (motionEvent.getAction() == 0) {
                this.bMB.stopMarqueen();
                return false;
            } else if (motionEvent.getAction() == 1) {
                this.bMB.startMarqueen();
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
