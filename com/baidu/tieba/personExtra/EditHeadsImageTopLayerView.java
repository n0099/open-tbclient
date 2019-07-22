package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes6.dex */
public class EditHeadsImageTopLayerView extends View {
    private int amS;
    private Paint ime;
    private Paint imf;
    private int imh;
    private int imi;
    private float imj;
    private float imk;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.ime = null;
        this.imf = null;
        this.imh = 0;
        this.imi = 0;
        this.imj = 0.42857143f;
        this.imk = 1.0f;
        this.amS = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ime = null;
        this.imf = null;
        this.imh = 0;
        this.imi = 0;
        this.imj = 0.42857143f;
        this.imk = 1.0f;
        this.amS = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ime = null;
        this.imf = null;
        this.imh = 0;
        this.imi = 0;
        this.imj = 0.42857143f;
        this.imk = 1.0f;
        this.amS = 1;
        init();
    }

    private void init() {
        this.ime = new Paint();
        this.ime.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.ime.setAlpha(153);
        this.imf = new Paint();
        this.imf.setStyle(Paint.Style.STROKE);
        this.imf.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.imf != null) {
            this.imf.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.amS = i;
        if (this.imf != null) {
            this.imf.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.imh, this.ime);
        canvas.drawRect(0.0f, getHeight() - this.imi, getWidth(), getHeight(), this.ime);
        canvas.drawRect(1.0f, this.imh, getWidth() - 1, getHeight() - this.imi, this.imf);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.imk * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.imh = (int) (((i4 - i2) - width) * this.imj);
        this.imi = (int) (((i4 - i2) - width) * (1.0f - this.imj));
    }
}
