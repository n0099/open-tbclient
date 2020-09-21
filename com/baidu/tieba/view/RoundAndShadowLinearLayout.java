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
/* loaded from: classes.dex */
public class RoundAndShadowLinearLayout extends LinearLayout {
    private Shape eiu;
    private Paint mPaint;
    private float mRadius;

    public RoundAndShadowLinearLayout(Context context) {
        this(context, null);
    }

    public RoundAndShadowLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAndShadowLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRadius = 0.0f;
        setLayerType(1, null);
        this.mRadius = getResources().getDimension(R.dimen.tbds32);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(-7829368);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public void setRadius(float f) {
        this.mRadius = f;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.eiu == null) {
                float[] fArr = new float[8];
                Arrays.fill(fArr, 0.0f);
                RectF rectF = new RectF(getPaddingLeft() <= 0 ? 0.1f : getPaddingLeft(), getPaddingTop() <= 0 ? 0.1f : getPaddingTop(), getPaddingRight() <= 0 ? 0.1f : getPaddingRight(), getPaddingBottom() > 0 ? getPaddingBottom() : 0.1f);
                float[] fArr2 = new float[8];
                Arrays.fill(fArr, 0.0f);
                Arrays.fill(fArr2, this.mRadius);
                this.eiu = new RoundRectShape(fArr, rectF, fArr2);
            }
            this.eiu.resize(getWidth(), getHeight());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int saveCount = canvas.getSaveCount();
        canvas.save();
        super.dispatchDraw(canvas);
        if (this.eiu != null) {
            this.eiu.draw(canvas, this.mPaint);
        }
        if (saveCount >= 1 && saveCount <= canvas.getSaveCount()) {
            canvas.restoreToCount(saveCount);
        }
    }
}
