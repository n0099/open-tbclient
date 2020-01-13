package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes8.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float Bn;
    private float ayM;
    private a kvd;
    private boolean kve;
    private boolean kvf;

    /* loaded from: classes8.dex */
    public interface a {
        void aN(float f);

        void c(float f, float f2, int i);

        void cOb();

        boolean d(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.kvd = aVar;
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
        this.kvf = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.ayM = motionEvent.getY();
                this.Bn = motionEvent.getY();
                if (this.kvd != null) {
                    this.kvd.aN(motionEvent.getY());
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
                if (this.kvd != null) {
                    this.kve = this.kvd.d(0.0f, motionEvent.getY(), 0);
                    return this.kve;
                }
                break;
            case 2:
                if (this.kvd != null) {
                    this.ayM = motionEvent.getY();
                    this.kve = this.kvd.d(motionEvent.getY() - this.ayM, motionEvent.getY(), motionEvent.getY() - this.Bn > 0.0f ? 1 : 2);
                    return this.kve;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.kvf) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.kve = false;
                if (this.kvd != null) {
                    this.kvd.cOb();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.ayM;
                int i = motionEvent.getY() - this.Bn > 0.0f ? 1 : 2;
                if (this.kve && this.kvd != null) {
                    this.kvd.c(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.kvf = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
