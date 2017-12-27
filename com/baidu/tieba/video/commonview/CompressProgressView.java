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
    private int aQB;
    private int aQC;
    private Paint aQD;
    private Paint aQE;
    private RectF aQF;
    private int aQG;
    private int mWidth;

    public CompressProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aQG = 0;
        init();
    }

    public CompressProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aQG = 0;
        init();
    }

    public CompressProgressView(Context context) {
        super(context);
        this.aQG = 0;
        init();
    }

    public void setProgress(int i) {
        if (i != this.aQG) {
            this.aQG = i;
            invalidate();
        }
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(d.e.ds100);
        this.aQB = getResources().getDimensionPixelSize(d.e.ds4);
        this.aQC = getResources().getDimensionPixelSize(d.e.ds2);
        this.aQD = new Paint();
        this.aQD.setStrokeWidth(this.aQB);
        this.aQD.setColor(getResources().getColor(d.C0108d.cp_bg_line_d));
        this.aQD.setStyle(Paint.Style.STROKE);
        this.aQD.setAntiAlias(true);
        this.aQE = new Paint();
        this.aQE.setStrokeWidth(this.aQC);
        this.aQE.setColor(getResources().getColor(d.C0108d.cp_cont_i_alpha40));
        this.aQE.setStyle(Paint.Style.STROKE);
        this.aQE.setAntiAlias(true);
        this.aQF = new RectF(this.aQB, this.aQB, this.mWidth + this.aQB, this.mWidth + this.aQB);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.aQF, 270.0f, 360.0f, false, this.aQE);
        canvas.drawArc(this.aQF, 270.0f, (this.aQG * 360) / 100, false, this.aQD);
    }
}
