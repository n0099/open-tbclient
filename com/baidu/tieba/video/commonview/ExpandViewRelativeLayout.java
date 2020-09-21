package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes22.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float bsV;
    private a mEZ;
    private boolean mFa;
    private boolean mFb;
    private float mLastY;

    /* loaded from: classes22.dex */
    public interface a {
        void aF(float f);

        void d(float f, float f2, int i);

        void dFr();

        boolean e(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.mEZ = aVar;
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
        this.mFb = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bsV = motionEvent.getY();
                this.mLastY = motionEvent.getY();
                if (this.mEZ != null) {
                    this.mEZ.aF(motionEvent.getY());
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
                if (this.mEZ != null) {
                    this.mFa = this.mEZ.e(0.0f, motionEvent.getY(), 0);
                    return this.mFa;
                }
                break;
            case 2:
                if (this.mEZ != null) {
                    this.bsV = motionEvent.getY();
                    this.mFa = this.mEZ.e(motionEvent.getY() - this.bsV, motionEvent.getY(), motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2);
                    return this.mFa;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mFb) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mFa = false;
                if (this.mEZ != null) {
                    this.mEZ.dFr();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.bsV;
                int i = motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2;
                if (this.mFa && this.mEZ != null) {
                    this.mEZ.d(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.mFb = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
