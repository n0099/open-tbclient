package com.baidu.tieba.pluginCenter.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class CircleProgressBar extends View {
    private float azc;
    private Paint ccD;
    private Paint ccE;
    private RectF ccF;
    private int currentProgress;

    public CircleProgressBar(Context context) {
        super(context);
        this.azc = 5.0f;
        akd();
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azc = 5.0f;
        akd();
    }

    private void akd() {
        this.ccF = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.ccD = new Paint();
        this.ccD.setAntiAlias(true);
        this.ccD.setDither(true);
        this.ccD.setStyle(Paint.Style.STROKE);
        this.ccD.setStrokeCap(Paint.Cap.ROUND);
        this.ccD.setStrokeWidth(this.azc);
        this.ccE = new Paint();
        this.ccE.setAntiAlias(true);
        this.ccE.setDither(true);
        this.ccE.setStyle(Paint.Style.STROKE);
        this.ccE.setStrokeCap(Paint.Cap.ROUND);
        this.ccE.setStrokeWidth(this.azc);
    }

    public void setCircleBackgroundColor(int i) {
        this.ccE.setColor(i);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i) {
        this.ccD.setColor(i);
        postInvalidate();
    }

    public void setWidth(int i) {
        this.azc = i;
        this.ccE.setStrokeWidth(i);
        this.ccD.setStrokeWidth(i);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.currentProgress >= 0) {
            this.ccF.left = this.azc;
            this.ccF.top = this.azc;
            this.ccF.right = getWidth() - this.azc;
            this.ccF.bottom = getHeight() - this.azc;
            canvas.drawArc(this.ccF, 0.0f, 360.0f, false, this.ccE);
            canvas.drawArc(this.ccF, -90.0f, 360.0f * (this.currentProgress / 100), false, this.ccD);
        }
    }

    public void setProgress(int i) {
        this.currentProgress = i;
        postInvalidate();
    }
}
