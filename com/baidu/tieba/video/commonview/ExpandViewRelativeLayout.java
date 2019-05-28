package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes5.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float NU;
    private float aIY;
    private a joO;
    private boolean joP;
    private boolean joQ;

    /* loaded from: classes5.dex */
    public interface a {
        void aS(float f);

        void crl();

        void d(float f, float f2, int i);

        boolean e(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.joO = aVar;
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
        this.joQ = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.aIY = motionEvent.getY();
                this.NU = motionEvent.getY();
                if (this.joO != null) {
                    this.joO.aS(motionEvent.getY());
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
                if (this.joO != null) {
                    this.joP = this.joO.e(0.0f, motionEvent.getY(), 0);
                    return this.joP;
                }
                break;
            case 2:
                if (this.joO != null) {
                    this.aIY = motionEvent.getY();
                    this.joP = this.joO.e(motionEvent.getY() - this.aIY, motionEvent.getY(), motionEvent.getY() - this.NU > 0.0f ? 1 : 2);
                    return this.joP;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.joQ) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.joP = false;
                if (this.joO != null) {
                    this.joO.crl();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.aIY;
                int i = motionEvent.getY() - this.NU > 0.0f ? 1 : 2;
                if (this.joP && this.joO != null) {
                    this.joO.d(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.joQ = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
