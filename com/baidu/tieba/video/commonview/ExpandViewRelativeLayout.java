package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes10.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float BF;
    private float aDd;
    private a kwh;
    private boolean kwi;
    private boolean kwj;

    /* loaded from: classes10.dex */
    public interface a {
        void aM(float f);

        void c(float f, float f2, int i);

        void cPA();

        boolean d(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.kwh = aVar;
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
        this.kwj = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.aDd = motionEvent.getY();
                this.BF = motionEvent.getY();
                if (this.kwh != null) {
                    this.kwh.aM(motionEvent.getY());
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
                if (this.kwh != null) {
                    this.kwi = this.kwh.d(0.0f, motionEvent.getY(), 0);
                    return this.kwi;
                }
                break;
            case 2:
                if (this.kwh != null) {
                    this.aDd = motionEvent.getY();
                    this.kwi = this.kwh.d(motionEvent.getY() - this.aDd, motionEvent.getY(), motionEvent.getY() - this.BF > 0.0f ? 1 : 2);
                    return this.kwi;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.kwj) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.kwi = false;
                if (this.kwh != null) {
                    this.kwh.cPA();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.aDd;
                int i = motionEvent.getY() - this.BF > 0.0f ? 1 : 2;
                if (this.kwi && this.kwh != null) {
                    this.kwh.c(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.kwj = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
