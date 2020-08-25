package com.baidu.tieba.view.bubbleView;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
class a extends Drawable {
    private RectF aCa;
    private Path aCb;
    private float aCc;
    private float aCd;
    private float aCe;
    private float aCf;
    private Paint mStrokePaint;
    private float mStrokeWidth;
    private Path mPath = new Path();
    private Paint mPaint = new Paint(1);

    public a(RectF rectF, float f, float f2, float f3, float f4, float f5, int i, int i2, ArrowDirection arrowDirection) {
        this.aCa = rectF;
        this.aCc = f;
        this.aCd = f2;
        this.aCe = f3;
        this.aCf = f4;
        this.mStrokeWidth = f5;
        this.mPaint.setColor(i2);
        if (f5 > 0.0f) {
            this.mStrokePaint = new Paint(1);
            this.mStrokePaint.setColor(i);
            this.aCb = new Path();
            a(arrowDirection, this.mPath, f5);
            a(arrowDirection, this.aCb, 0.0f);
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
            canvas.drawPath(this.aCb, this.mStrokePaint);
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
        return (int) this.aCa.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.aCa.height();
    }

    private void a(ArrowDirection arrowDirection, Path path, float f) {
        switch (arrowDirection) {
            case LEFT:
                if (this.aCd <= 0.0f) {
                    b(this.aCa, path, f);
                    return;
                } else if (f > 0.0f && f > this.aCd) {
                    b(this.aCa, path, f);
                    return;
                } else {
                    a(this.aCa, path, f);
                    return;
                }
            case TOP:
                if (this.aCd <= 0.0f) {
                    d(this.aCa, path, f);
                    return;
                } else if (f > 0.0f && f > this.aCd) {
                    d(this.aCa, path, f);
                    return;
                } else {
                    c(this.aCa, path, f);
                    return;
                }
            case RIGHT:
                if (this.aCd <= 0.0f) {
                    f(this.aCa, path, f);
                    return;
                } else if (f > 0.0f && f > this.aCd) {
                    f(this.aCa, path, f);
                    return;
                } else {
                    e(this.aCa, path, f);
                    return;
                }
            case BOTTOM:
                if (this.aCd <= 0.0f) {
                    h(this.aCa, path, f);
                    return;
                } else if (f > 0.0f && f > this.aCd) {
                    h(this.aCa, path, f);
                    return;
                } else {
                    g(this.aCa, path, f);
                    return;
                }
            default:
                return;
        }
    }

    private void a(RectF rectF, Path path, float f) {
        path.moveTo(this.aCc + rectF.left + this.aCd + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aCd) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.aCd, rectF.top + f, rectF.right - f, this.aCd + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aCd) - f);
        path.arcTo(new RectF(rectF.right - this.aCd, rectF.bottom - this.aCd, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aCc + this.aCd + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + this.aCc + f, rectF.bottom - this.aCd, this.aCd + rectF.left + this.aCc, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.aCc + f, (this.aCe + this.aCf) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.aCf + (this.aCe / 2.0f));
        path.lineTo(rectF.left + this.aCc + f, this.aCf + (f / 2.0f));
        path.lineTo(rectF.left + this.aCc + f, rectF.top + this.aCd + f);
        path.arcTo(new RectF(rectF.left + this.aCc + f, rectF.top + f, this.aCd + rectF.left + this.aCc, this.aCd + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void b(RectF rectF, Path path, float f) {
        path.moveTo(this.aCc + rectF.left + f, rectF.top + f);
        path.lineTo(rectF.width() - f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + this.aCc + f, rectF.bottom - f);
        path.lineTo(rectF.left + this.aCc + f, (this.aCe + this.aCf) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.aCf + (this.aCe / 2.0f));
        path.lineTo(rectF.left + this.aCc + f, this.aCf + (f / 2.0f));
        path.lineTo(rectF.left + this.aCc + f, rectF.top + f);
        path.close();
    }

    private void c(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + Math.min(this.aCf, this.aCd) + f, rectF.top + this.aCe + f);
        path.lineTo(rectF.left + this.aCf + (f / 2.0f), rectF.top + this.aCe + f);
        path.lineTo(rectF.left + (this.aCc / 2.0f) + this.aCf, rectF.top + f + f);
        path.lineTo(((rectF.left + this.aCc) + this.aCf) - (f / 2.0f), rectF.top + this.aCe + f);
        path.lineTo((rectF.right - this.aCd) - f, rectF.top + this.aCe + f);
        path.arcTo(new RectF(rectF.right - this.aCd, rectF.top + this.aCe + f, rectF.right - f, this.aCd + rectF.top + this.aCe), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aCd) - f);
        path.arcTo(new RectF(rectF.right - this.aCd, rectF.bottom - this.aCd, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aCd + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.aCd, this.aCd + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.aCe + this.aCd + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + this.aCe + f, this.aCd + rectF.left, this.aCd + rectF.top + this.aCe), 180.0f, 90.0f);
        path.close();
    }

    private void d(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aCf + f, rectF.top + this.aCe + f);
        path.lineTo(rectF.left + this.aCf + (f / 2.0f), rectF.top + this.aCe + f);
        path.lineTo(rectF.left + (this.aCc / 2.0f) + this.aCf, rectF.top + f + f);
        path.lineTo(((rectF.left + this.aCc) + this.aCf) - (f / 2.0f), rectF.top + this.aCe + f);
        path.lineTo(rectF.right - f, rectF.top + this.aCe + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + this.aCe + f);
        path.lineTo(rectF.left + this.aCf + f, rectF.top + this.aCe + f);
        path.close();
    }

