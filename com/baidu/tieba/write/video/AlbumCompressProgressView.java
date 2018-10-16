package com.baidu.tieba.write.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class AlbumCompressProgressView extends View {
    private int asM;
    private Paint asN;
    private Paint asO;
    private RectF asP;
    private int mLineWidth;
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
        this.mWidth = getResources().getDimensionPixelSize(e.C0175e.ds100);
        this.mLineWidth = getResources().getDimensionPixelSize(e.C0175e.ds4);
        this.asM = getResources().getDimensionPixelSize(e.C0175e.ds2);
        this.asN = new Paint();
        this.asN.setStrokeWidth(this.mLineWidth);
        this.asN.setColor(getResources().getColor(e.d.cp_bg_line_d));
        this.asN.setStyle(Paint.Style.STROKE);
        this.asN.setAntiAlias(true);
        this.asO = new Paint();
        this.asO.setStrokeWidth(this.asM);
        this.asO.setColor(getResources().getColor(e.d.cp_cont_i_alpha40));
        this.asO.setStyle(Paint.Style.STROKE);
        this.asO.setAntiAlias(true);
        this.asP = new RectF(this.mLineWidth, this.mLineWidth, this.mWidth + this.mLineWidth, this.mWidth + this.mLineWidth);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.asP, 270.0f, 360.0f, false, this.asO);
        canvas.drawArc(this.asP, 270.0f, (this.mValue * 360) / 100, false, this.asN);
    }
}
