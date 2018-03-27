package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends View {
    private int ggU;
    private boolean ggV;
    private Bitmap ggW;
    private float lS;
    private int mBorderColor;
    private Paint mBorderPaint;
    private Paint mPaint;
    private int mRadius;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ggU = ViewCompat.MEASURED_STATE_MASK;
        this.mBorderColor = -1;
        this.lS = getResources().getDimensionPixelSize(d.e.ds4);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.ggU);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setStrokeWidth(this.lS);
        this.ggW = BitmapFactory.decodeResource(getResources(), d.f.icon_select_n);
    }

    public void setChooseColor(int i) {
        this.ggU = i;
        this.mPaint.setColor(this.ggU);
    }

    public void setRadius(int i) {
        this.mRadius = i;
    }

    public int getChooseColor() {
        return this.ggU;
    }

    public void setIsChooseView(boolean z) {
        this.ggV = z;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mRadius, this.mPaint);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mRadius, this.mBorderPaint);
        if (this.ggV) {
            canvas.drawBitmap(this.ggW, getWidth() - this.ggW.getWidth(), 0.0f, (Paint) null);
        }
    }
}
