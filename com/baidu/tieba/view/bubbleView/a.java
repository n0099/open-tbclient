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
    private Path aGF;
    private float aGG;
    private float aGH;
    private float aGI;
    private float aGJ;
    private RectF mRect;
    private Paint mStrokePaint;
    private float mStrokeWidth;
    private Path mPath = new Path();
    private Paint mPaint = new Paint(1);

    public a(RectF rectF, float f, float f2, float f3, float f4, float f5, int i, int i2, ArrowDirection arrowDirection) {
        this.mRect = rectF;
        this.aGG = f;
        this.aGH = f2;
        this.aGI = f3;
        this.aGJ = f4;
        this.mStrokeWidth = f5;
        this.mPaint.setColor(i2);
        if (f5 > 0.0f) {
            this.mStrokePaint = new Paint(1);
            this.mStrokePaint.setColor(i);
            this.aGF = new Path();
            a(arrowDirection, this.mPath, f5);
            a(arrowDirection, this.aGF, 0.0f);
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
            canvas.drawPath(this.aGF, this.mStrokePaint);
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
                if (this.aGH <= 0.0f) {
                    b(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aGH) {
                    b(this.mRect, path, f);
                    return;
                } else {
                    a(this.mRect, path, f);
                    return;
                }
            case TOP:
                if (this.aGH <= 0.0f) {
                    d(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aGH) {
                    d(this.mRect, path, f);
                    return;
                } else {
                    c(this.mRect, path, f);
                    return;
                }
            case RIGHT:
                if (this.aGH <= 0.0f) {
                    f(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aGH) {
                    f(this.mRect, path, f);
                    return;
                } else {
                    e(this.mRect, path, f);
                    return;
                }
            case BOTTOM:
                if (this.aGH <= 0.0f) {
                    h(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aGH) {
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
        path.moveTo(this.aGG + rectF.left + this.aGH + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aGH) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.aGH, rectF.top + f, rectF.right - f, this.aGH + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aGH) - f);
        path.arcTo(new RectF(rectF.right - this.aGH, rectF.bottom - this.aGH, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aGG + this.aGH + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + this.aGG + f, rectF.bottom - this.aGH, this.aGH + rectF.left + this.aGG, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.aGG + f, (this.aGI + this.aGJ) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.aGJ + (this.aGI / 2.0f));
        path.lineTo(rectF.left + this.aGG + f, this.aGJ + (f / 2.0f));
        path.lineTo(rectF.left + this.aGG + f, rectF.top + this.aGH + f);
        path.arcTo(new RectF(rectF.left + this.aGG + f, rectF.top + f, this.aGH + rectF.left + this.aGG, this.aGH + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void b(RectF rectF, Path path, float f) {
        path.moveTo(this.aGG + rectF.left + f, rectF.top + f);
        path.lineTo(rectF.width() - f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + this.aGG + f, rectF.bottom - f);
        path.lineTo(rectF.left + this.aGG + f, (this.aGI + this.aGJ) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.aGJ + (this.aGI / 2.0f));
        path.lineTo(rectF.left + this.aGG + f, this.aGJ + (f / 2.0f));
        path.lineTo(rectF.left + this.aGG + f, rectF.top + f);
        path.close();
    }

    private void c(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + Math.min(this.aGJ, this.aGH) + f, rectF.top + this.aGI + f);
        path.lineTo(rectF.left + this.aGJ + (f / 2.0f), rectF.top + this.aGI + f);
        path.lineTo(rectF.left + (this.aGG / 2.0f) + this.aGJ, rectF.top + f + f);
        path.lineTo(((rectF.left + this.aGG) + this.aGJ) - (f / 2.0f), rectF.top + this.aGI + f);
        path.lineTo((rectF.right - this.aGH) - f, rectF.top + this.aGI + f);
        path.arcTo(new RectF(rectF.right - this.aGH, rectF.top + this.aGI + f, rectF.right - f, this.aGH + rectF.top + this.aGI), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aGH) - f);
        path.arcTo(new RectF(rectF.right - this.aGH, rectF.bottom - this.aGH, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aGH + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.aGH, this.aGH + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.aGI + this.aGH + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + this.aGI + f, this.aGH + rectF.left, this.aGH + rectF.top + this.aGI), 180.0f, 90.0f);
        path.close();
    }

    private void d(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aGJ + f, rectF.top + this.aGI + f);
        path.lineTo(rectF.left + this.aGJ + (f / 2.0f), rectF.top + this.aGI + f);
        path.lineTo(rectF.left + (this.aGG / 2.0f) + this.aGJ, rectF.top + f + f);
        path.lineTo(((rectF.left + this.aGG) + this.aGJ) - (f / 2.0f), rectF.top + this.aGI + f);
        path.lineTo(rectF.right - f, rectF.top + this.aGI + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + this.aGI + f);
        path.lineTo(rectF.left + this.aGJ + f, rectF.top + this.aGI + f);
        path.close();
    }

    private void e(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aGH + f, rectF.top + f);
        path.lineTo(((rectF.width() - this.aGH) - this.aGG) - f, rectF.top + f);
        path.arcTo(new RectF((rectF.right - this.aGH) - this.aGG, rectF.top + f, (rectF.right - this.aGG) - f, this.aGH + rectF.top), 270.0f, 90.0f);
        path.lineTo((rectF.right - this.aGG) - f, this.aGJ + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.aGJ + (this.aGI / 2.0f));
        path.lineTo((rectF.right - this.aGG) - f, (this.aGJ + this.aGI) - (f / 2.0f));
        path.lineTo((rectF.right - this.aGG) - f, (rectF.bottom - this.aGH) - f);
        path.arcTo(new RectF((rectF.right - this.aGH) - this.aGG, rectF.bottom - this.aGH, (rectF.right - this.aGG) - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aGG + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.aGH, this.aGH + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.aGH + rectF.left, this.aGH + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void f(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aGG) - f, rectF.top + f);
        path.lineTo((rectF.right - this.aGG) - f, this.aGJ + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.aGJ + (this.aGI / 2.0f));
        path.lineTo((rectF.right - this.aGG) - f, (this.aGJ + this.aGI) - (f / 2.0f));
        path.lineTo((rectF.right - this.aGG) - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }

    private void g(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aGH + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aGH) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.aGH, rectF.top + f, rectF.right - f, this.aGH + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, ((rectF.bottom - this.aGI) - this.aGH) - f);
        path.arcTo(new RectF(rectF.right - this.aGH, (rectF.bottom - this.aGH) - this.aGI, rectF.right - f, (rectF.bottom - this.aGI) - f), 0.0f, 90.0f);
        path.lineTo(((rectF.left + this.aGG) + this.aGJ) - (f / 2.0f), (rectF.bottom - this.aGI) - f);
        path.lineTo(rectF.left + this.aGJ + (this.aGG / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.aGJ + (f / 2.0f), (rectF.bottom - this.aGI) - f);
        path.lineTo(rectF.left + Math.min(this.aGH, this.aGJ) + f, (rectF.bottom - this.aGI) - f);
        path.arcTo(new RectF(rectF.left + f, (rectF.bottom - this.aGH) - this.aGI, this.aGH + rectF.left, (rectF.bottom - this.aGI) - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.aGH + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.aGH + rectF.left, this.aGH + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void h(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.top + f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aGI) - f);
        path.lineTo(((rectF.left + this.aGG) + this.aGJ) - (f / 2.0f), (rectF.bottom - this.aGI) - f);
        path.lineTo(rectF.left + this.aGJ + (this.aGG / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.aGJ + (f / 2.0f), (rectF.bottom - this.aGI) - f);
        path.lineTo(rectF.left + this.aGJ + f, (rectF.bottom - this.aGI) - f);
        path.lineTo(rectF.left + f, (rectF.bottom - this.aGI) - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }
}
