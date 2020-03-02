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
/* loaded from: classes13.dex */
public class XfremodeRoundLayout extends RelativeLayout {
    private Shape cVV;
    private Paint mPaint;
    private float[] mRadius;

    public XfremodeRoundLayout(Context context) {
        this(context, null);
    }

    public XfremodeRoundLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XfremodeRoundLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayerType(1, null);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(-7829368);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public void setRoundLayoutRadius(float[] fArr) {
        if (fArr != null && fArr.length == 8) {
            this.mRadius = Arrays.copyOf(fArr, fArr.length);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.cVV == null) {
                RectF rectF = new RectF(getPaddingLeft(), getPaddingTop() > 0 ? getPaddingTop() : 1.0f, getPaddingRight() <= 0 ? 1.0f : getPaddingRight(), getPaddingBottom());
                float[] fArr = new float[8];
                Arrays.fill(fArr, 0.0f);
                this.cVV = new RoundRectShape(fArr, rectF, this.mRadius);
            }
            this.cVV.resize(getWidth(), getHeight());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cVV != null) {
            this.cVV.draw(canvas, this.mPaint);
        }
    }
}
