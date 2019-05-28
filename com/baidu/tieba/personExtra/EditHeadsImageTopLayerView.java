package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes6.dex */
public class EditHeadsImageTopLayerView extends View {
    private int amp;
    private Paint ifN;
    private Paint ifO;
    private int ifP;
    private int ifQ;
    private float ifR;
    private float ifS;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.ifN = null;
        this.ifO = null;
        this.ifP = 0;
        this.ifQ = 0;
        this.ifR = 0.42857143f;
        this.ifS = 1.0f;
        this.amp = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ifN = null;
        this.ifO = null;
        this.ifP = 0;
        this.ifQ = 0;
        this.ifR = 0.42857143f;
        this.ifS = 1.0f;
        this.amp = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ifN = null;
        this.ifO = null;
        this.ifP = 0;
        this.ifQ = 0;
        this.ifR = 0.42857143f;
        this.ifS = 1.0f;
        this.amp = 1;
        init();
    }

    private void init() {
        this.ifN = new Paint();
        this.ifN.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.ifN.setAlpha(153);
        this.ifO = new Paint();
        this.ifO.setStyle(Paint.Style.STROKE);
        this.ifO.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.ifO != null) {
            this.ifO.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.amp = i;
        if (this.ifO != null) {
            this.ifO.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.ifP, this.ifN);
        canvas.drawRect(0.0f, getHeight() - this.ifQ, getWidth(), getHeight(), this.ifN);
        canvas.drawRect(1.0f, this.ifP, getWidth() - 1, getHeight() - this.ifQ, this.ifO);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.ifS * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.ifP = (int) (((i4 - i2) - width) * this.ifR);
        this.ifQ = (int) (((i4 - i2) - width) * (1.0f - this.ifR));
    }
}
