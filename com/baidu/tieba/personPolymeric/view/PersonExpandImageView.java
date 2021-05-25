package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes5.dex */
public class PersonExpandImageView extends ImageView {

    /* renamed from: e  reason: collision with root package name */
    public final Rect f19910e;

    /* renamed from: f  reason: collision with root package name */
    public final Rect f19911f;

    /* renamed from: g  reason: collision with root package name */
    public final Paint f19912g;

    /* renamed from: h  reason: collision with root package name */
    public int f19913h;

    public PersonExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19910e = new Rect();
        this.f19911f = new Rect();
        this.f19913h = 0;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.f19912g = new Paint();
        getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable;
        Bitmap bitmap;
        float f2;
        float f3;
        if (this.f19913h == 0 || (drawable = getDrawable()) == null || !(drawable instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null || bitmap.isRecycled()) {
            return;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        float f4 = width;
        float f5 = height;
        float f6 = 0.0f;
        if ((f4 * 1.0f) / f5 < (getWidth() * 1.0f) / this.f19913h) {
            float width2 = (((((getWidth() * getHeight()) * 1.0f) / this.f19913h) - getWidth()) * 0.2f) + getWidth();
            float f7 = ((1.0f * f5) / f4) * width2;
            if (width2 == 0.0f || f7 == 0.0f) {
                return;
            }
            float width3 = (getWidth() * width) / width2;
            float height2 = (getHeight() * height) / f7;
            f2 = (f4 - width3) / 2.0f;
            float f8 = (f5 - height2) / 2.0f;
            f3 = width3 + f2;
            if (f8 < 0.0f) {
                float abs = Math.abs(f8) + height2;
                if (abs <= f5) {
                    f5 = abs;
                }
            } else {
                f5 = f8 + height2;
                f6 = f8;
            }
        } else {
            float height3 = ((getHeight() * width) * 1.0f) / f5;
            if (height3 == 0.0f) {
                return;
            }
            float width4 = (getWidth() * width) / height3;
            f2 = (f4 - width4) / 2.0f;
            f3 = width4 + f2;
        }
        this.f19910e.set((int) f2, (int) f6, (int) f3, (int) f5);
        this.f19911f.set(0, 0, getWidth(), getHeight());
        canvas.drawBitmap(bitmap, this.f19910e, this.f19911f, this.f19912g);
    }

    public void setInitHeight(int i2) {
        this.f19913h = i2;
    }
}
