package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes10.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float UZ;
    private float aXa;
    private a lim;
    private boolean lin;
    private boolean lio;

    /* loaded from: classes10.dex */
    public interface a {
        void aw(float f);

        void c(float f, float f2, int i);

        boolean d(float f, float f2, int i);

        void daR();
    }

    public void setScrollCallBack(a aVar) {
        this.lim = aVar;
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
        this.lio = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.aXa = motionEvent.getY();
                this.UZ = motionEvent.getY();
                if (this.lim != null) {
                    this.lim.aw(motionEvent.getY());
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
                if (this.lim != null) {
                    this.lin = this.lim.d(0.0f, motionEvent.getY(), 0);
                    return this.lin;
                }
                break;
            case 2:
                if (this.lim != null) {
                    this.aXa = motionEvent.getY();
                    this.lin = this.lim.d(motionEvent.getY() - this.aXa, motionEvent.getY(), motionEvent.getY() - this.UZ > 0.0f ? 1 : 2);
                    return this.lin;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.lio) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.lin = false;
                if (this.lim != null) {
                    this.lim.daR();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.aXa;
                int i = motionEvent.getY() - this.UZ > 0.0f ? 1 : 2;
                if (this.lin && this.lim != null) {
                    this.lim.c(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.lio = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
