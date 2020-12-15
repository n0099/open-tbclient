package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BottomShadowLinearLayout extends LinearLayout {
    private int mHeight;
    private Paint mPaint;
    private float mRadius;
    private RectF mRectF;
    private int mWidth;
    private float nNO;
    private Paint nNP;
    private RectF nNQ;

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
        this.nNP = new Paint();
        this.nNP.reset();
        this.nNP.setAntiAlias(true);
        this.nNP.setStyle(Paint.Style.FILL);
        this.nNP.setDither(true);
        this.mRadius = l.getDimens(context, R.dimen.ds20);
        this.nNO = l.getDimens(context, R.dimen.ds25);
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
                this.mRectF = new RectF(0.0f, 0.0f, this.mWidth, this.mHeight - this.nNO);
            }
            canvas.drawRoundRect(this.mRectF, this.mRadius, this.mRadius, this.mPaint);
            if (this.nNQ == null) {
                this.nNQ = new RectF(0.0f, 0.0f, this.mWidth, this.mHeight / 2);
            }
            canvas.drawRect(this.nNQ, this.nNP);
            super.dispatchDraw(canvas);
        }
    }

    public void onChangeSkinType() {
        this.mPaint.setColor(ap.getColor(R.color.CAM_X0207));
        this.nNP.setColor(ap.getColor(R.color.CAM_X0207));
        this.mPaint.setShadowLayer(25.0f, 0.0f, 0.0f, ap.getColor(R.color.CAM_X0805));
    }
}
