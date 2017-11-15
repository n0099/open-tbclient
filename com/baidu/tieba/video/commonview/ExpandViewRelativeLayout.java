package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes2.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private a gEF;
    private boolean gEG;
    private float gEH;
    private boolean gEI;
    private float mLastY;

    /* loaded from: classes2.dex */
    public interface a {
        void ae(float f);

        void byM();

        void d(float f, float f2, int i);

        boolean e(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.gEF = aVar;
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
        this.gEI = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.gEH = motionEvent.getY();
                this.mLastY = motionEvent.getY();
                if (this.gEF != null) {
                    this.gEF.ae(motionEvent.getY());
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
                if (this.gEF != null) {
                    this.gEG = this.gEF.e(0.0f, motionEvent.getY(), 0);
                    return this.gEG;
                }
                break;
            case 2:
                if (this.gEF != null) {
                    this.gEH = motionEvent.getY();
                    this.gEG = this.gEF.e(motionEvent.getY() - this.gEH, motionEvent.getY(), motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2);
                    return this.gEG;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.gEI) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.gEG = false;
                if (this.gEF != null) {
                    this.gEF.byM();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.gEH;
                int i = motionEvent.getY() - this.mLastY > 0.0f ? 1 : 2;
                if (this.gEG && this.gEF != null) {
                    this.gEF.d(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.gEI = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
