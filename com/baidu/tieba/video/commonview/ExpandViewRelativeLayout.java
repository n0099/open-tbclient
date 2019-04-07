package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes5.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float Qm;
    private float aHe;
    private a iVP;
    private boolean iVQ;
    private boolean iVR;

    /* loaded from: classes5.dex */
    public interface a {
        void aO(float f);

        void cjg();

        void d(float f, float f2, int i);

        boolean e(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.iVP = aVar;
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
        this.iVR = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.aHe = motionEvent.getY();
                this.Qm = motionEvent.getY();
                if (this.iVP != null) {
                    this.iVP.aO(motionEvent.getY());
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
                if (this.iVP != null) {
                    this.iVQ = this.iVP.e(0.0f, motionEvent.getY(), 0);
                    return this.iVQ;
                }
                break;
            case 2:
                if (this.iVP != null) {
                    this.aHe = motionEvent.getY();
                    this.iVQ = this.iVP.e(motionEvent.getY() - this.aHe, motionEvent.getY(), motionEvent.getY() - this.Qm > 0.0f ? 1 : 2);
                    return this.iVQ;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.iVR) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.iVQ = false;
                if (this.iVP != null) {
                    this.iVP.cjg();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.aHe;
                int i = motionEvent.getY() - this.Qm > 0.0f ? 1 : 2;
                if (this.iVQ && this.iVP != null) {
                    this.iVP.d(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.iVR = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
