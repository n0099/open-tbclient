package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes2.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float fVd;
    private a hkW;
    private boolean hkX;
    private float hkY;
    private boolean hkZ;

    /* loaded from: classes2.dex */
    public interface a {
        void ay(float f);

        void bDs();

        void c(float f, float f2, int i);

        boolean d(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.hkW = aVar;
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
        this.hkZ = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.hkY = motionEvent.getY();
                this.fVd = motionEvent.getY();
                if (this.hkW != null) {
                    this.hkW.ay(motionEvent.getY());
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
                if (this.hkW != null) {
                    this.hkX = this.hkW.d(0.0f, motionEvent.getY(), 0);
                    return this.hkX;
                }
                break;
            case 2:
                if (this.hkW != null) {
                    this.hkY = motionEvent.getY();
                    this.hkX = this.hkW.d(motionEvent.getY() - this.hkY, motionEvent.getY(), motionEvent.getY() - this.fVd > 0.0f ? 1 : 2);
                    return this.hkX;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.hkZ) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.hkX = false;
                if (this.hkW != null) {
                    this.hkW.bDs();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.hkY;
                int i = motionEvent.getY() - this.fVd > 0.0f ? 1 : 2;
                if (this.hkX && this.hkW != null) {
                    this.hkW.c(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.hkZ = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
