package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint fSj;
    private Paint fSk;
    private int fSl;
    private int fSm;
    private float fSn;
    private float fSo;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.fSj = null;
        this.fSk = null;
        this.fSl = 0;
        this.fSm = 0;
        this.fSn = 0.42857143f;
        this.fSo = 1.0f;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fSj = null;
        this.fSk = null;
        this.fSl = 0;
        this.fSm = 0;
        this.fSn = 0.42857143f;
        this.fSo = 1.0f;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fSj = null;
        this.fSk = null;
        this.fSl = 0;
        this.fSm = 0;
        this.fSn = 0.42857143f;
        this.fSo = 1.0f;
        init();
    }

    private void init() {
        this.fSj = new Paint();
        this.fSj.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.fSj.setAlpha(153);
        this.fSk = new Paint();
        this.fSk.setStyle(Paint.Style.STROKE);
        this.fSk.setColor(-1);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.fSl, this.fSj);
        canvas.drawRect(0.0f, getHeight() - this.fSm, getWidth(), getHeight(), this.fSj);
        canvas.drawRect(1.0f, this.fSl, getWidth() - 1, getHeight() - this.fSm, this.fSk);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.fSo * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.fSl = (int) (((i4 - i2) - width) * this.fSn);
        this.fSm = (int) (((i4 - i2) - width) * (1.0f - this.fSn));
    }
}
