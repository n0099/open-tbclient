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
    private int aSc;
    private int aSd;
    private Paint aSe;
    private Paint aSf;
    private RectF aSg;
    private int aSh;
    private int mWidth;

    public AlbumCompressProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aSh = 0;
        init();
    }

    public AlbumCompressProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aSh = 0;
        init();
    }

    public AlbumCompressProgressView(Context context) {
        super(context);
        this.aSh = 0;
        init();
    }

    public void setProgress(int i) {
        if (i != this.aSh) {
            this.aSh = i;
            invalidate();
        }
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(d.e.ds100);
        this.aSc = getResources().getDimensionPixelSize(d.e.ds4);
        this.aSd = getResources().getDimensionPixelSize(d.e.ds2);
        this.aSe = new Paint();
        this.aSe.setStrokeWidth(this.aSc);
        this.aSe.setColor(getResources().getColor(d.C0140d.cp_bg_line_d));
        this.aSe.setStyle(Paint.Style.STROKE);
        this.aSe.setAntiAlias(true);
        this.aSf = new Paint();
        this.aSf.setStrokeWidth(this.aSd);
        this.aSf.setColor(getResources().getColor(d.C0140d.cp_cont_i_alpha40));
        this.aSf.setStyle(Paint.Style.STROKE);
        this.aSf.setAntiAlias(true);
        this.aSg = new RectF(this.aSc, this.aSc, this.mWidth + this.aSc, this.mWidth + this.aSc);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.aSg, 270.0f, 360.0f, false, this.aSf);
        canvas.drawArc(this.aSg, 270.0f, (this.aSh * 360) / 100, false, this.aSe);
    }
}
