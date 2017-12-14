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
    private int acl;
    private int acm;
    private Paint acn;
    private Paint aco;
    private RectF acp;
    private int acq;
    private int mWidth;

    public AlbumCompressProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.acq = 0;
        init();
    }

    public AlbumCompressProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.acq = 0;
        init();
    }

    public AlbumCompressProgressView(Context context) {
        super(context);
        this.acq = 0;
        init();
    }

    public void setProgress(int i) {
        if (i != this.acq) {
            this.acq = i;
            invalidate();
        }
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(d.e.ds100);
        this.acl = getResources().getDimensionPixelSize(d.e.ds4);
        this.acm = getResources().getDimensionPixelSize(d.e.ds2);
        this.acn = new Paint();
        this.acn.setStrokeWidth(this.acl);
        this.acn.setColor(getResources().getColor(d.C0096d.cp_bg_line_d));
        this.acn.setStyle(Paint.Style.STROKE);
        this.acn.setAntiAlias(true);
        this.aco = new Paint();
        this.aco.setStrokeWidth(this.acm);
        this.aco.setColor(getResources().getColor(d.C0096d.cp_cont_i_alpha40));
        this.aco.setStyle(Paint.Style.STROKE);
        this.aco.setAntiAlias(true);
        this.acp = new RectF(this.acl, this.acl, this.mWidth + this.acl, this.mWidth + this.acl);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.acp, 270.0f, 360.0f, false, this.aco);
        canvas.drawArc(this.acp, 270.0f, (this.acq * 360) / 100, false, this.acn);
    }
}
