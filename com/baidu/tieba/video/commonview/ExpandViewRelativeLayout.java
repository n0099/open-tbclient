package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes17.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float bpM;
    private float mLastY;
    private a mvo;
    private boolean mvp;
    private boolean mvq;

    /* loaded from: classes17.dex */
    public interface a {
        void aF(float f);

        void d(float f, float f2, int i);

        void dBx();

        boolean e(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.mvo = aVar;
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
        this.mvq = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bpM = motionEvent.getY();
                this.mLastY = motionEvent.getY();
                if (this.mvo != null) {
                    this.mvo.aF(motionEvent.getY());
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
                if (this.mvo != null) {
                    this.mvp = this.mvo.e(0.0f, motionEvent.getY(), 0);
                    return this.mvp;
                }
                break;
            case 2:
                if (this.mvo != null) {
                    this.bpM = motionEvent.getY();
                    this.mvp = this.mvo.e(motionEvent.getY() - this.bpM, motionEvent.getY(), motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2);
                    return this.mvp;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mvq) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mvp = false;
                if (this.mvo != null) {
                    this.mvo.dBx();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.bpM;
                int i = motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2;
                if (this.mvp && this.mvo != null) {
                    this.mvo.d(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.mvq = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
