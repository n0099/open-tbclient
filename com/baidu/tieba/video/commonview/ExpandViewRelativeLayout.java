package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes2.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private boolean hpA;
    private float hpB;
    private boolean hpC;
    private a hpz;
    private float mLastY;

    /* loaded from: classes2.dex */
    public interface a {
        void aG(float f);

        void bBg();

        void c(float f, float f2, int i);

        boolean d(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.hpz = aVar;
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
        this.hpC = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.hpB = motionEvent.getY();
                this.mLastY = motionEvent.getY();
                if (this.hpz != null) {
                    this.hpz.aG(motionEvent.getY());
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
                if (this.hpz != null) {
                    this.hpA = this.hpz.d(0.0f, motionEvent.getY(), 0);
                    return this.hpA;
                }
                break;
            case 2:
                if (this.hpz != null) {
                    this.hpB = motionEvent.getY();
                    this.hpA = this.hpz.d(motionEvent.getY() - this.hpB, motionEvent.getY(), motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2);
                    return this.hpA;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.hpC) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.hpA = false;
                if (this.hpz != null) {
                    this.hpz.bBg();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.hpB;
                int i = motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2;
                if (this.hpA && this.hpz != null) {
                    this.hpz.c(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.hpC = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
