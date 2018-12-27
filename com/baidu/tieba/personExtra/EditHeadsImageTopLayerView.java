package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint gwA;
    private Paint gwB;
    private int gwC;
    private int gwD;
    private float gwE;
    private float gwF;
    private int mLineWidth;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.gwA = null;
        this.gwB = null;
        this.gwC = 0;
        this.gwD = 0;
        this.gwE = 0.42857143f;
        this.gwF = 1.0f;
        this.mLineWidth = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gwA = null;
        this.gwB = null;
        this.gwC = 0;
        this.gwD = 0;
        this.gwE = 0.42857143f;
        this.gwF = 1.0f;
        this.mLineWidth = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gwA = null;
        this.gwB = null;
        this.gwC = 0;
        this.gwD = 0;
        this.gwE = 0.42857143f;
        this.gwF = 1.0f;
        this.mLineWidth = 1;
        init();
    }

    private void init() {
        this.gwA = new Paint();
        this.gwA.setColor(-16777216);
        this.gwA.setAlpha(153);
        this.gwB = new Paint();
        this.gwB.setStyle(Paint.Style.STROKE);
        this.gwB.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.gwB != null) {
            this.gwB.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.mLineWidth = i;
        if (this.gwB != null) {
            this.gwB.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.gwC, this.gwA);
        canvas.drawRect(0.0f, getHeight() - this.gwD, getWidth(), getHeight(), this.gwA);
        canvas.drawRect(1.0f, this.gwC, getWidth() - 1, getHeight() - this.gwD, this.gwB);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.gwF * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.gwC = (int) (((i4 - i2) - width) * this.gwE);
        this.gwD = (int) (((i4 - i2) - width) * (1.0f - this.gwE));
    }
}
