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
    private float nWw;
    private float oan;
    private RectF oao;
    private RectF oap;
    private RectF oaq;
    private RectF oar;

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
        this.nWw = l.getDimens(context, R.dimen.ds25);
        this.dwp = this.nWw;
        this.bMr = this.nWw;
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
            this.dxs = this.mWidth - this.nWw;
            this.oan = this.mHeight - this.nWw;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mWidth > 0 && this.mHeight > 0) {
            this.mPath.moveTo(this.dwp, this.bMr + this.mRadius);
            if (this.oao == null) {
                this.oao = new RectF(this.dwp, this.bMr, this.dwp + (this.mRadius * 2.0f), this.bMr + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.oao, 180.0f, 90.0f, false);
            this.mPath.lineTo(this.dxs - this.mRadius, this.bMr);
            if (this.oap == null) {
                this.oap = new RectF(this.dxs - (this.mRadius * 2.0f), this.bMr, this.dxs, this.bMr + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.oap, 270.0f, 90.0f, false);
            this.mPath.lineTo(this.dxs, this.oan - this.mRadius);
            if (this.oaq == null) {
                this.oaq = new RectF(this.dxs - (this.mRadius * 2.0f), this.oan - (this.mRadius * 2.0f), this.dxs, this.oan);
            }
            this.mPath.arcTo(this.oaq, 0.0f, 90.0f, false);
            this.mPath.lineTo(this.dwp + this.mRadius, this.oan);
            if (this.oar == null) {
                this.oar = new RectF(this.dwp, this.oan - (this.mRadius * 2.0f), this.dwp + (this.mRadius * 2.0f), this.oan);
            }
            this.mPath.arcTo(this.oar, 90.0f, 90.0f, false);
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
