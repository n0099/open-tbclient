package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ShadowLinearLayout extends LinearLayout {
    private float bke;
    private float cDf;
    private int mHeight;
    private Paint mPaint;
    private Path mPath;
    private float mRadius;
    private int mWidth;
    private float moL;
    private float mrD;
    private float mrE;
    private RectF mrF;
    private RectF mrG;
    private RectF mrH;
    private RectF mrI;

    public ShadowLinearLayout(Context context) {
        this(context, null);
    }

    public ShadowLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mPaint = new Paint();
        this.mPaint.reset();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setDither(true);
        this.mRadius = l.getDimens(context, R.dimen.ds20);
        this.moL = l.getDimens(context, R.dimen.ds25);
        this.cDf = this.moL;
        this.bke = this.moL;
        this.mPath = new Path();
        setLayerType(1, this.mPaint);
        onChangeSkinType();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        if (this.mWidth > 0 && this.mHeight > 0) {
            this.mrD = this.mWidth - this.moL;
            this.mrE = this.mHeight - this.moL;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mWidth > 0 && this.mHeight > 0) {
            this.mPath.moveTo(this.cDf, this.bke + this.mRadius);
            if (this.mrF == null) {
                this.mrF = new RectF(this.cDf, this.bke, this.cDf + (this.mRadius * 2.0f), this.bke + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.mrF, 180.0f, 90.0f, false);
            this.mPath.lineTo(this.mrD - this.mRadius, this.bke);
            if (this.mrG == null) {
                this.mrG = new RectF(this.mrD - (this.mRadius * 2.0f), this.bke, this.mrD, this.bke + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.mrG, 270.0f, 90.0f, false);
            this.mPath.lineTo(this.mrD, this.mrE - this.mRadius);
            if (this.mrH == null) {
                this.mrH = new RectF(this.mrD - (this.mRadius * 2.0f), this.mrE - (this.mRadius * 2.0f), this.mrD, this.mrE);
            }
            this.mPath.arcTo(this.mrH, 0.0f, 90.0f, false);
            this.mPath.lineTo(this.cDf + this.mRadius, this.mrE);
            if (this.mrI == null) {
                this.mrI = new RectF(this.cDf, this.mrE - (this.mRadius * 2.0f), this.cDf + (this.mRadius * 2.0f), this.mrE);
            }
            this.mPath.arcTo(this.mrI, 90.0f, 90.0f, false);
            this.mPath.lineTo(this.cDf, this.bke + this.mRadius);
            canvas.drawPath(this.mPath, this.mPaint);
            super.dispatchDraw(canvas);
        }
    }

    public void onChangeSkinType() {
        this.mPaint.setColor(ao.getColor(R.color.cp_bg_line_k));
        this.mPaint.setShadowLayer(25.0f, 0.0f, 0.0f, ao.getColor(R.color.cp_shadow_a_alpha25));
    }
}
