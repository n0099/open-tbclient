package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes6.dex */
public class EditHeadsImageTopLayerView extends View {
    private int amd;
    private Paint hNq;
    private Paint hNr;
    private int hNs;
    private int hNt;
    private float hNu;
    private float hNv;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.hNq = null;
        this.hNr = null;
        this.hNs = 0;
        this.hNt = 0;
        this.hNu = 0.42857143f;
        this.hNv = 1.0f;
        this.amd = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hNq = null;
        this.hNr = null;
        this.hNs = 0;
        this.hNt = 0;
        this.hNu = 0.42857143f;
        this.hNv = 1.0f;
        this.amd = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hNq = null;
        this.hNr = null;
        this.hNs = 0;
        this.hNt = 0;
        this.hNu = 0.42857143f;
        this.hNv = 1.0f;
        this.amd = 1;
        init();
    }

    private void init() {
        this.hNq = new Paint();
        this.hNq.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.hNq.setAlpha(153);
        this.hNr = new Paint();
        this.hNr.setStyle(Paint.Style.STROKE);
        this.hNr.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.hNr != null) {
            this.hNr.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.amd = i;
        if (this.hNr != null) {
            this.hNr.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.hNs, this.hNq);
        canvas.drawRect(0.0f, getHeight() - this.hNt, getWidth(), getHeight(), this.hNq);
        canvas.drawRect(1.0f, this.hNs, getWidth() - 1, getHeight() - this.hNt, this.hNr);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.hNv * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.hNs = (int) (((i4 - i2) - width) * this.hNu);
        this.hNt = (int) (((i4 - i2) - width) * (1.0f - this.hNu));
    }
}
