package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes8.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float bMr;
    private float mLastY;
    private a nMh;
    private boolean nMi;
    private boolean nMj;

    /* loaded from: classes8.dex */
    public interface a {
        void bc(float f);

        void d(float f, float f2, int i);

        void dSy();

        boolean e(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.nMh = aVar;
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
        this.nMj = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bMr = motionEvent.getY();
                this.mLastY = motionEvent.getY();
                if (this.nMh != null) {
                    this.nMh.bc(motionEvent.getY());
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
                if (this.nMh != null) {
                    this.nMi = this.nMh.e(0.0f, motionEvent.getY(), 0);
                    return this.nMi;
                }
                break;
            case 2:
                if (this.nMh != null) {
                    this.bMr = motionEvent.getY();
                    this.nMi = this.nMh.e(motionEvent.getY() - this.bMr, motionEvent.getY(), motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2);
                    return this.nMi;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.nMj) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.nMi = false;
                if (this.nMh != null) {
                    this.nMh.dSy();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.bMr;
                int i = motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2;
                if (this.nMi && this.nMh != null) {
                    this.nMh.d(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.nMj = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
