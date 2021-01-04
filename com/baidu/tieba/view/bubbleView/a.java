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
    private Path aIf;
    private float aIg;
    private float aIh;
    private float aIi;
    private float aIj;
    private RectF mRect;
    private Paint mStrokePaint;
    private float mStrokeWidth;
    private Path mPath = new Path();
    private Paint mPaint = new Paint(1);

    public a(RectF rectF, float f, float f2, float f3, float f4, float f5, int i, int i2, ArrowDirection arrowDirection) {
        this.mRect = rectF;
        this.aIg = f;
        this.aIh = f2;
        this.aIi = f3;
        this.aIj = f4;
        this.mStrokeWidth = f5;
        this.mPaint.setColor(i2);
        if (f5 > 0.0f) {
            this.mStrokePaint = new Paint(1);
            this.mStrokePaint.setColor(i);
            this.aIf = new Path();
            a(arrowDirection, this.mPath, f5);
            a(arrowDirection, this.aIf, 0.0f);
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
            canvas.drawPath(this.aIf, this.mStrokePaint);
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
                if (this.aIh <= 0.0f) {
                    b(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aIh) {
                    b(this.mRect, path, f);
                    return;
                } else {
                    a(this.mRect, path, f);
                    return;
                }
            case TOP:
                if (this.aIh <= 0.0f) {
                    d(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aIh) {
                    d(this.mRect, path, f);
                    return;
                } else {
                    c(this.mRect, path, f);
                    return;
                }
            case RIGHT:
                if (this.aIh <= 0.0f) {
                    f(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aIh) {
                    f(this.mRect, path, f);
                    return;
                } else {
                    e(this.mRect, path, f);
                    return;
                }
            case BOTTOM:
                if (this.aIh <= 0.0f) {
                    h(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aIh) {
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
        path.moveTo(this.aIg + rectF.left + this.aIh + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aIh) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.aIh, rectF.top + f, rectF.right - f, this.aIh + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aIh) - f);
        path.arcTo(new RectF(rectF.right - this.aIh, rectF.bottom - this.aIh, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aIg + this.aIh + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + this.aIg + f, rectF.bottom - this.aIh, this.aIh + rectF.left + this.aIg, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.aIg + f, (this.aIi + this.aIj) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.aIj + (this.aIi / 2.0f));
        path.lineTo(rectF.left + this.aIg + f, this.aIj + (f / 2.0f));
        path.lineTo(rectF.left + this.aIg + f, rectF.top + this.aIh + f);
        path.arcTo(new RectF(rectF.left + this.aIg + f, rectF.top + f, this.aIh + rectF.left + this.aIg, this.aIh + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void b(RectF rectF, Path path, float f) {
        path.moveTo(this.aIg + rectF.left + f, rectF.top + f);
        path.lineTo(rectF.width() - f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + this.aIg + f, rectF.bottom - f);
        path.lineTo(rectF.left + this.aIg + f, (this.aIi + this.aIj) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.aIj + (this.aIi / 2.0f));
        path.lineTo(rectF.left + this.aIg + f, this.aIj + (f / 2.0f));
        path.lineTo(rectF.left + this.aIg + f, rectF.top + f);
        path.close();
    }

    private void c(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + Math.min(this.aIj, this.aIh) + f, rectF.top + this.aIi + f);
        path.lineTo(rectF.left + this.aIj + (f / 2.0f), rectF.top + this.aIi + f);
        path.lineTo(rectF.left + (this.aIg / 2.0f) + this.aIj, rectF.top + f + f);
        path.lineTo(((rectF.left + this.aIg) + this.aIj) - (f / 2.0f), rectF.top + this.aIi + f);
        path.lineTo((rectF.right - this.aIh) - f, rectF.top + this.aIi + f);
        path.arcTo(new RectF(rectF.right - this.aIh, rectF.top + this.aIi + f, rectF.right - f, this.aIh + rectF.top + this.aIi), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aIh) - f);
        path.arcTo(new RectF(rectF.right - this.aIh, rectF.bottom - this.aIh, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aIh + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.aIh, this.aIh + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.aIi + this.aIh + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + this.aIi + f, this.aIh + rectF.left, this.aIh + rectF.top + this.aIi), 180.0f, 90.0f);
        path.close();
    }

    private void d(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aIj + f, rectF.top + this.aIi + f);
        path.lineTo(rectF.left + this.aIj + (f / 2.0f), rectF.top + this.aIi + f);
        path.lineTo(rectF.left + (this.aIg / 2.0f) + this.aIj, rectF.top + f + f);
        path.lineTo(((rectF.left + this.aIg) + this.aIj) - (f / 2.0f), rectF.top + this.aIi + f);
        path.lineTo(rectF.right - f, rectF.top + this.aIi + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + this.aIi + f);
        path.lineTo(rectF.left + this.aIj + f, rectF.top + this.aIi + f);
        path.close();
    }

    private void e(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aIh + f, rectF.top + f);
        path.lineTo(((rectF.width() - this.aIh) - this.aIg) - f, rectF.top + f);
        path.arcTo(new RectF((rectF.right - this.aIh) - this.aIg, rectF.top + f, (rectF.right - this.aIg) - f, this.aIh + rectF.top), 270.0f, 90.0f);
        path.lineTo((rectF.right - this.aIg) - f, this.aIj + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.aIj + (this.aIi / 2.0f));
        path.lineTo((rectF.right - this.aIg) - f, (this.aIj + this.aIi) - (f / 2.0f));
        path.lineTo((rectF.right - this.aIg) - f, (rectF.bottom - this.aIh) - f);
        path.arcTo(new RectF((rectF.right - this.aIh) - this.aIg, rectF.bottom - this.aIh, (rectF.right - this.aIg) - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aIg + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.aIh, this.aIh + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.aIh + rectF.left, this.aIh + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void f(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aIg) - f, rectF.top + f);
        path.lineTo((rectF.right - this.aIg) - f, this.aIj + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.aIj + (this.aIi / 2.0f));
        path.lineTo((rectF.right - this.aIg) - f, (this.aIj + this.aIi) - (f / 2.0f));
        path.lineTo((rectF.right - this.aIg) - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }

    private void g(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aIh + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aIh) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.aIh, rectF.top + f, rectF.right - f, this.aIh + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, ((rectF.bottom - this.aIi) - this.aIh) - f);
        path.arcTo(new RectF(rectF.right - this.aIh, (rectF.bottom - this.aIh) - this.aIi, rectF.right - f, (rectF.bottom - this.aIi) - f), 0.0f, 90.0f);
        path.lineTo(((rectF.left + this.aIg) + this.aIj) - (f / 2.0f), (rectF.bottom - this.aIi) - f);
        path.lineTo(rectF.left + this.aIj + (this.aIg / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.aIj + (f / 2.0f), (rectF.bottom - this.aIi) - f);
        path.lineTo(rectF.left + Math.min(this.aIh, this.aIj) + f, (rectF.bottom - this.aIi) - f);
        path.arcTo(new RectF(rectF.left + f, (rectF.bottom - this.aIh) - this.aIi, this.aIh + rectF.left, (rectF.bottom - this.aIi) - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.aIh + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.aIh + rectF.left, this.aIh + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void h(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.top + f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aIi) - f);
        path.lineTo(((rectF.left + this.aIg) + this.aIj) - (f / 2.0f), (rectF.bottom - this.aIi) - f);
        path.lineTo(rectF.left + this.aIj + (this.aIg / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.aIj + (f / 2.0f), (rectF.bottom - this.aIi) - f);
        path.lineTo(rectF.left + this.aIj + f, (rectF.bottom - this.aIi) - f);
        path.lineTo(rectF.left + f, (rectF.bottom - this.aIi) - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }
}
