package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes4.dex */
public class RoundImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private int f6766a;

    /* renamed from: b  reason: collision with root package name */
    private int f6767b;

    public RoundImageView(Context context) {
        super(context);
        this.f6766a = 0;
        this.f6767b = 0;
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6766a = 0;
        this.f6767b = 0;
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6766a = 0;
        this.f6767b = 0;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        int i;
        Bitmap bitmap3;
        Drawable drawable = getDrawable();
        if (drawable != null && getWidth() != 0 && getHeight() != 0) {
            measure(0, 0);
            if (drawable.getClass() != NinePatchDrawable.class && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                try {
                    bitmap2 = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                } catch (Throwable th) {
                    bitmap2 = null;
                }
                if (bitmap2 == null) {
                    super.onDraw(canvas);
                    return;
                }
                if (this.f6766a == 0) {
                    this.f6766a = getWidth();
                }
                if (this.f6767b == 0) {
                    this.f6767b = getHeight();
                }
                try {
                    bitmap3 = a(bitmap2, (this.f6766a < this.f6767b ? this.f6766a : this.f6767b) / 2);
                } catch (Throwable th2) {
                    bitmap3 = null;
                }
                if (bitmap3 == null) {
                    super.onDraw(canvas);
                } else {
                    canvas.drawBitmap(bitmap3, (this.f6766a / 2) - i, (this.f6767b / 2) - i, (Paint) null);
                }
            }
        }
    }

    private Bitmap a(Bitmap bitmap, int i) {
        int i2 = i * 2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmap2 = null;
        if (height > width) {
            bitmap2 = Bitmap.createBitmap(bitmap, 0, (height - width) / 2, width, width);
        } else if (height < width) {
            bitmap2 = Bitmap.createBitmap(bitmap, (width - height) / 2, 0, height, height);
        }
        if (bitmap2 != null) {
            bitmap = bitmap2;
        }
        if (bitmap.getWidth() != i2 || bitmap.getHeight() != i2) {
            bitmap = Bitmap.createScaledBitmap(bitmap, i2, i2, true);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2, bitmap.getWidth() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }
}
