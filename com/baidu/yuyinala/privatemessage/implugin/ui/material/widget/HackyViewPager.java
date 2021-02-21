package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.baidu.yuyinala.privatemessage.implugin.ui.theme.ThemeManager;
/* loaded from: classes11.dex */
public class HackyViewPager extends ViewPager {
    public HackyViewPager(Context context) {
        super(context);
    }

    public HackyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (ThemeManager.emw() == ThemeManager.ThemeMode.NIGHT) {
            canvas.drawColor(2130706432);
        }
    }
}
