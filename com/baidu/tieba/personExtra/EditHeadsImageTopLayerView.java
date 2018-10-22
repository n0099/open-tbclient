package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint glu;
    private Paint glv;
    private int glw;
    private int glx;
    private float gly;
    private float glz;
    private int mLineWidth;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.glu = null;
        this.glv = null;
        this.glw = 0;
        this.glx = 0;
        this.gly = 0.42857143f;
        this.glz = 1.0f;
        this.mLineWidth = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.glu = null;
        this.glv = null;
        this.glw = 0;
        this.glx = 0;
        this.gly = 0.42857143f;
        this.glz = 1.0f;
        this.mLineWidth = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.glu = null;
        this.glv = null;
        this.glw = 0;
        this.glx = 0;
        this.gly = 0.42857143f;
        this.glz = 1.0f;
        this.mLineWidth = 1;
        init();
    }

    private void init() {
        this.glu = new Paint();
        this.glu.setColor(-16777216);
        this.glu.setAlpha(153);
        this.glv = new Paint();
        this.glv.setStyle(Paint.Style.STROKE);
        this.glv.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.glv != null) {
            this.glv.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.mLineWidth = i;
        if (this.glv != null) {
            this.glv.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.glw, this.glu);
        canvas.drawRect(0.0f, getHeight() - this.glx, getWidth(), getHeight(), this.glu);
        canvas.drawRect(1.0f, this.glw, getWidth() - 1, getHeight() - this.glx, this.glv);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.glz * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.glw = (int) (((i4 - i2) - width) * this.gly);
        this.glx = (int) (((i4 - i2) - width) * (1.0f - this.gly));
    }
}
