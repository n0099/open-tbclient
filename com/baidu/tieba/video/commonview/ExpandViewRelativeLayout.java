package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes5.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float NT;
    private float aIY;
    private a joS;
    private boolean joT;
    private boolean joU;

    /* loaded from: classes5.dex */
    public interface a {
        void aS(float f);

        void crm();

        void d(float f, float f2, int i);

        boolean e(float f, float f2, int i);
    }

    public void setScrollCallBack(a aVar) {
        this.joS = aVar;
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
        this.joU = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.aIY = motionEvent.getY();
                this.NT = motionEvent.getY();
                if (this.joS != null) {
                    this.joS.aS(motionEvent.getY());
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
                if (this.joS != null) {
                    this.joT = this.joS.e(0.0f, motionEvent.getY(), 0);
                    return this.joT;
                }
                break;
            case 2:
                if (this.joS != null) {
                    this.aIY = motionEvent.getY();
                    this.joT = this.joS.e(motionEvent.getY() - this.aIY, motionEvent.getY(), motionEvent.getY() - this.NT > 0.0f ? 1 : 2);
                    return this.joT;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.joU) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.joT = false;
                if (this.joS != null) {
                    this.joS.crm();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.aIY;
                int i = motionEvent.getY() - this.NT > 0.0f ? 1 : 2;
                if (this.joT && this.joS != null) {
                    this.joS.d(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.joU = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
