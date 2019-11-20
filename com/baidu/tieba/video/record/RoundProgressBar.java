package com.baidu.tieba.video.record;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes5.dex */
public class RoundProgressBar extends View {
    private int jEL;
    private int mHeight;
    private Paint mPaint;
    private float mProgress;
    private int mProgressColor;
    private int mWidth;

    public RoundProgressBar(Context context) {
        this(context, null);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        init();
    }

    public void init() {
        this.jEL = 4;
        this.mProgressColor = Color.rgb(255, 255, 255);
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mWidth = getWidth();
        this.mHeight = getHeight();
        if (this.mWidth > this.mHeight) {
            this.mWidth = this.mHeight;
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.jEL);
        this.mPaint.setColor(this.mProgressColor);
        canvas.drawArc(new RectF(5.0f, 5.0f, this.mWidth - 5, this.mHeight - 5), 270.0f, (360.0f * this.mProgress) / 100.0f, false, this.mPaint);
    }

    public void ay(float f) {
        this.mProgress = f;
        invalidate();
    }
}
