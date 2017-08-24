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
    private Paint CZ;
    private int DF;
    private int eUO;
    private float eUP;
    private boolean eUQ;
    private Bitmap eUR;
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
        this.eUO = obtainStyledAttributes.getColor(d.n.ChooseColorView_chooseColor, ViewCompat.MEASURED_STATE_MASK);
        this.DF = obtainStyledAttributes.getColor(d.n.ChooseColorView_chooseBorderColor, -1);
        this.eUP = obtainStyledAttributes.getDimension(d.n.ChooseColorView_chooseBorderWidth, getResources().getDimensionPixelSize(d.f.ds4));
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.eUO);
        this.CZ = new Paint();
        this.CZ.setColor(this.DF);
        this.CZ.setAntiAlias(true);
        this.CZ.setStyle(Paint.Style.STROKE);
        this.CZ.setStrokeWidth(this.eUP);
        this.eUR = BitmapFactory.decodeResource(getResources(), d.g.icon_select_n);
    }

    public void setChooseColor(int i) {
        this.eUO = i;
        this.mPaint.setColor(this.eUO);
    }

    public void setRadius(int i) {
        this.mRadius = i;
    }

    public int getChooseColor() {
        return this.eUO;
    }

    public void setIsChooseView(boolean z) {
        this.eUQ = z;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mRadius, this.mPaint);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mRadius, this.CZ);
        if (this.eUQ) {
            canvas.drawBitmap(this.eUR, getWidth() - this.eUR.getWidth(), 0.0f, (Paint) null);
        }
    }
}
