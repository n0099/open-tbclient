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
    private int bcw;
    private int dIJ;
    private Paint dIK;
    private Paint dIL;
    private RectF dIM;
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
        this.bcw = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.dIJ = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.dIK = new Paint();
        this.dIK.setStrokeWidth(this.bcw);
        this.dIK.setColor(getResources().getColor(R.color.cp_bg_line_d));
        this.dIK.setStyle(Paint.Style.STROKE);
        this.dIK.setAntiAlias(true);
        this.dIL = new Paint();
        this.dIL.setStrokeWidth(this.dIJ);
        this.dIL.setColor(getResources().getColor(R.color.cp_cont_a));
        this.dIL.setStyle(Paint.Style.STROKE);
        this.dIL.setAntiAlias(true);
        this.dIM = new RectF(this.bcw, this.bcw, this.mWidth + this.bcw, this.mWidth + this.bcw);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.dIM, 270.0f, 360.0f, false, this.dIL);
        canvas.drawArc(this.dIM, 270.0f, (this.mValue * 360) / 100, false, this.dIK);
    }
}
