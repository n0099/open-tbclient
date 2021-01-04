package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
/* loaded from: classes8.dex */
public class PersonExpandImageView extends ImageView {
    private final DisplayMetrics mAQ;
    private int mAR;
    private final Rect mDstRect;
    private final Paint mPaint;
    private final Rect mSrcRect;

    public PersonExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSrcRect = new Rect();
        this.mDstRect = new Rect();
        this.mAR = 0;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.mPaint = new Paint();
        this.mAQ = getResources().getDisplayMetrics();
    }

    public void setInitHeight(int i) {
        this.mAR = i;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        Bitmap bitmap;
        float f;
        float f2;
        float f3;
        float f4 = 0.0f;
        if (this.mAR != 0 && (drawable = getDrawable()) != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.mAQ);
            int scaledHeight = bitmap.getScaledHeight(this.mAQ);
            if (scaledWidth != 0 && scaledHeight != 0) {
                if ((scaledWidth * 1.0f) / scaledHeight < (getWidth() * 1.0f) / this.mAR) {
                    float width = (((((getWidth() * getHeight()) * 1.0f) / this.mAR) - getWidth()) * 0.2f) + getWidth();
                    float f5 = ((scaledHeight * 1.0f) / scaledWidth) * width;
                    if (width != 0.0f && f5 != 0.0f) {
                        float width2 = (getWidth() * scaledWidth) / width;
                        float height = (getHeight() * scaledHeight) / f5;
                        f3 = (scaledWidth - width2) / 2.0f;
                        float f6 = (scaledHeight - height) / 2.0f;
                        f = width2 + f3;
                        if (f6 < 0.0f) {
                            f2 = Math.abs(f6) + height;
                            if (f2 > scaledHeight) {
                                f2 = scaledHeight;
                            }
                        } else {
                            f2 = f6 + height;
                            f4 = f6;
                        }
                    } else {
                        return;
                    }
                } else {
                    float height2 = ((getHeight() * scaledWidth) * 1.0f) / scaledHeight;
                    if (height2 != 0.0f) {
                        float width3 = (getWidth() * scaledWidth) / height2;
                        float f7 = (scaledWidth - width3) / 2.0f;
                        f = width3 + f7;
                        f2 = scaledHeight;
                        f3 = f7;
                    } else {
                        return;
                    }
                }
                this.mSrcRect.set((int) f3, (int) f4, (int) f, (int) f2);
                this.mDstRect.set(0, 0, getWidth(), getHeight());
                canvas.drawBitmap(bitmap, this.mSrcRect, this.mDstRect, this.mPaint);
            }
        }
    }
}
