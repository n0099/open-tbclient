package com.baidu.tieba.write.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class AlbumCompressProgressView extends View {
    private int aco;
    private int acp;
    private Paint acq;
    private Paint acr;
    private RectF acs;
    private int act;
    private int mWidth;

    public AlbumCompressProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.act = 0;
        init();
    }

    public AlbumCompressProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.act = 0;
        init();
    }

    public AlbumCompressProgressView(Context context) {
        super(context);
        this.act = 0;
        init();
    }

    public void setProgress(int i) {
        if (i != this.act) {
            this.act = i;
            invalidate();
        }
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(d.e.ds100);
        this.aco = getResources().getDimensionPixelSize(d.e.ds4);
        this.acp = getResources().getDimensionPixelSize(d.e.ds2);
        this.acq = new Paint();
        this.acq.setStrokeWidth(this.aco);
        this.acq.setColor(getResources().getColor(d.C0095d.cp_bg_line_d));
        this.acq.setStyle(Paint.Style.STROKE);
        this.acq.setAntiAlias(true);
        this.acr = new Paint();
        this.acr.setStrokeWidth(this.acp);
        this.acr.setColor(getResources().getColor(d.C0095d.cp_cont_i_alpha40));
        this.acr.setStyle(Paint.Style.STROKE);
        this.acr.setAntiAlias(true);
        this.acs = new RectF(this.aco, this.aco, this.mWidth + this.aco, this.mWidth + this.aco);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.acs, 270.0f, 360.0f, false, this.acr);
        canvas.drawArc(this.acs, 270.0f, (this.act * 360) / 100, false, this.acq);
    }
}
