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
    public int f21517e;

    /* renamed from: f  reason: collision with root package name */
    public int f21518f;

    /* renamed from: g  reason: collision with root package name */
    public int f21519g;

    /* renamed from: h  reason: collision with root package name */
    public int f21520h;

    /* renamed from: i  reason: collision with root package name */
    public float f21521i;
    public Paint j;

    public RoundProgressBar(Context context) {
        this(context, null);
    }

    public void a() {
        this.f21520h = 4;
        this.f21517e = Color.rgb(255, 255, 255);
    }

    public void b(float f2) {
        this.f21521i = f2;
        invalidate();
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f21518f = getWidth();
        int height = getHeight();
        this.f21519g = height;
        if (this.f21518f > height) {
            this.f21518f = height;
        }
        this.j.setAntiAlias(true);
        this.j.setStyle(Paint.Style.STROKE);
        this.j.setStrokeWidth(this.f21520h);
        this.j.setColor(this.f21517e);
        canvas.drawArc(new RectF(5.0f, 5.0f, this.f21518f - 5, this.f21519g - 5), 270.0f, (this.f21521i * 360.0f) / 100.0f, false, this.j);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.j = new Paint();
        a();
    }
}
