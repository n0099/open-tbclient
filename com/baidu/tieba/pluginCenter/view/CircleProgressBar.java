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
    public Paint f20560e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f20561f;

    /* renamed from: g  reason: collision with root package name */
    public float f20562g;

    /* renamed from: h  reason: collision with root package name */
    public int f20563h;
    public RectF i;

    public CircleProgressBar(Context context) {
        super(context);
        this.f20562g = 5.0f;
        a();
    }

    public final void a() {
        this.i = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        Paint paint = new Paint();
        this.f20560e = paint;
        paint.setAntiAlias(true);
        this.f20560e.setDither(true);
        this.f20560e.setStyle(Paint.Style.STROKE);
        this.f20560e.setStrokeCap(Paint.Cap.ROUND);
        this.f20560e.setStrokeWidth(this.f20562g);
        Paint paint2 = new Paint();
        this.f20561f = paint2;
        paint2.setAntiAlias(true);
        this.f20561f.setDither(true);
        this.f20561f.setStyle(Paint.Style.STROKE);
        this.f20561f.setStrokeCap(Paint.Cap.ROUND);
        this.f20561f.setStrokeWidth(this.f20562g);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f20563h >= 0) {
            RectF rectF = this.i;
            float f2 = this.f20562g;
            rectF.left = f2;
            rectF.top = f2;
            rectF.right = getWidth() - this.f20562g;
            this.i.bottom = getHeight() - this.f20562g;
            canvas.drawArc(this.i, 0.0f, 360.0f, false, this.f20561f);
            canvas.drawArc(this.i, -90.0f, (this.f20563h / 100) * 360.0f, false, this.f20560e);
        }
    }

    public void setCircleBackgroundColor(int i) {
        this.f20561f.setColor(i);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i) {
        this.f20560e.setColor(i);
        postInvalidate();
    }

    public void setProgress(int i) {
        this.f20563h = i;
        postInvalidate();
    }

    public void setWidth(int i) {
        float f2 = i;
        this.f20562g = f2;
        this.f20561f.setStrokeWidth(f2);
        this.f20560e.setStrokeWidth(f2);
        postInvalidate();
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20562g = 5.0f;
        a();
    }
}
