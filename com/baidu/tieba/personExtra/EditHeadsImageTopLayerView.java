package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes6.dex */
public class EditHeadsImageTopLayerView extends View {
    private int anq;
    private Paint ipj;
    private Paint ipk;
    private int ipl;
    private int ipm;
    private float ipn;
    private float ipo;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.ipj = null;
        this.ipk = null;
        this.ipl = 0;
        this.ipm = 0;
        this.ipn = 0.42857143f;
        this.ipo = 1.0f;
        this.anq = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ipj = null;
        this.ipk = null;
        this.ipl = 0;
        this.ipm = 0;
        this.ipn = 0.42857143f;
        this.ipo = 1.0f;
        this.anq = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ipj = null;
        this.ipk = null;
        this.ipl = 0;
        this.ipm = 0;
        this.ipn = 0.42857143f;
        this.ipo = 1.0f;
        this.anq = 1;
        init();
    }

    private void init() {
        this.ipj = new Paint();
        this.ipj.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.ipj.setAlpha(153);
        this.ipk = new Paint();
        this.ipk.setStyle(Paint.Style.STROKE);
        this.ipk.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.ipk != null) {
            this.ipk.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.anq = i;
        if (this.ipk != null) {
            this.ipk.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.ipl, this.ipj);
        canvas.drawRect(0.0f, getHeight() - this.ipm, getWidth(), getHeight(), this.ipj);
        canvas.drawRect(1.0f, this.ipl, getWidth() - 1, getHeight() - this.ipm, this.ipk);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.ipo * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.ipl = (int) (((i4 - i2) - width) * this.ipn);
        this.ipm = (int) (((i4 - i2) - width) * (1.0f - this.ipn));
    }
}
