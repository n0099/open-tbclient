package com.baidu.tieba.newfaceshop.facemake;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes9.dex */
public class FaceImageLayout extends FrameLayout {
    private a lBU;

    /* loaded from: classes9.dex */
    public interface a {
        void diJ();
    }

    public FaceImageLayout(Context context) {
        super(context);
    }

    public FaceImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FaceImageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.lBU != null) {
            this.lBU.diJ();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setListener(a aVar) {
        this.lBU = aVar;
    }
}
