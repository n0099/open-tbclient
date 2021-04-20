package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class RoundAndShadowLinearLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public float f21853e;

    /* renamed from: f  reason: collision with root package name */
    public Shape f21854f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f21855g;

    public RoundAndShadowLinearLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int saveCount = canvas.getSaveCount();
        canvas.save();
        super.dispatchDraw(canvas);
        Shape shape = this.f21854f;
        if (shape != null) {
            shape.draw(canvas, this.f21855g);
        }
        if (saveCount < 1 || saveCount > canvas.getSaveCount()) {
            return;
        }
        canvas.restoreToCount(saveCount);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.f21854f == null) {
                float[] fArr = new float[8];
                Arrays.fill(fArr, 0.0f);
                RectF rectF = new RectF(getPaddingLeft() <= 0 ? 0.1f : getPaddingLeft(), getPaddingTop() <= 0 ? 0.1f : getPaddingTop(), getPaddingRight() <= 0 ? 0.1f : getPaddingRight(), getPaddingBottom() > 0 ? getPaddingBottom() : 0.1f);
                float[] fArr2 = new float[8];
                Arrays.fill(fArr, 0.0f);
                Arrays.fill(fArr2, this.f21853e);
                this.f21854f = new RoundRectShape(fArr, rectF, fArr2);
            }
            this.f21854f.resize(getWidth(), getHeight());
        }
    }

    public void setRadius(float f2) {
        this.f21853e = f2;
    }

    public RoundAndShadowLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAndShadowLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21853e = 0.0f;
        setLayerType(1, null);
        this.f21853e = getResources().getDimension(R.dimen.tbds32);
        Paint paint = new Paint();
        this.f21855g = paint;
        paint.setAntiAlias(true);
        this.f21855g.setColor(-7829368);
        this.f21855g.setStyle(Paint.Style.FILL);
        this.f21855g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }
}
