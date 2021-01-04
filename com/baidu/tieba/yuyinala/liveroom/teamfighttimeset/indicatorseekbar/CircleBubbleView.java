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
    private int ovc;
    private float ovd;
    private float ove;
    private float ovf;
    private float ovg;
    private String ovh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CircleBubbleView(Context context, float f, int i, int i2, String str) {
        super(context, null, 0);
        this.mContext = context;
        this.ovd = f;
        this.ovc = i;
        this.mIndicatorColor = i2;
        init(str);
    }

    private void init(String str) {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(1.0f);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setTextSize(this.ovd);
        Rect rect = new Rect();
        this.mPaint.getTextBounds(str, 0, str.length(), rect);
        this.ove = rect.width() + f.dp2px(this.mContext, 4.0f);
        int dp2px = f.dp2px(this.mContext, 36.0f);
        if (this.ove < dp2px) {
            this.ove = dp2px;
        }
        this.ovg = rect.height();
        this.ovf = this.ove * 1.2f;
        cuv();
    }

    private void cuv() {
        this.mPath = new Path();
        this.mPath.arcTo(new RectF(0.0f, 0.0f, this.ove, this.ove), 135.0f, 270.0f);
        this.mPath.lineTo(this.ove / 2.0f, this.ovf);
        this.mPath.close();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension((int) this.ove, (int) this.ovf);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.mPaint.setColor(this.mIndicatorColor);
        canvas.drawPath(this.mPath, this.mPaint);
        this.mPaint.setColor(this.ovc);
        canvas.drawText(this.ovh, this.ove / 2.0f, (this.ovf / 2.0f) + (this.ovg / 4.0f), this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setProgress(String str) {
        this.ovh = str;
        invalidate();
    }
}
