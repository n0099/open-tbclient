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
    private Paint bhT;
    private Paint bhU;
    private int bhV;
    private int bhW;
    private float bhX;
    private float bhY;
    private int bhZ;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.bhT = null;
        this.bhU = null;
        this.bhV = 0;
        this.bhW = 0;
        this.bhX = 0.42857143f;
        this.bhY = 1.0f;
        this.bhZ = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bhT = null;
        this.bhU = null;
        this.bhV = 0;
        this.bhW = 0;
        this.bhX = 0.42857143f;
        this.bhY = 1.0f;
        this.bhZ = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bhT = null;
        this.bhU = null;
        this.bhV = 0;
        this.bhW = 0;
        this.bhX = 0.42857143f;
        this.bhY = 1.0f;
        this.bhZ = 1;
        init();
    }

    private void init() {
        this.bhT = new Paint();
        this.bhT.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bhT.setAlpha(Opcodes.IFEQ);
        this.bhU = new Paint();
        this.bhU.setStyle(Paint.Style.STROKE);
        this.bhU.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.bhU != null) {
            this.bhU.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.bhZ = i;
        if (this.bhU != null) {
            this.bhU.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.bhV, this.bhT);
        canvas.drawRect(0.0f, getHeight() - this.bhW, getWidth(), getHeight(), this.bhT);
        canvas.drawRect(1.0f, this.bhV, getWidth() - 1, getHeight() - this.bhW, this.bhU);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.bhY * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.bhV = (int) (((i4 - i2) - width) * this.bhX);
        this.bhW = (int) (((i4 - i2) - width) * (1.0f - this.bhX));
    }

    public void setmCutHeightScale(float f) {
        this.bhY = f;
    }
}
