package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes7.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float bNR;
    private float mLastY;
    private a nOm;
    private boolean nOn;
    private boolean nOo;

    /* loaded from: classes7.dex */
    public interface a {
        void bg(float f);

        void d(float f, float f2, int i);

        void dSG();

        boolean e(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.nOm = aVar;
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
        this.nOo = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bNR = motionEvent.getY();
                this.mLastY = motionEvent.getY();
                if (this.nOm != null) {
                    this.nOm.bg(motionEvent.getY());
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
                if (this.nOm != null) {
                    this.nOn = this.nOm.e(0.0f, motionEvent.getY(), 0);
                    return this.nOn;
                }
                break;
            case 2:
                if (this.nOm != null) {
                    this.bNR = motionEvent.getY();
                    this.nOn = this.nOm.e(motionEvent.getY() - this.bNR, motionEvent.getY(), motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2);
                    return this.nOn;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.nOo) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.nOn = false;
                if (this.nOm != null) {
                    this.nOm.dSG();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.bNR;
                int i = motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2;
                if (this.nOn && this.nOm != null) {
                    this.nOm.d(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.nOo = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
