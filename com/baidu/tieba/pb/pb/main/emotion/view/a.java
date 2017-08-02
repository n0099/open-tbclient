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
    private Paint Bx;
    private int Ce;
    private int eRG;
    private float eRH;
    private boolean eRI;
    private Bitmap eRJ;
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
        this.eRG = obtainStyledAttributes.getColor(d.n.ChooseColorView_chooseColor, ViewCompat.MEASURED_STATE_MASK);
        this.Ce = obtainStyledAttributes.getColor(d.n.ChooseColorView_chooseBorderColor, -1);
        this.eRH = obtainStyledAttributes.getDimension(d.n.ChooseColorView_chooseBorderWidth, getResources().getDimensionPixelSize(d.f.ds4));
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.eRG);
        this.Bx = new Paint();
        this.Bx.setColor(this.Ce);
        this.Bx.setAntiAlias(true);
        this.Bx.setStyle(Paint.Style.STROKE);
        this.Bx.setStrokeWidth(this.eRH);
        this.eRJ = BitmapFactory.decodeResource(getResources(), d.g.icon_select_n);
    }

    public void setChooseColor(int i) {
        this.eRG = i;
        this.mPaint.setColor(this.eRG);
    }

    public void setRadius(int i) {
        this.mRadius = i;
    }

    public int getChooseColor() {
        return this.eRG;
    }

    public void setIsChooseView(boolean z) {
        this.eRI = z;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mRadius, this.mPaint);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mRadius, this.Bx);
        if (this.eRI) {
            canvas.drawBitmap(this.eRJ, getWidth() - this.eRJ.getWidth(), 0.0f, (Paint) null);
        }
    }
}
