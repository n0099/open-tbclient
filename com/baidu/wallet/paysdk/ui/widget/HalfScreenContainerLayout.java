package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
/* loaded from: classes5.dex */
public class HalfScreenContainerLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public boolean f26391a;

    public HalfScreenContainerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f26391a = false;
    }

    @Override // android.view.View
    public boolean isClickable() {
        return !this.f26391a;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f26391a;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.f26391a = !z;
    }
}
