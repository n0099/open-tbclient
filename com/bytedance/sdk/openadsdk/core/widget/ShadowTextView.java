package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public class ShadowTextView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    public Paint f28522a;

    /* renamed from: b  reason: collision with root package name */
    public RectF f28523b;

    /* renamed from: c  reason: collision with root package name */
    public int f28524c;

    public ShadowTextView(Context context) {
        this(context, null);
    }

    private void a() {
        setTextColor(-1);
        Paint paint = new Paint();
        this.f28522a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f28522a.setColor(Color.parseColor("#99333333"));
        this.f28522a.setAntiAlias(true);
        this.f28522a.setStrokeWidth(0.0f);
        this.f28523b = new RectF();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF = this.f28523b;
        float f2 = rectF.bottom;
        canvas.drawRoundRect(rectF, f2 / 2.0f, f2 / 2.0f, this.f28522a);
        canvas.translate((this.f28523b.right / 2.0f) - (getPaint().measureText(getText().toString()) / 2.0f), 0.0f);
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            int measureText = (int) getPaint().measureText("00");
            this.f28524c = measureText;
            if (measuredWidth < measureText) {
                measuredWidth = measureText;
            }
            int i3 = measuredWidth + ((measuredHeight / 2) * 2);
            setMeasuredDimension(i3, measuredHeight);
            this.f28523b.set(0.0f, 0.0f, i3, measuredHeight);
            return;
        }
        this.f28523b.set(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public ShadowTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28524c = 0;
        a();
    }
}
