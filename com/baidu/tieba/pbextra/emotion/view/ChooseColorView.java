package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ChooseColorView extends View {
    private int mBorderColor;
    private Paint mBorderPaint;
    private float mBorderWidth;
    private Paint mPaint;
    private int mRadius;
    private int mhT;
    private boolean mhU;
    private Bitmap mhV;

    public ChooseColorView(Context context) {
        this(context, null);
    }

    public ChooseColorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mhT = ViewCompat.MEASURED_STATE_MASK;
        this.mBorderColor = -1;
        this.mBorderWidth = getResources().getDimensionPixelSize(R.dimen.ds4);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.mhT);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.mhV = BitmapFactory.decodeResource(getResources(), R.drawable.icon_select_n);
    }

    public void setChooseColor(int i) {
        this.mhT = i;
        this.mPaint.setColor(this.mhT);
    }

    public void setRadius(int i) {
        this.mRadius = i;
    }

    public int getChooseColor() {
        return this.mhT;
    }

    public void setIsChooseView(boolean z) {
        this.mhU = z;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mRadius, this.mPaint);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mRadius, this.mBorderPaint);
        if (this.mhU) {
            canvas.drawBitmap(this.mhV, getWidth() - this.mhV.getWidth(), 0.0f, (Paint) null);
        }
    }
}
