package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes10.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float BF;
    private float aDc;
    private a kwf;
    private boolean kwg;
    private boolean kwh;

    /* loaded from: classes10.dex */
    public interface a {
        void aM(float f);

        void c(float f, float f2, int i);

        void cPy();

        boolean d(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.kwf = aVar;
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
        this.kwh = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.aDc = motionEvent.getY();
                this.BF = motionEvent.getY();
                if (this.kwf != null) {
                    this.kwf.aM(motionEvent.getY());
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
                if (this.kwf != null) {
                    this.kwg = this.kwf.d(0.0f, motionEvent.getY(), 0);
                    return this.kwg;
                }
                break;
            case 2:
                if (this.kwf != null) {
                    this.aDc = motionEvent.getY();
                    this.kwg = this.kwf.d(motionEvent.getY() - this.aDc, motionEvent.getY(), motionEvent.getY() - this.BF > 0.0f ? 1 : 2);
                    return this.kwg;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.kwh) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.kwg = false;
                if (this.kwf != null) {
                    this.kwf.cPy();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.aDc;
                int i = motionEvent.getY() - this.BF > 0.0f ? 1 : 2;
                if (this.kwg && this.kwf != null) {
                    this.kwf.c(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.kwh = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
