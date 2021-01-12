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
    private int oqu;
    private float oqv;
    private float oqw;
    private float oqx;
    private float oqy;
    private String oqz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CircleBubbleView(Context context, float f, int i, int i2, String str) {
        super(context, null, 0);
        this.mContext = context;
        this.oqv = f;
        this.oqu = i;
        this.mIndicatorColor = i2;
        init(str);
    }

    private void init(String str) {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(1.0f);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setTextSize(this.oqv);
        Rect rect = new Rect();
        this.mPaint.getTextBounds(str, 0, str.length(), rect);
        this.oqw = rect.width() + f.dp2px(this.mContext, 4.0f);
        int dp2px = f.dp2px(this.mContext, 36.0f);
        if (this.oqw < dp2px) {
            this.oqw = dp2px;
        }
        this.oqy = rect.height();
        this.oqx = this.oqw * 1.2f;
        cqE();
    }

    private void cqE() {
        this.mPath = new Path();
        this.mPath.arcTo(new RectF(0.0f, 0.0f, this.oqw, this.oqw), 135.0f, 270.0f);
        this.mPath.lineTo(this.oqw / 2.0f, this.oqx);
        this.mPath.close();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension((int) this.oqw, (int) this.oqx);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.mPaint.setColor(this.mIndicatorColor);
        canvas.drawPath(this.mPath, this.mPaint);
        this.mPaint.setColor(this.oqu);
        canvas.drawText(this.oqz, this.oqw / 2.0f, (this.oqx / 2.0f) + (this.oqy / 4.0f), this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setProgress(String str) {
        this.oqz = str;
        invalidate();
    }
}
