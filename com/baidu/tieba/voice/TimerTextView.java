package com.baidu.tieba.voice;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
public class TimerTextView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    int f2551a;

    public TimerTextView(Context context) {
        this(context, null, 0);
    }

    public TimerTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimerTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2551a = 0;
    }

    private int getContentWidth() {
        if (this.f2551a > 0) {
            return this.f2551a;
        }
        this.f2551a = ((int) Layout.getDesiredWidth("9'59\"", getPaint())) + getPaddingLeft() + getPaddingRight();
        return this.f2551a;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(getContentWidth(), 1073741824), i2);
    }
}
