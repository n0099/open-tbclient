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
/* loaded from: classes.dex */
public class PersonExpandImageView extends ImageView {
    private final Rect fiq;
    private final Rect fir;
    private final DisplayMetrics fis;
    private int fit;
    private final Paint mPaint;

    public PersonExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fiq = new Rect();
        this.fir = new Rect();
        this.fit = 0;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.mPaint = new Paint();
        this.fis = getResources().getDisplayMetrics();
    }

    public void setInitHeight(int i) {
        this.fit = i;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        Bitmap bitmap;
        float f;
        float f2;
        float f3;
        float f4 = 0.0f;
        if (this.fit != 0 && (drawable = getDrawable()) != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.fis);
            int scaledHeight = bitmap.getScaledHeight(this.fis);
            if (scaledWidth != 0 && scaledHeight != 0) {
                if ((scaledWidth * 1.0f) / scaledHeight < (getWidth() * 1.0f) / this.fit) {
                    float width = (((((getWidth() * getHeight()) * 1.0f) / this.fit) - getWidth()) * 0.2f) + getWidth();
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
                this.fiq.set((int) f, (int) f4, (int) f2, (int) f3);
                this.fir.set(0, 0, getWidth(), getHeight());
                canvas.drawBitmap(bitmap, this.fiq, this.fir, this.mPaint);
            }
        }
    }
}
