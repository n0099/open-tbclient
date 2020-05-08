package com.baidu.tieba.write.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class AlbumCompressProgressView extends View {
    private int aVi;
    private int duO;
    private Paint duP;
    private Paint duQ;
    private RectF duR;
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
        this.aVi = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.duO = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.duP = new Paint();
        this.duP.setStrokeWidth(this.aVi);
        this.duP.setColor(getResources().getColor(R.color.cp_bg_line_d));
        this.duP.setStyle(Paint.Style.STROKE);
        this.duP.setAntiAlias(true);
        this.duQ = new Paint();
        this.duQ.setStrokeWidth(this.duO);
        this.duQ.setColor(getResources().getColor(R.color.cp_cont_a));
        this.duQ.setStyle(Paint.Style.STROKE);
        this.duQ.setAntiAlias(true);
        this.duR = new RectF(this.aVi, this.aVi, this.mWidth + this.aVi, this.mWidth + this.aVi);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.duR, 270.0f, 360.0f, false, this.duQ);
        canvas.drawArc(this.duR, 270.0f, (this.mValue * 360) / 100, false, this.duP);
    }
}
