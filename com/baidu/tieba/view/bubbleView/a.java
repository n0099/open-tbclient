package com.baidu.tieba.view.bubbleView;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
class a extends Drawable {
    private RectF NJ;
    private Path NK;
    private float NL;
    private float NM;
    private float NN;
    private float NP;
    private Paint mStrokePaint;
    private float mStrokeWidth;
    private Path mPath = new Path();
    private Paint mPaint = new Paint(1);

    public a(RectF rectF, float f, float f2, float f3, float f4, float f5, int i, int i2, ArrowDirection arrowDirection) {
        this.NJ = rectF;
        this.NL = f;
        this.NM = f2;
        this.NN = f3;
        this.NP = f4;
        this.mStrokeWidth = f5;
        this.mPaint.setColor(i2);
        if (f5 > 0.0f) {
            this.mStrokePaint = new Paint(1);
            this.mStrokePaint.setColor(i);
            this.NK = new Path();
            a(arrowDirection, this.mPath, f5);
            a(arrowDirection, this.NK, 0.0f);
            return;
        }
        a(arrowDirection, this.mPath, 0.0f);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mStrokeWidth > 0.0f) {
            canvas.drawPath(this.NK, this.mStrokePaint);
        }
        canvas.drawPath(this.mPath, this.mPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.NJ.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.NJ.height();
    }

    private void a(ArrowDirection arrowDirection, Path path, float f) {
        switch (arrowDirection) {
            case LEFT:
                if (this.NM <= 0.0f) {
                    b(this.NJ, path, f);
                    return;
                } else if (f > 0.0f && f > this.NM) {
                    b(this.NJ, path, f);
                    return;
                } else {
                    a(this.NJ, path, f);
                    return;
                }
            case TOP:
                if (this.NM <= 0.0f) {
                    d(this.NJ, path, f);
                    return;
                } else if (f > 0.0f && f > this.NM) {
                    d(this.NJ, path, f);
                    return;
                } else {
                    c(this.NJ, path, f);
                    return;
                }
            case RIGHT:
                if (this.NM <= 0.0f) {
                    f(this.NJ, path, f);
                    return;
                } else if (f > 0.0f && f > this.NM) {
                    f(this.NJ, path, f);
                    return;
                } else {
                    e(this.NJ, path, f);
                    return;
                }
            case BOTTOM:
                if (this.NM <= 0.0f) {
                    h(this.NJ, path, f);
                    return;
                } else if (f > 0.0f && f > this.NM) {
                    h(this.NJ, path, f);
                    return;
                } else {
                    g(this.NJ, path, f);
                    return;
                }
            default:
                return;
        }
    }

    private void a(RectF rectF, Path path, float f) {
        path.moveTo(this.NL + rectF.left + this.NM + f, rectF.top + f);
        path.lineTo((rectF.width() - this.NM) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.NM, rectF.top + f, rectF.right - f, this.NM + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.NM) - f);
        path.arcTo(new RectF(rectF.right - this.NM, rectF.bottom - this.NM, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.NL + this.NM + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + this.NL + f, rectF.bottom - this.NM, this.NM + rectF.left + this.NL, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.NL + f, (this.NN + this.NP) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.NP + (this.NN / 2.0f));
        path.lineTo(rectF.left + this.NL + f, this.NP + (f / 2.0f));
        path.lineTo(rectF.left + this.NL + f, rectF.top + this.NM + f);
        path.arcTo(new RectF(rectF.left + this.NL + f, rectF.top + f, this.NM + rectF.left + this.NL, this.NM + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void b(RectF rectF, Path path, float f) {
        path.moveTo(this.NL + rectF.left + f, rectF.top + f);
        path.lineTo(rectF.width() - f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + this.NL + f, rectF.bottom - f);
        path.lineTo(rectF.left + this.NL + f, (this.NN + this.NP) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.NP + (this.NN / 2.0f));
        path.lineTo(rectF.left + this.NL + f, this.NP + (f / 2.0f));
        path.lineTo(rectF.left + this.NL + f, rectF.top + f);
        path.close();
    }

    private void c(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + Math.min(this.NP, this.NM) + f, rectF.top + this.NN + f);
        path.lineTo(rectF.left + this.NP + (f / 2.0f), rectF.top + this.NN + f);
        path.lineTo(rectF.left + (this.NL / 2.0f) + this.NP, rectF.top + f + f);
        path.lineTo(((rectF.left + this.NL) + this.NP) - (f / 2.0f), rectF.top + this.NN + f);
        path.lineTo((rectF.right - this.NM) - f, rectF.top + this.NN + f);
        path.arcTo(new RectF(rectF.right - this.NM, rectF.top + this.NN + f, rectF.right - f, this.NM + rectF.top + this.NN), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.NM) - f);
        path.arcTo(new RectF(rectF.right - this.NM, rectF.bottom - this.NM, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.NM + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.NM, this.NM + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.NN + this.NM + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + this.NN + f, this.NM + rectF.left, this.NM + rectF.top + this.NN), 180.0f, 90.0f);
        path.close();
    }

    private void d(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.NP + f, rectF.top + this.NN + f);
        path.lineTo(rectF.left + this.NP + (f / 2.0f), rectF.top + this.NN + f);
        path.lineTo(rectF.left + (this.NL / 2.0f) + this.NP, rectF.top + f + f);
        path.lineTo(((rectF.left + this.NL) + this.NP) - (f / 2.0f), rectF.top + this.NN + f);
        path.lineTo(rectF.right - f, rectF.top + this.NN + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + this.NN + f);
        path.lineTo(rectF.left + this.NP + f, rectF.top + this.NN + f);
        path.close();
    }

