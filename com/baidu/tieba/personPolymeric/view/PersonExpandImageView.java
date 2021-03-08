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
/* loaded from: classes7.dex */
public class PersonExpandImageView extends ImageView {
    private final Rect mDstRect;
    private final DisplayMetrics mHH;
    private int mHI;
    private final Paint mPaint;
    private final Rect mSrcRect;

    public PersonExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSrcRect = new Rect();
        this.mDstRect = new Rect();
        this.mHI = 0;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.mPaint = new Paint();
        this.mHH = getResources().getDisplayMetrics();
    }

    public void setInitHeight(int i) {
        this.mHI = i;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        Bitmap bitmap;
        float f;
        float f2;
        float f3;
        float f4 = 0.0f;
        if (this.mHI != 0 && (drawable = getDrawable()) != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width != 0 && height != 0) {
                if ((width * 1.0f) / height < (getWidth() * 1.0f) / this.mHI) {
                    float width2 = (((((getWidth() * getHeight()) * 1.0f) / this.mHI) - getWidth()) * 0.2f) + getWidth();
                    float f5 = ((height * 1.0f) / width) * width2;
                    if (width2 != 0.0f && f5 != 0.0f) {
                        float width3 = (getWidth() * width) / width2;
                        float height2 = (getHeight() * height) / f5;
                        f3 = (width - width3) / 2.0f;
                        float f6 = (height - height2) / 2.0f;
                        f = width3 + f3;
                        if (f6 < 0.0f) {
                            f2 = Math.abs(f6) + height2;
                            if (f2 > height) {
                                f2 = height;
                            }
                        } else {
                            f2 = f6 + height2;
                            f4 = f6;
                        }
                    } else {
                        return;
                    }
                } else {
                    float height3 = ((getHeight() * width) * 1.0f) / height;
                    if (height3 != 0.0f) {
                        float width4 = (getWidth() * width) / height3;
                        float f7 = (width - width4) / 2.0f;
                        f = width4 + f7;
                        f2 = height;
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
