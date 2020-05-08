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
    private Paint aVc;
    private Paint aVd;
    private int aVe;
    private int aVf;
    private float aVg;
    private float aVh;
    private int aVi;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.aVc = null;
        this.aVd = null;
        this.aVe = 0;
        this.aVf = 0;
        this.aVg = 0.42857143f;
        this.aVh = 1.0f;
        this.aVi = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aVc = null;
        this.aVd = null;
        this.aVe = 0;
        this.aVf = 0;
        this.aVg = 0.42857143f;
        this.aVh = 1.0f;
        this.aVi = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aVc = null;
        this.aVd = null;
        this.aVe = 0;
        this.aVf = 0;
        this.aVg = 0.42857143f;
        this.aVh = 1.0f;
        this.aVi = 1;
        init();
    }

    private void init() {
        this.aVc = new Paint();
        this.aVc.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.aVc.setAlpha(Opcodes.IFEQ);
        this.aVd = new Paint();
        this.aVd.setStyle(Paint.Style.STROKE);
        this.aVd.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.aVd != null) {
            this.aVd.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.aVi = i;
        if (this.aVd != null) {
            this.aVd.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.aVe, this.aVc);
        canvas.drawRect(0.0f, getHeight() - this.aVf, getWidth(), getHeight(), this.aVc);
        canvas.drawRect(1.0f, this.aVe, getWidth() - 1, getHeight() - this.aVf, this.aVd);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.aVh * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.aVe = (int) (((i4 - i2) - width) * this.aVg);
        this.aVf = (int) (((i4 - i2) - width) * (1.0f - this.aVg));
    }
}
