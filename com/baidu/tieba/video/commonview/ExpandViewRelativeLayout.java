package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes8.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float bNt;
    private float mLastY;
    private a nGB;
    private boolean nGC;
    private boolean nGD;

    /* loaded from: classes8.dex */
    public interface a {
        void aZ(float f);

        void d(float f, float f2, int i);

        void dTX();

        boolean e(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.nGB = aVar;
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
        this.nGD = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bNt = motionEvent.getY();
                this.mLastY = motionEvent.getY();
                if (this.nGB != null) {
                    this.nGB.aZ(motionEvent.getY());
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
                if (this.nGB != null) {
                    this.nGC = this.nGB.e(0.0f, motionEvent.getY(), 0);
                    return this.nGC;
                }
                break;
            case 2:
                if (this.nGB != null) {
                    this.bNt = motionEvent.getY();
                    this.nGC = this.nGB.e(motionEvent.getY() - this.bNt, motionEvent.getY(), motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2);
                    return this.nGC;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.nGD) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.nGC = false;
                if (this.nGB != null) {
                    this.nGB.dTX();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.bNt;
                int i = motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2;
                if (this.nGC && this.nGB != null) {
                    this.nGB.d(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.nGD = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
