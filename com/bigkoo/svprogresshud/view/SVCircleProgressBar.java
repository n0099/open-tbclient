package com.bigkoo.svprogresshud.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bigkoo.svprogresshud.R;
/* loaded from: classes5.dex */
public class SVCircleProgressBar extends View {
    public static final int FILL = 1;
    public static final int STROKE = 0;
    public int max;
    public Paint paint;
    public int progress;
    public int roundColor;
    public int roundProgressColor;
    public float roundWidth;
    public int style;

    public SVCircleProgressBar(Context context) {
        this(context, null);
    }

    public int getCircleColor() {
        return this.roundColor;
    }

    public int getCircleProgressColor() {
        return this.roundProgressColor;
    }

    public synchronized int getMax() {
        return this.max;
    }

    public synchronized int getProgress() {
        return this.progress;
    }

    public float getRoundWidth() {
        return this.roundWidth;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        super.onDraw(canvas);
        int width = getWidth() / 2;
        float f2 = width;
        int i3 = (int) (f2 - (this.roundWidth / 2.0f));
        this.paint.setAntiAlias(true);
        this.paint.setColor(this.roundColor);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(this.roundWidth);
        canvas.drawCircle(f2, f2, i3, this.paint);
        this.paint.setStrokeWidth(this.roundWidth);
        this.paint.setColor(this.roundProgressColor);
        float f3 = width - i3;
        float f4 = width + i3;
        RectF rectF = new RectF(f3, f3, f4, f4);
        int i4 = this.style;
        if (i4 == 0) {
            this.paint.setStyle(Paint.Style.STROKE);
            canvas.drawArc(rectF, 270.0f, (this.progress * 360) / this.max, false, this.paint);
        } else if (i4 != 1) {
        } else {
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            if (this.progress != 0) {
                canvas.drawArc(rectF, 270.0f, (i2 * 360) / this.max, true, this.paint);
            }
        }
    }

    public void setCircleColor(int i2) {
        this.roundColor = i2;
    }

    public void setCircleProgressColor(int i2) {
        this.roundProgressColor = i2;
    }

    public synchronized void setMax(int i2) {
        if (i2 >= 0) {
            this.max = i2;
        } else {
            throw new IllegalArgumentException("max not less than 0");
        }
    }

    public synchronized void setProgress(int i2) {
        if (i2 >= 0) {
            if (i2 > this.max) {
                i2 = this.max;
            }
            if (i2 <= this.max) {
                this.progress = i2;
                postInvalidate();
            }
        } else {
            throw new IllegalArgumentException("progress not less than 0");
        }
    }

    public void setRoundWidth(float f2) {
        this.roundWidth = f2;
    }

    public SVCircleProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SVCircleProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.paint = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SVCircleProgressBar);
        this.roundColor = obtainStyledAttributes.getColor(R.styleable.SVCircleProgressBar_svprogress_roundColor, -16776961);
        this.roundProgressColor = obtainStyledAttributes.getColor(R.styleable.SVCircleProgressBar_svprogress_roundProgressColor, -7829368);
        this.roundWidth = obtainStyledAttributes.getDimension(R.styleable.SVCircleProgressBar_svprogress_roundWidth, 5.0f);
        this.max = obtainStyledAttributes.getInteger(R.styleable.SVCircleProgressBar_svprogress_max, 100);
        this.style = obtainStyledAttributes.getInt(R.styleable.SVCircleProgressBar_svprogress_style, 0);
        obtainStyledAttributes.recycle();
    }
}
