package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class CompressProgressView extends View {
    private int awQ;
    private int cRi;
    private Paint cRj;
    private Paint cRk;
    private RectF cRl;
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
        this.awQ = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.cRi = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.cRj = new Paint();
        this.cRj.setStrokeWidth(this.awQ);
        this.cRj.setColor(getResources().getColor(R.color.cp_bg_line_d));
        this.cRj.setStyle(Paint.Style.STROKE);
        this.cRj.setAntiAlias(true);
        this.cRk = new Paint();
        this.cRk.setStrokeWidth(this.cRi);
        this.cRk.setColor(getResources().getColor(R.color.cp_cont_a));
        this.cRk.setStyle(Paint.Style.STROKE);
        this.cRk.setAntiAlias(true);
        this.cRl = new RectF(this.awQ, this.awQ, this.mWidth + this.awQ, this.mWidth + this.awQ);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.cRl, 270.0f, 360.0f, false, this.cRk);
        canvas.drawArc(this.cRl, 270.0f, (this.mValue * 360) / 100, false, this.cRj);
    }
}
