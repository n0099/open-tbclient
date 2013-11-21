package com.baidu.tieba.square;

import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CarouselRecommendView f2421a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(CarouselRecommendView carouselRecommendView) {
        this.f2421a = carouselRecommendView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ViewPager viewPager;
        viewPager = this.f2421a.c;
        if (view == viewPager) {
            if (motionEvent.getAction() == 0) {
                this.f2421a.b();
                return false;
            } else if (motionEvent.getAction() == 1) {
                this.f2421a.a();
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
