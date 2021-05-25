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
    public Paint f20001e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f20002f;

    /* renamed from: g  reason: collision with root package name */
    public float f20003g;

    /* renamed from: h  reason: collision with root package name */
    public int f20004h;

    /* renamed from: i  reason: collision with root package name */
    public RectF f20005i;

    public CircleProgressBar(Context context) {
        super(context);
        this.f20003g = 5.0f;
        a();
    }

    public final void a() {
        this.f20005i = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        Paint paint = new Paint();
        this.f20001e = paint;
        paint.setAntiAlias(true);
        this.f20001e.setDither(true);
        this.f20001e.setStyle(Paint.Style.STROKE);
        this.f20001e.setStrokeCap(Paint.Cap.ROUND);
        this.f20001e.setStrokeWidth(this.f20003g);
        Paint paint2 = new Paint();
        this.f20002f = paint2;
        paint2.setAntiAlias(true);
        this.f20002f.setDither(true);
        this.f20002f.setStyle(Paint.Style.STROKE);
        this.f20002f.setStrokeCap(Paint.Cap.ROUND);
        this.f20002f.setStrokeWidth(this.f20003g);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f20004h >= 0) {
            RectF rectF = this.f20005i;
            float f2 = this.f20003g;
            rectF.left = f2;
            rectF.top = f2;
            rectF.right = getWidth() - this.f20003g;
            this.f20005i.bottom = getHeight() - this.f20003g;
            canvas.drawArc(this.f20005i, 0.0f, 360.0f, false, this.f20002f);
            canvas.drawArc(this.f20005i, -90.0f, (this.f20004h / 100) * 360.0f, false, this.f20001e);
        }
    }

    public void setCircleBackgroundColor(int i2) {
        this.f20002f.setColor(i2);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i2) {
        this.f20001e.setColor(i2);
        postInvalidate();
    }

    public void setProgress(int i2) {
        this.f20004h = i2;
        postInvalidate();
    }

    public void setWidth(int i2) {
        float f2 = i2;
        this.f20003g = f2;
        this.f20002f.setStrokeWidth(f2);
        this.f20001e.setStrokeWidth(f2);
        postInvalidate();
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20003g = 5.0f;
        a();
    }
}
