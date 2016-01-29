package com.baidu.tieba.person;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint cXi;
    private Paint cXj;
    private int cXk;
    private int cXl;
    private float cXm;
    private float cXn;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.cXi = null;
        this.cXj = null;
        this.cXk = 0;
        this.cXl = 0;
        this.cXm = 0.42857143f;
        this.cXn = 1.0f;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cXi = null;
        this.cXj = null;
        this.cXk = 0;
        this.cXl = 0;
        this.cXm = 0.42857143f;
        this.cXn = 1.0f;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cXi = null;
        this.cXj = null;
        this.cXk = 0;
        this.cXl = 0;
        this.cXm = 0.42857143f;
        this.cXn = 1.0f;
        init();
    }

    private void init() {
        this.cXi = new Paint();
        this.cXi.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.cXi.setAlpha(153);
        this.cXj = new Paint();
        this.cXj.setStyle(Paint.Style.STROKE);
        this.cXj.setColor(-1);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.cXk, this.cXi);
        canvas.drawRect(0.0f, getHeight() - this.cXl, getWidth(), getHeight(), this.cXi);
        canvas.drawRect(1.0f, this.cXk, getWidth() - 1, getHeight() - this.cXl, this.cXj);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.cXn * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.cXk = (int) (((i4 - i2) - width) * this.cXm);
        this.cXl = (int) (((i4 - i2) - width) * (1.0f - this.cXm));
    }
}
