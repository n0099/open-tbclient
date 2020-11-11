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
/* loaded from: classes24.dex */
public class PersonExpandImageView extends ImageView {
    private final Rect mDstRect;
    private final Paint mPaint;
    private final Rect mSrcRect;
    private final DisplayMetrics mhc;
    private int mhd;

    public PersonExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSrcRect = new Rect();
        this.mDstRect = new Rect();
        this.mhd = 0;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.mPaint = new Paint();
        this.mhc = getResources().getDisplayMetrics();
    }

    public void setInitHeight(int i) {
        this.mhd = i;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        Bitmap bitmap;
        float f;
        float f2;
        float f3;
        float f4 = 0.0f;
        if (this.mhd != 0 && (drawable = getDrawable()) != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.mhc);
            int scaledHeight = bitmap.getScaledHeight(this.mhc);
            if (scaledWidth != 0 && scaledHeight != 0) {
                if ((scaledWidth * 1.0f) / scaledHeight < (getWidth() * 1.0f) / this.mhd) {
                    float width = (((((getWidth() * getHeight()) * 1.0f) / this.mhd) - getWidth()) * 0.2f) + getWidth();
                    float f5 = ((scaledHeight * 1.0f) / scaledWidth) * width;
                    if (width != 0.0f && f5 != 0.0f) {
                        float width2 = (getWidth() * scaledWidth) / width;
                        float height = (getHeight() * scaledHeight) / f5;
                        float f6 = (scaledWidth - width2) / 2.0f;
                        float f7 = (scaledHeight - height) / 2.0f;
                        f2 = width2 + f6;
                        if (f7 < 0.0f) {
                            f3 = Math.abs(f7) + height;
                            if (f3 > scaledHeight) {
                                f3 = scaledHeight;
                            }
                            f = f6;
                        } else {
                            f3 = f7 + height;
                            f4 = f7;
                            f = f6;
                        }
                    } else {
                        return;
                    }
                } else {
                    float height2 = ((getHeight() * scaledWidth) * 1.0f) / scaledHeight;
                    if (height2 != 0.0f) {
                        float width3 = (getWidth() * scaledWidth) / height2;
                        f = (scaledWidth - width3) / 2.0f;
                        f2 = width3 + f;
                        f3 = scaledHeight;
                    } else {
                        return;
                    }
                }
                this.mSrcRect.set((int) f, (int) f4, (int) f2, (int) f3);
                this.mDstRect.set(0, 0, getWidth(), getHeight());
                canvas.drawBitmap(bitmap, this.mSrcRect, this.mDstRect, this.mPaint);
            }
        }
    }
}
