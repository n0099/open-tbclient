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
    private String oqA;
    private int oqv;
    private float oqw;
    private float oqx;
    private float oqy;
    private float oqz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CircleBubbleView(Context context, float f, int i, int i2, String str) {
        super(context, null, 0);
        this.mContext = context;
        this.oqw = f;
        this.oqv = i;
        this.mIndicatorColor = i2;
        init(str);
    }

    private void init(String str) {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(1.0f);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setTextSize(this.oqw);
        Rect rect = new Rect();
        this.mPaint.getTextBounds(str, 0, str.length(), rect);
        this.oqx = rect.width() + f.dp2px(this.mContext, 4.0f);
        int dp2px = f.dp2px(this.mContext, 36.0f);
        if (this.oqx < dp2px) {
            this.oqx = dp2px;
        }
        this.oqz = rect.height();
        this.oqy = this.oqx * 1.2f;
        cqE();
    }

    private void cqE() {
        this.mPath = new Path();
        this.mPath.arcTo(new RectF(0.0f, 0.0f, this.oqx, this.oqx), 135.0f, 270.0f);
        this.mPath.lineTo(this.oqx / 2.0f, this.oqy);
        this.mPath.close();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension((int) this.oqx, (int) this.oqy);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.mPaint.setColor(this.mIndicatorColor);
        canvas.drawPath(this.mPath, this.mPaint);
        this.mPaint.setColor(this.oqv);
        canvas.drawText(this.oqA, this.oqx / 2.0f, (this.oqy / 2.0f) + (this.oqz / 4.0f), this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setProgress(String str) {
        this.oqA = str;
        invalidate();
    }
}
