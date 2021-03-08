package com.baidu.tieba.tbean.view;

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
import com.baidu.tieba.R;
import java.util.Arrays;
/* loaded from: classes8.dex */
public class RoundRelativeLayout extends RelativeLayout {
    private static final int gcm = R.color.black_alpha4;
    private Paint bjg;
    private Shape eXx;
    private Paint mPaint;
    private float mRadius;
    private RectF mRectF;
    private Paint mStrokePaint;
    private int nFj;

    public RoundRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRadius = 0.0f;
        setLayerType(1, null);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(-1);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.mStrokePaint = new Paint();
        this.mStrokePaint.setAntiAlias(true);
        this.mStrokePaint.setColor(0);
        this.mStrokePaint.setStyle(Paint.Style.FILL);
        this.mStrokePaint.setShadowLayer(getResources().getDimension(R.dimen.tbds5), 0.0f, getResources().getDimension(R.dimen.tbds8), getResources().getColor(gcm));
        this.mStrokePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.mRectF = new RectF();
        this.bjg = new Paint();
        this.bjg.setAntiAlias(true);
        this.bjg.setColor(-1);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setBgColorRes(int i) {
        this.nFj = i;
        if (this.nFj != 0) {
            this.bjg.setColor(getContext().getResources().getColor(this.nFj));
            invalidate();
        }
    }

    public void setRadius(float f) {
        this.mRadius = f;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.eXx == null) {
                float[] fArr = new float[8];
                Arrays.fill(fArr, 0.0f);
                float dimension = ((float) getPaddingLeft()) <= getResources().getDimension(R.dimen.tbds8) ? getResources().getDimension(R.dimen.tbds8) : getPaddingLeft();
                float dimension2 = ((float) getPaddingRight()) <= getResources().getDimension(R.dimen.tbds8) ? getResources().getDimension(R.dimen.tbds8) : getPaddingRight();
                float paddingTop = getPaddingTop() <= 0 ? 1.0f : getPaddingTop();
                float dimension3 = ((float) getPaddingBottom()) <= getResources().getDimension(R.dimen.tbds8) ? getResources().getDimension(R.dimen.tbds8) : getPaddingBottom();
                RectF rectF = new RectF(dimension, paddingTop, dimension2, dimension3);
                float[] fArr2 = new float[8];
                Arrays.fill(fArr2, this.mRadius);
                this.eXx = new RoundRectShape(fArr, rectF, fArr2);
                this.mRectF.set(dimension, paddingTop, getWidth() - dimension2, getHeight() - dimension3);
            }
            this.eXx.resize(getWidth(), getHeight());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int saveCount = canvas.getSaveCount();
        canvas.save();
        canvas.drawRoundRect(this.mRectF, this.mRadius, this.mRadius, this.bjg);
        super.dispatchDraw(canvas);
        if (this.eXx != null) {
            this.eXx.draw(canvas, this.mPaint);
        }
        canvas.drawRoundRect(this.mRectF, this.mRadius, this.mRadius, this.mStrokePaint);
        if (saveCount >= 1 && saveCount <= canvas.getSaveCount()) {
            canvas.restoreToCount(saveCount);
        }
    }
}
