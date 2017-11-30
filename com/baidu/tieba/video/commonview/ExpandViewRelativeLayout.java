package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes2.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private a gOn;
    private boolean gOo;
    private float gOp;
    private boolean gOq;
    private float mLastY;

    /* loaded from: classes2.dex */
    public interface a {
        void ao(float f);

        void bAP();

        void c(float f, float f2, int i);

        boolean d(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.gOn = aVar;
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
        this.gOq = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.gOp = motionEvent.getY();
                this.mLastY = motionEvent.getY();
                if (this.gOn != null) {
                    this.gOn.ao(motionEvent.getY());
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
                if (this.gOn != null) {
                    this.gOo = this.gOn.d(0.0f, motionEvent.getY(), 0);
                    return this.gOo;
                }
                break;
            case 2:
                if (this.gOn != null) {
                    this.gOp = motionEvent.getY();
                    this.gOo = this.gOn.d(motionEvent.getY() - this.gOp, motionEvent.getY(), motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2);
                    return this.gOo;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.gOq) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.gOo = false;
                if (this.gOn != null) {
                    this.gOn.bAP();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.gOp;
                int i = motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2;
                if (this.gOo && this.gOn != null) {
                    this.gOn.c(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.gOq = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
