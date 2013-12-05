package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class ClickableLayout4Frame extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private h f2624a;

    public ClickableLayout4Frame(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2624a = null;
    }

    public ClickableLayout4Frame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2624a = null;
    }

    public ClickableLayout4Frame(Context context) {
        super(context);
        this.f2624a = null;
    }

    public void setOnkeyUpListener(h hVar) {
        this.f2624a = hVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && this.f2624a != null) {
            this.f2624a.a();
        }
        return dispatchTouchEvent;
    }
}
