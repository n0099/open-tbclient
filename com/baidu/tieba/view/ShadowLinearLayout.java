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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ShadowLinearLayout extends LinearLayout {
    private float bDx;
    private float dmY;
    private float dmq;
    private int mHeight;
    private Paint mPaint;
    private Path mPath;
    private float mRadius;
    private int mWidth;
    private float nDp;
    private RectF nDq;
    private RectF nDr;
    private RectF nDs;
    private RectF nDt;
    private float nzK;

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
        this.nzK = l.getDimens(context, R.dimen.ds25);
        this.dmq = this.nzK;
        this.bDx = this.nzK;
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
            this.dmY = this.mWidth - this.nzK;
            this.nDp = this.mHeight - this.nzK;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mWidth > 0 && this.mHeight > 0) {
            this.mPath.moveTo(this.dmq, this.bDx + this.mRadius);
            if (this.nDq == null) {
                this.nDq = new RectF(this.dmq, this.bDx, this.dmq + (this.mRadius * 2.0f), this.bDx + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.nDq, 180.0f, 90.0f, false);
            this.mPath.lineTo(this.dmY - this.mRadius, this.bDx);
            if (this.nDr == null) {
                this.nDr = new RectF(this.dmY - (this.mRadius * 2.0f), this.bDx, this.dmY, this.bDx + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.nDr, 270.0f, 90.0f, false);
            this.mPath.lineTo(this.dmY, this.nDp - this.mRadius);
            if (this.nDs == null) {
                this.nDs = new RectF(this.dmY - (this.mRadius * 2.0f), this.nDp - (this.mRadius * 2.0f), this.dmY, this.nDp);
            }
            this.mPath.arcTo(this.nDs, 0.0f, 90.0f, false);
            this.mPath.lineTo(this.dmq + this.mRadius, this.nDp);
            if (this.nDt == null) {
                this.nDt = new RectF(this.dmq, this.nDp - (this.mRadius * 2.0f), this.dmq + (this.mRadius * 2.0f), this.nDp);
            }
            this.mPath.arcTo(this.nDt, 90.0f, 90.0f, false);
            this.mPath.lineTo(this.dmq, this.bDx + this.mRadius);
            canvas.drawPath(this.mPath, this.mPaint);
            super.dispatchDraw(canvas);
        }
    }

    public void onChangeSkinType() {
        this.mPaint.setColor(ap.getColor(R.color.CAM_X0211));
        this.mPaint.setShadowLayer(25.0f, 0.0f, 0.0f, ap.getColor(R.color.CAM_X0805));
    }
}
