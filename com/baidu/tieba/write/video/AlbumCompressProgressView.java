package com.baidu.tieba.write.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class AlbumCompressProgressView extends View {
    private int amp;
    private int bMH;
    private Paint bMI;
    private Paint bMJ;
    private RectF bMK;
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
        this.amp = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.bMH = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.bMI = new Paint();
        this.bMI.setStrokeWidth(this.amp);
        this.bMI.setColor(getResources().getColor(R.color.cp_bg_line_d));
        this.bMI.setStyle(Paint.Style.STROKE);
        this.bMI.setAntiAlias(true);
        this.bMJ = new Paint();
        this.bMJ.setStrokeWidth(this.bMH);
        this.bMJ.setColor(getResources().getColor(R.color.cp_btn_a));
        this.bMJ.setStyle(Paint.Style.STROKE);
        this.bMJ.setAntiAlias(true);
        this.bMK = new RectF(this.amp, this.amp, this.mWidth + this.amp, this.mWidth + this.amp);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.bMK, 270.0f, 360.0f, false, this.bMJ);
        canvas.drawArc(this.bMK, 270.0f, (this.mValue * 360) / 100, false, this.bMI);
    }
}
