package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint fGQ;
    private Paint fGR;
    private int fGS;
    private int fGT;
    private float fGU;
    private float fGV;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.fGQ = null;
        this.fGR = null;
        this.fGS = 0;
        this.fGT = 0;
        this.fGU = 0.42857143f;
        this.fGV = 1.0f;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fGQ = null;
        this.fGR = null;
        this.fGS = 0;
        this.fGT = 0;
        this.fGU = 0.42857143f;
        this.fGV = 1.0f;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fGQ = null;
        this.fGR = null;
        this.fGS = 0;
        this.fGT = 0;
        this.fGU = 0.42857143f;
        this.fGV = 1.0f;
        init();
    }

    private void init() {
        this.fGQ = new Paint();
        this.fGQ.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.fGQ.setAlpha(153);
        this.fGR = new Paint();
        this.fGR.setStyle(Paint.Style.STROKE);
        this.fGR.setColor(-1);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.fGS, this.fGQ);
        canvas.drawRect(0.0f, getHeight() - this.fGT, getWidth(), getHeight(), this.fGQ);
        canvas.drawRect(1.0f, this.fGS, getWidth() - 1, getHeight() - this.fGT, this.fGR);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.fGV * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.fGS = (int) (((i4 - i2) - width) * this.fGU);
        this.fGT = (int) (((i4 - i2) - width) * (1.0f - this.fGU));
    }
}
