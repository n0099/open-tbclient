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
    private int aRR;
    private int aRS;
    private Paint aRT;
    private Paint aRU;
    private RectF aRV;
    private int aRW;
    private int mWidth;

    public CompressProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aRW = 0;
        init();
    }

    public CompressProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aRW = 0;
        init();
    }

    public CompressProgressView(Context context) {
        super(context);
        this.aRW = 0;
        init();
    }

    public void setProgress(int i) {
        if (i != this.aRW) {
            this.aRW = i;
            invalidate();
        }
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(d.e.ds100);
        this.aRR = getResources().getDimensionPixelSize(d.e.ds4);
        this.aRS = getResources().getDimensionPixelSize(d.e.ds2);
        this.aRT = new Paint();
        this.aRT.setStrokeWidth(this.aRR);
        this.aRT.setColor(getResources().getColor(d.C0141d.cp_bg_line_d));
        this.aRT.setStyle(Paint.Style.STROKE);
        this.aRT.setAntiAlias(true);
        this.aRU = new Paint();
        this.aRU.setStrokeWidth(this.aRS);
        this.aRU.setColor(getResources().getColor(d.C0141d.cp_cont_i_alpha40));
        this.aRU.setStyle(Paint.Style.STROKE);
        this.aRU.setAntiAlias(true);
        this.aRV = new RectF(this.aRR, this.aRR, this.mWidth + this.aRR, this.mWidth + this.aRR);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.aRV, 270.0f, 360.0f, false, this.aRU);
        canvas.drawArc(this.aRV, 270.0f, (this.aRW * 360) / 100, false, this.aRT);
    }
}
