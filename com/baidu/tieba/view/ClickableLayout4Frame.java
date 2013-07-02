package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class ClickableLayout4Frame extends FrameLayout {
    private long a;
    private f b;

    public ClickableLayout4Frame(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = null;
    }

    public ClickableLayout4Frame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
    }

    public ClickableLayout4Frame(Context context) {
        super(context);
        this.b = null;
    }

    public void setOnkeyUpListener(f fVar) {
        this.b = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && this.b != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.a < 300) {
                this.b.b();
            } else {
                this.b.a();
            }
            this.a = currentTimeMillis;
        }
        return dispatchTouchEvent;
    }
}
