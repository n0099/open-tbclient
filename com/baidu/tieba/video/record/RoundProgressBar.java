package com.baidu.tieba.video.record;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes10.dex */
public class RoundProgressBar extends View {
    private int lpu;
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
        this.lpu = 4;
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
        this.mPaint.setStrokeWidth(this.lpu);
        this.mPaint.setColor(this.mProgressColor);
        canvas.drawArc(new RectF(5.0f, 5.0f, this.mWidth - 5, this.mHeight - 5), 270.0f, (360.0f * this.mProgress) / 100.0f, false, this.mPaint);
    }

    public void F(float f) {
        this.mProgress = f;
        invalidate();
    }
}
