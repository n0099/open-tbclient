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
    private Paint bLo;
    private Paint bLp;
    private int bLq;
    private int bLr;
    private float bLs;
    private float bLt;
    private int bLu;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.bLo = null;
        this.bLp = null;
        this.bLq = 0;
        this.bLr = 0;
        this.bLs = 0.42857143f;
        this.bLt = 1.0f;
        this.bLu = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bLo = null;
        this.bLp = null;
        this.bLq = 0;
        this.bLr = 0;
        this.bLs = 0.42857143f;
        this.bLt = 1.0f;
        this.bLu = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bLo = null;
        this.bLp = null;
        this.bLq = 0;
        this.bLr = 0;
        this.bLs = 0.42857143f;
        this.bLt = 1.0f;
        this.bLu = 1;
        init();
    }

    private void init() {
        this.bLo = new Paint();
        this.bLo.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bLo.setAlpha(Opcodes.IFEQ);
        this.bLp = new Paint();
        this.bLp.setStyle(Paint.Style.STROKE);
        this.bLp.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.bLp != null) {
            this.bLp.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.bLu = i;
        if (this.bLp != null) {
            this.bLp.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.bLq, this.bLo);
        canvas.drawRect(0.0f, getHeight() - this.bLr, getWidth(), getHeight(), this.bLo);
        canvas.drawRect(1.0f, this.bLq, getWidth() - 1, getHeight() - this.bLr, this.bLp);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.bLt * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.bLq = (int) (((i4 - i2) - width) * this.bLs);
        this.bLr = (int) (((i4 - i2) - width) * (1.0f - this.bLs));
    }

    public void setmCutHeightScale(float f) {
        this.bLt = f;
    }
}
