package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes23.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float byX;
    private float mLastY;
    private a nhn;
    private boolean nho;
    private boolean nhp;

    /* loaded from: classes23.dex */
    public interface a {
        void aN(float f);

        void d(float f, float f2, int i);

        void dMl();

        boolean e(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.nhn = aVar;
    }

    public ExpandViewRelativeLayout(Context context) {
        super(context);
        init(context);
    }

    public ExpandViewRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ExpandViewRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.nhp = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.byX = motionEvent.getY();
                this.mLastY = motionEvent.getY();
                if (this.nhn != null) {
                    this.nhn.aN(motionEvent.getY());
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.nhn != null) {
                    this.nho = this.nhn.e(0.0f, motionEvent.getY(), 0);
                    return this.nho;
                }
                break;
            case 2:
                if (this.nhn != null) {
                    this.byX = motionEvent.getY();
                    this.nho = this.nhn.e(motionEvent.getY() - this.byX, motionEvent.getY(), motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2);
                    return this.nho;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.nhp) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.nho = false;
                if (this.nhn != null) {
                    this.nhn.dMl();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.byX;
                int i = motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2;
                if (this.nho && this.nhn != null) {
                    this.nhn.d(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.nhp = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
