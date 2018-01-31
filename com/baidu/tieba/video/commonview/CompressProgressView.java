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
    private int aQD;
    private int aQE;
    private Paint aQF;
    private Paint aQG;
    private RectF aQH;
    private int aQI;
    private int mWidth;

    public CompressProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aQI = 0;
        init();
    }

    public CompressProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aQI = 0;
        init();
    }

    public CompressProgressView(Context context) {
        super(context);
        this.aQI = 0;
        init();
    }

    public void setProgress(int i) {
        if (i != this.aQI) {
            this.aQI = i;
            invalidate();
        }
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(d.e.ds100);
        this.aQD = getResources().getDimensionPixelSize(d.e.ds4);
        this.aQE = getResources().getDimensionPixelSize(d.e.ds2);
        this.aQF = new Paint();
        this.aQF.setStrokeWidth(this.aQD);
        this.aQF.setColor(getResources().getColor(d.C0108d.cp_bg_line_d));
        this.aQF.setStyle(Paint.Style.STROKE);
        this.aQF.setAntiAlias(true);
        this.aQG = new Paint();
        this.aQG.setStrokeWidth(this.aQE);
        this.aQG.setColor(getResources().getColor(d.C0108d.cp_cont_i_alpha40));
        this.aQG.setStyle(Paint.Style.STROKE);
        this.aQG.setAntiAlias(true);
        this.aQH = new RectF(this.aQD, this.aQD, this.mWidth + this.aQD, this.mWidth + this.aQD);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.aQH, 270.0f, 360.0f, false, this.aQG);
        canvas.drawArc(this.aQH, 270.0f, (this.aQI * 360) / 100, false, this.aQF);
    }
}
