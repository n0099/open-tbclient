package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes5.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float aKe;
    private a jyC;
    private boolean jyD;
    private boolean jyE;
    private float mLastY;

    /* loaded from: classes5.dex */
    public interface a {
        void aU(float f);

        void cvh();

        void d(float f, float f2, int i);

        boolean e(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.jyC = aVar;
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
        this.jyE = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.aKe = motionEvent.getY();
                this.mLastY = motionEvent.getY();
                if (this.jyC != null) {
                    this.jyC.aU(motionEvent.getY());
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
                if (this.jyC != null) {
                    this.jyD = this.jyC.e(0.0f, motionEvent.getY(), 0);
                    return this.jyD;
                }
                break;
            case 2:
                if (this.jyC != null) {
                    this.aKe = motionEvent.getY();
                    this.jyD = this.jyC.e(motionEvent.getY() - this.aKe, motionEvent.getY(), motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2);
                    return this.jyD;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.jyE) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.jyD = false;
                if (this.jyC != null) {
                    this.jyC.cvh();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.aKe;
                int i = motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2;
                if (this.jyD && this.jyC != null) {
                    this.jyC.d(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.jyE = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
