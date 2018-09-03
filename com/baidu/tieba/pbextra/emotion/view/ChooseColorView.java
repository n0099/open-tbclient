package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class ChooseColorView extends View {
    private int dkB;
    private int fRU;
    private boolean fRV;
    private Bitmap fRW;
    private int mBorderColor;
    private Paint mBorderPaint;
    private float mBorderWidth;
    private Paint mPaint;

    public ChooseColorView(Context context) {
        this(context, null);
    }

    public ChooseColorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fRU = ViewCompat.MEASURED_STATE_MASK;
        this.mBorderColor = -1;
        this.mBorderWidth = getResources().getDimensionPixelSize(f.e.ds4);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.fRU);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.fRW = BitmapFactory.decodeResource(getResources(), f.C0146f.icon_select_n);
    }

    public void setChooseColor(int i) {
        this.fRU = i;
        this.mPaint.setColor(this.fRU);
    }

    public void setRadius(int i) {
        this.dkB = i;
    }

    public int getChooseColor() {
        return this.fRU;
    }

    public void setIsChooseView(boolean z) {
        this.fRV = z;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.dkB, this.mPaint);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.dkB, this.mBorderPaint);
        if (this.fRV) {
            canvas.drawBitmap(this.fRW, getWidth() - this.fRW.getWidth(), 0.0f, (Paint) null);
        }
    }
}
