package com.baidu.tieba.videoplay.verticalviewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes2.dex */
public class VerticalViewPager extends ViewPager {
    private a hxV;
    private float mLastX;
    private float mLastY;

    /* loaded from: classes2.dex */
    public interface a {
        void bDQ();
    }

    public VerticalViewPager(Context context) {
        this(context, null);
    }

    public VerticalViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setPageTransformer(false, new com.baidu.tieba.videoplay.verticalviewpager.a.a());
    }

    private MotionEvent P(MotionEvent motionEvent) {
        float width = getWidth();
        float height = getHeight();
        motionEvent.setLocation((motionEvent.getY() / height) * width, (motionEvent.getX() / width) * height);
        return motionEvent;
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hxV != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.mLastX = motionEvent.getX();
                    this.mLastY = motionEvent.getY();
                    break;
                case 1:
                    if (this.mLastX - motionEvent.getX() > 50.0f && (this.mLastX - motionEvent.getX()) - 10.0f > Math.abs(motionEvent.getY() - this.mLastY)) {
                        this.hxV.bDQ();
                        z = true;
                        break;
                    } else if (Math.abs(motionEvent.getY() - this.mLastY) > 10.0f || Math.abs(motionEvent.getX() - this.mLastX) > 10.0f) {
                        z = true;
                        break;
                    }
                    break;
                case 2:
                    if (Math.abs(motionEvent.getY() - this.mLastY) > 10.0f || Math.abs(motionEvent.getX() - this.mLastX) > 10.0f) {
                        z = true;
                        break;
                    }
                    break;
            }
        }
        if (!z) {
            z = super.onInterceptTouchEvent(P(motionEvent));
        }
        P(motionEvent);
        return z;
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hxV != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.mLastX = motionEvent.getX();
                    this.mLastY = motionEvent.getY();
                    break;
                case 1:
                    if (this.mLastX - motionEvent.getX() > 50.0f && (this.mLastX - motionEvent.getX()) - 10.0f > Math.abs(motionEvent.getY() - this.mLastY)) {
                        this.hxV.bDQ();
                        break;
                    }
                    break;
            }
        }
        return super.onTouchEvent(P(motionEvent));
    }

    public void setOnTouchDirectionListener(a aVar) {
        this.hxV = aVar;
    }
}
