package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.fastjson.asm.Opcodes;
/* loaded from: classes18.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint bnE;
    private Paint bnF;
    private int bnG;
    private int bnH;
    private float bnI;
    private float bnJ;
    private int bnK;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.bnE = null;
        this.bnF = null;
        this.bnG = 0;
        this.bnH = 0;
        this.bnI = 0.42857143f;
        this.bnJ = 1.0f;
        this.bnK = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bnE = null;
        this.bnF = null;
        this.bnG = 0;
        this.bnH = 0;
        this.bnI = 0.42857143f;
        this.bnJ = 1.0f;
        this.bnK = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bnE = null;
        this.bnF = null;
        this.bnG = 0;
        this.bnH = 0;
        this.bnI = 0.42857143f;
        this.bnJ = 1.0f;
        this.bnK = 1;
        init();
    }

    private void init() {
        this.bnE = new Paint();
        this.bnE.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bnE.setAlpha(Opcodes.IFEQ);
        this.bnF = new Paint();
        this.bnF.setStyle(Paint.Style.STROKE);
        this.bnF.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.bnF != null) {
            this.bnF.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.bnK = i;
        if (this.bnF != null) {
            this.bnF.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.bnG, this.bnE);
        canvas.drawRect(0.0f, getHeight() - this.bnH, getWidth(), getHeight(), this.bnE);
        canvas.drawRect(1.0f, this.bnG, getWidth() - 1, getHeight() - this.bnH, this.bnF);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.bnJ * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.bnG = (int) (((i4 - i2) - width) * this.bnI);
        this.bnH = (int) (((i4 - i2) - width) * (1.0f - this.bnI));
    }

    public void setmCutHeightScale(float f) {
        this.bnJ = f;
    }
}
