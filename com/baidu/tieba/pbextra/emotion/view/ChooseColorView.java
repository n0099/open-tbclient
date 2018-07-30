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
public class ChooseColorView extends View {
    private int dkD;
    private int fSc;
    private boolean fSd;
    private Bitmap fSe;
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
        this.fSc = ViewCompat.MEASURED_STATE_MASK;
        this.mBorderColor = -1;
        this.mBorderWidth = getResources().getDimensionPixelSize(d.e.ds4);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.fSc);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.fSe = BitmapFactory.decodeResource(getResources(), d.f.icon_select_n);
    }

    public void setChooseColor(int i) {
        this.fSc = i;
        this.mPaint.setColor(this.fSc);
    }

    public void setRadius(int i) {
        this.dkD = i;
    }

    public int getChooseColor() {
        return this.fSc;
    }

    public void setIsChooseView(boolean z) {
        this.fSd = z;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.dkD, this.mPaint);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.dkD, this.mBorderPaint);
        if (this.fSd) {
            canvas.drawBitmap(this.fSe, getWidth() - this.fSe.getWidth(), 0.0f, (Paint) null);
        }
    }
}
