package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ShadowLinearLayout extends LinearLayout {
    private float bMr;
    private float dwp;
    private float dxs;
    private int mHeight;
    private Paint mPaint;
    private Path mPath;
    private float mRadius;
    private int mWidth;
    private float nWW;
    private float oaN;
    private RectF oaO;
    private RectF oaP;
    private RectF oaQ;
    private RectF oaR;

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
        this.nWW = l.getDimens(context, R.dimen.ds25);
        this.dwp = this.nWW;
        this.bMr = this.nWW;
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
            this.dxs = this.mWidth - this.nWW;
            this.oaN = this.mHeight - this.nWW;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mWidth > 0 && this.mHeight > 0) {
            this.mPath.moveTo(this.dwp, this.bMr + this.mRadius);
            if (this.oaO == null) {
                this.oaO = new RectF(this.dwp, this.bMr, this.dwp + (this.mRadius * 2.0f), this.bMr + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.oaO, 180.0f, 90.0f, false);
            this.mPath.lineTo(this.dxs - this.mRadius, this.bMr);
            if (this.oaP == null) {
                this.oaP = new RectF(this.dxs - (this.mRadius * 2.0f), this.bMr, this.dxs, this.bMr + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.oaP, 270.0f, 90.0f, false);
            this.mPath.lineTo(this.dxs, this.oaN - this.mRadius);
            if (this.oaQ == null) {
                this.oaQ = new RectF(this.dxs - (this.mRadius * 2.0f), this.oaN - (this.mRadius * 2.0f), this.dxs, this.oaN);
            }
            this.mPath.arcTo(this.oaQ, 0.0f, 90.0f, false);
            this.mPath.lineTo(this.dwp + this.mRadius, this.oaN);
            if (this.oaR == null) {
                this.oaR = new RectF(this.dwp, this.oaN - (this.mRadius * 2.0f), this.dwp + (this.mRadius * 2.0f), this.oaN);
            }
            this.mPath.arcTo(this.oaR, 90.0f, 90.0f, false);
            this.mPath.lineTo(this.dwp, this.bMr + this.mRadius);
            canvas.drawPath(this.mPath, this.mPaint);
            super.dispatchDraw(canvas);
        }
    }

    public void onChangeSkinType() {
        this.mPaint.setColor(ap.getColor(R.color.CAM_X0211));
        this.mPaint.setShadowLayer(25.0f, 0.0f, 0.0f, ap.getColor(R.color.CAM_X0805));
    }
}
