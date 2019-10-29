package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes5.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float aqG;
    private a jyu;
    private boolean jyv;
    private boolean jyw;
    private float mLastY;

    /* loaded from: classes5.dex */
    public interface a {
        void ax(float f);

        void c(float f, float f2, int i);

        void csW();

        boolean d(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.jyu = aVar;
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
        this.jyw = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.aqG = motionEvent.getY();
                this.mLastY = motionEvent.getY();
                if (this.jyu != null) {
                    this.jyu.ax(motionEvent.getY());
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
                if (this.jyu != null) {
                    this.jyv = this.jyu.d(0.0f, motionEvent.getY(), 0);
                    return this.jyv;
                }
                break;
            case 2:
                if (this.jyu != null) {
                    this.aqG = motionEvent.getY();
                    this.jyv = this.jyu.d(motionEvent.getY() - this.aqG, motionEvent.getY(), motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2);
                    return this.jyv;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.jyw) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.jyv = false;
                if (this.jyu != null) {
                    this.jyu.csW();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.aqG;
                int i = motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2;
                if (this.jyv && this.jyu != null) {
                    this.jyu.c(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.jyw = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
