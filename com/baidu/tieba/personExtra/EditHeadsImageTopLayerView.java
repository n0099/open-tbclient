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
    private Paint aBq;
    private Paint aBr;
    private int aBs;
    private int aBt;
    private float aBu;
    private float aBv;
    private int aBw;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.aBq = null;
        this.aBr = null;
        this.aBs = 0;
        this.aBt = 0;
        this.aBu = 0.42857143f;
        this.aBv = 1.0f;
        this.aBw = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBq = null;
        this.aBr = null;
        this.aBs = 0;
        this.aBt = 0;
        this.aBu = 0.42857143f;
        this.aBv = 1.0f;
        this.aBw = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBq = null;
        this.aBr = null;
        this.aBs = 0;
        this.aBt = 0;
        this.aBu = 0.42857143f;
        this.aBv = 1.0f;
        this.aBw = 1;
        init();
    }

    private void init() {
        this.aBq = new Paint();
        this.aBq.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.aBq.setAlpha(Opcodes.IFEQ);
        this.aBr = new Paint();
        this.aBr.setStyle(Paint.Style.STROKE);
        this.aBr.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.aBr != null) {
            this.aBr.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.aBw = i;
        if (this.aBr != null) {
            this.aBr.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.aBs, this.aBq);
        canvas.drawRect(0.0f, getHeight() - this.aBt, getWidth(), getHeight(), this.aBq);
        canvas.drawRect(1.0f, this.aBs, getWidth() - 1, getHeight() - this.aBt, this.aBr);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.aBv * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.aBs = (int) (((i4 - i2) - width) * this.aBu);
        this.aBt = (int) (((i4 - i2) - width) * (1.0f - this.aBu));
    }
}
