package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class ClickableLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private e f1481a;

    public ClickableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1481a = null;
    }

    public ClickableLayout(Context context) {
        super(context);
        this.f1481a = null;
    }

    public void setOnkeyUpListener(e eVar) {
        this.f1481a = eVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && this.f1481a != null) {
            this.f1481a.a();
        }
        return dispatchTouchEvent;
    }
}
