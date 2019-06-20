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
    private Paint ifO;
    private Paint ifP;
    private int ifQ;
    private int ifR;
    private float ifS;
    private float ifT;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.ifO = null;
        this.ifP = null;
        this.ifQ = 0;
        this.ifR = 0;
        this.ifS = 0.42857143f;
        this.ifT = 1.0f;
        this.amp = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ifO = null;
        this.ifP = null;
        this.ifQ = 0;
        this.ifR = 0;
        this.ifS = 0.42857143f;
        this.ifT = 1.0f;
        this.amp = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ifO = null;
        this.ifP = null;
        this.ifQ = 0;
        this.ifR = 0;
        this.ifS = 0.42857143f;
        this.ifT = 1.0f;
        this.amp = 1;
        init();
    }

    private void init() {
        this.ifO = new Paint();
        this.ifO.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.ifO.setAlpha(153);
        this.ifP = new Paint();
        this.ifP.setStyle(Paint.Style.STROKE);
        this.ifP.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.ifP != null) {
            this.ifP.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.amp = i;
        if (this.ifP != null) {
            this.ifP.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.ifQ, this.ifO);
        canvas.drawRect(0.0f, getHeight() - this.ifR, getWidth(), getHeight(), this.ifO);
        canvas.drawRect(1.0f, this.ifQ, getWidth() - 1, getHeight() - this.ifR, this.ifP);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.ifT * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.ifQ = (int) (((i4 - i2) - width) * this.ifS);
        this.ifR = (int) (((i4 - i2) - width) * (1.0f - this.ifS));
    }
}
