package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes17.dex */
public class ExpandViewRelativeLayout extends RelativeLayout {
    private float VN;
    private float bke;
    private a mdl;
    private boolean mdm;
    private boolean mdn;

    /* loaded from: classes17.dex */
    public interface a {
        void az(float f);

        void c(float f, float f2, int i);

        boolean d(float f, float f2, int i);

        void dpT();
    }

    public void setScrollCallBack(a aVar) {
        this.mdl = aVar;
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
        this.mdn = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bke = motionEvent.getY();
                this.VN = motionEvent.getY();
                if (this.mdl != null) {
                    this.mdl.az(motionEvent.getY());
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
                if (this.mdl != null) {
                    this.mdm = this.mdl.d(0.0f, motionEvent.getY(), 0);
                    return this.mdm;
                }
                break;
            case 2:
                if (this.mdl != null) {
                    this.bke = motionEvent.getY();
                    this.mdm = this.mdl.d(motionEvent.getY() - this.bke, motionEvent.getY(), motionEvent.getY() - this.VN > 0.0f ? 1 : 2);
                    return this.mdm;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mdn) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mdm = false;
                if (this.mdl != null) {
                    this.mdl.dpT();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.bke;
                int i = motionEvent.getY() - this.VN > 0.0f ? 1 : 2;
                if (this.mdm && this.mdl != null) {
                    this.mdl.c(motionEvent.getY(), y, i);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsCanLayout(boolean z) {
        this.mdn = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(false);
    }
}
