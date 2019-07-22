package com.baidu.tieba.pluginCenter.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class CircleProgressBar extends View {
    private float aAM;
    private Paint clX;
    private Paint clY;
    private RectF clZ;
    private int currentProgress;

    public CircleProgressBar(Context context) {
        super(context);
        this.aAM = 5.0f;
        aqh();
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aAM = 5.0f;
        aqh();
    }

    private void aqh() {
        this.clZ = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.clX = new Paint();
        this.clX.setAntiAlias(true);
        this.clX.setDither(true);
        this.clX.setStyle(Paint.Style.STROKE);
        this.clX.setStrokeCap(Paint.Cap.ROUND);
        this.clX.setStrokeWidth(this.aAM);
        this.clY = new Paint();
        this.clY.setAntiAlias(true);
        this.clY.setDither(true);
        this.clY.setStyle(Paint.Style.STROKE);
        this.clY.setStrokeCap(Paint.Cap.ROUND);
        this.clY.setStrokeWidth(this.aAM);
    }

    public void setCircleBackgroundColor(int i) {
        this.clY.setColor(i);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i) {
        this.clX.setColor(i);
        postInvalidate();
    }

    public void setWidth(int i) {
        this.aAM = i;
        this.clY.setStrokeWidth(i);
        this.clX.setStrokeWidth(i);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.currentProgress >= 0) {
            this.clZ.left = this.aAM;
            this.clZ.top = this.aAM;
            this.clZ.right = getWidth() - this.aAM;
            this.clZ.bottom = getHeight() - this.aAM;
            canvas.drawArc(this.clZ, 0.0f, 360.0f, false, this.clY);
            canvas.drawArc(this.clZ, -90.0f, 360.0f * (this.currentProgress / 100), false, this.clX);
        }
    }

    public void setProgress(int i) {
        this.currentProgress = i;
        postInvalidate();
    }
}
