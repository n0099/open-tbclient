package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class ClickableLayout4Frame extends FrameLayout {
    private q a;

    public ClickableLayout4Frame(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
    }

    public ClickableLayout4Frame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
    }

    public ClickableLayout4Frame(Context context) {
        super(context);
        this.a = null;
    }

    public void setOnkeyUpListener(q qVar) {
        this.a = qVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && this.a != null) {
            this.a.a();
        }
        return dispatchTouchEvent;
    }
}
