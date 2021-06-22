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
    public Paint f20160e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f20161f;

    /* renamed from: g  reason: collision with root package name */
    public float f20162g;

    /* renamed from: h  reason: collision with root package name */
    public int f20163h;

    /* renamed from: i  reason: collision with root package name */
    public RectF f20164i;

    public CircleProgressBar(Context context) {
        super(context);
        this.f20162g = 5.0f;
        a();
    }

    public final void a() {
        this.f20164i = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        Paint paint = new Paint();
        this.f20160e = paint;
        paint.setAntiAlias(true);
        this.f20160e.setDither(true);
        this.f20160e.setStyle(Paint.Style.STROKE);
        this.f20160e.setStrokeCap(Paint.Cap.ROUND);
        this.f20160e.setStrokeWidth(this.f20162g);
        Paint paint2 = new Paint();
        this.f20161f = paint2;
        paint2.setAntiAlias(true);
        this.f20161f.setDither(true);
        this.f20161f.setStyle(Paint.Style.STROKE);
        this.f20161f.setStrokeCap(Paint.Cap.ROUND);
        this.f20161f.setStrokeWidth(this.f20162g);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f20163h >= 0) {
            RectF rectF = this.f20164i;
            float f2 = this.f20162g;
            rectF.left = f2;
            rectF.top = f2;
            rectF.right = getWidth() - this.f20162g;
            this.f20164i.bottom = getHeight() - this.f20162g;
            canvas.drawArc(this.f20164i, 0.0f, 360.0f, false, this.f20161f);
            canvas.drawArc(this.f20164i, -90.0f, (this.f20163h / 100) * 360.0f, false, this.f20160e);
        }
    }

    public void setCircleBackgroundColor(int i2) {
        this.f20161f.setColor(i2);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i2) {
        this.f20160e.setColor(i2);
        postInvalidate();
    }

    public void setProgress(int i2) {
        this.f20163h = i2;
        postInvalidate();
    }

    public void setWidth(int i2) {
        float f2 = i2;
        this.f20162g = f2;
        this.f20161f.setStrokeWidth(f2);
        this.f20160e.setStrokeWidth(f2);
        postInvalidate();
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20162g = 5.0f;
        a();
    }
}
