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
    private Paint ape;
    private int apu;
    private int ggP;
    private boolean ggQ;
    private Bitmap ggR;
    private float lS;
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
        this.ggP = ViewCompat.MEASURED_STATE_MASK;
        this.apu = -1;
        this.lS = getResources().getDimensionPixelSize(d.e.ds4);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.ggP);
        this.ape = new Paint();
        this.ape.setColor(this.apu);
        this.ape.setAntiAlias(true);
        this.ape.setStyle(Paint.Style.STROKE);
        this.ape.setStrokeWidth(this.lS);
        this.ggR = BitmapFactory.decodeResource(getResources(), d.f.icon_select_n);
    }

    public void setChooseColor(int i) {
        this.ggP = i;
        this.mPaint.setColor(this.ggP);
    }

    public void setRadius(int i) {
        this.mRadius = i;
    }

    public int getChooseColor() {
        return this.ggP;
    }

    public void setIsChooseView(boolean z) {
        this.ggQ = z;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mRadius, this.mPaint);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mRadius, this.ape);
        if (this.ggQ) {
            canvas.drawBitmap(this.ggR, getWidth() - this.ggR.getWidth(), 0.0f, (Paint) null);
        }
    }
}
