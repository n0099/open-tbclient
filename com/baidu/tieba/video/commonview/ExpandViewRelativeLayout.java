package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes2.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float fNq;
    private a hdd;
    private boolean hde;
    private float hdf;
    private boolean hdg;

    /* loaded from: classes2.dex */
    public interface a {
        void aF(float f);

        void bAB();

        void c(float f, float f2, int i);

        boolean d(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.hdd = aVar;
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
        this.hdg = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.hdf = motionEvent.getY();
                this.fNq = motionEvent.getY();
                if (this.hdd != null) {
                    this.hdd.aF(motionEvent.getY());
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
                if (this.hdd != null) {
                    this.hde = this.hdd.d(0.0f, motionEvent.getY(), 0);
                    return this.hde;
                }
                break;
            case 2:
                if (this.hdd != null) {
                    this.hdf = motionEvent.getY();
                    this.hde = this.hdd.d(motionEvent.getY() - this.hdf, motionEvent.getY(), motionEvent.getY() - this.fNq > 0.0f ? 1 : 2);
                    return this.hde;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.hdg) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.hde = false;
                if (this.hdd != null) {
                    this.hdd.bAB();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.hdf;
                int i = motionEvent.getY() - this.fNq > 0.0f ? 1 : 2;
                if (this.hde && this.hdd != null) {
                    this.hdd.c(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.hdg = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
