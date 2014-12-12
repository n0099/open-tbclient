package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class ClickableLayout4Frame extends FrameLayout {
    private c cdl;

    public ClickableLayout4Frame(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cdl = null;
    }

    public ClickableLayout4Frame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cdl = null;
    }

    public ClickableLayout4Frame(Context context) {
        super(context);
        this.cdl = null;
    }

    public void setOnkeyUpListener(c cVar) {
        this.cdl = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && this.cdl != null) {
            this.cdl.ajE();
        }
        return dispatchTouchEvent;
    }
}
