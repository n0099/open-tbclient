package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes17.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float VN;
    private float bke;
    private a mdj;
    private boolean mdk;
    private boolean mdl;

    /* loaded from: classes17.dex */
    public interface a {
        void az(float f);

        void c(float f, float f2, int i);

        boolean d(float f, float f2, int i);

        void dpS();
    }

    public void setScrollCallBack(a aVar) {
        this.mdj = aVar;
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
        this.mdl = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bke = motionEvent.getY();
                this.VN = motionEvent.getY();
                if (this.mdj != null) {
                    this.mdj.az(motionEvent.getY());
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
                if (this.mdj != null) {
                    this.mdk = this.mdj.d(0.0f, motionEvent.getY(), 0);
                    return this.mdk;
                }
                break;
            case 2:
                if (this.mdj != null) {
                    this.bke = motionEvent.getY();
                    this.mdk = this.mdj.d(motionEvent.getY() - this.bke, motionEvent.getY(), motionEvent.getY() - this.VN > 0.0f ? 1 : 2);
                    return this.mdk;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mdl) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mdk = false;
                if (this.mdj != null) {
                    this.mdj.dpS();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.bke;
                int i = motionEvent.getY() - this.VN > 0.0f ? 1 : 2;
                if (this.mdk && this.mdj != null) {
                    this.mdj.c(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.mdl = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
