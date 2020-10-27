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
    private float byX;
    private float diN;
    private float dic;
    private int mHeight;
    private Paint mPaint;
    private Path mPath;
    private float mRadius;
    private int mWidth;
    private float nsI;
    private float nvY;
    private RectF nvZ;
    private RectF nwa;
    private RectF nwb;
    private RectF nwc;

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
        this.nsI = l.getDimens(context, R.dimen.ds25);
        this.dic = this.nsI;
        this.byX = this.nsI;
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
            this.diN = this.mWidth - this.nsI;
            this.nvY = this.mHeight - this.nsI;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mWidth > 0 && this.mHeight > 0) {
            this.mPath.moveTo(this.dic, this.byX + this.mRadius);
            if (this.nvZ == null) {
                this.nvZ = new RectF(this.dic, this.byX, this.dic + (this.mRadius * 2.0f), this.byX + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.nvZ, 180.0f, 90.0f, false);
            this.mPath.lineTo(this.diN - this.mRadius, this.byX);
            if (this.nwa == null) {
                this.nwa = new RectF(this.diN - (this.mRadius * 2.0f), this.byX, this.diN, this.byX + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.nwa, 270.0f, 90.0f, false);
            this.mPath.lineTo(this.diN, this.nvY - this.mRadius);
            if (this.nwb == null) {
                this.nwb = new RectF(this.diN - (this.mRadius * 2.0f), this.nvY - (this.mRadius * 2.0f), this.diN, this.nvY);
            }
            this.mPath.arcTo(this.nwb, 0.0f, 90.0f, false);
            this.mPath.lineTo(this.dic + this.mRadius, this.nvY);
            if (this.nwc == null) {
                this.nwc = new RectF(this.dic, this.nvY - (this.mRadius * 2.0f), this.dic + (this.mRadius * 2.0f), this.nvY);
            }
            this.mPath.arcTo(this.nwc, 90.0f, 90.0f, false);
            this.mPath.lineTo(this.dic, this.byX + this.mRadius);
            canvas.drawPath(this.mPath, this.mPaint);
            super.dispatchDraw(canvas);
        }
    }

    public void onChangeSkinType() {
        this.mPaint.setColor(ap.getColor(R.color.cp_bg_line_k));
        this.mPaint.setShadowLayer(25.0f, 0.0f, 0.0f, ap.getColor(R.color.cp_shadow_a_alpha25));
    }
}
