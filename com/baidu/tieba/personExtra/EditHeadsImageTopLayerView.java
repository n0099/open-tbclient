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
    private Paint aBc;
    private Paint aBd;
    private int aBe;
    private int aBf;
    private float aBg;
    private float aBh;
    private int aBi;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.aBc = null;
        this.aBd = null;
        this.aBe = 0;
        this.aBf = 0;
        this.aBg = 0.42857143f;
        this.aBh = 1.0f;
        this.aBi = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBc = null;
        this.aBd = null;
        this.aBe = 0;
        this.aBf = 0;
        this.aBg = 0.42857143f;
        this.aBh = 1.0f;
        this.aBi = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBc = null;
        this.aBd = null;
        this.aBe = 0;
        this.aBf = 0;
        this.aBg = 0.42857143f;
        this.aBh = 1.0f;
        this.aBi = 1;
        init();
    }

    private void init() {
        this.aBc = new Paint();
        this.aBc.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.aBc.setAlpha(Opcodes.IFEQ);
        this.aBd = new Paint();
        this.aBd.setStyle(Paint.Style.STROKE);
        this.aBd.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.aBd != null) {
            this.aBd.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.aBi = i;
        if (this.aBd != null) {
            this.aBd.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.aBe, this.aBc);
        canvas.drawRect(0.0f, getHeight() - this.aBf, getWidth(), getHeight(), this.aBc);
        canvas.drawRect(1.0f, this.aBe, getWidth() - 1, getHeight() - this.aBf, this.aBd);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.aBh * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.aBe = (int) (((i4 - i2) - width) * this.aBg);
        this.aBf = (int) (((i4 - i2) - width) * (1.0f - this.aBg));
    }
}
