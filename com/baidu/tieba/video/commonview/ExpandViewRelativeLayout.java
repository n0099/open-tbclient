package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes22.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float bDx;
    private float mLastY;
    private a noq;
    private boolean nor;
    private boolean nos;

    /* loaded from: classes22.dex */
    public interface a {
        void aW(float f);

        void d(float f, float f2, int i);

        void dOM();

        boolean e(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.noq = aVar;
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
        this.nos = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bDx = motionEvent.getY();
                this.mLastY = motionEvent.getY();
                if (this.noq != null) {
                    this.noq.aW(motionEvent.getY());
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
                if (this.noq != null) {
                    this.nor = this.noq.e(0.0f, motionEvent.getY(), 0);
                    return this.nor;
                }
                break;
            case 2:
                if (this.noq != null) {
                    this.bDx = motionEvent.getY();
                    this.nor = this.noq.e(motionEvent.getY() - this.bDx, motionEvent.getY(), motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2);
                    return this.nor;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.nos) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.nor = false;
                if (this.noq != null) {
                    this.noq.dOM();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.bDx;
                int i = motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2;
                if (this.nor && this.noq != null) {
                    this.noq.d(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.nos = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
