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
    private int aBg;
    private int cVk;
    private Paint cVl;
    private Paint cVm;
    private RectF cVn;
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
        this.aBg = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.cVk = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.cVl = new Paint();
        this.cVl.setStrokeWidth(this.aBg);
        this.cVl.setColor(getResources().getColor(R.color.cp_bg_line_d));
        this.cVl.setStyle(Paint.Style.STROKE);
        this.cVl.setAntiAlias(true);
        this.cVm = new Paint();
        this.cVm.setStrokeWidth(this.cVk);
        this.cVm.setColor(getResources().getColor(R.color.cp_cont_a));
        this.cVm.setStyle(Paint.Style.STROKE);
        this.cVm.setAntiAlias(true);
        this.cVn = new RectF(this.aBg, this.aBg, this.mWidth + this.aBg, this.mWidth + this.aBg);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.cVn, 270.0f, 360.0f, false, this.cVm);
        canvas.drawArc(this.cVn, 270.0f, (this.mValue * 360) / 100, false, this.cVl);
    }
}
