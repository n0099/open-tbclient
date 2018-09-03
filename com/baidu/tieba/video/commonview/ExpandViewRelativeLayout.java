package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes2.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float fNj;
    private a hde;
    private boolean hdf;
    private float hdg;
    private boolean hdh;

    /* loaded from: classes2.dex */
    public interface a {
        void aE(float f);

        void bAD();

        void c(float f, float f2, int i);

        boolean d(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.hde = aVar;
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
        this.hdh = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.hdg = motionEvent.getY();
                this.fNj = motionEvent.getY();
                if (this.hde != null) {
                    this.hde.aE(motionEvent.getY());
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
                if (this.hde != null) {
                    this.hdf = this.hde.d(0.0f, motionEvent.getY(), 0);
                    return this.hdf;
                }
                break;
            case 2:
                if (this.hde != null) {
                    this.hdg = motionEvent.getY();
                    this.hdf = this.hde.d(motionEvent.getY() - this.hdg, motionEvent.getY(), motionEvent.getY() - this.fNj > 0.0f ? 1 : 2);
                    return this.hdf;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.hdh) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.hdf = false;
                if (this.hde != null) {
                    this.hde.bAD();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.hdg;
                int i = motionEvent.getY() - this.fNj > 0.0f ? 1 : 2;
                if (this.hdf && this.hde != null) {
                    this.hde.c(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.hdh = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
