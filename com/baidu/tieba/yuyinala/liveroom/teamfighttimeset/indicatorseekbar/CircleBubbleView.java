package com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
/* loaded from: classes11.dex */
public class CircleBubbleView extends View {
    private Context mContext;
    private int mIndicatorColor;
    private Paint mPaint;
    private Path mPath;
    private int oAL;
    private float oAM;
    private float oAN;
    private float oAO;
    private float oAP;
    private String oAQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CircleBubbleView(Context context, float f, int i, int i2, String str) {
        super(context, null, 0);
        this.mContext = context;
        this.oAM = f;
        this.oAL = i;
        this.mIndicatorColor = i2;
        init(str);
    }

    private void init(String str) {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(1.0f);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setTextSize(this.oAM);
        Rect rect = new Rect();
        this.mPaint.getTextBounds(str, 0, str.length(), rect);
        this.oAN = rect.width() + f.dp2px(this.mContext, 4.0f);
        int dp2px = f.dp2px(this.mContext, 36.0f);
        if (this.oAN < dp2px) {
            this.oAN = dp2px;
        }
        this.oAP = rect.height();
        this.oAO = this.oAN * 1.2f;
        crV();
    }

    private void crV() {
        this.mPath = new Path();
        this.mPath.arcTo(new RectF(0.0f, 0.0f, this.oAN, this.oAN), 135.0f, 270.0f);
        this.mPath.lineTo(this.oAN / 2.0f, this.oAO);
        this.mPath.close();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension((int) this.oAN, (int) this.oAO);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.mPaint.setColor(this.mIndicatorColor);
        canvas.drawPath(this.mPath, this.mPaint);
        this.mPaint.setColor(this.oAL);
        canvas.drawText(this.oAQ, this.oAN / 2.0f, (this.oAO / 2.0f) + (this.oAP / 4.0f), this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setProgress(String str) {
        this.oAQ = str;
        invalidate();
    }
}
