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
    private Paint f7070a;

    /* renamed from: b  reason: collision with root package name */
    private RectF f7071b;
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
        this.f7070a = new Paint();
        this.f7070a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f7070a.setColor(Color.parseColor("#99333333"));
        this.f7070a.setAntiAlias(true);
        this.f7070a.setStrokeWidth(0.0f);
        this.f7071b = new RectF();
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
            this.f7071b.set(0.0f, 0.0f, i3, measuredHeight);
            return;
        }
        this.f7071b.set(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawRoundRect(this.f7071b, this.f7071b.bottom / 2.0f, this.f7071b.bottom / 2.0f, this.f7070a);
        canvas.translate((this.f7071b.right / 2.0f) - (getPaint().measureText(getText().toString()) / 2.0f), 0.0f);
        super.onDraw(canvas);
    }
}
