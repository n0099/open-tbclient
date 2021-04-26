package com.baidu.tieba.pluginCenter.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes4.dex */
public class CircleProgressBar extends View {

    /* renamed from: e  reason: collision with root package name */
    public Paint f20791e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f20792f;

    /* renamed from: g  reason: collision with root package name */
    public float f20793g;

    /* renamed from: h  reason: collision with root package name */
    public int f20794h;

    /* renamed from: i  reason: collision with root package name */
    public RectF f20795i;

    public CircleProgressBar(Context context) {
        super(context);
        this.f20793g = 5.0f;
        a();
    }

    public final void a() {
        this.f20795i = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        Paint paint = new Paint();
        this.f20791e = paint;
        paint.setAntiAlias(true);
        this.f20791e.setDither(true);
        this.f20791e.setStyle(Paint.Style.STROKE);
        this.f20791e.setStrokeCap(Paint.Cap.ROUND);
        this.f20791e.setStrokeWidth(this.f20793g);
        Paint paint2 = new Paint();
        this.f20792f = paint2;
        paint2.setAntiAlias(true);
        this.f20792f.setDither(true);
        this.f20792f.setStyle(Paint.Style.STROKE);
        this.f20792f.setStrokeCap(Paint.Cap.ROUND);
        this.f20792f.setStrokeWidth(this.f20793g);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f20794h >= 0) {
            RectF rectF = this.f20795i;
            float f2 = this.f20793g;
            rectF.left = f2;
            rectF.top = f2;
            rectF.right = getWidth() - this.f20793g;
            this.f20795i.bottom = getHeight() - this.f20793g;
            canvas.drawArc(this.f20795i, 0.0f, 360.0f, false, this.f20792f);
            canvas.drawArc(this.f20795i, -90.0f, (this.f20794h / 100) * 360.0f, false, this.f20791e);
        }
    }

    public void setCircleBackgroundColor(int i2) {
        this.f20792f.setColor(i2);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i2) {
        this.f20791e.setColor(i2);
        postInvalidate();
    }

    public void setProgress(int i2) {
        this.f20794h = i2;
        postInvalidate();
    }

    public void setWidth(int i2) {
        float f2 = i2;
        this.f20793g = f2;
        this.f20792f.setStrokeWidth(f2);
        this.f20791e.setStrokeWidth(f2);
        postInvalidate();
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20793g = 5.0f;
        a();
    }
}
