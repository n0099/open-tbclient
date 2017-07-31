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
    private float mArrowHeight;
    private float mArrowPosition;
    private float mArrowWidth;
    private float mCornersRadius;
    private RectF mRect;
    private Paint mStrokePaint;
    private Path mStrokePath;
    private float mStrokeWidth;
    private Path mPath = new Path();
    private Paint mPaint = new Paint(1);

    public a(RectF rectF, float f, float f2, float f3, float f4, float f5, int i, int i2, ArrowDirection arrowDirection) {
        this.mRect = rectF;
        this.mArrowWidth = f;
        this.mCornersRadius = f2;
        this.mArrowHeight = f3;
        this.mArrowPosition = f4;
        this.mStrokeWidth = f5;
        this.mPaint.setColor(i2);
        if (f5 > 0.0f) {
            this.mStrokePaint = new Paint(1);
            this.mStrokePaint.setColor(i);
            this.mStrokePath = new Path();
            a(arrowDirection, this.mPath, f5);
            a(arrowDirection, this.mStrokePath, 0.0f);
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
            canvas.drawPath(this.mStrokePath, this.mStrokePaint);
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
                if (this.mCornersRadius <= 0.0f) {
                    initLeftSquarePath(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.mCornersRadius) {
                    initLeftSquarePath(this.mRect, path, f);
                    return;
                } else {
                    initLeftRoundedPath(this.mRect, path, f);
                    return;
                }
            case TOP:
                if (this.mCornersRadius <= 0.0f) {
                    initTopSquarePath(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.mCornersRadius) {
                    initTopSquarePath(this.mRect, path, f);
                    return;
                } else {
                    initTopRoundedPath(this.mRect, path, f);
                    return;
                }
            case RIGHT:
                if (this.mCornersRadius <= 0.0f) {
                    initRightSquarePath(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.mCornersRadius) {
                    initRightSquarePath(this.mRect, path, f);
                    return;
                } else {
                    initRightRoundedPath(this.mRect, path, f);
                    return;
                }
            case BOTTOM:
                if (this.mCornersRadius <= 0.0f) {
                    initBottomSquarePath(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.mCornersRadius) {
                    initBottomSquarePath(this.mRect, path, f);
                    return;
                } else {
                    initBottomRoundedPath(this.mRect, path, f);
                    return;
                }
            default:
                return;
        }
    }

    private void initLeftRoundedPath(RectF rectF, Path path, float f) {
        path.moveTo(this.mArrowWidth + rectF.left + this.mCornersRadius + f, rectF.top + f);
        path.lineTo((rectF.width() - this.mCornersRadius) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.mCornersRadius, rectF.top + f, rectF.right - f, this.mCornersRadius + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.mCornersRadius) - f);
        path.arcTo(new RectF(rectF.right - this.mCornersRadius, rectF.bottom - this.mCornersRadius, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.mArrowWidth + this.mCornersRadius + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + this.mArrowWidth + f, rectF.bottom - this.mCornersRadius, this.mCornersRadius + rectF.left + this.mArrowWidth, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.mArrowWidth + f, (this.mArrowHeight + this.mArrowPosition) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.mArrowPosition + (this.mArrowHeight / 2.0f));
        path.lineTo(rectF.left + this.mArrowWidth + f, this.mArrowPosition + (f / 2.0f));
        path.lineTo(rectF.left + this.mArrowWidth + f, rectF.top + this.mCornersRadius + f);
        path.arcTo(new RectF(rectF.left + this.mArrowWidth + f, rectF.top + f, this.mCornersRadius + rectF.left + this.mArrowWidth, this.mCornersRadius + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void initLeftSquarePath(RectF rectF, Path path, float f) {
        path.moveTo(this.mArrowWidth + rectF.left + f, rectF.top + f);
        path.lineTo(rectF.width() - f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + this.mArrowWidth + f, rectF.bottom - f);
        path.lineTo(rectF.left + this.mArrowWidth + f, (this.mArrowHeight + this.mArrowPosition) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.mArrowPosition + (this.mArrowHeight / 2.0f));
        path.lineTo(rectF.left + this.mArrowWidth + f, this.mArrowPosition + (f / 2.0f));
        path.lineTo(rectF.left + this.mArrowWidth + f, rectF.top + f);
        path.close();
    }

    private void initTopRoundedPath(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + Math.min(this.mArrowPosition, this.mCornersRadius) + f, rectF.top + this.mArrowHeight + f);
        path.lineTo(rectF.left + this.mArrowPosition + (f / 2.0f), rectF.top + this.mArrowHeight + f);
        path.lineTo(rectF.left + (this.mArrowWidth / 2.0f) + this.mArrowPosition, rectF.top + f + f);
        path.lineTo(((rectF.left + this.mArrowWidth) + this.mArrowPosition) - (f / 2.0f), rectF.top + this.mArrowHeight + f);
        path.lineTo((rectF.right - this.mCornersRadius) - f, rectF.top + this.mArrowHeight + f);
        path.arcTo(new RectF(rectF.right - this.mCornersRadius, rectF.top + this.mArrowHeight + f, rectF.right - f, this.mCornersRadius + rectF.top + this.mArrowHeight), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.mCornersRadius) - f);
        path.arcTo(new RectF(rectF.right - this.mCornersRadius, rectF.bottom - this.mCornersRadius, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.mCornersRadius + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.mCornersRadius, this.mCornersRadius + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.mArrowHeight + this.mCornersRadius + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + this.mArrowHeight + f, this.mCornersRadius + rectF.left, this.mCornersRadius + rectF.top + this.mArrowHeight), 180.0f, 90.0f);
        path.close();
    }

    private void initTopSquarePath(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.mArrowPosition + f, rectF.top + this.mArrowHeight + f);
        path.lineTo(rectF.left + this.mArrowPosition + (f / 2.0f), rectF.top + this.mArrowHeight + f);
        path.lineTo(rectF.left + (this.mArrowWidth / 2.0f) + this.mArrowPosition, rectF.top + f + f);
        path.lineTo(((rectF.left + this.mArrowWidth) + this.mArrowPosition) - (f / 2.0f), rectF.top + this.mArrowHeight + f);
        path.lineTo(rectF.right - f, rectF.top + this.mArrowHeight + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + this.mArrowHeight + f);
        path.lineTo(rectF.left + this.mArrowPosition + f, rectF.top + this.mArrowHeight + f);
        path.close();
    }

    private void initRightRoundedPath(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.mCornersRadius + f, rectF.top + f);
        path.lineTo(((rectF.width() - this.mCornersRadius) - this.mArrowWidth) - f, rectF.top + f);
        path.arcTo(new RectF((rectF.right - this.mCornersRadius) - this.mArrowWidth, rectF.top + f, (rectF.right - this.mArrowWidth) - f, this.mCornersRadius + rectF.top), 270.0f, 90.0f);
        path.lineTo((rectF.right - this.mArrowWidth) - f, this.mArrowPosition + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.mArrowPosition + (this.mArrowHeight / 2.0f));
        path.lineTo((rectF.right - this.mArrowWidth) - f, (this.mArrowPosition + this.mArrowHeight) - (f / 2.0f));
        path.lineTo((rectF.right - this.mArrowWidth) - f, (rectF.bottom - this.mCornersRadius) - f);
        path.arcTo(new RectF((rectF.right - this.mCornersRadius) - this.mArrowWidth, rectF.bottom - this.mCornersRadius, (rectF.right - this.mArrowWidth) - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.mArrowWidth + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.mCornersRadius, this.mCornersRadius + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.mCornersRadius + rectF.left, this.mCornersRadius + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void initRightSquarePath(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo((rectF.width() - this.mArrowWidth) - f, rectF.top + f);
        path.lineTo((rectF.right - this.mArrowWidth) - f, this.mArrowPosition + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.mArrowPosition + (this.mArrowHeight / 2.0f));
        path.lineTo((rectF.right - this.mArrowWidth) - f, (this.mArrowPosition + this.mArrowHeight) - (f / 2.0f));
        path.lineTo((rectF.right - this.mArrowWidth) - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }

    private void initBottomRoundedPath(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.mCornersRadius + f, rectF.top + f);
        path.lineTo((rectF.width() - this.mCornersRadius) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.mCornersRadius, rectF.top + f, rectF.right - f, this.mCornersRadius + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, ((rectF.bottom - this.mArrowHeight) - this.mCornersRadius) - f);
        path.arcTo(new RectF(rectF.right - this.mCornersRadius, (rectF.bottom - this.mCornersRadius) - this.mArrowHeight, rectF.right - f, (rectF.bottom - this.mArrowHeight) - f), 0.0f, 90.0f);
        path.lineTo(((rectF.left + this.mArrowWidth) + this.mArrowPosition) - (f / 2.0f), (rectF.bottom - this.mArrowHeight) - f);
        path.lineTo(rectF.left + this.mArrowPosition + (this.mArrowWidth / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.mArrowPosition + (f / 2.0f), (rectF.bottom - this.mArrowHeight) - f);
        path.lineTo(rectF.left + Math.min(this.mCornersRadius, this.mArrowPosition) + f, (rectF.bottom - this.mArrowHeight) - f);
        path.arcTo(new RectF(rectF.left + f, (rectF.bottom - this.mCornersRadius) - this.mArrowHeight, this.mCornersRadius + rectF.left, (rectF.bottom - this.mArrowHeight) - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.mCornersRadius + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.mCornersRadius + rectF.left, this.mCornersRadius + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void initBottomSquarePath(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.top + f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.mArrowHeight) - f);
        path.lineTo(((rectF.left + this.mArrowWidth) + this.mArrowPosition) - (f / 2.0f), (rectF.bottom - this.mArrowHeight) - f);
        path.lineTo(rectF.left + this.mArrowPosition + (this.mArrowWidth / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.mArrowPosition + (f / 2.0f), (rectF.bottom - this.mArrowHeight) - f);
        path.lineTo(rectF.left + this.mArrowPosition + f, (rectF.bottom - this.mArrowHeight) - f);
        path.lineTo(rectF.left + f, (rectF.bottom - this.mArrowHeight) - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }
}
