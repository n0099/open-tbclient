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
    private RectF aoX;
    private Path aoY;
    private float aoZ;
    private float apa;
    private float apb;
    private float apc;
    private Paint mStrokePaint;
    private float mStrokeWidth;
    private Path mPath = new Path();
    private Paint mPaint = new Paint(1);

    public a(RectF rectF, float f, float f2, float f3, float f4, float f5, int i, int i2, ArrowDirection arrowDirection) {
        this.aoX = rectF;
        this.aoZ = f;
        this.apa = f2;
        this.apb = f3;
        this.apc = f4;
        this.mStrokeWidth = f5;
        this.mPaint.setColor(i2);
        if (f5 > 0.0f) {
            this.mStrokePaint = new Paint(1);
            this.mStrokePaint.setColor(i);
            this.aoY = new Path();
            a(arrowDirection, this.mPath, f5);
            a(arrowDirection, this.aoY, 0.0f);
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
            canvas.drawPath(this.aoY, this.mStrokePaint);
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
        return (int) this.aoX.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.aoX.height();
    }

    private void a(ArrowDirection arrowDirection, Path path, float f) {
        switch (arrowDirection) {
            case LEFT:
                if (this.apa <= 0.0f) {
                    b(this.aoX, path, f);
                    return;
                } else if (f > 0.0f && f > this.apa) {
                    b(this.aoX, path, f);
                    return;
                } else {
                    a(this.aoX, path, f);
                    return;
                }
            case TOP:
                if (this.apa <= 0.0f) {
                    d(this.aoX, path, f);
                    return;
                } else if (f > 0.0f && f > this.apa) {
                    d(this.aoX, path, f);
                    return;
                } else {
                    c(this.aoX, path, f);
                    return;
                }
            case RIGHT:
                if (this.apa <= 0.0f) {
                    f(this.aoX, path, f);
                    return;
                } else if (f > 0.0f && f > this.apa) {
                    f(this.aoX, path, f);
                    return;
                } else {
                    e(this.aoX, path, f);
                    return;
                }
            case BOTTOM:
                if (this.apa <= 0.0f) {
                    h(this.aoX, path, f);
                    return;
                } else if (f > 0.0f && f > this.apa) {
                    h(this.aoX, path, f);
                    return;
                } else {
                    g(this.aoX, path, f);
                    return;
                }
            default:
                return;
        }
    }

    private void a(RectF rectF, Path path, float f) {
        path.moveTo(this.aoZ + rectF.left + this.apa + f, rectF.top + f);
        path.lineTo((rectF.width() - this.apa) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.apa, rectF.top + f, rectF.right - f, this.apa + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.apa) - f);
        path.arcTo(new RectF(rectF.right - this.apa, rectF.bottom - this.apa, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aoZ + this.apa + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + this.aoZ + f, rectF.bottom - this.apa, this.apa + rectF.left + this.aoZ, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.aoZ + f, (this.apb + this.apc) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.apc + (this.apb / 2.0f));
        path.lineTo(rectF.left + this.aoZ + f, this.apc + (f / 2.0f));
        path.lineTo(rectF.left + this.aoZ + f, rectF.top + this.apa + f);
        path.arcTo(new RectF(rectF.left + this.aoZ + f, rectF.top + f, this.apa + rectF.left + this.aoZ, this.apa + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void b(RectF rectF, Path path, float f) {
        path.moveTo(this.aoZ + rectF.left + f, rectF.top + f);
        path.lineTo(rectF.width() - f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + this.aoZ + f, rectF.bottom - f);
        path.lineTo(rectF.left + this.aoZ + f, (this.apb + this.apc) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.apc + (this.apb / 2.0f));
        path.lineTo(rectF.left + this.aoZ + f, this.apc + (f / 2.0f));
        path.lineTo(rectF.left + this.aoZ + f, rectF.top + f);
        path.close();
    }

    private void c(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + Math.min(this.apc, this.apa) + f, rectF.top + this.apb + f);
        path.lineTo(rectF.left + this.apc + (f / 2.0f), rectF.top + this.apb + f);
        path.lineTo(rectF.left + (this.aoZ / 2.0f) + this.apc, rectF.top + f + f);
        path.lineTo(((rectF.left + this.aoZ) + this.apc) - (f / 2.0f), rectF.top + this.apb + f);
        path.lineTo((rectF.right - this.apa) - f, rectF.top + this.apb + f);
        path.arcTo(new RectF(rectF.right - this.apa, rectF.top + this.apb + f, rectF.right - f, this.apa + rectF.top + this.apb), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.apa) - f);
        path.arcTo(new RectF(rectF.right - this.apa, rectF.bottom - this.apa, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.apa + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.apa, this.apa + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.apb + this.apa + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + this.apb + f, this.apa + rectF.left, this.apa + rectF.top + this.apb), 180.0f, 90.0f);
        path.close();
    }

    private void d(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.apc + f, rectF.top + this.apb + f);
        path.lineTo(rectF.left + this.apc + (f / 2.0f), rectF.top + this.apb + f);
        path.lineTo(rectF.left + (this.aoZ / 2.0f) + this.apc, rectF.top + f + f);
        path.lineTo(((rectF.left + this.aoZ) + this.apc) - (f / 2.0f), rectF.top + this.apb + f);
        path.lineTo(rectF.right - f, rectF.top + this.apb + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + this.apb + f);
        path.lineTo(rectF.left + this.apc + f, rectF.top + this.apb + f);
        path.close();
    }

    private void e(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.apa + f, rectF.top + f);
        path.lineTo(((rectF.width() - this.apa) - this.aoZ) - f, rectF.top + f);
        path.arcTo(new RectF((rectF.right - this.apa) - this.aoZ, rectF.top + f, (rectF.right - this.aoZ) - f, this.apa + rectF.top), 270.0f, 90.0f);
        path.lineTo((rectF.right - this.aoZ) - f, this.apc + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.apc + (this.apb / 2.0f));
        path.lineTo((rectF.right - this.aoZ) - f, (this.apc + this.apb) - (f / 2.0f));
        path.lineTo((rectF.right - this.aoZ) - f, (rectF.bottom - this.apa) - f);
        path.arcTo(new RectF((rectF.right - this.apa) - this.aoZ, rectF.bottom - this.apa, (rectF.right - this.aoZ) - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aoZ + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.apa, this.apa + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.apa + rectF.left, this.apa + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void f(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aoZ) - f, rectF.top + f);
        path.lineTo((rectF.right - this.aoZ) - f, this.apc + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.apc + (this.apb / 2.0f));
        path.lineTo((rectF.right - this.aoZ) - f, (this.apc + this.apb) - (f / 2.0f));
        path.lineTo((rectF.right - this.aoZ) - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }

    private void g(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.apa + f, rectF.top + f);
        path.lineTo((rectF.width() - this.apa) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.apa, rectF.top + f, rectF.right - f, this.apa + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, ((rectF.bottom - this.apb) - this.apa) - f);
        path.arcTo(new RectF(rectF.right - this.apa, (rectF.bottom - this.apa) - this.apb, rectF.right - f, (rectF.bottom - this.apb) - f), 0.0f, 90.0f);
        path.lineTo(((rectF.left + this.aoZ) + this.apc) - (f / 2.0f), (rectF.bottom - this.apb) - f);
        path.lineTo(rectF.left + this.apc + (this.aoZ / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.apc + (f / 2.0f), (rectF.bottom - this.apb) - f);
        path.lineTo(rectF.left + Math.min(this.apa, this.apc) + f, (rectF.bottom - this.apb) - f);
        path.arcTo(new RectF(rectF.left + f, (rectF.bottom - this.apa) - this.apb, this.apa + rectF.left, (rectF.bottom - this.apb) - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.apa + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.apa + rectF.left, this.apa + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void h(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.top + f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.apb) - f);
        path.lineTo(((rectF.left + this.aoZ) + this.apc) - (f / 2.0f), (rectF.bottom - this.apb) - f);
        path.lineTo(rectF.left + this.apc + (this.aoZ / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.apc + (f / 2.0f), (rectF.bottom - this.apb) - f);
        path.lineTo(rectF.left + this.apc + f, (rectF.bottom - this.apb) - f);
        path.lineTo(rectF.left + f, (rectF.bottom - this.apb) - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }
}
