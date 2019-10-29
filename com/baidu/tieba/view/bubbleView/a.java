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
    private RectF Ol;
    private Path Om;
    private float On;
    private float Oo;
    private float Op;
    private float Oq;
    private Paint mStrokePaint;
    private float mStrokeWidth;
    private Path mPath = new Path();
    private Paint mPaint = new Paint(1);

    public a(RectF rectF, float f, float f2, float f3, float f4, float f5, int i, int i2, ArrowDirection arrowDirection) {
        this.Ol = rectF;
        this.On = f;
        this.Oo = f2;
        this.Op = f3;
        this.Oq = f4;
        this.mStrokeWidth = f5;
        this.mPaint.setColor(i2);
        if (f5 > 0.0f) {
            this.mStrokePaint = new Paint(1);
            this.mStrokePaint.setColor(i);
            this.Om = new Path();
            a(arrowDirection, this.mPath, f5);
            a(arrowDirection, this.Om, 0.0f);
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
            canvas.drawPath(this.Om, this.mStrokePaint);
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
        return (int) this.Ol.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.Ol.height();
    }

    private void a(ArrowDirection arrowDirection, Path path, float f) {
        switch (arrowDirection) {
            case LEFT:
                if (this.Oo <= 0.0f) {
                    b(this.Ol, path, f);
                    return;
                } else if (f > 0.0f && f > this.Oo) {
                    b(this.Ol, path, f);
                    return;
                } else {
                    a(this.Ol, path, f);
                    return;
                }
            case TOP:
                if (this.Oo <= 0.0f) {
                    d(this.Ol, path, f);
                    return;
                } else if (f > 0.0f && f > this.Oo) {
                    d(this.Ol, path, f);
                    return;
                } else {
                    c(this.Ol, path, f);
                    return;
                }
            case RIGHT:
                if (this.Oo <= 0.0f) {
                    f(this.Ol, path, f);
                    return;
                } else if (f > 0.0f && f > this.Oo) {
                    f(this.Ol, path, f);
                    return;
                } else {
                    e(this.Ol, path, f);
                    return;
                }
            case BOTTOM:
                if (this.Oo <= 0.0f) {
                    h(this.Ol, path, f);
                    return;
                } else if (f > 0.0f && f > this.Oo) {
                    h(this.Ol, path, f);
                    return;
                } else {
                    g(this.Ol, path, f);
                    return;
                }
            default:
                return;
        }
    }

    private void a(RectF rectF, Path path, float f) {
        path.moveTo(this.On + rectF.left + this.Oo + f, rectF.top + f);
        path.lineTo((rectF.width() - this.Oo) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.Oo, rectF.top + f, rectF.right - f, this.Oo + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.Oo) - f);
        path.arcTo(new RectF(rectF.right - this.Oo, rectF.bottom - this.Oo, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.On + this.Oo + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + this.On + f, rectF.bottom - this.Oo, this.Oo + rectF.left + this.On, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.On + f, (this.Op + this.Oq) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.Oq + (this.Op / 2.0f));
        path.lineTo(rectF.left + this.On + f, this.Oq + (f / 2.0f));
        path.lineTo(rectF.left + this.On + f, rectF.top + this.Oo + f);
        path.arcTo(new RectF(rectF.left + this.On + f, rectF.top + f, this.Oo + rectF.left + this.On, this.Oo + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void b(RectF rectF, Path path, float f) {
        path.moveTo(this.On + rectF.left + f, rectF.top + f);
        path.lineTo(rectF.width() - f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + this.On + f, rectF.bottom - f);
        path.lineTo(rectF.left + this.On + f, (this.Op + this.Oq) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.Oq + (this.Op / 2.0f));
        path.lineTo(rectF.left + this.On + f, this.Oq + (f / 2.0f));
        path.lineTo(rectF.left + this.On + f, rectF.top + f);
        path.close();
    }

    private void c(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + Math.min(this.Oq, this.Oo) + f, rectF.top + this.Op + f);
        path.lineTo(rectF.left + this.Oq + (f / 2.0f), rectF.top + this.Op + f);
        path.lineTo(rectF.left + (this.On / 2.0f) + this.Oq, rectF.top + f + f);
        path.lineTo(((rectF.left + this.On) + this.Oq) - (f / 2.0f), rectF.top + this.Op + f);
        path.lineTo((rectF.right - this.Oo) - f, rectF.top + this.Op + f);
        path.arcTo(new RectF(rectF.right - this.Oo, rectF.top + this.Op + f, rectF.right - f, this.Oo + rectF.top + this.Op), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.Oo) - f);
        path.arcTo(new RectF(rectF.right - this.Oo, rectF.bottom - this.Oo, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.Oo + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.Oo, this.Oo + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.Op + this.Oo + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + this.Op + f, this.Oo + rectF.left, this.Oo + rectF.top + this.Op), 180.0f, 90.0f);
        path.close();
    }

    private void d(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.Oq + f, rectF.top + this.Op + f);
        path.lineTo(rectF.left + this.Oq + (f / 2.0f), rectF.top + this.Op + f);
        path.lineTo(rectF.left + (this.On / 2.0f) + this.Oq, rectF.top + f + f);
        path.lineTo(((rectF.left + this.On) + this.Oq) - (f / 2.0f), rectF.top + this.Op + f);
        path.lineTo(rectF.right - f, rectF.top + this.Op + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + this.Op + f);
        path.lineTo(rectF.left + this.Oq + f, rectF.top + this.Op + f);
        path.close();
    }

    private void e(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.Oo + f, rectF.top + f);
        path.lineTo(((rectF.width() - this.Oo) - this.On) - f, rectF.top + f);
        path.arcTo(new RectF((rectF.right - this.Oo) - this.On, rectF.top + f, (rectF.right - this.On) - f, this.Oo + rectF.top), 270.0f, 90.0f);
        path.lineTo((rectF.right - this.On) - f, this.Oq + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.Oq + (this.Op / 2.0f));
        path.lineTo((rectF.right - this.On) - f, (this.Oq + this.Op) - (f / 2.0f));
        path.lineTo((rectF.right - this.On) - f, (rectF.bottom - this.Oo) - f);
        path.arcTo(new RectF((rectF.right - this.Oo) - this.On, rectF.bottom - this.Oo, (rectF.right - this.On) - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.On + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.Oo, this.Oo + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.Oo + rectF.left, this.Oo + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void f(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo((rectF.width() - this.On) - f, rectF.top + f);
        path.lineTo((rectF.right - this.On) - f, this.Oq + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.Oq + (this.Op / 2.0f));
        path.lineTo((rectF.right - this.On) - f, (this.Oq + this.Op) - (f / 2.0f));
        path.lineTo((rectF.right - this.On) - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }

    private void g(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.Oo + f, rectF.top + f);
        path.lineTo((rectF.width() - this.Oo) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.Oo, rectF.top + f, rectF.right - f, this.Oo + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, ((rectF.bottom - this.Op) - this.Oo) - f);
        path.arcTo(new RectF(rectF.right - this.Oo, (rectF.bottom - this.Oo) - this.Op, rectF.right - f, (rectF.bottom - this.Op) - f), 0.0f, 90.0f);
        path.lineTo(((rectF.left + this.On) + this.Oq) - (f / 2.0f), (rectF.bottom - this.Op) - f);
        path.lineTo(rectF.left + this.Oq + (this.On / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.Oq + (f / 2.0f), (rectF.bottom - this.Op) - f);
        path.lineTo(rectF.left + Math.min(this.Oo, this.Oq) + f, (rectF.bottom - this.Op) - f);
        path.arcTo(new RectF(rectF.left + f, (rectF.bottom - this.Oo) - this.Op, this.Oo + rectF.left, (rectF.bottom - this.Op) - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.Oo + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.Oo + rectF.left, this.Oo + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void h(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.top + f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.Op) - f);
        path.lineTo(((rectF.left + this.On) + this.Oq) - (f / 2.0f), (rectF.bottom - this.Op) - f);
        path.lineTo(rectF.left + this.Oq + (this.On / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.Oq + (f / 2.0f), (rectF.bottom - this.Op) - f);
        path.lineTo(rectF.left + this.Oq + f, (rectF.bottom - this.Op) - f);
        path.lineTo(rectF.left + f, (rectF.bottom - this.Op) - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }
}
