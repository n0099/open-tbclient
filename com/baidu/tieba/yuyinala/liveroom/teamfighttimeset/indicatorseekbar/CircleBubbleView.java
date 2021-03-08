package com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
/* loaded from: classes10.dex */
public class CircleBubbleView extends View {
    private Context mContext;
    private int mIndicatorColor;
    private Paint mPaint;
    private Path mPath;
    private int oCQ;
    private float oCR;
    private float oCS;
    private float oCT;
    private float oCU;
    private String oCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CircleBubbleView(Context context, float f, int i, int i2, String str) {
        super(context, null, 0);
        this.mContext = context;
        this.oCR = f;
        this.oCQ = i;
        this.mIndicatorColor = i2;
        init(str);
    }

    private void init(String str) {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(1.0f);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setTextSize(this.oCR);
        Rect rect = new Rect();
        this.mPaint.getTextBounds(str, 0, str.length(), rect);
        this.oCS = rect.width() + f.dp2px(this.mContext, 4.0f);
        int dp2px = f.dp2px(this.mContext, 36.0f);
        if (this.oCS < dp2px) {
            this.oCS = dp2px;
        }
        this.oCU = rect.height();
        this.oCT = this.oCS * 1.2f;
        csb();
    }

    private void csb() {
        this.mPath = new Path();
        this.mPath.arcTo(new RectF(0.0f, 0.0f, this.oCS, this.oCS), 135.0f, 270.0f);
        this.mPath.lineTo(this.oCS / 2.0f, this.oCT);
        this.mPath.close();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension((int) this.oCS, (int) this.oCT);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.mPaint.setColor(this.mIndicatorColor);
        canvas.drawPath(this.mPath, this.mPaint);
        this.mPaint.setColor(this.oCQ);
        canvas.drawText(this.oCV, this.oCS / 2.0f, (this.oCT / 2.0f) + (this.oCU / 4.0f), this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setProgress(String str) {
        this.oCV = str;
        invalidate();
    }
}
