package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class CompressProgressView extends View {
    private int amd;
    private int bFo;
    private Paint bFp;
    private Paint bFq;
    private RectF bFr;
    private int mValue;
    private int mWidth;

    public CompressProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mValue = 0;
        init();
    }

    public CompressProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mValue = 0;
        init();
    }

    public CompressProgressView(Context context) {
        super(context);
        this.mValue = 0;
        init();
    }

    public void setProgress(int i) {
        if (i != this.mValue) {
            this.mValue = i;
            invalidate();
        }
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(d.e.ds100);
        this.amd = getResources().getDimensionPixelSize(d.e.ds4);
        this.bFo = getResources().getDimensionPixelSize(d.e.ds2);
        this.bFp = new Paint();
        this.bFp.setStrokeWidth(this.amd);
        this.bFp.setColor(getResources().getColor(d.C0277d.cp_bg_line_d));
        this.bFp.setStyle(Paint.Style.STROKE);
        this.bFp.setAntiAlias(true);
        this.bFq = new Paint();
        this.bFq.setStrokeWidth(this.bFo);
        this.bFq.setColor(getResources().getColor(d.C0277d.cp_btn_a));
        this.bFq.setStyle(Paint.Style.STROKE);
        this.bFq.setAntiAlias(true);
        this.bFr = new RectF(this.amd, this.amd, this.mWidth + this.amd, this.mWidth + this.amd);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.bFr, 270.0f, 360.0f, false, this.bFq);
        canvas.drawArc(this.bFr, 270.0f, (this.mValue * 360) / 100, false, this.bFp);
    }
}
