package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint fFK;
    private Paint fFL;
    private int fFM;
    private int fFN;
    private float fFO;
    private float fFP;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.fFK = null;
        this.fFL = null;
        this.fFM = 0;
        this.fFN = 0;
        this.fFO = 0.42857143f;
        this.fFP = 1.0f;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fFK = null;
        this.fFL = null;
        this.fFM = 0;
        this.fFN = 0;
        this.fFO = 0.42857143f;
        this.fFP = 1.0f;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fFK = null;
        this.fFL = null;
        this.fFM = 0;
        this.fFN = 0;
        this.fFO = 0.42857143f;
        this.fFP = 1.0f;
        init();
    }

    private void init() {
        this.fFK = new Paint();
        this.fFK.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.fFK.setAlpha(153);
        this.fFL = new Paint();
        this.fFL.setStyle(Paint.Style.STROKE);
        this.fFL.setColor(-1);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.fFM, this.fFK);
        canvas.drawRect(0.0f, getHeight() - this.fFN, getWidth(), getHeight(), this.fFK);
        canvas.drawRect(1.0f, this.fFM, getWidth() - 1, getHeight() - this.fFN, this.fFL);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.fFP * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.fFM = (int) (((i4 - i2) - width) * this.fFO);
        this.fFN = (int) (((i4 - i2) - width) * (1.0f - this.fFO));
    }
}
