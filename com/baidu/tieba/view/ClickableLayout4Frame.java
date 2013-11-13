package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class ClickableLayout4Frame extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private g f2527a;

    public ClickableLayout4Frame(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2527a = null;
    }

    public ClickableLayout4Frame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2527a = null;
    }

    public ClickableLayout4Frame(Context context) {
        super(context);
        this.f2527a = null;
    }

    public void setOnkeyUpListener(g gVar) {
        this.f2527a = gVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && this.f2527a != null) {
            this.f2527a.a();
        }
        return dispatchTouchEvent;
    }
}
