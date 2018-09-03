package com.baidu.tieba.write.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class AlbumCompressProgressView extends View {
    private int aln;
    private int alo;
    private Paint alp;
    private Paint alq;
    private RectF alr;
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
        this.mWidth = getResources().getDimensionPixelSize(f.e.ds100);
        this.aln = getResources().getDimensionPixelSize(f.e.ds4);
        this.alo = getResources().getDimensionPixelSize(f.e.ds2);
        this.alp = new Paint();
        this.alp.setStrokeWidth(this.aln);
        this.alp.setColor(getResources().getColor(f.d.cp_bg_line_d));
        this.alp.setStyle(Paint.Style.STROKE);
        this.alp.setAntiAlias(true);
        this.alq = new Paint();
        this.alq.setStrokeWidth(this.alo);
        this.alq.setColor(getResources().getColor(f.d.cp_cont_i_alpha40));
        this.alq.setStyle(Paint.Style.STROKE);
        this.alq.setAntiAlias(true);
        this.alr = new RectF(this.aln, this.aln, this.mWidth + this.aln, this.mWidth + this.aln);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.alr, 270.0f, 360.0f, false, this.alq);
        canvas.drawArc(this.alr, 270.0f, (this.mValue * 360) / 100, false, this.alp);
    }
}
