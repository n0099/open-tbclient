package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
public class ShadowTextView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private Paint f6770a;

    /* renamed from: b  reason: collision with root package name */
    private RectF f6771b;
    private int c;

    public ShadowTextView(Context context) {
        this(context, null);
    }

    public ShadowTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 0;
        a();
    }

    private void a() {
        setTextColor(-1);
        this.f6770a = new Paint();
        this.f6770a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f6770a.setColor(Color.parseColor("#99333333"));
        this.f6770a.setAntiAlias(true);
        this.f6770a.setStrokeWidth(0.0f);
        this.f6771b = new RectF();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            this.c = (int) getPaint().measureText("00");
            if (measuredWidth < this.c) {
                measuredWidth = this.c;
            }
            int i3 = measuredWidth + ((measuredHeight / 2) * 2);
            setMeasuredDimension(i3, measuredHeight);
            this.f6771b.set(0.0f, 0.0f, i3, measuredHeight);
            return;
        }
        this.f6771b.set(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawRoundRect(this.f6771b, this.f6771b.bottom / 2.0f, this.f6771b.bottom / 2.0f, this.f6770a);
        canvas.translate((this.f6771b.right / 2.0f) - (getPaint().measureText(getText().toString()) / 2.0f), 0.0f);
        super.onDraw(canvas);
    }
}
