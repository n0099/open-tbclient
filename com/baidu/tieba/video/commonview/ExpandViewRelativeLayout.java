package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes10.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float VV;
    private float bjK;
    private a lVQ;
    private boolean lVR;
    private boolean lVS;

    /* loaded from: classes10.dex */
    public interface a {
        void aA(float f);

        void c(float f, float f2, int i);

        boolean d(float f, float f2, int i);

        void dmD();
    }

    public void setScrollCallBack(a aVar) {
        this.lVQ = aVar;
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
        this.lVS = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bjK = motionEvent.getY();
                this.VV = motionEvent.getY();
                if (this.lVQ != null) {
                    this.lVQ.aA(motionEvent.getY());
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
                if (this.lVQ != null) {
                    this.lVR = this.lVQ.d(0.0f, motionEvent.getY(), 0);
                    return this.lVR;
                }
                break;
            case 2:
                if (this.lVQ != null) {
                    this.bjK = motionEvent.getY();
                    this.lVR = this.lVQ.d(motionEvent.getY() - this.bjK, motionEvent.getY(), motionEvent.getY() - this.VV > 0.0f ? 1 : 2);
                    return this.lVR;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.lVS) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.lVR = false;
                if (this.lVQ != null) {
                    this.lVQ.dmD();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.bjK;
                int i = motionEvent.getY() - this.VV > 0.0f ? 1 : 2;
                if (this.lVR && this.lVQ != null) {
                    this.lVQ.c(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.lVS = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
