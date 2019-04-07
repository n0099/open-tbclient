package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes6.dex */
public class EditHeadsImageTopLayerView extends View {
    private int amc;
    private Paint hNp;
    private Paint hNq;
    private int hNr;
    private int hNs;
    private float hNt;
    private float hNu;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.hNp = null;
        this.hNq = null;
        this.hNr = 0;
        this.hNs = 0;
        this.hNt = 0.42857143f;
        this.hNu = 1.0f;
        this.amc = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hNp = null;
        this.hNq = null;
        this.hNr = 0;
        this.hNs = 0;
        this.hNt = 0.42857143f;
        this.hNu = 1.0f;
        this.amc = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hNp = null;
        this.hNq = null;
        this.hNr = 0;
        this.hNs = 0;
        this.hNt = 0.42857143f;
        this.hNu = 1.0f;
        this.amc = 1;
        init();
    }

    private void init() {
        this.hNp = new Paint();
        this.hNp.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.hNp.setAlpha(153);
        this.hNq = new Paint();
        this.hNq.setStyle(Paint.Style.STROKE);
        this.hNq.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.hNq != null) {
            this.hNq.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.amc = i;
        if (this.hNq != null) {
            this.hNq.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.hNr, this.hNp);
        canvas.drawRect(0.0f, getHeight() - this.hNs, getWidth(), getHeight(), this.hNp);
        canvas.drawRect(1.0f, this.hNr, getWidth() - 1, getHeight() - this.hNs, this.hNq);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.hNu * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.hNr = (int) (((i4 - i2) - width) * this.hNt);
        this.hNs = (int) (((i4 - i2) - width) * (1.0f - this.hNt));
    }
}
