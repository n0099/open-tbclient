package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class EditHeadsImageTopLayerView extends View {
    private int aln;
    private Paint fWC;
    private Paint fWD;
    private int fWE;
    private int fWF;
    private float fWG;
    private float fWH;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.fWC = null;
        this.fWD = null;
        this.fWE = 0;
        this.fWF = 0;
        this.fWG = 0.42857143f;
        this.fWH = 1.0f;
        this.aln = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fWC = null;
        this.fWD = null;
        this.fWE = 0;
        this.fWF = 0;
        this.fWG = 0.42857143f;
        this.fWH = 1.0f;
        this.aln = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fWC = null;
        this.fWD = null;
        this.fWE = 0;
        this.fWF = 0;
        this.fWG = 0.42857143f;
        this.fWH = 1.0f;
        this.aln = 1;
        init();
    }

    private void init() {
        this.fWC = new Paint();
        this.fWC.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.fWC.setAlpha(153);
        this.fWD = new Paint();
        this.fWD.setStyle(Paint.Style.STROKE);
        this.fWD.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.fWD != null) {
            this.fWD.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.aln = i;
        if (this.fWD != null) {
            this.fWD.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.fWE, this.fWC);
        canvas.drawRect(0.0f, getHeight() - this.fWF, getWidth(), getHeight(), this.fWC);
        canvas.drawRect(1.0f, this.fWE, getWidth() - 1, getHeight() - this.fWF, this.fWD);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.fWH * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.fWE = (int) (((i4 - i2) - width) * this.fWG);
        this.fWF = (int) (((i4 - i2) - width) * (1.0f - this.fWG));
    }
}
