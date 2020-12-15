package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes23.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float bIF;
    private float mLastY;
    private a nCv;
    private boolean nCw;
    private boolean nCx;

    /* loaded from: classes23.dex */
    public interface a {
        void aX(float f);

        void d(float f, float f2, int i);

        void dUf();

        boolean e(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.nCv = aVar;
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
        this.nCx = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bIF = motionEvent.getY();
                this.mLastY = motionEvent.getY();
                if (this.nCv != null) {
                    this.nCv.aX(motionEvent.getY());
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
                if (this.nCv != null) {
                    this.nCw = this.nCv.e(0.0f, motionEvent.getY(), 0);
                    return this.nCw;
                }
                break;
            case 2:
                if (this.nCv != null) {
                    this.bIF = motionEvent.getY();
                    this.nCw = this.nCv.e(motionEvent.getY() - this.bIF, motionEvent.getY(), motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2);
                    return this.nCw;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.nCx) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.nCw = false;
                if (this.nCv != null) {
                    this.nCv.dUf();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.bIF;
                int i = motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2;
                if (this.nCw && this.nCv != null) {
                    this.nCv.d(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.nCx = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
