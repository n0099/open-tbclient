package com.baidu.tieba.pluginCenter.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class CircleProgressBar extends View {

    /* renamed from: e  reason: collision with root package name */
    public Paint f20252e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f20253f;

    /* renamed from: g  reason: collision with root package name */
    public float f20254g;

    /* renamed from: h  reason: collision with root package name */
    public int f20255h;
    public RectF i;

    public CircleProgressBar(Context context) {
        super(context);
        this.f20254g = 5.0f;
        a();
    }

    public final void a() {
        this.i = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        Paint paint = new Paint();
        this.f20252e = paint;
        paint.setAntiAlias(true);
        this.f20252e.setDither(true);
        this.f20252e.setStyle(Paint.Style.STROKE);
        this.f20252e.setStrokeCap(Paint.Cap.ROUND);
        this.f20252e.setStrokeWidth(this.f20254g);
        Paint paint2 = new Paint();
        this.f20253f = paint2;
        paint2.setAntiAlias(true);
        this.f20253f.setDither(true);
        this.f20253f.setStyle(Paint.Style.STROKE);
        this.f20253f.setStrokeCap(Paint.Cap.ROUND);
        this.f20253f.setStrokeWidth(this.f20254g);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f20255h >= 0) {
            RectF rectF = this.i;
            float f2 = this.f20254g;
            rectF.left = f2;
            rectF.top = f2;
            rectF.right = getWidth() - this.f20254g;
            this.i.bottom = getHeight() - this.f20254g;
            canvas.drawArc(this.i, 0.0f, 360.0f, false, this.f20253f);
            canvas.drawArc(this.i, -90.0f, (this.f20255h / 100) * 360.0f, false, this.f20252e);
        }
    }

    public void setCircleBackgroundColor(int i) {
        this.f20253f.setColor(i);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i) {
        this.f20252e.setColor(i);
        postInvalidate();
    }

    public void setProgress(int i) {
        this.f20255h = i;
        postInvalidate();
    }

    public void setWidth(int i) {
        float f2 = i;
        this.f20254g = f2;
        this.f20253f.setStrokeWidth(f2);
        this.f20252e.setStrokeWidth(f2);
        postInvalidate();
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20254g = 5.0f;
        a();
    }
}
