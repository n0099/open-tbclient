package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class CompressProgressView extends View {
    private int aVd;
    private int duK;
    private Paint duL;
    private Paint duM;
    private RectF duN;
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
        this.mWidth = getResources().getDimensionPixelSize(R.dimen.ds100);
        this.aVd = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.duK = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.duL = new Paint();
        this.duL.setStrokeWidth(this.aVd);
        this.duL.setColor(getResources().getColor(R.color.cp_bg_line_d));
        this.duL.setStyle(Paint.Style.STROKE);
        this.duL.setAntiAlias(true);
        this.duM = new Paint();
        this.duM.setStrokeWidth(this.duK);
        this.duM.setColor(getResources().getColor(R.color.cp_cont_a));
        this.duM.setStyle(Paint.Style.STROKE);
        this.duM.setAntiAlias(true);
        this.duN = new RectF(this.aVd, this.aVd, this.mWidth + this.aVd, this.mWidth + this.aVd);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.duN, 270.0f, 360.0f, false, this.duM);
        canvas.drawArc(this.duN, 270.0f, (this.mValue * 360) / 100, false, this.duL);
    }
}
