package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint glt;
    private Paint glu;
    private int glv;
    private int glw;
    private float glx;
    private float gly;
    private int mLineWidth;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.glt = null;
        this.glu = null;
        this.glv = 0;
        this.glw = 0;
        this.glx = 0.42857143f;
        this.gly = 1.0f;
        this.mLineWidth = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.glt = null;
        this.glu = null;
        this.glv = 0;
        this.glw = 0;
        this.glx = 0.42857143f;
        this.gly = 1.0f;
        this.mLineWidth = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.glt = null;
        this.glu = null;
        this.glv = 0;
        this.glw = 0;
        this.glx = 0.42857143f;
        this.gly = 1.0f;
        this.mLineWidth = 1;
        init();
    }

    private void init() {
        this.glt = new Paint();
        this.glt.setColor(-16777216);
        this.glt.setAlpha(153);
        this.glu = new Paint();
        this.glu.setStyle(Paint.Style.STROKE);
        this.glu.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.glu != null) {
            this.glu.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.mLineWidth = i;
        if (this.glu != null) {
            this.glu.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.glv, this.glt);
        canvas.drawRect(0.0f, getHeight() - this.glw, getWidth(), getHeight(), this.glt);
        canvas.drawRect(1.0f, this.glv, getWidth() - 1, getHeight() - this.glw, this.glu);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.gly * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.glv = (int) (((i4 - i2) - width) * this.glx);
        this.glw = (int) (((i4 - i2) - width) * (1.0f - this.glx));
    }
}
