package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class ShadowTextView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    public Paint f28641a;

    /* renamed from: b  reason: collision with root package name */
    public RectF f28642b;

    /* renamed from: c  reason: collision with root package name */
    public int f28643c;

    public ShadowTextView(Context context) {
        this(context, null);
    }

    private void a() {
        setTextColor(-1);
        Paint paint = new Paint();
        this.f28641a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f28641a.setColor(Color.parseColor("#99333333"));
        this.f28641a.setAntiAlias(true);
        this.f28641a.setStrokeWidth(0.0f);
        this.f28642b = new RectF();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF = this.f28642b;
        float f2 = rectF.bottom;
        canvas.drawRoundRect(rectF, f2 / 2.0f, f2 / 2.0f, this.f28641a);
        canvas.translate((this.f28642b.right / 2.0f) - (getPaint().measureText(getText().toString()) / 2.0f), 0.0f);
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            int measureText = (int) getPaint().measureText("00");
            this.f28643c = measureText;
            if (measuredWidth < measureText) {
                measuredWidth = measureText;
            }
            int i4 = measuredWidth + ((measuredHeight / 2) * 2);
            setMeasuredDimension(i4, measuredHeight);
            this.f28642b.set(0.0f, 0.0f, i4, measuredHeight);
            return;
        }
        this.f28642b.set(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public ShadowTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowTextView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f28643c = 0;
        a();
    }
}
