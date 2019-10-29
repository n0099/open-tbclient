package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes6.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint aot;
    private Paint aou;
    private int aov;
    private int aow;
    private float aox;
    private float aoy;
    private int aoz;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.aot = null;
        this.aou = null;
        this.aov = 0;
        this.aow = 0;
        this.aox = 0.42857143f;
        this.aoy = 1.0f;
        this.aoz = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aot = null;
        this.aou = null;
        this.aov = 0;
        this.aow = 0;
        this.aox = 0.42857143f;
        this.aoy = 1.0f;
        this.aoz = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aot = null;
        this.aou = null;
        this.aov = 0;
        this.aow = 0;
        this.aox = 0.42857143f;
        this.aoy = 1.0f;
        this.aoz = 1;
        init();
    }

    private void init() {
        this.aot = new Paint();
        this.aot.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.aot.setAlpha(153);
        this.aou = new Paint();
        this.aou.setStyle(Paint.Style.STROKE);
        this.aou.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.aou != null) {
            this.aou.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.aoz = i;
        if (this.aou != null) {
            this.aou.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.aov, this.aot);
        canvas.drawRect(0.0f, getHeight() - this.aow, getWidth(), getHeight(), this.aot);
        canvas.drawRect(1.0f, this.aov, getWidth() - 1, getHeight() - this.aow, this.aou);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.aoy * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.aov = (int) (((i4 - i2) - width) * this.aox);
        this.aow = (int) (((i4 - i2) - width) * (1.0f - this.aox));
    }
}
