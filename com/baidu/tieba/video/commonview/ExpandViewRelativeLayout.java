package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes8.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float bMr;
    private float mLastY;
    private a nLH;
    private boolean nLI;
    private boolean nLJ;

    /* loaded from: classes8.dex */
    public interface a {
        void bc(float f);

        void d(float f, float f2, int i);

        void dSq();

        boolean e(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.nLH = aVar;
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
        this.nLJ = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bMr = motionEvent.getY();
                this.mLastY = motionEvent.getY();
                if (this.nLH != null) {
                    this.nLH.bc(motionEvent.getY());
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
                if (this.nLH != null) {
                    this.nLI = this.nLH.e(0.0f, motionEvent.getY(), 0);
                    return this.nLI;
                }
                break;
            case 2:
                if (this.nLH != null) {
                    this.bMr = motionEvent.getY();
                    this.nLI = this.nLH.e(motionEvent.getY() - this.bMr, motionEvent.getY(), motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2);
                    return this.nLI;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.nLJ) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.nLI = false;
                if (this.nLH != null) {
                    this.nLH.dSq();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.bMr;
                int i = motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2;
                if (this.nLI && this.nLH != null) {
                    this.nLH.d(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.nLJ = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
