package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes5.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float Ok;
    private float aJG;
    private a juZ;
    private boolean jva;
    private boolean jvb;

    /* loaded from: classes5.dex */
    public interface a {
        void aT(float f);

        void ctX();

        void d(float f, float f2, int i);

        boolean e(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.juZ = aVar;
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
        this.jvb = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.aJG = motionEvent.getY();
                this.Ok = motionEvent.getY();
                if (this.juZ != null) {
                    this.juZ.aT(motionEvent.getY());
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
                if (this.juZ != null) {
                    this.jva = this.juZ.e(0.0f, motionEvent.getY(), 0);
                    return this.jva;
                }
                break;
            case 2:
                if (this.juZ != null) {
                    this.aJG = motionEvent.getY();
                    this.jva = this.juZ.e(motionEvent.getY() - this.aJG, motionEvent.getY(), motionEvent.getY() - this.Ok > 0.0f ? 1 : 2);
                    return this.jva;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.jvb) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.jva = false;
                if (this.juZ != null) {
                    this.juZ.ctX();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.aJG;
                int i = motionEvent.getY() - this.Ok > 0.0f ? 1 : 2;
                if (this.jva && this.juZ != null) {
                    this.juZ.d(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.jvb = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
