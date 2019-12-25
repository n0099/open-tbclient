package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes8.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint avY;
    private Paint avZ;
    private int awa;
    private int awb;
    private float awc;
    private float awd;
    private int awe;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.avY = null;
        this.avZ = null;
        this.awa = 0;
        this.awb = 0;
        this.awc = 0.42857143f;
        this.awd = 1.0f;
        this.awe = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avY = null;
        this.avZ = null;
        this.awa = 0;
        this.awb = 0;
        this.awc = 0.42857143f;
        this.awd = 1.0f;
        this.awe = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.avY = null;
        this.avZ = null;
        this.awa = 0;
        this.awb = 0;
        this.awc = 0.42857143f;
        this.awd = 1.0f;
        this.awe = 1;
        init();
    }

    private void init() {
        this.avY = new Paint();
        this.avY.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.avY.setAlpha(153);
        this.avZ = new Paint();
        this.avZ.setStyle(Paint.Style.STROKE);
        this.avZ.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.avZ != null) {
            this.avZ.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.awe = i;
        if (this.avZ != null) {
            this.avZ.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.awa, this.avY);
        canvas.drawRect(0.0f, getHeight() - this.awb, getWidth(), getHeight(), this.avY);
        canvas.drawRect(1.0f, this.awa, getWidth() - 1, getHeight() - this.awb, this.avZ);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.awd * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.awa = (int) (((i4 - i2) - width) * this.awc);
        this.awb = (int) (((i4 - i2) - width) * (1.0f - this.awc));
    }
}
