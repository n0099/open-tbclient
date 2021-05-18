package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class XfremodeRoundLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Shape f20292e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f20293f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f20294g;

    public XfremodeRoundLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        Shape shape = this.f20292e;
        if (shape != null) {
            shape.draw(canvas, this.f20293f);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            if (this.f20292e == null) {
                RectF rectF = new RectF(getPaddingLeft(), getPaddingTop() > 0 ? getPaddingTop() : 1.0f, getPaddingRight() <= 0 ? 1.0f : getPaddingRight(), getPaddingBottom());
                float[] fArr = new float[8];
                Arrays.fill(fArr, 0.0f);
                this.f20292e = new RoundRectShape(fArr, rectF, this.f20294g);
            }
            this.f20292e.resize(getWidth(), getHeight());
        }
    }

    public void setRoundLayoutRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.f20294g = Arrays.copyOf(fArr, fArr.length);
    }

    public XfremodeRoundLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XfremodeRoundLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setLayerType(1, null);
        Paint paint = new Paint();
        this.f20293f = paint;
        paint.setAntiAlias(true);
        this.f20293f.setColor(-7829368);
        this.f20293f.setStyle(Paint.Style.FILL);
        this.f20293f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public void setRoundLayoutRadius(float f2) {
        setRoundLayoutRadius(new float[]{f2, f2, f2, f2, f2, f2, f2, f2});
    }
}
