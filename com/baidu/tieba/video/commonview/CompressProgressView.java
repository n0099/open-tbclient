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
    private Paint atA;
    private Paint atB;
    private RectF atC;
    private int atz;
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
        this.mWidth = getResources().getDimensionPixelSize(e.C0200e.ds100);
        this.mLineWidth = getResources().getDimensionPixelSize(e.C0200e.ds4);
        this.atz = getResources().getDimensionPixelSize(e.C0200e.ds2);
        this.atA = new Paint();
        this.atA.setStrokeWidth(this.mLineWidth);
        this.atA.setColor(getResources().getColor(e.d.cp_bg_line_d));
        this.atA.setStyle(Paint.Style.STROKE);
        this.atA.setAntiAlias(true);
        this.atB = new Paint();
        this.atB.setStrokeWidth(this.atz);
        this.atB.setColor(getResources().getColor(e.d.cp_cont_i_alpha40));
        this.atB.setStyle(Paint.Style.STROKE);
        this.atB.setAntiAlias(true);
        this.atC = new RectF(this.mLineWidth, this.mLineWidth, this.mWidth + this.mLineWidth, this.mWidth + this.mLineWidth);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.atC, 270.0f, 360.0f, false, this.atB);
        canvas.drawArc(this.atC, 270.0f, (this.mValue * 360) / 100, false, this.atA);
    }
}
