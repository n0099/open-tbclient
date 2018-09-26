package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class ChooseColorView extends View {
    private int dqu;
    private int fZk;
    private boolean fZl;
    private Bitmap fZm;
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
        this.fZk = ViewCompat.MEASURED_STATE_MASK;
        this.mBorderColor = -1;
        this.mBorderWidth = getResources().getDimensionPixelSize(e.C0141e.ds4);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.fZk);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.fZm = BitmapFactory.decodeResource(getResources(), e.f.icon_select_n);
    }

    public void setChooseColor(int i) {
        this.fZk = i;
        this.mPaint.setColor(this.fZk);
    }

    public void setRadius(int i) {
        this.dqu = i;
    }

    public int getChooseColor() {
        return this.fZk;
    }

    public void setIsChooseView(boolean z) {
        this.fZl = z;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.dqu, this.mPaint);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.dqu, this.mBorderPaint);
        if (this.fZl) {
            canvas.drawBitmap(this.fZm, getWidth() - this.fZm.getWidth(), 0.0f, (Paint) null);
        }
    }
}
