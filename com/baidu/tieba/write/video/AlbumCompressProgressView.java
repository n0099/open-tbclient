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
    private int awZ;
    private Paint axa;
    private Paint axb;
    private RectF axc;
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
        this.mWidth = getResources().getDimensionPixelSize(e.C0210e.ds100);
        this.mLineWidth = getResources().getDimensionPixelSize(e.C0210e.ds4);
        this.awZ = getResources().getDimensionPixelSize(e.C0210e.ds2);
        this.axa = new Paint();
        this.axa.setStrokeWidth(this.mLineWidth);
        this.axa.setColor(getResources().getColor(e.d.cp_bg_line_d));
        this.axa.setStyle(Paint.Style.STROKE);
        this.axa.setAntiAlias(true);
        this.axb = new Paint();
        this.axb.setStrokeWidth(this.awZ);
        this.axb.setColor(getResources().getColor(e.d.cp_cont_i_alpha40));
        this.axb.setStyle(Paint.Style.STROKE);
        this.axb.setAntiAlias(true);
        this.axc = new RectF(this.mLineWidth, this.mLineWidth, this.mWidth + this.mLineWidth, this.mWidth + this.mLineWidth);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.axc, 270.0f, 360.0f, false, this.axb);
        canvas.drawArc(this.axc, 270.0f, (this.mValue * 360) / 100, false, this.axa);
    }
}
