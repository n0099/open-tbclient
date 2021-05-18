package com.baidu.tieba.pluginCenter.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes5.dex */
public class CircleProgressBar extends View {

    /* renamed from: e  reason: collision with root package name */
    public Paint f20079e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f20080f;

    /* renamed from: g  reason: collision with root package name */
    public float f20081g;

    /* renamed from: h  reason: collision with root package name */
    public int f20082h;

    /* renamed from: i  reason: collision with root package name */
    public RectF f20083i;

    public CircleProgressBar(Context context) {
        super(context);
        this.f20081g = 5.0f;
        a();
    }

    public final void a() {
        this.f20083i = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        Paint paint = new Paint();
        this.f20079e = paint;
        paint.setAntiAlias(true);
        this.f20079e.setDither(true);
        this.f20079e.setStyle(Paint.Style.STROKE);
        this.f20079e.setStrokeCap(Paint.Cap.ROUND);
        this.f20079e.setStrokeWidth(this.f20081g);
        Paint paint2 = new Paint();
        this.f20080f = paint2;
        paint2.setAntiAlias(true);
        this.f20080f.setDither(true);
        this.f20080f.setStyle(Paint.Style.STROKE);
        this.f20080f.setStrokeCap(Paint.Cap.ROUND);
        this.f20080f.setStrokeWidth(this.f20081g);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f20082h >= 0) {
            RectF rectF = this.f20083i;
            float f2 = this.f20081g;
            rectF.left = f2;
            rectF.top = f2;
            rectF.right = getWidth() - this.f20081g;
            this.f20083i.bottom = getHeight() - this.f20081g;
            canvas.drawArc(this.f20083i, 0.0f, 360.0f, false, this.f20080f);
            canvas.drawArc(this.f20083i, -90.0f, (this.f20082h / 100) * 360.0f, false, this.f20079e);
        }
    }

    public void setCircleBackgroundColor(int i2) {
        this.f20080f.setColor(i2);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i2) {
        this.f20079e.setColor(i2);
        postInvalidate();
    }

    public void setProgress(int i2) {
        this.f20082h = i2;
        postInvalidate();
    }

    public void setWidth(int i2) {
        float f2 = i2;
        this.f20081g = f2;
        this.f20080f.setStrokeWidth(f2);
        this.f20079e.setStrokeWidth(f2);
        postInvalidate();
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20081g = 5.0f;
        a();
    }
}
