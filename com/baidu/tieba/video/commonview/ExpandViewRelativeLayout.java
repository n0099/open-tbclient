package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes10.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float Vr;
    private float bez;
    private a lBb;
    private boolean lBc;
    private boolean lBd;

    /* loaded from: classes10.dex */
    public interface a {
        void av(float f);

        void c(float f, float f2, int i);

        boolean d(float f, float f2, int i);

        void did();
    }

    public void setScrollCallBack(a aVar) {
        this.lBb = aVar;
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
        this.lBd = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bez = motionEvent.getY();
                this.Vr = motionEvent.getY();
                if (this.lBb != null) {
                    this.lBb.av(motionEvent.getY());
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
                if (this.lBb != null) {
                    this.lBc = this.lBb.d(0.0f, motionEvent.getY(), 0);
                    return this.lBc;
                }
                break;
            case 2:
                if (this.lBb != null) {
                    this.bez = motionEvent.getY();
                    this.lBc = this.lBb.d(motionEvent.getY() - this.bez, motionEvent.getY(), motionEvent.getY() - this.Vr > 0.0f ? 1 : 2);
                    return this.lBc;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.lBd) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.lBc = false;
                if (this.lBb != null) {
                    this.lBb.did();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.bez;
                int i = motionEvent.getY() - this.Vr > 0.0f ? 1 : 2;
                if (this.lBc && this.lBb != null) {
                    this.lBb.c(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.lBd = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
