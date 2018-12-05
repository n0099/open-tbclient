package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint gtJ;
    private Paint gtK;
    private int gtL;
    private int gtM;
    private float gtN;
    private float gtO;
    private int mLineWidth;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.gtJ = null;
        this.gtK = null;
        this.gtL = 0;
        this.gtM = 0;
        this.gtN = 0.42857143f;
        this.gtO = 1.0f;
        this.mLineWidth = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gtJ = null;
        this.gtK = null;
        this.gtL = 0;
        this.gtM = 0;
        this.gtN = 0.42857143f;
        this.gtO = 1.0f;
        this.mLineWidth = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gtJ = null;
        this.gtK = null;
        this.gtL = 0;
        this.gtM = 0;
        this.gtN = 0.42857143f;
        this.gtO = 1.0f;
        this.mLineWidth = 1;
        init();
    }

    private void init() {
        this.gtJ = new Paint();
        this.gtJ.setColor(-16777216);
        this.gtJ.setAlpha(153);
        this.gtK = new Paint();
        this.gtK.setStyle(Paint.Style.STROKE);
        this.gtK.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.gtK != null) {
            this.gtK.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.mLineWidth = i;
        if (this.gtK != null) {
            this.gtK.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.gtL, this.gtJ);
        canvas.drawRect(0.0f, getHeight() - this.gtM, getWidth(), getHeight(), this.gtJ);
        canvas.drawRect(1.0f, this.gtL, getWidth() - 1, getHeight() - this.gtM, this.gtK);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.gtO * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.gtL = (int) (((i4 - i2) - width) * this.gtN);
        this.gtM = (int) (((i4 - i2) - width) * (1.0f - this.gtN));
    }
}
