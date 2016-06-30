package com.baidu.tieba.person;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes.dex */
public class EditHeadsImageTopLayerView extends View {
    private int edA;
    private int edB;
    private float edC;
    private float edD;
    private Paint edy;
    private Paint edz;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.edy = null;
        this.edz = null;
        this.edA = 0;
        this.edB = 0;
        this.edC = 0.42857143f;
        this.edD = 1.0f;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.edy = null;
        this.edz = null;
        this.edA = 0;
        this.edB = 0;
        this.edC = 0.42857143f;
        this.edD = 1.0f;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.edy = null;
        this.edz = null;
        this.edA = 0;
        this.edB = 0;
        this.edC = 0.42857143f;
        this.edD = 1.0f;
        init();
    }

    private void init() {
        this.edy = new Paint();
        this.edy.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.edy.setAlpha(153);
        this.edz = new Paint();
        this.edz.setStyle(Paint.Style.STROKE);
        this.edz.setColor(-1);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.edA, this.edy);
        canvas.drawRect(0.0f, getHeight() - this.edB, getWidth(), getHeight(), this.edy);
        canvas.drawRect(1.0f, this.edA, getWidth() - 1, getHeight() - this.edB, this.edz);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.edD * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.edA = (int) (((i4 - i2) - width) * this.edC);
        this.edB = (int) (((i4 - i2) - width) * (1.0f - this.edC));
    }
}
