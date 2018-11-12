package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class ChooseColorView extends View {
    private int gij;
    private boolean gik;
    private Bitmap gil;
    private int mBorderColor;
    private Paint mBorderPaint;
    private float mBorderWidth;
    private Paint mPaint;
    private int mRadius;

    public ChooseColorView(Context context) {
        this(context, null);
    }

    public ChooseColorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gij = -16777216;
        this.mBorderColor = -1;
        this.mBorderWidth = getResources().getDimensionPixelSize(e.C0200e.ds4);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.gij);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.gil = BitmapFactory.decodeResource(getResources(), e.f.icon_select_n);
    }

    public void setChooseColor(int i) {
        this.gij = i;
        this.mPaint.setColor(this.gij);
    }

    public void setRadius(int i) {
        this.mRadius = i;
    }

    public int getChooseColor() {
        return this.gij;
    }

    public void setIsChooseView(boolean z) {
        this.gik = z;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mRadius, this.mPaint);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mRadius, this.mBorderPaint);
        if (this.gik) {
            canvas.drawBitmap(this.gil, getWidth() - this.gil.getWidth(), 0.0f, (Paint) null);
        }
    }
}
