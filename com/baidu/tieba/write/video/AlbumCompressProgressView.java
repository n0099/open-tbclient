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
    private int aBi;
    private int cVm;
    private Paint cVn;
    private Paint cVo;
    private RectF cVp;
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
        this.aBi = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.cVm = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.cVn = new Paint();
        this.cVn.setStrokeWidth(this.aBi);
        this.cVn.setColor(getResources().getColor(R.color.cp_bg_line_d));
        this.cVn.setStyle(Paint.Style.STROKE);
        this.cVn.setAntiAlias(true);
        this.cVo = new Paint();
        this.cVo.setStrokeWidth(this.cVm);
        this.cVo.setColor(getResources().getColor(R.color.cp_cont_a));
        this.cVo.setStyle(Paint.Style.STROKE);
        this.cVo.setAntiAlias(true);
        this.cVp = new RectF(this.aBi, this.aBi, this.mWidth + this.aBi, this.mWidth + this.aBi);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.cVp, 270.0f, 360.0f, false, this.cVo);
        canvas.drawArc(this.cVp, 270.0f, (this.mValue * 360) / 100, false, this.cVn);
    }
}
