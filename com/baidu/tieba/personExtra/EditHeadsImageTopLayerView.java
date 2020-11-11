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
    private Paint bCE;
    private Paint bCF;
    private int bCG;
    private int bCH;
    private float bCI;
    private float bCJ;
    private int bCK;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.bCE = null;
        this.bCF = null;
        this.bCG = 0;
        this.bCH = 0;
        this.bCI = 0.42857143f;
        this.bCJ = 1.0f;
        this.bCK = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bCE = null;
        this.bCF = null;
        this.bCG = 0;
        this.bCH = 0;
        this.bCI = 0.42857143f;
        this.bCJ = 1.0f;
        this.bCK = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bCE = null;
        this.bCF = null;
        this.bCG = 0;
        this.bCH = 0;
        this.bCI = 0.42857143f;
        this.bCJ = 1.0f;
        this.bCK = 1;
        init();
    }

    private void init() {
        this.bCE = new Paint();
        this.bCE.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bCE.setAlpha(Opcodes.IFEQ);
        this.bCF = new Paint();
        this.bCF.setStyle(Paint.Style.STROKE);
        this.bCF.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.bCF != null) {
            this.bCF.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.bCK = i;
        if (this.bCF != null) {
            this.bCF.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.bCG, this.bCE);
        canvas.drawRect(0.0f, getHeight() - this.bCH, getWidth(), getHeight(), this.bCE);
        canvas.drawRect(1.0f, this.bCG, getWidth() - 1, getHeight() - this.bCH, this.bCF);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.bCJ * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.bCG = (int) (((i4 - i2) - width) * this.bCI);
        this.bCH = (int) (((i4 - i2) - width) * (1.0f - this.bCI));
    }

    public void setmCutHeightScale(float f) {
        this.bCJ = f;
    }
}
