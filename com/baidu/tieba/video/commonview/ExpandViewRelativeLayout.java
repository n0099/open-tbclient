package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes23.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float bwJ;
    private float mLastY;
    private a mUN;
    private boolean mUO;
    private boolean mUP;

    /* loaded from: classes23.dex */
    public interface a {
        void aL(float f);

        void d(float f, float f2, int i);

        void dJd();

        boolean e(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.mUN = aVar;
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
        this.mUP = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bwJ = motionEvent.getY();
                this.mLastY = motionEvent.getY();
                if (this.mUN != null) {
                    this.mUN.aL(motionEvent.getY());
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
                if (this.mUN != null) {
                    this.mUO = this.mUN.e(0.0f, motionEvent.getY(), 0);
                    return this.mUO;
                }
                break;
            case 2:
                if (this.mUN != null) {
                    this.bwJ = motionEvent.getY();
                    this.mUO = this.mUN.e(motionEvent.getY() - this.bwJ, motionEvent.getY(), motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2);
                    return this.mUO;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mUP) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mUO = false;
                if (this.mUN != null) {
                    this.mUN.dJd();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.bwJ;
                int i = motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2;
                if (this.mUO && this.mUN != null) {
                    this.mUN.d(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.mUP = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
