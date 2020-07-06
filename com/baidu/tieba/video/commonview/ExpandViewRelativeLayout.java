package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes10.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float VV;
    private float bjK;
    private a lVT;
    private boolean lVU;
    private boolean lVV;

    /* loaded from: classes10.dex */
    public interface a {
        void aA(float f);

        void c(float f, float f2, int i);

        boolean d(float f, float f2, int i);

        void dmH();
    }

    public void setScrollCallBack(a aVar) {
        this.lVT = aVar;
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
        this.lVV = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bjK = motionEvent.getY();
                this.VV = motionEvent.getY();
                if (this.lVT != null) {
                    this.lVT.aA(motionEvent.getY());
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
                if (this.lVT != null) {
                    this.lVU = this.lVT.d(0.0f, motionEvent.getY(), 0);
                    return this.lVU;
                }
                break;
            case 2:
                if (this.lVT != null) {
                    this.bjK = motionEvent.getY();
                    this.lVU = this.lVT.d(motionEvent.getY() - this.bjK, motionEvent.getY(), motionEvent.getY() - this.VV > 0.0f ? 1 : 2);
                    return this.lVU;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.lVV) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.lVU = false;
                if (this.lVT != null) {
                    this.lVT.dmH();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.bjK;
                int i = motionEvent.getY() - this.VV > 0.0f ? 1 : 2;
                if (this.lVU && this.lVT != null) {
                    this.lVT.c(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.lVV = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
