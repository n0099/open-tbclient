package com.baidu.tieba.pluginCenter.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class CircleProgressBar extends View {
    private float aAe;
    private Paint ckL;
    private Paint ckM;
    private RectF ckN;
    private int currentProgress;

    public CircleProgressBar(Context context) {
        super(context);
        this.aAe = 5.0f;
        apb();
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aAe = 5.0f;
        apb();
    }

    private void apb() {
        this.ckN = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.ckL = new Paint();
        this.ckL.setAntiAlias(true);
        this.ckL.setDither(true);
        this.ckL.setStyle(Paint.Style.STROKE);
        this.ckL.setStrokeCap(Paint.Cap.ROUND);
        this.ckL.setStrokeWidth(this.aAe);
        this.ckM = new Paint();
        this.ckM.setAntiAlias(true);
        this.ckM.setDither(true);
        this.ckM.setStyle(Paint.Style.STROKE);
        this.ckM.setStrokeCap(Paint.Cap.ROUND);
        this.ckM.setStrokeWidth(this.aAe);
    }

    public void setCircleBackgroundColor(int i) {
        this.ckM.setColor(i);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i) {
        this.ckL.setColor(i);
        postInvalidate();
    }

    public void setWidth(int i) {
        this.aAe = i;
        this.ckM.setStrokeWidth(i);
        this.ckL.setStrokeWidth(i);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.currentProgress >= 0) {
            this.ckN.left = this.aAe;
            this.ckN.top = this.aAe;
            this.ckN.right = getWidth() - this.aAe;
            this.ckN.bottom = getHeight() - this.aAe;
            canvas.drawArc(this.ckN, 0.0f, 360.0f, false, this.ckM);
            canvas.drawArc(this.ckN, -90.0f, 360.0f * (this.currentProgress / 100), false, this.ckL);
        }
    }

    public void setProgress(int i) {
        this.currentProgress = i;
        postInvalidate();
    }
}
