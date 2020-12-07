package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.fastjson.asm.Opcodes;
/* loaded from: classes24.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint bGb;
    private Paint bGc;
    private int bGd;
    private int bGe;
    private float bGf;
    private float bGg;
    private int bGh;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.bGb = null;
        this.bGc = null;
        this.bGd = 0;
        this.bGe = 0;
        this.bGf = 0.42857143f;
        this.bGg = 1.0f;
        this.bGh = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGb = null;
        this.bGc = null;
        this.bGd = 0;
        this.bGe = 0;
        this.bGf = 0.42857143f;
        this.bGg = 1.0f;
        this.bGh = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bGb = null;
        this.bGc = null;
        this.bGd = 0;
        this.bGe = 0;
        this.bGf = 0.42857143f;
        this.bGg = 1.0f;
        this.bGh = 1;
        init();
    }

    private void init() {
        this.bGb = new Paint();
        this.bGb.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bGb.setAlpha(Opcodes.IFEQ);
        this.bGc = new Paint();
        this.bGc.setStyle(Paint.Style.STROKE);
        this.bGc.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.bGc != null) {
            this.bGc.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.bGh = i;
        if (this.bGc != null) {
            this.bGc.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.bGd, this.bGb);
        canvas.drawRect(0.0f, getHeight() - this.bGe, getWidth(), getHeight(), this.bGb);
        canvas.drawRect(1.0f, this.bGd, getWidth() - 1, getHeight() - this.bGe, this.bGc);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.bGg * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.bGd = (int) (((i4 - i2) - width) * this.bGf);
        this.bGe = (int) (((i4 - i2) - width) * (1.0f - this.bGf));
    }

    public void setmCutHeightScale(float f) {
        this.bGg = f;
    }
}