    private void e(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aCd + f, rectF.top + f);
        path.lineTo(((rectF.width() - this.aCd) - this.aCc) - f, rectF.top + f);
        path.arcTo(new RectF((rectF.right - this.aCd) - this.aCc, rectF.top + f, (rectF.right - this.aCc) - f, this.aCd + rectF.top), 270.0f, 90.0f);
        path.lineTo((rectF.right - this.aCc) - f, this.aCf + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.aCf + (this.aCe / 2.0f));
        path.lineTo((rectF.right - this.aCc) - f, (this.aCf + this.aCe) - (f / 2.0f));
        path.lineTo((rectF.right - this.aCc) - f, (rectF.bottom - this.aCd) - f);
        path.arcTo(new RectF((rectF.right - this.aCd) - this.aCc, rectF.bottom - this.aCd, (rectF.right - this.aCc) - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aCc + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.aCd, this.aCd + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.aCd + rectF.left, this.aCd + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void f(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aCc) - f, rectF.top + f);
        path.lineTo((rectF.right - this.aCc) - f, this.aCf + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.aCf + (this.aCe / 2.0f));
        path.lineTo((rectF.right - this.aCc) - f, (this.aCf + this.aCe) - (f / 2.0f));
        path.lineTo((rectF.right - this.aCc) - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }

    private void g(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aCd + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aCd) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.aCd, rectF.top + f, rectF.right - f, this.aCd + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, ((rectF.bottom - this.aCe) - this.aCd) - f);
        path.arcTo(new RectF(rectF.right - this.aCd, (rectF.bottom - this.aCd) - this.aCe, rectF.right - f, (rectF.bottom - this.aCe) - f), 0.0f, 90.0f);
        path.lineTo(((rectF.left + this.aCc) + this.aCf) - (f / 2.0f), (rectF.bottom - this.aCe) - f);
        path.lineTo(rectF.left + this.aCf + (this.aCc / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.aCf + (f / 2.0f), (rectF.bottom - this.aCe) - f);
        path.lineTo(rectF.left + Math.min(this.aCd, this.aCf) + f, (rectF.bottom - this.aCe) - f);
        path.arcTo(new RectF(rectF.left + f, (rectF.bottom - this.aCd) - this.aCe, this.aCd + rectF.left, (rectF.bottom - this.aCe) - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.aCd + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.aCd + rectF.left, this.aCd + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void h(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.top + f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aCe) - f);
        path.lineTo(((rectF.left + this.aCc) + this.aCf) - (f / 2.0f), (rectF.bottom - this.aCe) - f);
        path.lineTo(rectF.left + this.aCf + (this.aCc / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.aCf + (f / 2.0f), (rectF.bottom - this.aCe) - f);
        path.lineTo(rectF.left + this.aCf + f, (rectF.bottom - this.aCe) - f);
        path.lineTo(rectF.left + f, (rectF.bottom - this.aCe) - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }
}
