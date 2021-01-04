package com.baidu.tieba.tblauncherInterestGuide.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes2.dex */
public class RightSlideViewPager extends ViewPager {
    public RightSlideViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RightSlideViewPager(Context context) {
        super(context);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Object tag = getTag();
        if (tag != null && (tag instanceof String) && "canScroll".equals((String) tag)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Object tag = getTag();
        if (tag != null && (tag instanceof String) && "canScroll".equals((String) tag)) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }
}
