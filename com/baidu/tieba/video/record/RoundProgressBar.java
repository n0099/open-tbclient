package com.baidu.tieba.video.record;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes5.dex */
public class RoundProgressBar extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f21859e;

    /* renamed from: f  reason: collision with root package name */
    public int f21860f;

    /* renamed from: g  reason: collision with root package name */
    public int f21861g;

    /* renamed from: h  reason: collision with root package name */
    public int f21862h;
    public float i;
    public Paint j;

    public RoundProgressBar(Context context) {
        this(context, null);
    }

    public void a() {
        this.f21862h = 4;
        this.f21859e = Color.rgb(255, 255, 255);
    }

    public void b(float f2) {
        this.i = f2;
        invalidate();
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f21860f = getWidth();
        int height = getHeight();
        this.f21861g = height;
        if (this.f21860f > height) {
            this.f21860f = height;
        }
        this.j.setAntiAlias(true);
        this.j.setStyle(Paint.Style.STROKE);
        this.j.setStrokeWidth(this.f21862h);
        this.j.setColor(this.f21859e);
        canvas.drawArc(new RectF(5.0f, 5.0f, this.f21860f - 5, this.f21861g - 5), 270.0f, (this.i * 360.0f) / 100.0f, false, this.j);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = new Paint();
        a();
    }
}
