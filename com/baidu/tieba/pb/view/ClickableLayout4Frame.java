package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class ClickableLayout4Frame extends FrameLayout {
    private b bOv;

    public ClickableLayout4Frame(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bOv = null;
    }

    public ClickableLayout4Frame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bOv = null;
    }

    public ClickableLayout4Frame(Context context) {
        super(context);
        this.bOv = null;
    }

    public void setOnkeyUpListener(b bVar) {
        this.bOv = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && this.bOv != null) {
            this.bOv.acy();
        }
        return dispatchTouchEvent;
    }
}
