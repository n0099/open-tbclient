package com.baidu.tieba.kn;

import android.content.Context;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
public class TimerTextView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private d f1171a;
    private b b;

    public TimerTextView(Context context) {
        this(context, null, 0);
    }

    public TimerTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimerTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1171a = new d(this);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        float f = getContext().getResources().getDisplayMetrics().density;
        TextPaint paint = getPaint();
        float textSize = paint.getTextSize();
        paint.setTextSize(TypedValue.applyDimension(2, 10.0f, getResources().getDisplayMetrics()));
        float desiredWidth = Layout.getDesiredWidth("9分99秒", paint);
        paint.setTextSize(textSize);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.max((int) ((f * 60.0f) + desiredWidth), View.MeasureSpec.getSize(i)), 1073741824), i2);
    }

    public void setTimeInSeconds(long j) {
        this.b = new b(j);
        setText(this.b.toString());
        this.f1171a.removeMessages(65536);
        this.f1171a.sendEmptyMessageDelayed(65536, 1000L);
    }

    public void setOnCooldown(c cVar) {
        this.b.a(cVar);
    }

    public void a() {
        this.f1171a.removeMessages(65536);
    }
}
