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
    private float bIF;
    private float dtt;
    private float dub;
    private int mHeight;
    private Paint mPaint;
    private Path mPath;
    private float mRadius;
    private int mWidth;
    private float nNM;
    private float nRr;
    private RectF nRs;
    private RectF nRt;
    private RectF nRu;
    private RectF nRv;

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
        this.nNM = l.getDimens(context, R.dimen.ds25);
        this.dtt = this.nNM;
        this.bIF = this.nNM;
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
            this.dub = this.mWidth - this.nNM;
            this.nRr = this.mHeight - this.nNM;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mWidth > 0 && this.mHeight > 0) {
            this.mPath.moveTo(this.dtt, this.bIF + this.mRadius);
            if (this.nRs == null) {
                this.nRs = new RectF(this.dtt, this.bIF, this.dtt + (this.mRadius * 2.0f), this.bIF + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.nRs, 180.0f, 90.0f, false);
            this.mPath.lineTo(this.dub - this.mRadius, this.bIF);
            if (this.nRt == null) {
                this.nRt = new RectF(this.dub - (this.mRadius * 2.0f), this.bIF, this.dub, this.bIF + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.nRt, 270.0f, 90.0f, false);
            this.mPath.lineTo(this.dub, this.nRr - this.mRadius);
            if (this.nRu == null) {
                this.nRu = new RectF(this.dub - (this.mRadius * 2.0f), this.nRr - (this.mRadius * 2.0f), this.dub, this.nRr);
            }
            this.mPath.arcTo(this.nRu, 0.0f, 90.0f, false);
            this.mPath.lineTo(this.dtt + this.mRadius, this.nRr);
            if (this.nRv == null) {
                this.nRv = new RectF(this.dtt, this.nRr - (this.mRadius * 2.0f), this.dtt + (this.mRadius * 2.0f), this.nRr);
            }
            this.mPath.arcTo(this.nRv, 90.0f, 90.0f, false);
            this.mPath.lineTo(this.dtt, this.bIF + this.mRadius);
            canvas.drawPath(this.mPath, this.mPaint);
            super.dispatchDraw(canvas);
        }
    }

    public void onChangeSkinType() {
        this.mPaint.setColor(ap.getColor(R.color.CAM_X0211));
        this.mPaint.setShadowLayer(25.0f, 0.0f, 0.0f, ap.getColor(R.color.CAM_X0805));
    }
}
