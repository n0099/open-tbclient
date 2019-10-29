package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class CompressProgressView extends View {
    private int aoz;
    private int cfp;
    private Paint cfq;
    private Paint cfr;
    private RectF cfs;
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
        this.aoz = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.cfp = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.cfq = new Paint();
        this.cfq.setStrokeWidth(this.aoz);
        this.cfq.setColor(getResources().getColor(R.color.cp_bg_line_d));
        this.cfq.setStyle(Paint.Style.STROKE);
        this.cfq.setAntiAlias(true);
        this.cfr = new Paint();
        this.cfr.setStrokeWidth(this.cfp);
        this.cfr.setColor(getResources().getColor(R.color.cp_cont_a));
        this.cfr.setStyle(Paint.Style.STROKE);
        this.cfr.setAntiAlias(true);
        this.cfs = new RectF(this.aoz, this.aoz, this.mWidth + this.aoz, this.mWidth + this.aoz);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.cfs, 270.0f, 360.0f, false, this.cfr);
        canvas.drawArc(this.cfs, 270.0f, (this.mValue * 360) / 100, false, this.cfq);
    }
}
