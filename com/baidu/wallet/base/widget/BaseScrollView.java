package com.baidu.wallet.base.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
/* loaded from: classes5.dex */
public class BaseScrollView extends ScrollView {
    public BaseScrollView(Context context) {
        super(context);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public BaseScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
