package com.baidu.tieba.person;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint dvg;
    private Paint dvh;
    private int dvi;
    private int dvj;
    private float dvk;
    private float dvl;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.dvg = null;
        this.dvh = null;
        this.dvi = 0;
        this.dvj = 0;
        this.dvk = 0.42857143f;
        this.dvl = 1.0f;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dvg = null;
        this.dvh = null;
        this.dvi = 0;
        this.dvj = 0;
        this.dvk = 0.42857143f;
        this.dvl = 1.0f;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dvg = null;
        this.dvh = null;
        this.dvi = 0;
        this.dvj = 0;
        this.dvk = 0.42857143f;
        this.dvl = 1.0f;
        init();
    }

    private void init() {
        this.dvg = new Paint();
        this.dvg.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.dvg.setAlpha(153);
        this.dvh = new Paint();
        this.dvh.setStyle(Paint.Style.STROKE);
        this.dvh.setColor(-1);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.dvi, this.dvg);
        canvas.drawRect(0.0f, getHeight() - this.dvj, getWidth(), getHeight(), this.dvg);
        canvas.drawRect(1.0f, this.dvi, getWidth() - 1, getHeight() - this.dvj, this.dvh);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.dvl * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.dvi = (int) (((i4 - i2) - width) * this.dvk);
        this.dvj = (int) (((i4 - i2) - width) * (1.0f - this.dvk));
    }
}
