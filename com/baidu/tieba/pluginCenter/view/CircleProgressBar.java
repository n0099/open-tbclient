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
    public Paint f20078e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f20079f;

    /* renamed from: g  reason: collision with root package name */
    public float f20080g;

    /* renamed from: h  reason: collision with root package name */
    public int f20081h;

    /* renamed from: i  reason: collision with root package name */
    public RectF f20082i;

    public CircleProgressBar(Context context) {
        super(context);
        this.f20080g = 5.0f;
        a();
    }

    public final void a() {
        this.f20082i = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        Paint paint = new Paint();
        this.f20078e = paint;
        paint.setAntiAlias(true);
        this.f20078e.setDither(true);
        this.f20078e.setStyle(Paint.Style.STROKE);
        this.f20078e.setStrokeCap(Paint.Cap.ROUND);
        this.f20078e.setStrokeWidth(this.f20080g);
        Paint paint2 = new Paint();
        this.f20079f = paint2;
        paint2.setAntiAlias(true);
        this.f20079f.setDither(true);
        this.f20079f.setStyle(Paint.Style.STROKE);
        this.f20079f.setStrokeCap(Paint.Cap.ROUND);
        this.f20079f.setStrokeWidth(this.f20080g);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f20081h >= 0) {
            RectF rectF = this.f20082i;
            float f2 = this.f20080g;
            rectF.left = f2;
            rectF.top = f2;
            rectF.right = getWidth() - this.f20080g;
            this.f20082i.bottom = getHeight() - this.f20080g;
            canvas.drawArc(this.f20082i, 0.0f, 360.0f, false, this.f20079f);
            canvas.drawArc(this.f20082i, -90.0f, (this.f20081h / 100) * 360.0f, false, this.f20078e);
        }
    }

    public void setCircleBackgroundColor(int i2) {
        this.f20079f.setColor(i2);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i2) {
        this.f20078e.setColor(i2);
        postInvalidate();
    }

    public void setProgress(int i2) {
        this.f20081h = i2;
        postInvalidate();
    }

    public void setWidth(int i2) {
        float f2 = i2;
        this.f20080g = f2;
        this.f20079f.setStrokeWidth(f2);
        this.f20078e.setStrokeWidth(f2);
        postInvalidate();
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20080g = 5.0f;
        a();
    }
}
