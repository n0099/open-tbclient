package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes5.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float gcE;
    private a hsn;
    private boolean hso;
    private boolean hsp;
    private float mStartY;

    /* loaded from: classes5.dex */
    public interface a {
        void az(float f);

        void bGG();

        void c(float f, float f2, int i);

        boolean d(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.hsn = aVar;
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
        this.hsp = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mStartY = motionEvent.getY();
                this.gcE = motionEvent.getY();
                if (this.hsn != null) {
                    this.hsn.az(motionEvent.getY());
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
                if (this.hsn != null) {
                    this.hso = this.hsn.d(0.0f, motionEvent.getY(), 0);
                    return this.hso;
                }
                break;
            case 2:
                if (this.hsn != null) {
                    this.mStartY = motionEvent.getY();
                    this.hso = this.hsn.d(motionEvent.getY() - this.mStartY, motionEvent.getY(), motionEvent.getY() - this.gcE > 0.0f ? 1 : 2);
                    return this.hso;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.hsp) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.hso = false;
                if (this.hsn != null) {
                    this.hsn.bGG();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.mStartY;
                int i = motionEvent.getY() - this.gcE > 0.0f ? 1 : 2;
                if (this.hso && this.hsn != null) {
                    this.hsn.c(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.hsp = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
