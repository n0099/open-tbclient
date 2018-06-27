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
    private int alO;
    private int alP;
    private Paint alQ;
    private Paint alR;
    private RectF alS;
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
        this.alO = getResources().getDimensionPixelSize(d.e.ds4);
        this.alP = getResources().getDimensionPixelSize(d.e.ds2);
        this.alQ = new Paint();
        this.alQ.setStrokeWidth(this.alO);
        this.alQ.setColor(getResources().getColor(d.C0142d.cp_bg_line_d));
        this.alQ.setStyle(Paint.Style.STROKE);
        this.alQ.setAntiAlias(true);
        this.alR = new Paint();
        this.alR.setStrokeWidth(this.alP);
        this.alR.setColor(getResources().getColor(d.C0142d.cp_cont_i_alpha40));
        this.alR.setStyle(Paint.Style.STROKE);
        this.alR.setAntiAlias(true);
        this.alS = new RectF(this.alO, this.alO, this.mWidth + this.alO, this.mWidth + this.alO);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.alS, 270.0f, 360.0f, false, this.alR);
        canvas.drawArc(this.alS, 270.0f, (this.mValue * 360) / 100, false, this.alQ);
    }
}
