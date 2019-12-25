package com.baidu.tieba.tblauncherInterestGuide.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes6.dex */
public class RightSlideViewPager extends ViewPager {
    public RightSlideViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RightSlideViewPager(Context context) {
        super(context);
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Object tag = getTag();
        if (tag != null && (tag instanceof String) && "canScroll".equals((String) tag)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Object tag = getTag();
        if (tag != null && (tag instanceof String) && "canScroll".equals((String) tag)) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }
}
