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
    public int f22184e;

    /* renamed from: f  reason: collision with root package name */
    public int f22185f;

    /* renamed from: g  reason: collision with root package name */
    public int f22186g;

    /* renamed from: h  reason: collision with root package name */
    public int f22187h;

    /* renamed from: i  reason: collision with root package name */
    public float f22188i;
    public Paint j;

    public RoundProgressBar(Context context) {
        this(context, null);
    }

    public void a() {
        this.f22187h = 4;
        this.f22184e = Color.rgb(255, 255, 255);
    }

    public void b(float f2) {
        this.f22188i = f2;
        invalidate();
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f22185f = getWidth();
        int height = getHeight();
        this.f22186g = height;
        if (this.f22185f > height) {
            this.f22185f = height;
        }
        this.j.setAntiAlias(true);
        this.j.setStyle(Paint.Style.STROKE);
        this.j.setStrokeWidth(this.f22187h);
        this.j.setColor(this.f22184e);
        canvas.drawArc(new RectF(5.0f, 5.0f, this.f22185f - 5, this.f22186g - 5), 270.0f, (this.f22188i * 360.0f) / 100.0f, false, this.j);
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
