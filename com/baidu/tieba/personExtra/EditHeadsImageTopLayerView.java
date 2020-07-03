package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.fastjson.asm.Opcodes;
/* loaded from: classes11.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint bhA;
    private Paint bhB;
    private int bhC;
    private int bhD;
    private float bhE;
    private float bhF;
    private int bhG;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.bhA = null;
        this.bhB = null;
        this.bhC = 0;
        this.bhD = 0;
        this.bhE = 0.42857143f;
        this.bhF = 1.0f;
        this.bhG = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bhA = null;
        this.bhB = null;
        this.bhC = 0;
        this.bhD = 0;
        this.bhE = 0.42857143f;
        this.bhF = 1.0f;
        this.bhG = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bhA = null;
        this.bhB = null;
        this.bhC = 0;
        this.bhD = 0;
        this.bhE = 0.42857143f;
        this.bhF = 1.0f;
        this.bhG = 1;
        init();
    }

    private void init() {
        this.bhA = new Paint();
        this.bhA.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bhA.setAlpha(Opcodes.IFEQ);
        this.bhB = new Paint();
        this.bhB.setStyle(Paint.Style.STROKE);
        this.bhB.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.bhB != null) {
            this.bhB.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.bhG = i;
        if (this.bhB != null) {
            this.bhB.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.bhC, this.bhA);
        canvas.drawRect(0.0f, getHeight() - this.bhD, getWidth(), getHeight(), this.bhA);
        canvas.drawRect(1.0f, this.bhC, getWidth() - 1, getHeight() - this.bhD, this.bhB);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.bhF * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.bhC = (int) (((i4 - i2) - width) * this.bhE);
        this.bhD = (int) (((i4 - i2) - width) * (1.0f - this.bhE));
    }
}
