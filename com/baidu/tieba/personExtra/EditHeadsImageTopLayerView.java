package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes6.dex */
public class EditHeadsImageTopLayerView extends View {
    private int alY;
    private Paint hND;
    private Paint hNE;
    private int hNF;
    private int hNG;
    private float hNH;
    private float hNI;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.hND = null;
        this.hNE = null;
        this.hNF = 0;
        this.hNG = 0;
        this.hNH = 0.42857143f;
        this.hNI = 1.0f;
        this.alY = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hND = null;
        this.hNE = null;
        this.hNF = 0;
        this.hNG = 0;
        this.hNH = 0.42857143f;
        this.hNI = 1.0f;
        this.alY = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hND = null;
        this.hNE = null;
        this.hNF = 0;
        this.hNG = 0;
        this.hNH = 0.42857143f;
        this.hNI = 1.0f;
        this.alY = 1;
        init();
    }

    private void init() {
        this.hND = new Paint();
        this.hND.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.hND.setAlpha(153);
        this.hNE = new Paint();
        this.hNE.setStyle(Paint.Style.STROKE);
        this.hNE.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.hNE != null) {
            this.hNE.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.alY = i;
        if (this.hNE != null) {
            this.hNE.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.hNF, this.hND);
        canvas.drawRect(0.0f, getHeight() - this.hNG, getWidth(), getHeight(), this.hND);
        canvas.drawRect(1.0f, this.hNF, getWidth() - 1, getHeight() - this.hNG, this.hNE);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.hNI * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.hNF = (int) (((i4 - i2) - width) * this.hNH);
        this.hNG = (int) (((i4 - i2) - width) * (1.0f - this.hNH));
    }
}
