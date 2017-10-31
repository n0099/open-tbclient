package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class CompressProgressView extends View {
    private int abW;
    private int abX;
    private Paint abY;
    private Paint abZ;
    private RectF aca;
    private int acb;
    private int mWidth;

    public CompressProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.acb = 0;
        init();
    }

    public CompressProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.acb = 0;
        init();
    }

    public CompressProgressView(Context context) {
        super(context);
        this.acb = 0;
        init();
    }

    public void setProgress(int i) {
        if (i != this.acb) {
            this.acb = i;
            invalidate();
        }
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(d.e.ds100);
        this.abW = getResources().getDimensionPixelSize(d.e.ds4);
        this.abX = getResources().getDimensionPixelSize(d.e.ds2);
        this.abY = new Paint();
        this.abY.setStrokeWidth(this.abW);
        this.abY.setColor(getResources().getColor(d.C0080d.cp_bg_line_d));
        this.abY.setStyle(Paint.Style.STROKE);
        this.abY.setAntiAlias(true);
        this.abZ = new Paint();
        this.abZ.setStrokeWidth(this.abX);
        this.abZ.setColor(getResources().getColor(d.C0080d.cp_cont_i_alpha40));
        this.abZ.setStyle(Paint.Style.STROKE);
        this.abZ.setAntiAlias(true);
        this.aca = new RectF(this.abW, this.abW, this.mWidth + this.abW, this.mWidth + this.abW);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.aca, 270.0f, 360.0f, false, this.abZ);
        canvas.drawArc(this.aca, 270.0f, (this.acb * 360) / 100, false, this.abY);
    }
}
