package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes5.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private a htW;
    private boolean htX;
    private boolean htY;
    private float mLastY;
    private float mStartY;

    /* loaded from: classes5.dex */
    public interface a {
        void aB(float f);

        void bGf();

        void c(float f, float f2, int i);

        boolean d(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.htW = aVar;
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
        this.htY = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mStartY = motionEvent.getY();
                this.mLastY = motionEvent.getY();
                if (this.htW != null) {
                    this.htW.aB(motionEvent.getY());
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
                if (this.htW != null) {
                    this.htX = this.htW.d(0.0f, motionEvent.getY(), 0);
                    return this.htX;
                }
                break;
            case 2:
                if (this.htW != null) {
                    this.mStartY = motionEvent.getY();
                    this.htX = this.htW.d(motionEvent.getY() - this.mStartY, motionEvent.getY(), motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2);
                    return this.htX;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.htY) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.htX = false;
                if (this.htW != null) {
                    this.htW.bGf();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.mStartY;
                int i = motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2;
                if (this.htX && this.htW != null) {
                    this.htW.c(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.htY = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
