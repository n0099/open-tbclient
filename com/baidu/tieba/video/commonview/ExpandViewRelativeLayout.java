package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes8.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float Bn;
    private float ayM;
    private a kvi;
    private boolean kvj;
    private boolean kvk;

    /* loaded from: classes8.dex */
    public interface a {
        void aN(float f);

        void c(float f, float f2, int i);

        void cOd();

        boolean d(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.kvi = aVar;
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
        this.kvk = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.ayM = motionEvent.getY();
                this.Bn = motionEvent.getY();
                if (this.kvi != null) {
                    this.kvi.aN(motionEvent.getY());
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
                if (this.kvi != null) {
                    this.kvj = this.kvi.d(0.0f, motionEvent.getY(), 0);
                    return this.kvj;
                }
                break;
            case 2:
                if (this.kvi != null) {
                    this.ayM = motionEvent.getY();
                    this.kvj = this.kvi.d(motionEvent.getY() - this.ayM, motionEvent.getY(), motionEvent.getY() - this.Bn > 0.0f ? 1 : 2);
                    return this.kvj;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.kvk) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.kvj = false;
                if (this.kvi != null) {
                    this.kvi.cOd();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.ayM;
                int i = motionEvent.getY() - this.Bn > 0.0f ? 1 : 2;
                if (this.kvj && this.kvi != null) {
                    this.kvi.c(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.kvk = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
