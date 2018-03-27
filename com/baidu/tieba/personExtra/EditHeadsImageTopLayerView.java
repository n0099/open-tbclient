package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint glq;
    private Paint glr;
    private int gls;
    private int glt;
    private float glu;
    private float glv;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.glq = null;
        this.glr = null;
        this.gls = 0;
        this.glt = 0;
        this.glu = 0.42857143f;
        this.glv = 1.0f;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.glq = null;
        this.glr = null;
        this.gls = 0;
        this.glt = 0;
        this.glu = 0.42857143f;
        this.glv = 1.0f;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.glq = null;
        this.glr = null;
        this.gls = 0;
        this.glt = 0;
        this.glu = 0.42857143f;
        this.glv = 1.0f;
        init();
    }

    private void init() {
        this.glq = new Paint();
        this.glq.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.glq.setAlpha(153);
        this.glr = new Paint();
        this.glr.setStyle(Paint.Style.STROKE);
        this.glr.setColor(-1);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.gls, this.glq);
        canvas.drawRect(0.0f, getHeight() - this.glt, getWidth(), getHeight(), this.glq);
        canvas.drawRect(1.0f, this.gls, getWidth() - 1, getHeight() - this.glt, this.glr);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.glv * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.gls = (int) (((i4 - i2) - width) * this.glu);
        this.glt = (int) (((i4 - i2) - width) * (1.0f - this.glu));
    }
}
