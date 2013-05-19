package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class ClickableLayout extends LinearLayout {
    private e a;

    public ClickableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
    }

    public ClickableLayout(Context context) {
        super(context);
        this.a = null;
    }

    public void setOnkeyUpListener(e eVar) {
        this.a = eVar;
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
