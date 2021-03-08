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
    private float bNR;
    private float dxQ;
    private float dyT;
    private int mHeight;
    private Paint mPaint;
    private Path mPath;
    private float mRadius;
    private int mWidth;
    private float nZb;
    private float ocU;
    private RectF ocV;
    private RectF ocW;
    private RectF ocX;
    private RectF ocY;

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
        this.nZb = l.getDimens(context, R.dimen.ds25);
        this.dxQ = this.nZb;
        this.bNR = this.nZb;
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
            this.dyT = this.mWidth - this.nZb;
            this.ocU = this.mHeight - this.nZb;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mWidth > 0 && this.mHeight > 0) {
            this.mPath.moveTo(this.dxQ, this.bNR + this.mRadius);
            if (this.ocV == null) {
                this.ocV = new RectF(this.dxQ, this.bNR, this.dxQ + (this.mRadius * 2.0f), this.bNR + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.ocV, 180.0f, 90.0f, false);
            this.mPath.lineTo(this.dyT - this.mRadius, this.bNR);
            if (this.ocW == null) {
                this.ocW = new RectF(this.dyT - (this.mRadius * 2.0f), this.bNR, this.dyT, this.bNR + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.ocW, 270.0f, 90.0f, false);
            this.mPath.lineTo(this.dyT, this.ocU - this.mRadius);
            if (this.ocX == null) {
                this.ocX = new RectF(this.dyT - (this.mRadius * 2.0f), this.ocU - (this.mRadius * 2.0f), this.dyT, this.ocU);
            }
            this.mPath.arcTo(this.ocX, 0.0f, 90.0f, false);
            this.mPath.lineTo(this.dxQ + this.mRadius, this.ocU);
            if (this.ocY == null) {
                this.ocY = new RectF(this.dxQ, this.ocU - (this.mRadius * 2.0f), this.dxQ + (this.mRadius * 2.0f), this.ocU);
            }
            this.mPath.arcTo(this.ocY, 90.0f, 90.0f, false);
            this.mPath.lineTo(this.dxQ, this.bNR + this.mRadius);
            canvas.drawPath(this.mPath, this.mPaint);
            super.dispatchDraw(canvas);
        }
    }

    public void onChangeSkinType() {
        this.mPaint.setColor(ap.getColor(R.color.CAM_X0211));
        this.mPaint.setShadowLayer(25.0f, 0.0f, 0.0f, ap.getColor(R.color.CAM_X0805));
    }
}
