package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BottomShadowLinearLayout extends LinearLayout {
    private int mHeight;
    private Paint mPaint;
    private float mRadius;
    private RectF mRectF;
    private int mWidth;
    private float nMF;
    private Paint nMG;
    private RectF nMH;

    public BottomShadowLinearLayout(Context context) {
        this(context, null);
    }

    public BottomShadowLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomShadowLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mPaint = new Paint();
        this.mPaint.reset();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setDither(true);
        this.nMG = new Paint();
        this.nMG.reset();
        this.nMG.setAntiAlias(true);
        this.nMG.setStyle(Paint.Style.FILL);
        this.nMG.setDither(true);
        this.mRadius = l.getDimens(context, R.dimen.ds20);
        this.nMF = l.getDimens(context, R.dimen.ds25);
        setLayerType(1, this.mPaint);
        onChangeSkinType();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mWidth > 0 && this.mHeight > 0) {
            if (this.mRectF == null) {
                this.mRectF = new RectF(0.0f, 0.0f, this.mWidth, this.mHeight - this.nMF);
            }
            canvas.drawRoundRect(this.mRectF, this.mRadius, this.mRadius, this.mPaint);
            if (this.nMH == null) {
                this.nMH = new RectF(0.0f, 0.0f, this.mWidth, this.mHeight / 2);
            }
            canvas.drawRect(this.nMH, this.nMG);
            super.dispatchDraw(canvas);
        }
    }

    public void onChangeSkinType() {
        this.mPaint.setColor(ao.getColor(R.color.CAM_X0207));
        this.nMG.setColor(ao.getColor(R.color.CAM_X0207));
        this.mPaint.setShadowLayer(25.0f, 0.0f, 0.0f, ao.getColor(R.color.CAM_X0805));
    }
}
