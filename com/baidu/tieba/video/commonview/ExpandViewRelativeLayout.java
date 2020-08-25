package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes17.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float bpJ;
    private float mLastY;
    private a muW;
    private boolean muX;
    private boolean muY;

    /* loaded from: classes17.dex */
    public interface a {
        void aF(float f);

        void d(float f, float f2, int i);

        void dBo();

        boolean e(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.muW = aVar;
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
        this.muY = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bpJ = motionEvent.getY();
                this.mLastY = motionEvent.getY();
                if (this.muW != null) {
                    this.muW.aF(motionEvent.getY());
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
                if (this.muW != null) {
                    this.muX = this.muW.e(0.0f, motionEvent.getY(), 0);
                    return this.muX;
                }
                break;
            case 2:
                if (this.muW != null) {
                    this.bpJ = motionEvent.getY();
                    this.muX = this.muW.e(motionEvent.getY() - this.bpJ, motionEvent.getY(), motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2);
                    return this.muX;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.muY) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.muX = false;
                if (this.muW != null) {
                    this.muW.dBo();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.bpJ;
                int i = motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2;
                if (this.muX && this.muW != null) {
                    this.muW.d(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.muY = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
