package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint gxE;
    private Paint gxF;
    private int gxG;
    private int gxH;
    private float gxI;
    private float gxJ;
    private int mLineWidth;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.gxE = null;
        this.gxF = null;
        this.gxG = 0;
        this.gxH = 0;
        this.gxI = 0.42857143f;
        this.gxJ = 1.0f;
        this.mLineWidth = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gxE = null;
        this.gxF = null;
        this.gxG = 0;
        this.gxH = 0;
        this.gxI = 0.42857143f;
        this.gxJ = 1.0f;
        this.mLineWidth = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gxE = null;
        this.gxF = null;
        this.gxG = 0;
        this.gxH = 0;
        this.gxI = 0.42857143f;
        this.gxJ = 1.0f;
        this.mLineWidth = 1;
        init();
    }

    private void init() {
        this.gxE = new Paint();
        this.gxE.setColor(-16777216);
        this.gxE.setAlpha(153);
        this.gxF = new Paint();
        this.gxF.setStyle(Paint.Style.STROKE);
        this.gxF.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.gxF != null) {
            this.gxF.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.mLineWidth = i;
        if (this.gxF != null) {
            this.gxF.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.gxG, this.gxE);
        canvas.drawRect(0.0f, getHeight() - this.gxH, getWidth(), getHeight(), this.gxE);
        canvas.drawRect(1.0f, this.gxG, getWidth() - 1, getHeight() - this.gxH, this.gxF);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.gxJ * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.gxG = (int) (((i4 - i2) - width) * this.gxI);
        this.gxH = (int) (((i4 - i2) - width) * (1.0f - this.gxI));
    }
}
