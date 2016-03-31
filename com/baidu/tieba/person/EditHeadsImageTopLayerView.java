package com.baidu.tieba.person;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint drK;
    private Paint drL;
    private int drM;
    private int drN;
    private float drO;
    private float drP;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.drK = null;
        this.drL = null;
        this.drM = 0;
        this.drN = 0;
        this.drO = 0.42857143f;
        this.drP = 1.0f;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.drK = null;
        this.drL = null;
        this.drM = 0;
        this.drN = 0;
        this.drO = 0.42857143f;
        this.drP = 1.0f;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.drK = null;
        this.drL = null;
        this.drM = 0;
        this.drN = 0;
        this.drO = 0.42857143f;
        this.drP = 1.0f;
        init();
    }

    private void init() {
        this.drK = new Paint();
        this.drK.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.drK.setAlpha(153);
        this.drL = new Paint();
        this.drL.setStyle(Paint.Style.STROKE);
        this.drL.setColor(-1);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.drM, this.drK);
        canvas.drawRect(0.0f, getHeight() - this.drN, getWidth(), getHeight(), this.drK);
        canvas.drawRect(1.0f, this.drM, getWidth() - 1, getHeight() - this.drN, this.drL);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.drP * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.drM = (int) (((i4 - i2) - width) * this.drO);
        this.drN = (int) (((i4 - i2) - width) * (1.0f - this.drO));
    }
}
