package com.baidu.tieba.pluginCenter.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes5.dex */
public class CircleProgressBar extends View {
    private int azV;
    private float bvn;
    private Paint dmN;
    private Paint dmO;
    private RectF dmP;

    public CircleProgressBar(Context context) {
        super(context);
        this.bvn = 5.0f;
        aJM();
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bvn = 5.0f;
        aJM();
    }

    private void aJM() {
        this.dmP = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.dmN = new Paint();
        this.dmN.setAntiAlias(true);
        this.dmN.setDither(true);
        this.dmN.setStyle(Paint.Style.STROKE);
        this.dmN.setStrokeCap(Paint.Cap.ROUND);
        this.dmN.setStrokeWidth(this.bvn);
        this.dmO = new Paint();
        this.dmO.setAntiAlias(true);
        this.dmO.setDither(true);
        this.dmO.setStyle(Paint.Style.STROKE);
        this.dmO.setStrokeCap(Paint.Cap.ROUND);
        this.dmO.setStrokeWidth(this.bvn);
    }

    public void setCircleBackgroundColor(int i) {
        this.dmO.setColor(i);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i) {
        this.dmN.setColor(i);
        postInvalidate();
    }

    public void setWidth(int i) {
        this.bvn = i;
        this.dmO.setStrokeWidth(i);
        this.dmN.setStrokeWidth(i);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.azV >= 0) {
            this.dmP.left = this.bvn;
            this.dmP.top = this.bvn;
            this.dmP.right = getWidth() - this.bvn;
            this.dmP.bottom = getHeight() - this.bvn;
            canvas.drawArc(this.dmP, 0.0f, 360.0f, false, this.dmO);
            canvas.drawArc(this.dmP, -90.0f, 360.0f * (this.azV / 100), false, this.dmN);
        }
    }

    public void setProgress(int i) {
        this.azV = i;
        postInvalidate();
    }
}
