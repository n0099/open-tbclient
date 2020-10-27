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
    private Paint bwt;
    private Paint bwu;
    private int bwv;
    private int bww;
    private float bwx;
    private float bwy;
    private int bwz;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.bwt = null;
        this.bwu = null;
        this.bwv = 0;
        this.bww = 0;
        this.bwx = 0.42857143f;
        this.bwy = 1.0f;
        this.bwz = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bwt = null;
        this.bwu = null;
        this.bwv = 0;
        this.bww = 0;
        this.bwx = 0.42857143f;
        this.bwy = 1.0f;
        this.bwz = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bwt = null;
        this.bwu = null;
        this.bwv = 0;
        this.bww = 0;
        this.bwx = 0.42857143f;
        this.bwy = 1.0f;
        this.bwz = 1;
        init();
    }

    private void init() {
        this.bwt = new Paint();
        this.bwt.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bwt.setAlpha(Opcodes.IFEQ);
        this.bwu = new Paint();
        this.bwu.setStyle(Paint.Style.STROKE);
        this.bwu.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.bwu != null) {
            this.bwu.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.bwz = i;
        if (this.bwu != null) {
            this.bwu.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.bwv, this.bwt);
        canvas.drawRect(0.0f, getHeight() - this.bww, getWidth(), getHeight(), this.bwt);
        canvas.drawRect(1.0f, this.bwv, getWidth() - 1, getHeight() - this.bww, this.bwu);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.bwy * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.bwv = (int) (((i4 - i2) - width) * this.bwx);
        this.bww = (int) (((i4 - i2) - width) * (1.0f - this.bwx));
    }

    public void setmCutHeightScale(float f) {
        this.bwy = f;
    }
}
