package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.alibaba.fastjson.asm.Opcodes;
/* loaded from: classes7.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint bGe;
    private Paint bGf;
    private int bGg;
    private int bGh;
    private float bGi;
    private float bGj;
    private int bGk;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.bGe = null;
        this.bGf = null;
        this.bGg = 0;
        this.bGh = 0;
        this.bGi = 0.42857143f;
        this.bGj = 1.0f;
        this.bGk = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGe = null;
        this.bGf = null;
        this.bGg = 0;
        this.bGh = 0;
        this.bGi = 0.42857143f;
        this.bGj = 1.0f;
        this.bGk = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bGe = null;
        this.bGf = null;
        this.bGg = 0;
        this.bGh = 0;
        this.bGi = 0.42857143f;
        this.bGj = 1.0f;
        this.bGk = 1;
        init();
    }

    private void init() {
        this.bGe = new Paint();
        this.bGe.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bGe.setAlpha(Opcodes.IFEQ);
        this.bGf = new Paint();
        this.bGf.setStyle(Paint.Style.STROKE);
        this.bGf.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.bGf != null) {
            this.bGf.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.bGk = i;
        if (this.bGf != null) {
            this.bGf.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.bGg, this.bGe);
        canvas.drawRect(0.0f, getHeight() - this.bGh, getWidth(), getHeight(), this.bGe);
        canvas.drawRect(1.0f, this.bGg, getWidth() - 1, getHeight() - this.bGh, this.bGf);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.bGj * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.bGg = (int) (((i4 - i2) - width) * this.bGi);
        this.bGh = (int) (((i4 - i2) - width) * (1.0f - this.bGi));
    }

    public void setmCutHeightScale(float f) {
        this.bGj = f;
    }
}
