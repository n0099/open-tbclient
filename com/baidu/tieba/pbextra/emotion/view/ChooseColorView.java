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
    private int dyv;
    private int ggM;
    private boolean ggN;
    private Bitmap ggO;
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
        this.ggM = -16777216;
        this.mBorderColor = -1;
        this.mBorderWidth = getResources().getDimensionPixelSize(e.C0175e.ds4);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.ggM);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.ggO = BitmapFactory.decodeResource(getResources(), e.f.icon_select_n);
    }

    public void setChooseColor(int i) {
        this.ggM = i;
        this.mPaint.setColor(this.ggM);
    }

    public void setRadius(int i) {
        this.dyv = i;
    }

    public int getChooseColor() {
        return this.ggM;
    }

    public void setIsChooseView(boolean z) {
        this.ggN = z;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.dyv, this.mPaint);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.dyv, this.mBorderPaint);
        if (this.ggN) {
            canvas.drawBitmap(this.ggO, getWidth() - this.ggO.getWidth(), 0.0f, (Paint) null);
        }
    }
}
