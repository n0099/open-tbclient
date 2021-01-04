package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes8.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float bNt;
    private float mLastY;
    private a nGC;
    private boolean nGD;
    private boolean nGE;

    /* loaded from: classes8.dex */
    public interface a {
        void aZ(float f);

        void d(float f, float f2, int i);

        void dTW();

        boolean e(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.nGC = aVar;
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
        this.nGE = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bNt = motionEvent.getY();
                this.mLastY = motionEvent.getY();
                if (this.nGC != null) {
                    this.nGC.aZ(motionEvent.getY());
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
                if (this.nGC != null) {
                    this.nGD = this.nGC.e(0.0f, motionEvent.getY(), 0);
                    return this.nGD;
                }
                break;
            case 2:
                if (this.nGC != null) {
                    this.bNt = motionEvent.getY();
                    this.nGD = this.nGC.e(motionEvent.getY() - this.bNt, motionEvent.getY(), motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2);
                    return this.nGD;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.nGE) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.nGD = false;
                if (this.nGC != null) {
                    this.nGC.dTW();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.bNt;
                int i = motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2;
                if (this.nGD && this.nGC != null) {
                    this.nGC.d(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.nGE = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
