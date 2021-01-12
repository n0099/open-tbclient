package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes7.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float bIH;
    private float mLastY;
    private a nBW;
    private boolean nBX;
    private boolean nBY;

    /* loaded from: classes7.dex */
    public interface a {
        void aZ(float f);

        void d(float f, float f2, int i);

        void dQf();

        boolean e(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.nBW = aVar;
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
        this.nBY = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bIH = motionEvent.getY();
                this.mLastY = motionEvent.getY();
                if (this.nBW != null) {
                    this.nBW.aZ(motionEvent.getY());
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
                if (this.nBW != null) {
                    this.nBX = this.nBW.e(0.0f, motionEvent.getY(), 0);
                    return this.nBX;
                }
                break;
            case 2:
                if (this.nBW != null) {
                    this.bIH = motionEvent.getY();
                    this.nBX = this.nBW.e(motionEvent.getY() - this.bIH, motionEvent.getY(), motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2);
                    return this.nBX;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.nBY) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.nBX = false;
                if (this.nBW != null) {
                    this.nBW.dQf();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.bIH;
                int i = motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2;
                if (this.nBX && this.nBW != null) {
                    this.nBW.d(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.nBY = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
