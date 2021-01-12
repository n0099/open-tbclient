package com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes10.dex */
public class ArrowView extends View {
    private final int mHeight;
    private final Paint mPaint;
    private final Path mPath;
    private final int mWidth;

    public ArrowView(Context context) {
        this(context, null);
    }

    public ArrowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArrowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mWidth = f.dp2px(context, 12.0f);
        this.mHeight = f.dp2px(context, 7.0f);
        this.mPath = new Path();
        this.mPath.moveTo(0.0f, 0.0f);
        this.mPath.lineTo(this.mWidth, 0.0f);
        this.mPath.lineTo(this.mWidth / 2.0f, this.mHeight);
        this.mPath.close();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setColor(int i) {
        this.mPaint.setColor(i);
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(this.mPath, this.mPaint);
    }
}
