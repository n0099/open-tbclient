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
    public Paint f20260e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f20261f;

    /* renamed from: g  reason: collision with root package name */
    public float f20262g;

    /* renamed from: h  reason: collision with root package name */
    public int f20263h;
    public RectF i;

    public CircleProgressBar(Context context) {
        super(context);
        this.f20262g = 5.0f;
        a();
    }

    public final void a() {
        this.i = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        Paint paint = new Paint();
        this.f20260e = paint;
        paint.setAntiAlias(true);
        this.f20260e.setDither(true);
        this.f20260e.setStyle(Paint.Style.STROKE);
        this.f20260e.setStrokeCap(Paint.Cap.ROUND);
        this.f20260e.setStrokeWidth(this.f20262g);
        Paint paint2 = new Paint();
        this.f20261f = paint2;
        paint2.setAntiAlias(true);
        this.f20261f.setDither(true);
        this.f20261f.setStyle(Paint.Style.STROKE);
        this.f20261f.setStrokeCap(Paint.Cap.ROUND);
        this.f20261f.setStrokeWidth(this.f20262g);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f20263h >= 0) {
            RectF rectF = this.i;
            float f2 = this.f20262g;
            rectF.left = f2;
            rectF.top = f2;
            rectF.right = getWidth() - this.f20262g;
            this.i.bottom = getHeight() - this.f20262g;
            canvas.drawArc(this.i, 0.0f, 360.0f, false, this.f20261f);
            canvas.drawArc(this.i, -90.0f, (this.f20263h / 100) * 360.0f, false, this.f20260e);
        }
    }

    public void setCircleBackgroundColor(int i) {
        this.f20261f.setColor(i);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i) {
        this.f20260e.setColor(i);
        postInvalidate();
    }

    public void setProgress(int i) {
        this.f20263h = i;
        postInvalidate();
    }

    public void setWidth(int i) {
        float f2 = i;
        this.f20262g = f2;
        this.f20261f.setStrokeWidth(f2);
        this.f20260e.setStrokeWidth(f2);
        postInvalidate();
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20262g = 5.0f;
        a();
    }
}
