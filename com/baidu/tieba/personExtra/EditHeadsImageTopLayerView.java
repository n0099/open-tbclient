package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint gmT;
    private Paint gmU;
    private int gmV;
    private int gmW;
    private float gmX;
    private float gmY;
    private int mLineWidth;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.gmT = null;
        this.gmU = null;
        this.gmV = 0;
        this.gmW = 0;
        this.gmX = 0.42857143f;
        this.gmY = 1.0f;
        this.mLineWidth = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gmT = null;
        this.gmU = null;
        this.gmV = 0;
        this.gmW = 0;
        this.gmX = 0.42857143f;
        this.gmY = 1.0f;
        this.mLineWidth = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gmT = null;
        this.gmU = null;
        this.gmV = 0;
        this.gmW = 0;
        this.gmX = 0.42857143f;
        this.gmY = 1.0f;
        this.mLineWidth = 1;
        init();
    }

    private void init() {
        this.gmT = new Paint();
        this.gmT.setColor(-16777216);
        this.gmT.setAlpha(153);
        this.gmU = new Paint();
        this.gmU.setStyle(Paint.Style.STROKE);
        this.gmU.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.gmU != null) {
            this.gmU.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.mLineWidth = i;
        if (this.gmU != null) {
            this.gmU.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.gmV, this.gmT);
        canvas.drawRect(0.0f, getHeight() - this.gmW, getWidth(), getHeight(), this.gmT);
        canvas.drawRect(1.0f, this.gmV, getWidth() - 1, getHeight() - this.gmW, this.gmU);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.gmY * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.gmV = (int) (((i4 - i2) - width) * this.gmX);
        this.gmW = (int) (((i4 - i2) - width) * (1.0f - this.gmX));
    }
}
