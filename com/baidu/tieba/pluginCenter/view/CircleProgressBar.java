package com.baidu.tieba.pluginCenter.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class CircleProgressBar extends View {
    private float aUg;
    private int asf;
    private Paint czh;
    private Paint czi;
    private RectF czj;

    public CircleProgressBar(Context context) {
        super(context);
        this.aUg = 5.0f;
        asn();
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aUg = 5.0f;
        asn();
    }

    private void asn() {
        this.czj = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.czh = new Paint();
        this.czh.setAntiAlias(true);
        this.czh.setDither(true);
        this.czh.setStyle(Paint.Style.STROKE);
        this.czh.setStrokeCap(Paint.Cap.ROUND);
        this.czh.setStrokeWidth(this.aUg);
        this.czi = new Paint();
        this.czi.setAntiAlias(true);
        this.czi.setDither(true);
        this.czi.setStyle(Paint.Style.STROKE);
        this.czi.setStrokeCap(Paint.Cap.ROUND);
        this.czi.setStrokeWidth(this.aUg);
    }

    public void setCircleBackgroundColor(int i) {
        this.czi.setColor(i);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i) {
        this.czh.setColor(i);
        postInvalidate();
    }

    public void setWidth(int i) {
        this.aUg = i;
        this.czi.setStrokeWidth(i);
        this.czh.setStrokeWidth(i);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.asf >= 0) {
            this.czj.left = this.aUg;
            this.czj.top = this.aUg;
            this.czj.right = getWidth() - this.aUg;
            this.czj.bottom = getHeight() - this.aUg;
            canvas.drawArc(this.czj, 0.0f, 360.0f, false, this.czi);
            canvas.drawArc(this.czj, -90.0f, 360.0f * (this.asf / 100), false, this.czh);
        }
    }

    public void setProgress(int i) {
        this.asf = i;
        postInvalidate();
    }
}
