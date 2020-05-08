package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes10.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float Vc;
    private float aXf;
    private a liq;
    private boolean lir;
    private boolean lis;

    /* loaded from: classes10.dex */
    public interface a {
        void aw(float f);

        void c(float f, float f2, int i);

        boolean d(float f, float f2, int i);

        void daO();
    }

    public void setScrollCallBack(a aVar) {
        this.liq = aVar;
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
        this.lis = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.aXf = motionEvent.getY();
                this.Vc = motionEvent.getY();
                if (this.liq != null) {
                    this.liq.aw(motionEvent.getY());
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
                if (this.liq != null) {
                    this.lir = this.liq.d(0.0f, motionEvent.getY(), 0);
                    return this.lir;
                }
                break;
            case 2:
                if (this.liq != null) {
                    this.aXf = motionEvent.getY();
                    this.lir = this.liq.d(motionEvent.getY() - this.aXf, motionEvent.getY(), motionEvent.getY() - this.Vc > 0.0f ? 1 : 2);
                    return this.lir;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.lis) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.lir = false;
                if (this.liq != null) {
                    this.liq.daO();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.aXf;
                int i = motionEvent.getY() - this.Vc > 0.0f ? 1 : 2;
                if (this.lir && this.liq != null) {
                    this.liq.c(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.lis = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
