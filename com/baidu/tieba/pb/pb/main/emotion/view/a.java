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
    private Paint CX;
    private int DD;
    private int eST;
    private float eSU;
    private boolean eSV;
    private Bitmap eSW;
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
        this.eST = obtainStyledAttributes.getColor(d.n.ChooseColorView_chooseColor, ViewCompat.MEASURED_STATE_MASK);
        this.DD = obtainStyledAttributes.getColor(d.n.ChooseColorView_chooseBorderColor, -1);
        this.eSU = obtainStyledAttributes.getDimension(d.n.ChooseColorView_chooseBorderWidth, getResources().getDimensionPixelSize(d.f.ds4));
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.eST);
        this.CX = new Paint();
        this.CX.setColor(this.DD);
        this.CX.setAntiAlias(true);
        this.CX.setStyle(Paint.Style.STROKE);
        this.CX.setStrokeWidth(this.eSU);
        this.eSW = BitmapFactory.decodeResource(getResources(), d.g.icon_select_n);
    }

    public void setChooseColor(int i) {
        this.eST = i;
        this.mPaint.setColor(this.eST);
    }

    public void setRadius(int i) {
        this.mRadius = i;
    }

    public int getChooseColor() {
        return this.eST;
    }

    public void setIsChooseView(boolean z) {
        this.eSV = z;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mRadius, this.mPaint);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mRadius, this.CX);
        if (this.eSV) {
            canvas.drawBitmap(this.eSW, getWidth() - this.eSW.getWidth(), 0.0f, (Paint) null);
        }
    }
}
