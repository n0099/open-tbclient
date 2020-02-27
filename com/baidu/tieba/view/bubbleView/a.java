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
    private RectF WF;
    private Path WG;
    private float WH;
    private float WI;
    private float WJ;
    private float WK;
    private Paint mStrokePaint;
    private float mStrokeWidth;
    private Path mPath = new Path();
    private Paint mPaint = new Paint(1);

    public a(RectF rectF, float f, float f2, float f3, float f4, float f5, int i, int i2, ArrowDirection arrowDirection) {
        this.WF = rectF;
        this.WH = f;
        this.WI = f2;
        this.WJ = f3;
        this.WK = f4;
        this.mStrokeWidth = f5;
        this.mPaint.setColor(i2);
        if (f5 > 0.0f) {
            this.mStrokePaint = new Paint(1);
            this.mStrokePaint.setColor(i);
            this.WG = new Path();
            a(arrowDirection, this.mPath, f5);
            a(arrowDirection, this.WG, 0.0f);
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
            canvas.drawPath(this.WG, this.mStrokePaint);
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
        return (int) this.WF.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.WF.height();
    }

    private void a(ArrowDirection arrowDirection, Path path, float f) {
        switch (arrowDirection) {
            case LEFT:
                if (this.WI <= 0.0f) {
                    b(this.WF, path, f);
                    return;
                } else if (f > 0.0f && f > this.WI) {
                    b(this.WF, path, f);
                    return;
                } else {
                    a(this.WF, path, f);
                    return;
                }
            case TOP:
                if (this.WI <= 0.0f) {
                    d(this.WF, path, f);
                    return;
                } else if (f > 0.0f && f > this.WI) {
                    d(this.WF, path, f);
                    return;
                } else {
                    c(this.WF, path, f);
                    return;
                }
            case RIGHT:
                if (this.WI <= 0.0f) {
                    f(this.WF, path, f);
                    return;
                } else if (f > 0.0f && f > this.WI) {
                    f(this.WF, path, f);
                    return;
                } else {
                    e(this.WF, path, f);
                    return;
                }
            case BOTTOM:
                if (this.WI <= 0.0f) {
                    h(this.WF, path, f);
                    return;
                } else if (f > 0.0f && f > this.WI) {
                    h(this.WF, path, f);
                    return;
                } else {
                    g(this.WF, path, f);
                    return;
                }
            default:
                return;
        }
    }

    private void a(RectF rectF, Path path, float f) {
        path.moveTo(this.WH + rectF.left + this.WI + f, rectF.top + f);
        path.lineTo((rectF.width() - this.WI) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.WI, rectF.top + f, rectF.right - f, this.WI + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.WI) - f);
        path.arcTo(new RectF(rectF.right - this.WI, rectF.bottom - this.WI, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.WH + this.WI + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + this.WH + f, rectF.bottom - this.WI, this.WI + rectF.left + this.WH, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.WH + f, (this.WJ + this.WK) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.WK + (this.WJ / 2.0f));
        path.lineTo(rectF.left + this.WH + f, this.WK + (f / 2.0f));
        path.lineTo(rectF.left + this.WH + f, rectF.top + this.WI + f);
        path.arcTo(new RectF(rectF.left + this.WH + f, rectF.top + f, this.WI + rectF.left + this.WH, this.WI + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void b(RectF rectF, Path path, float f) {
        path.moveTo(this.WH + rectF.left + f, rectF.top + f);
        path.lineTo(rectF.width() - f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + this.WH + f, rectF.bottom - f);
        path.lineTo(rectF.left + this.WH + f, (this.WJ + this.WK) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.WK + (this.WJ / 2.0f));
        path.lineTo(rectF.left + this.WH + f, this.WK + (f / 2.0f));
        path.lineTo(rectF.left + this.WH + f, rectF.top + f);
        path.close();
    }

    private void c(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + Math.min(this.WK, this.WI) + f, rectF.top + this.WJ + f);
        path.lineTo(rectF.left + this.WK + (f / 2.0f), rectF.top + this.WJ + f);
        path.lineTo(rectF.left + (this.WH / 2.0f) + this.WK, rectF.top + f + f);
        path.lineTo(((rectF.left + this.WH) + this.WK) - (f / 2.0f), rectF.top + this.WJ + f);
        path.lineTo((rectF.right - this.WI) - f, rectF.top + this.WJ + f);
        path.arcTo(new RectF(rectF.right - this.WI, rectF.top + this.WJ + f, rectF.right - f, this.WI + rectF.top + this.WJ), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.WI) - f);
        path.arcTo(new RectF(rectF.right - this.WI, rectF.bottom - this.WI, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.WI + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.WI, this.WI + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.WJ + this.WI + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + this.WJ + f, this.WI + rectF.left, this.WI + rectF.top + this.WJ), 180.0f, 90.0f);
        path.close();
    }

    private void d(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.WK + f, rectF.top + this.WJ + f);
        path.lineTo(rectF.left + this.WK + (f / 2.0f), rectF.top + this.WJ + f);
        path.lineTo(rectF.left + (this.WH / 2.0f) + this.WK, rectF.top + f + f);
        path.lineTo(((rectF.left + this.WH) + this.WK) - (f / 2.0f), rectF.top + this.WJ + f);
        path.lineTo(rectF.right - f, rectF.top + this.WJ + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + this.WJ + f);
        path.lineTo(rectF.left + this.WK + f, rectF.top + this.WJ + f);
        path.close();
    }

    private void e(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.WI + f, rectF.top + f);
        path.lineTo(((rectF.width() - this.WI) - this.WH) - f, rectF.top + f);
        path.arcTo(new RectF((rectF.right - this.WI) - this.WH, rectF.top + f, (rectF.right - this.WH) - f, this.WI + rectF.top), 270.0f, 90.0f);
        path.lineTo((rectF.right - this.WH) - f, this.WK + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.WK + (this.WJ / 2.0f));
        path.lineTo((rectF.right - this.WH) - f, (this.WK + this.WJ) - (f / 2.0f));
        path.lineTo((rectF.right - this.WH) - f, (rectF.bottom - this.WI) - f);
        path.arcTo(new RectF((rectF.right - this.WI) - this.WH, rectF.bottom - this.WI, (rectF.right - this.WH) - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.WH + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.WI, this.WI + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.WI + rectF.left, this.WI + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void f(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo((rectF.width() - this.WH) - f, rectF.top + f);
        path.lineTo((rectF.right - this.WH) - f, this.WK + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.WK + (this.WJ / 2.0f));
        path.lineTo((rectF.right - this.WH) - f, (this.WK + this.WJ) - (f / 2.0f));
        path.lineTo((rectF.right - this.WH) - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }

    private void g(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.WI + f, rectF.top + f);
        path.lineTo((rectF.width() - this.WI) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.WI, rectF.top + f, rectF.right - f, this.WI + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, ((rectF.bottom - this.WJ) - this.WI) - f);
        path.arcTo(new RectF(rectF.right - this.WI, (rectF.bottom - this.WI) - this.WJ, rectF.right - f, (rectF.bottom - this.WJ) - f), 0.0f, 90.0f);
        path.lineTo(((rectF.left + this.WH) + this.WK) - (f / 2.0f), (rectF.bottom - this.WJ) - f);
        path.lineTo(rectF.left + this.WK + (this.WH / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.WK + (f / 2.0f), (rectF.bottom - this.WJ) - f);
        path.lineTo(rectF.left + Math.min(this.WI, this.WK) + f, (rectF.bottom - this.WJ) - f);
        path.arcTo(new RectF(rectF.left + f, (rectF.bottom - this.WI) - this.WJ, this.WI + rectF.left, (rectF.bottom - this.WJ) - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.WI + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.WI + rectF.left, this.WI + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void h(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.top + f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.WJ) - f);
        path.lineTo(((rectF.left + this.WH) + this.WK) - (f / 2.0f), (rectF.bottom - this.WJ) - f);
        path.lineTo(rectF.left + this.WK + (this.WH / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.WK + (f / 2.0f), (rectF.bottom - this.WJ) - f);
        path.lineTo(rectF.left + this.WK + f, (rectF.bottom - this.WJ) - f);
        path.lineTo(rectF.left + f, (rectF.bottom - this.WJ) - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }
}
