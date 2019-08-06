package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ChooseColorView extends View {
    private Paint GF;
    private int GW;
    private int iip;
    private boolean iiq;
    private Bitmap iir;
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
        this.iip = ViewCompat.MEASURED_STATE_MASK;
        this.GW = -1;
        this.mBorderWidth = getResources().getDimensionPixelSize(R.dimen.ds4);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.iip);
        this.GF = new Paint();
        this.GF.setColor(this.GW);
        this.GF.setAntiAlias(true);
        this.GF.setStyle(Paint.Style.STROKE);
        this.GF.setStrokeWidth(this.mBorderWidth);
        this.iir = BitmapFactory.decodeResource(getResources(), R.drawable.icon_select_n);
    }

    public void setChooseColor(int i) {
        this.iip = i;
        this.mPaint.setColor(this.iip);
    }

    public void setRadius(int i) {
        this.mRadius = i;
    }

    public int getChooseColor() {
        return this.iip;
    }

    public void setIsChooseView(boolean z) {
        this.iiq = z;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mRadius, this.mPaint);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mRadius, this.GF);
        if (this.iiq) {
            canvas.drawBitmap(this.iir, getWidth() - this.iir.getWidth(), 0.0f, (Paint) null);
        }
    }
}
