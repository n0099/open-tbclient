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
    private int aRT;
    private int aRU;
    private Paint aRV;
    private Paint aRW;
    private RectF aRX;
    private int aRY;
    private int mWidth;

    public AlbumCompressProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aRY = 0;
        init();
    }

    public AlbumCompressProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aRY = 0;
        init();
    }

    public AlbumCompressProgressView(Context context) {
        super(context);
        this.aRY = 0;
        init();
    }

    public void setProgress(int i) {
        if (i != this.aRY) {
            this.aRY = i;
            invalidate();
        }
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(d.e.ds100);
        this.aRT = getResources().getDimensionPixelSize(d.e.ds4);
        this.aRU = getResources().getDimensionPixelSize(d.e.ds2);
        this.aRV = new Paint();
        this.aRV.setStrokeWidth(this.aRT);
        this.aRV.setColor(getResources().getColor(d.C0141d.cp_bg_line_d));
        this.aRV.setStyle(Paint.Style.STROKE);
        this.aRV.setAntiAlias(true);
        this.aRW = new Paint();
        this.aRW.setStrokeWidth(this.aRU);
        this.aRW.setColor(getResources().getColor(d.C0141d.cp_cont_i_alpha40));
        this.aRW.setStyle(Paint.Style.STROKE);
        this.aRW.setAntiAlias(true);
        this.aRX = new RectF(this.aRT, this.aRT, this.mWidth + this.aRT, this.mWidth + this.aRT);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.aRX, 270.0f, 360.0f, false, this.aRW);
        canvas.drawArc(this.aRX, 270.0f, (this.aRY * 360) / 100, false, this.aRV);
    }
}
