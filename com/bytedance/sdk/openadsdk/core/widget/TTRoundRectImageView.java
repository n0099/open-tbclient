package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes5.dex */
public class TTRoundRectImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    public Paint f28544a;

    /* renamed from: b  reason: collision with root package name */
    public int f28545b;

    /* renamed from: c  reason: collision with root package name */
    public int f28546c;

    /* renamed from: d  reason: collision with root package name */
    public Matrix f28547d;

    public TTRoundRectImageView(Context context) {
        this(context, null);
    }

    private Bitmap a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int width = drawable.getIntrinsicWidth() <= 0 ? getWidth() : drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight() <= 0 ? getHeight() : drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return createBitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Bitmap a2 = a(drawable);
            if (a2 != null) {
                Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                BitmapShader bitmapShader = new BitmapShader(a2, tileMode, tileMode);
                float f2 = 1.0f;
                if (a2.getWidth() != getWidth() || a2.getHeight() != getHeight()) {
                    f2 = Math.max((getWidth() * 1.0f) / a2.getWidth(), (getHeight() * 1.0f) / a2.getHeight());
                }
                this.f28547d.setScale(f2, f2);
                bitmapShader.setLocalMatrix(this.f28547d);
                this.f28544a.setShader(bitmapShader);
                canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.f28545b, this.f28546c, this.f28544a);
                return;
            }
            super.onDraw(canvas);
            return;
        }
        super.onDraw(canvas);
    }

    public void setXRound(int i) {
        this.f28545b = i;
        postInvalidate();
    }

    public void setYRound(int i) {
        this.f28546c = i;
        postInvalidate();
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28545b = 25;
        this.f28546c = 25;
        Paint paint = new Paint();
        this.f28544a = paint;
        paint.setAntiAlias(true);
        this.f28544a.setFilterBitmap(true);
        this.f28547d = new Matrix();
    }
}
