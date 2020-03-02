package com.baidu.tieba.write.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class AlbumCompressProgressView extends View {
    private int aBh;
    private int cVl;
    private Paint cVm;
    private Paint cVn;
    private RectF cVo;
    private int mValue;
    private int mWidth;

    public AlbumCompressProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mValue = 0;
        init();
    }

    public AlbumCompressProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mValue = 0;
        init();
    }

    public AlbumCompressProgressView(Context context) {
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
        this.aBh = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.cVl = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.cVm = new Paint();
        this.cVm.setStrokeWidth(this.aBh);
        this.cVm.setColor(getResources().getColor(R.color.cp_bg_line_d));
        this.cVm.setStyle(Paint.Style.STROKE);
        this.cVm.setAntiAlias(true);
        this.cVn = new Paint();
        this.cVn.setStrokeWidth(this.cVl);
        this.cVn.setColor(getResources().getColor(R.color.cp_cont_a));
        this.cVn.setStyle(Paint.Style.STROKE);
        this.cVn.setAntiAlias(true);
        this.cVo = new RectF(this.aBh, this.aBh, this.mWidth + this.aBh, this.mWidth + this.aBh);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.cVo, 270.0f, 360.0f, false, this.cVn);
        canvas.drawArc(this.cVo, 270.0f, (this.mValue * 360) / 100, false, this.cVm);
    }
}
