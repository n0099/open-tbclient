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
    private Paint ifK;
    private Paint ifL;
    private int ifM;
    private int ifN;
    private float ifO;
    private float ifP;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.ifK = null;
        this.ifL = null;
        this.ifM = 0;
        this.ifN = 0;
        this.ifO = 0.42857143f;
        this.ifP = 1.0f;
        this.amp = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ifK = null;
        this.ifL = null;
        this.ifM = 0;
        this.ifN = 0;
        this.ifO = 0.42857143f;
        this.ifP = 1.0f;
        this.amp = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ifK = null;
        this.ifL = null;
        this.ifM = 0;
        this.ifN = 0;
        this.ifO = 0.42857143f;
        this.ifP = 1.0f;
        this.amp = 1;
        init();
    }

    private void init() {
        this.ifK = new Paint();
        this.ifK.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.ifK.setAlpha(153);
        this.ifL = new Paint();
        this.ifL.setStyle(Paint.Style.STROKE);
        this.ifL.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.ifL != null) {
            this.ifL.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.amp = i;
        if (this.ifL != null) {
            this.ifL.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.ifM, this.ifK);
        canvas.drawRect(0.0f, getHeight() - this.ifN, getWidth(), getHeight(), this.ifK);
        canvas.drawRect(1.0f, this.ifM, getWidth() - 1, getHeight() - this.ifN, this.ifL);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.ifP * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.ifM = (int) (((i4 - i2) - width) * this.ifO);
        this.ifN = (int) (((i4 - i2) - width) * (1.0f - this.ifO));
    }
}
