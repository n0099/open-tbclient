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
    private int Bm;
    private int eXk;
    private float eXl;
    private boolean eXm;
    private Bitmap eXn;
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
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.l.ChooseColorView);
        this.eXk = obtainStyledAttributes.getColor(d.l.ChooseColorView_chooseColor, ViewCompat.MEASURED_STATE_MASK);
        this.Bm = obtainStyledAttributes.getColor(d.l.ChooseColorView_chooseBorderColor, -1);
        this.eXl = obtainStyledAttributes.getDimension(d.l.ChooseColorView_chooseBorderWidth, getResources().getDimensionPixelSize(d.e.ds4));
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.eXk);
        this.AV = new Paint();
        this.AV.setColor(this.Bm);
        this.AV.setAntiAlias(true);
        this.AV.setStyle(Paint.Style.STROKE);
        this.AV.setStrokeWidth(this.eXl);
        this.eXn = BitmapFactory.decodeResource(getResources(), d.f.icon_select_n);
    }

    public void setChooseColor(int i) {
        this.eXk = i;
        this.mPaint.setColor(this.eXk);
    }

    public void setRadius(int i) {
        this.mRadius = i;
    }

    public int getChooseColor() {
        return this.eXk;
    }

    public void setIsChooseView(boolean z) {
        this.eXm = z;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mRadius, this.mPaint);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mRadius, this.AV);
        if (this.eXm) {
            canvas.drawBitmap(this.eXn, getWidth() - this.eXn.getWidth(), 0.0f, (Paint) null);
        }
    }
}
