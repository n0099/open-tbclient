package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint gxF;
    private Paint gxG;
    private int gxH;
    private int gxI;
    private float gxJ;
    private float gxK;
    private int mLineWidth;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.gxF = null;
        this.gxG = null;
        this.gxH = 0;
        this.gxI = 0;
        this.gxJ = 0.42857143f;
        this.gxK = 1.0f;
        this.mLineWidth = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gxF = null;
        this.gxG = null;
        this.gxH = 0;
        this.gxI = 0;
        this.gxJ = 0.42857143f;
        this.gxK = 1.0f;
        this.mLineWidth = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gxF = null;
        this.gxG = null;
        this.gxH = 0;
        this.gxI = 0;
        this.gxJ = 0.42857143f;
        this.gxK = 1.0f;
        this.mLineWidth = 1;
        init();
    }

    private void init() {
        this.gxF = new Paint();
        this.gxF.setColor(-16777216);
        this.gxF.setAlpha(153);
        this.gxG = new Paint();
        this.gxG.setStyle(Paint.Style.STROKE);
        this.gxG.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.gxG != null) {
            this.gxG.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.mLineWidth = i;
        if (this.gxG != null) {
            this.gxG.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.gxH, this.gxF);
        canvas.drawRect(0.0f, getHeight() - this.gxI, getWidth(), getHeight(), this.gxF);
        canvas.drawRect(1.0f, this.gxH, getWidth() - 1, getHeight() - this.gxI, this.gxG);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.gxK * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.gxH = (int) (((i4 - i2) - width) * this.gxJ);
        this.gxI = (int) (((i4 - i2) - width) * (1.0f - this.gxJ));
    }
}
