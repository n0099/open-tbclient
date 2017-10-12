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
    private final Rect fiF;
    private final Rect fiG;
    private final DisplayMetrics fiH;
    private int fiI;
    private final Paint mPaint;

    public PersonExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fiF = new Rect();
        this.fiG = new Rect();
        this.fiI = 0;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.mPaint = new Paint();
        this.fiH = getResources().getDisplayMetrics();
    }

    public void setInitHeight(int i) {
        this.fiI = i;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        Bitmap bitmap;
        float f;
        float f2;
        float f3;
        float f4 = 0.0f;
        if (this.fiI != 0 && (drawable = getDrawable()) != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.fiH);
            int scaledHeight = bitmap.getScaledHeight(this.fiH);
            if (scaledWidth != 0 && scaledHeight != 0) {
                if ((scaledWidth * 1.0f) / scaledHeight < (getWidth() * 1.0f) / this.fiI) {
                    float width = (((((getWidth() * getHeight()) * 1.0f) / this.fiI) - getWidth()) * 0.2f) + getWidth();
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
                this.fiF.set((int) f, (int) f4, (int) f2, (int) f3);
                this.fiG.set(0, 0, getWidth(), getHeight());
                canvas.drawBitmap(bitmap, this.fiF, this.fiG, this.mPaint);
            }
        }
    }
}
