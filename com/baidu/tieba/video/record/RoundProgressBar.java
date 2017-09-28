package com.baidu.tieba.video.record;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes2.dex */
public class RoundProgressBar extends View {
    private int gAI;
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
        this.gAI = 4;
        this.mProgressColor = Color.rgb((int) MotionEventCompat.ACTION_MASK, (int) MotionEventCompat.ACTION_MASK, (int) MotionEventCompat.ACTION_MASK);
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
        this.mPaint.setStrokeWidth(this.gAI);
        this.mPaint.setColor(this.mProgressColor);
        canvas.drawArc(new RectF(5.0f, 5.0f, this.mWidth - 5, this.mHeight - 5), 270.0f, (360.0f * this.mProgress) / 100.0f, false, this.mPaint);
    }

    public void ag(float f) {
        this.mProgress = f;
        invalidate();
    }
}
