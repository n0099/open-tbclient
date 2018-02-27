package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint gla;
    private Paint glb;
    private int glc;
    private int gld;
    private float gle;
    private float glf;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.gla = null;
        this.glb = null;
        this.glc = 0;
        this.gld = 0;
        this.gle = 0.42857143f;
        this.glf = 1.0f;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gla = null;
        this.glb = null;
        this.glc = 0;
        this.gld = 0;
        this.gle = 0.42857143f;
        this.glf = 1.0f;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gla = null;
        this.glb = null;
        this.glc = 0;
        this.gld = 0;
        this.gle = 0.42857143f;
        this.glf = 1.0f;
        init();
    }

    private void init() {
        this.gla = new Paint();
        this.gla.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.gla.setAlpha(153);
        this.glb = new Paint();
        this.glb.setStyle(Paint.Style.STROKE);
        this.glb.setColor(-1);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.glc, this.gla);
        canvas.drawRect(0.0f, getHeight() - this.gld, getWidth(), getHeight(), this.gla);
        canvas.drawRect(1.0f, this.glc, getWidth() - 1, getHeight() - this.gld, this.glb);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.glf * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.glc = (int) (((i4 - i2) - width) * this.gle);
        this.gld = (int) (((i4 - i2) - width) * (1.0f - this.gle));
    }
}
