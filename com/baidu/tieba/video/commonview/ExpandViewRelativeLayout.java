package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes7.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float Bi;
    private float ayd;
    private a krA;
    private boolean krB;
    private boolean krC;

    /* loaded from: classes7.dex */
    public interface a {
        void aO(float f);

        void c(float f, float f2, int i);

        void cMW();

        boolean d(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.krA = aVar;
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
        this.krC = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.ayd = motionEvent.getY();
                this.Bi = motionEvent.getY();
                if (this.krA != null) {
                    this.krA.aO(motionEvent.getY());
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
                if (this.krA != null) {
                    this.krB = this.krA.d(0.0f, motionEvent.getY(), 0);
                    return this.krB;
                }
                break;
            case 2:
                if (this.krA != null) {
                    this.ayd = motionEvent.getY();
                    this.krB = this.krA.d(motionEvent.getY() - this.ayd, motionEvent.getY(), motionEvent.getY() - this.Bi > 0.0f ? 1 : 2);
                    return this.krB;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.krC) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.krB = false;
                if (this.krA != null) {
                    this.krA.cMW();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.ayd;
                int i = motionEvent.getY() - this.Bi > 0.0f ? 1 : 2;
                if (this.krB && this.krA != null) {
                    this.krA.c(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.krC = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
