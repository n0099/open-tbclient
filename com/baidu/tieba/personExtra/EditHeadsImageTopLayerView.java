package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes6.dex */
public class EditHeadsImageTopLayerView extends View {
    private int amS;
    private Paint inj;
    private Paint ink;
    private int inl;
    private int inm;
    private float inn;
    private float ino;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.inj = null;
        this.ink = null;
        this.inl = 0;
        this.inm = 0;
        this.inn = 0.42857143f;
        this.ino = 1.0f;
        this.amS = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.inj = null;
        this.ink = null;
        this.inl = 0;
        this.inm = 0;
        this.inn = 0.42857143f;
        this.ino = 1.0f;
        this.amS = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.inj = null;
        this.ink = null;
        this.inl = 0;
        this.inm = 0;
        this.inn = 0.42857143f;
        this.ino = 1.0f;
        this.amS = 1;
        init();
    }

    private void init() {
        this.inj = new Paint();
        this.inj.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.inj.setAlpha(153);
        this.ink = new Paint();
        this.ink.setStyle(Paint.Style.STROKE);
        this.ink.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.ink != null) {
            this.ink.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.amS = i;
        if (this.ink != null) {
            this.ink.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.inl, this.inj);
        canvas.drawRect(0.0f, getHeight() - this.inm, getWidth(), getHeight(), this.inj);
        canvas.drawRect(1.0f, this.inl, getWidth() - 1, getHeight() - this.inm, this.ink);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.ino * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.inl = (int) (((i4 - i2) - width) * this.inn);
        this.inm = (int) (((i4 - i2) - width) * (1.0f - this.inn));
    }
}
