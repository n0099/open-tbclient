package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint fFN;
    private Paint fFO;
    private int fFP;
    private int fFQ;
    private float fFR;
    private float fFS;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.fFN = null;
        this.fFO = null;
        this.fFP = 0;
        this.fFQ = 0;
        this.fFR = 0.42857143f;
        this.fFS = 1.0f;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fFN = null;
        this.fFO = null;
        this.fFP = 0;
        this.fFQ = 0;
        this.fFR = 0.42857143f;
        this.fFS = 1.0f;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fFN = null;
        this.fFO = null;
        this.fFP = 0;
        this.fFQ = 0;
        this.fFR = 0.42857143f;
        this.fFS = 1.0f;
        init();
    }

    private void init() {
        this.fFN = new Paint();
        this.fFN.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.fFN.setAlpha(153);
        this.fFO = new Paint();
        this.fFO.setStyle(Paint.Style.STROKE);
        this.fFO.setColor(-1);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.fFP, this.fFN);
        canvas.drawRect(0.0f, getHeight() - this.fFQ, getWidth(), getHeight(), this.fFN);
        canvas.drawRect(1.0f, this.fFP, getWidth() - 1, getHeight() - this.fFQ, this.fFO);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.fFS * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.fFP = (int) (((i4 - i2) - width) * this.fFR);
        this.fFQ = (int) (((i4 - i2) - width) * (1.0f - this.fFR));
    }
}
