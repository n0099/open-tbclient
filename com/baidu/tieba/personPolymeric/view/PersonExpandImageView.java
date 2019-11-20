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
/* loaded from: classes6.dex */
public class PersonExpandImageView extends ImageView {
    private final Rect aFW;
    private final DisplayMetrics itA;
    private int itB;
    private final Rect mDstRect;
    private final Paint mPaint;

    public PersonExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFW = new Rect();
        this.mDstRect = new Rect();
        this.itB = 0;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.mPaint = new Paint();
        this.itA = getResources().getDisplayMetrics();
    }

    public void setInitHeight(int i) {
        this.itB = i;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        Bitmap bitmap;
        float f;
        float f2;
        float f3;
        float f4 = 0.0f;
        if (this.itB != 0 && (drawable = getDrawable()) != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.itA);
            int scaledHeight = bitmap.getScaledHeight(this.itA);
            if (scaledWidth != 0 && scaledHeight != 0) {
                if ((scaledWidth * 1.0f) / scaledHeight < (getWidth() * 1.0f) / this.itB) {
                    float width = (((((getWidth() * getHeight()) * 1.0f) / this.itB) - getWidth()) * 0.2f) + getWidth();
                    float f5 = ((scaledHeight * 1.0f) / scaledWidth) * width;
                    if (width != 0.0f && f5 != 0.0f) {
                        float width2 = (getWidth() * scaledWidth) / width;
                        float height = (getHeight() * scaledHeight) / f5;
                        f = (scaledWidth - width2) / 2.0f;
                        f4 = (scaledHeight - height) / 2.0f;
                        f2 = width2 + f;
                        f3 = f4 + height;
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
                this.aFW.set((int) f, (int) f4, (int) f2, (int) f3);
                this.mDstRect.set(0, 0, getWidth(), getHeight());
                canvas.drawBitmap(bitmap, this.aFW, this.mDstRect, this.mPaint);
            }
        }
    }
}
