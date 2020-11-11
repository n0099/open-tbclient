package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes23.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float bFi;
    private float mLastY;
    private a nnj;
    private boolean nnk;
    private boolean nnl;

    /* loaded from: classes23.dex */
    public interface a {
        void aP(float f);

        void d(float f, float f2, int i);

        void dON();

        boolean e(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.nnj = aVar;
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
        this.nnl = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bFi = motionEvent.getY();
                this.mLastY = motionEvent.getY();
                if (this.nnj != null) {
                    this.nnj.aP(motionEvent.getY());
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
                if (this.nnj != null) {
                    this.nnk = this.nnj.e(0.0f, motionEvent.getY(), 0);
                    return this.nnk;
                }
                break;
            case 2:
                if (this.nnj != null) {
                    this.bFi = motionEvent.getY();
                    this.nnk = this.nnj.e(motionEvent.getY() - this.bFi, motionEvent.getY(), motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2);
                    return this.nnk;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.nnl) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.nnk = false;
                if (this.nnj != null) {
                    this.nnj.dON();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.bFi;
                int i = motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2;
                if (this.nnk && this.nnj != null) {
                    this.nnj.d(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.nnl = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
