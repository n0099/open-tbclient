package com.bigkoo.svprogresshud.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bigkoo.svprogresshud.R;
/* loaded from: classes4.dex */
public class SVCircleProgressBar extends View {
    public static final int FILL = 1;
    public static final int STROKE = 0;
    private int max;
    private Paint paint;
    private int progress;
    private int roundColor;
    private int roundProgressColor;
    private float roundWidth;
    private int style;

    public SVCircleProgressBar(Context context) {
        this(context, null);
    }

    public SVCircleProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SVCircleProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.paint = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SVCircleProgressBar);
        this.roundColor = obtainStyledAttributes.getColor(R.styleable.SVCircleProgressBar_svprogress_roundColor, -16776961);
        this.roundProgressColor = obtainStyledAttributes.getColor(R.styleable.SVCircleProgressBar_svprogress_roundProgressColor, -7829368);
        this.roundWidth = obtainStyledAttributes.getDimension(R.styleable.SVCircleProgressBar_svprogress_roundWidth, 5.0f);
        this.max = obtainStyledAttributes.getInteger(R.styleable.SVCircleProgressBar_svprogress_max, 100);
        this.style = obtainStyledAttributes.getInt(R.styleable.SVCircleProgressBar_svprogress_style, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        int i = (int) (width - (this.roundWidth / 2.0f));
        this.paint.setAntiAlias(true);
        this.paint.setColor(this.roundColor);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(this.roundWidth);
        canvas.drawCircle(width, width, i, this.paint);
        this.paint.setStrokeWidth(this.roundWidth);
        this.paint.setColor(this.roundProgressColor);
        RectF rectF = new RectF(width - i, width - i, width + i, width + i);
        switch (this.style) {
            case 0:
                this.paint.setStyle(Paint.Style.STROKE);
                canvas.drawArc(rectF, 270.0f, (this.progress * 360) / this.max, false, this.paint);
                return;
            case 1:
                this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
                if (this.progress != 0) {
                    canvas.drawArc(rectF, 270.0f, (this.progress * 360) / this.max, true, this.paint);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public synchronized int getMax() {
        return this.max;
    }

    public synchronized void setMax(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("max not less than 0");
        }
        this.max = i;
    }

    public synchronized int getProgress() {
        return this.progress;
    }

    public synchronized void setProgress(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("progress not less than 0");
        }
        if (i > this.max) {
            i = this.max;
        }
        if (i <= this.max) {
            this.progress = i;
            postInvalidate();
        }
    }

    public int getCircleColor() {
        return this.roundColor;
    }

    public void setCircleColor(int i) {
        this.roundColor = i;
    }

    public int getCircleProgressColor() {
        return this.roundProgressColor;
    }

    public void setCircleProgressColor(int i) {
        this.roundProgressColor = i;
    }

    public float getRoundWidth() {
        return this.roundWidth;
    }

    public void setRoundWidth(float f) {
        this.roundWidth = f;
    }
}
