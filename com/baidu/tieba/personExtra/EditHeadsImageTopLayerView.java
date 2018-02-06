package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint gll;
    private Paint glm;
    private int gln;
    private int glo;
    private float glp;
    private float glq;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.gll = null;
        this.glm = null;
        this.gln = 0;
        this.glo = 0;
        this.glp = 0.42857143f;
        this.glq = 1.0f;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gll = null;
        this.glm = null;
        this.gln = 0;
        this.glo = 0;
        this.glp = 0.42857143f;
        this.glq = 1.0f;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gll = null;
        this.glm = null;
        this.gln = 0;
        this.glo = 0;
        this.glp = 0.42857143f;
        this.glq = 1.0f;
        init();
    }

    private void init() {
        this.gll = new Paint();
        this.gll.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.gll.setAlpha(153);
        this.glm = new Paint();
        this.glm.setStyle(Paint.Style.STROKE);
        this.glm.setColor(-1);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.gln, this.gll);
        canvas.drawRect(0.0f, getHeight() - this.glo, getWidth(), getHeight(), this.gll);
        canvas.drawRect(1.0f, this.gln, getWidth() - 1, getHeight() - this.glo, this.glm);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.glq * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.gln = (int) (((i4 - i2) - width) * this.glp);
        this.glo = (int) (((i4 - i2) - width) * (1.0f - this.glp));
    }
}
