package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.e;
/* loaded from: classes5.dex */
public class CompressProgressView extends View {
    private int axD;
    private Paint axE;
    private Paint axF;
    private RectF axG;
    private int mLineWidth;
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
        this.mWidth = getResources().getDimensionPixelSize(e.C0210e.ds100);
        this.mLineWidth = getResources().getDimensionPixelSize(e.C0210e.ds4);
        this.axD = getResources().getDimensionPixelSize(e.C0210e.ds2);
        this.axE = new Paint();
        this.axE.setStrokeWidth(this.mLineWidth);
        this.axE.setColor(getResources().getColor(e.d.cp_bg_line_d));
        this.axE.setStyle(Paint.Style.STROKE);
        this.axE.setAntiAlias(true);
        this.axF = new Paint();
        this.axF.setStrokeWidth(this.axD);
        this.axF.setColor(getResources().getColor(e.d.cp_cont_i_alpha40));
        this.axF.setStyle(Paint.Style.STROKE);
        this.axF.setAntiAlias(true);
        this.axG = new RectF(this.mLineWidth, this.mLineWidth, this.mWidth + this.mLineWidth, this.mWidth + this.mLineWidth);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.axG, 270.0f, 360.0f, false, this.axF);
        canvas.drawArc(this.axG, 270.0f, (this.mValue * 360) / 100, false, this.axE);
    }
}
