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
    private Path aFR;
    private float aFS;
    private float aFT;
    private float aFU;
    private float aFV;
    private RectF mRect;
    private Paint mStrokePaint;
    private float mStrokeWidth;
    private Path mPath = new Path();
    private Paint mPaint = new Paint(1);

    public a(RectF rectF, float f, float f2, float f3, float f4, float f5, int i, int i2, ArrowDirection arrowDirection) {
        this.mRect = rectF;
        this.aFS = f;
        this.aFT = f2;
        this.aFU = f3;
        this.aFV = f4;
        this.mStrokeWidth = f5;
        this.mPaint.setColor(i2);
        if (f5 > 0.0f) {
            this.mStrokePaint = new Paint(1);
            this.mStrokePaint.setColor(i);
            this.aFR = new Path();
            a(arrowDirection, this.mPath, f5);
            a(arrowDirection, this.aFR, 0.0f);
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
            canvas.drawPath(this.aFR, this.mStrokePaint);
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
        return (int) this.mRect.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.mRect.height();
    }

    private void a(ArrowDirection arrowDirection, Path path, float f) {
        switch (arrowDirection) {
            case LEFT:
                if (this.aFT <= 0.0f) {
                    b(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aFT) {
                    b(this.mRect, path, f);
                    return;
                } else {
                    a(this.mRect, path, f);
                    return;
                }
            case TOP:
                if (this.aFT <= 0.0f) {
                    d(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aFT) {
                    d(this.mRect, path, f);
                    return;
                } else {
                    c(this.mRect, path, f);
                    return;
                }
            case RIGHT:
                if (this.aFT <= 0.0f) {
                    f(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aFT) {
                    f(this.mRect, path, f);
                    return;
                } else {
                    e(this.mRect, path, f);
                    return;
                }
            case BOTTOM:
                if (this.aFT <= 0.0f) {
                    h(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aFT) {
                    h(this.mRect, path, f);
                    return;
                } else {
                    g(this.mRect, path, f);
                    return;
                }
            default:
                return;
        }
    }

    private void a(RectF rectF, Path path, float f) {
        path.moveTo(this.aFS + rectF.left + this.aFT + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aFT) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.aFT, rectF.top + f, rectF.right - f, this.aFT + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aFT) - f);
        path.arcTo(new RectF(rectF.right - this.aFT, rectF.bottom - this.aFT, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aFS + this.aFT + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + this.aFS + f, rectF.bottom - this.aFT, this.aFT + rectF.left + this.aFS, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.aFS + f, (this.aFU + this.aFV) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.aFV + (this.aFU / 2.0f));
        path.lineTo(rectF.left + this.aFS + f, this.aFV + (f / 2.0f));
        path.lineTo(rectF.left + this.aFS + f, rectF.top + this.aFT + f);
        path.arcTo(new RectF(rectF.left + this.aFS + f, rectF.top + f, this.aFT + rectF.left + this.aFS, this.aFT + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void b(RectF rectF, Path path, float f) {
        path.moveTo(this.aFS + rectF.left + f, rectF.top + f);
        path.lineTo(rectF.width() - f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + this.aFS + f, rectF.bottom - f);
        path.lineTo(rectF.left + this.aFS + f, (this.aFU + this.aFV) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.aFV + (this.aFU / 2.0f));
        path.lineTo(rectF.left + this.aFS + f, this.aFV + (f / 2.0f));
        path.lineTo(rectF.left + this.aFS + f, rectF.top + f);
        path.close();
    }

    private void c(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + Math.min(this.aFV, this.aFT) + f, rectF.top + this.aFU + f);
        path.lineTo(rectF.left + this.aFV + (f / 2.0f), rectF.top + this.aFU + f);
        path.lineTo(rectF.left + (this.aFS / 2.0f) + this.aFV, rectF.top + f + f);
        path.lineTo(((rectF.left + this.aFS) + this.aFV) - (f / 2.0f), rectF.top + this.aFU + f);
        path.lineTo((rectF.right - this.aFT) - f, rectF.top + this.aFU + f);
        path.arcTo(new RectF(rectF.right - this.aFT, rectF.top + this.aFU + f, rectF.right - f, this.aFT + rectF.top + this.aFU), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aFT) - f);
        path.arcTo(new RectF(rectF.right - this.aFT, rectF.bottom - this.aFT, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aFT + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.aFT, this.aFT + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.aFU + this.aFT + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + this.aFU + f, this.aFT + rectF.left, this.aFT + rectF.top + this.aFU), 180.0f, 90.0f);
        path.close();
    }

    private void d(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aFV + f, rectF.top + this.aFU + f);
        path.lineTo(rectF.left + this.aFV + (f / 2.0f), rectF.top + this.aFU + f);
        path.lineTo(rectF.left + (this.aFS / 2.0f) + this.aFV, rectF.top + f + f);
        path.lineTo(((rectF.left + this.aFS) + this.aFV) - (f / 2.0f), rectF.top + this.aFU + f);
        path.lineTo(rectF.right - f, rectF.top + this.aFU + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + this.aFU + f);
        path.lineTo(rectF.left + this.aFV + f, rectF.top + this.aFU + f);
        path.close();
    }

    private void e(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aFT + f, rectF.top + f);
        path.lineTo(((rectF.width() - this.aFT) - this.aFS) - f, rectF.top + f);
        path.arcTo(new RectF((rectF.right - this.aFT) - this.aFS, rectF.top + f, (rectF.right - this.aFS) - f, this.aFT + rectF.top), 270.0f, 90.0f);
        path.lineTo((rectF.right - this.aFS) - f, this.aFV + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.aFV + (this.aFU / 2.0f));
        path.lineTo((rectF.right - this.aFS) - f, (this.aFV + this.aFU) - (f / 2.0f));
        path.lineTo((rectF.right - this.aFS) - f, (rectF.bottom - this.aFT) - f);
        path.arcTo(new RectF((rectF.right - this.aFT) - this.aFS, rectF.bottom - this.aFT, (rectF.right - this.aFS) - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aFS + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.aFT, this.aFT + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.aFT + rectF.left, this.aFT + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void f(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aFS) - f, rectF.top + f);
        path.lineTo((rectF.right - this.aFS) - f, this.aFV + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.aFV + (this.aFU / 2.0f));
        path.lineTo((rectF.right - this.aFS) - f, (this.aFV + this.aFU) - (f / 2.0f));
        path.lineTo((rectF.right - this.aFS) - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }

    private void g(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aFT + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aFT) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.aFT, rectF.top + f, rectF.right - f, this.aFT + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, ((rectF.bottom - this.aFU) - this.aFT) - f);
        path.arcTo(new RectF(rectF.right - this.aFT, (rectF.bottom - this.aFT) - this.aFU, rectF.right - f, (rectF.bottom - this.aFU) - f), 0.0f, 90.0f);
        path.lineTo(((rectF.left + this.aFS) + this.aFV) - (f / 2.0f), (rectF.bottom - this.aFU) - f);
        path.lineTo(rectF.left + this.aFV + (this.aFS / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.aFV + (f / 2.0f), (rectF.bottom - this.aFU) - f);
        path.lineTo(rectF.left + Math.min(this.aFT, this.aFV) + f, (rectF.bottom - this.aFU) - f);
        path.arcTo(new RectF(rectF.left + f, (rectF.bottom - this.aFT) - this.aFU, this.aFT + rectF.left, (rectF.bottom - this.aFU) - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.aFT + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.aFT + rectF.left, this.aFT + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void h(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.top + f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aFU) - f);
        path.lineTo(((rectF.left + this.aFS) + this.aFV) - (f / 2.0f), (rectF.bottom - this.aFU) - f);
        path.lineTo(rectF.left + this.aFV + (this.aFS / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.aFV + (f / 2.0f), (rectF.bottom - this.aFU) - f);
        path.lineTo(rectF.left + this.aFV + f, (rectF.bottom - this.aFU) - f);
        path.lineTo(rectF.left + f, (rectF.bottom - this.aFU) - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }
}
