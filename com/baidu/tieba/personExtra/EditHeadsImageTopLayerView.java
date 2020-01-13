package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes9.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint awK;
    private Paint awL;
    private int awM;
    private int awN;
    private float awO;
    private float awP;
    private int awQ;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.awK = null;
        this.awL = null;
        this.awM = 0;
        this.awN = 0;
        this.awO = 0.42857143f;
        this.awP = 1.0f;
        this.awQ = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awK = null;
        this.awL = null;
        this.awM = 0;
        this.awN = 0;
        this.awO = 0.42857143f;
        this.awP = 1.0f;
        this.awQ = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.awK = null;
        this.awL = null;
        this.awM = 0;
        this.awN = 0;
        this.awO = 0.42857143f;
        this.awP = 1.0f;
        this.awQ = 1;
        init();
    }

    private void init() {
        this.awK = new Paint();
        this.awK.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.awK.setAlpha(153);
        this.awL = new Paint();
        this.awL.setStyle(Paint.Style.STROKE);
        this.awL.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.awL != null) {
            this.awL.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.awQ = i;
        if (this.awL != null) {
            this.awL.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.awM, this.awK);
        canvas.drawRect(0.0f, getHeight() - this.awN, getWidth(), getHeight(), this.awK);
        canvas.drawRect(1.0f, this.awM, getWidth() - 1, getHeight() - this.awN, this.awL);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.awP * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.awM = (int) (((i4 - i2) - width) * this.awO);
        this.awN = (int) (((i4 - i2) - width) * (1.0f - this.awO));
    }
}