    private void e(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.NM + f, rectF.top + f);
        path.lineTo(((rectF.width() - this.NM) - this.NL) - f, rectF.top + f);
        path.arcTo(new RectF((rectF.right - this.NM) - this.NL, rectF.top + f, (rectF.right - this.NL) - f, this.NM + rectF.top), 270.0f, 90.0f);
        path.lineTo((rectF.right - this.NL) - f, this.NP + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.NP + (this.NN / 2.0f));
        path.lineTo((rectF.right - this.NL) - f, (this.NP + this.NN) - (f / 2.0f));
        path.lineTo((rectF.right - this.NL) - f, (rectF.bottom - this.NM) - f);
        path.arcTo(new RectF((rectF.right - this.NM) - this.NL, rectF.bottom - this.NM, (rectF.right - this.NL) - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.NL + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.NM, this.NM + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.NM + rectF.left, this.NM + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void f(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo((rectF.width() - this.NL) - f, rectF.top + f);
        path.lineTo((rectF.right - this.NL) - f, this.NP + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.NP + (this.NN / 2.0f));
        path.lineTo((rectF.right - this.NL) - f, (this.NP + this.NN) - (f / 2.0f));
        path.lineTo((rectF.right - this.NL) - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }

    private void g(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.NM + f, rectF.top + f);
        path.lineTo((rectF.width() - this.NM) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.NM, rectF.top + f, rectF.right - f, this.NM + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, ((rectF.bottom - this.NN) - this.NM) - f);
        path.arcTo(new RectF(rectF.right - this.NM, (rectF.bottom - this.NM) - this.NN, rectF.right - f, (rectF.bottom - this.NN) - f), 0.0f, 90.0f);
        path.lineTo(((rectF.left + this.NL) + this.NP) - (f / 2.0f), (rectF.bottom - this.NN) - f);
        path.lineTo(rectF.left + this.NP + (this.NL / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.NP + (f / 2.0f), (rectF.bottom - this.NN) - f);
        path.lineTo(rectF.left + Math.min(this.NM, this.NP) + f, (rectF.bottom - this.NN) - f);
        path.arcTo(new RectF(rectF.left + f, (rectF.bottom - this.NM) - this.NN, this.NM + rectF.left, (rectF.bottom - this.NN) - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.NM + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.NM + rectF.left, this.NM + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void h(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.top + f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.NN) - f);
        path.lineTo(((rectF.left + this.NL) + this.NP) - (f / 2.0f), (rectF.bottom - this.NN) - f);
        path.lineTo(rectF.left + this.NP + (this.NL / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.NP + (f / 2.0f), (rectF.bottom - this.NN) - f);
        path.lineTo(rectF.left + this.NP + f, (rectF.bottom - this.NN) - f);
        path.lineTo(rectF.left + f, (rectF.bottom - this.NN) - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }
}
