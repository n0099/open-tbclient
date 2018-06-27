package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint fWl;
    private Paint fWm;
    private int fWn;
    private int fWo;
    private float fWp;
    private float fWq;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.fWl = null;
        this.fWm = null;
        this.fWn = 0;
        this.fWo = 0;
        this.fWp = 0.42857143f;
        this.fWq = 1.0f;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fWl = null;
        this.fWm = null;
        this.fWn = 0;
        this.fWo = 0;
        this.fWp = 0.42857143f;
        this.fWq = 1.0f;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fWl = null;
        this.fWm = null;
        this.fWn = 0;
        this.fWo = 0;
        this.fWp = 0.42857143f;
        this.fWq = 1.0f;
        init();
    }

    private void init() {
        this.fWl = new Paint();
        this.fWl.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.fWl.setAlpha(153);
        this.fWm = new Paint();
        this.fWm.setStyle(Paint.Style.STROKE);
        this.fWm.setColor(-1);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.fWn, this.fWl);
        canvas.drawRect(0.0f, getHeight() - this.fWo, getWidth(), getHeight(), this.fWl);
        canvas.drawRect(1.0f, this.fWn, getWidth() - 1, getHeight() - this.fWo, this.fWm);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.fWq * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.fWn = (int) (((i4 - i2) - width) * this.fWp);
        this.fWo = (int) (((i4 - i2) - width) * (1.0f - this.fWp));
    }
}
