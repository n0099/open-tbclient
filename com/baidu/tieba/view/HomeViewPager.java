package com.baidu.tieba.view;

import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class HomeViewPager extends ViewPager {
    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }
}
