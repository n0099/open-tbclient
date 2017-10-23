package com.baidu.tieba.pb.pb.main.emotion.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends View {
    private Paint AV;
    private int BC;
    private float GM;
    private int eNW;
    private boolean eNX;
    private Bitmap eNY;
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
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.n.ChooseColorView);
        this.eNW = obtainStyledAttributes.getColor(d.n.ChooseColorView_chooseColor, ViewCompat.MEASURED_STATE_MASK);
        this.BC = obtainStyledAttributes.getColor(d.n.ChooseColorView_chooseBorderColor, -1);
        this.GM = obtainStyledAttributes.getDimension(d.n.ChooseColorView_chooseBorderWidth, getResources().getDimensionPixelSize(d.f.ds4));
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.eNW);
        this.AV = new Paint();
        this.AV.setColor(this.BC);
        this.AV.setAntiAlias(true);
        this.AV.setStyle(Paint.Style.STROKE);
        this.AV.setStrokeWidth(this.GM);
        this.eNY = BitmapFactory.decodeResource(getResources(), d.g.icon_select_n);
    }

    public void setChooseColor(int i) {
        this.eNW = i;
        this.mPaint.setColor(this.eNW);
    }

    public void setRadius(int i) {
        this.mRadius = i;
    }

    public int getChooseColor() {
        return this.eNW;
    }

    public void setIsChooseView(boolean z) {
        this.eNX = z;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mRadius, this.mPaint);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mRadius, this.AV);
        if (this.eNX) {
            canvas.drawBitmap(this.eNY, getWidth() - this.eNY.getWidth(), 0.0f, (Paint) null);
        }
    }
}
