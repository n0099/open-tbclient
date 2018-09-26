package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class EditHeadsImageTopLayerView extends View {
    private int anS;
    private Paint gdR;
    private Paint gdS;
    private int gdT;
    private int gdU;
    private float gdV;
    private float gdW;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.gdR = null;
        this.gdS = null;
        this.gdT = 0;
        this.gdU = 0;
        this.gdV = 0.42857143f;
        this.gdW = 1.0f;
        this.anS = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gdR = null;
        this.gdS = null;
        this.gdT = 0;
        this.gdU = 0;
        this.gdV = 0.42857143f;
        this.gdW = 1.0f;
        this.anS = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gdR = null;
        this.gdS = null;
        this.gdT = 0;
        this.gdU = 0;
        this.gdV = 0.42857143f;
        this.gdW = 1.0f;
        this.anS = 1;
        init();
    }

    private void init() {
        this.gdR = new Paint();
        this.gdR.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.gdR.setAlpha(153);
        this.gdS = new Paint();
        this.gdS.setStyle(Paint.Style.STROKE);
        this.gdS.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.gdS != null) {
            this.gdS.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.anS = i;
        if (this.gdS != null) {
            this.gdS.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.gdT, this.gdR);
        canvas.drawRect(0.0f, getHeight() - this.gdU, getWidth(), getHeight(), this.gdR);
        canvas.drawRect(1.0f, this.gdT, getWidth() - 1, getHeight() - this.gdU, this.gdS);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.gdW * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.gdT = (int) (((i4 - i2) - width) * this.gdV);
        this.gdU = (int) (((i4 - i2) - width) * (1.0f - this.gdV));
    }
}
