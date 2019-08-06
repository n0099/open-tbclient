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
    private int amS;
    private int bNN;
    private Paint bNO;
    private Paint bNP;
    private RectF bNQ;
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
        this.amS = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.bNN = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.bNO = new Paint();
        this.bNO.setStrokeWidth(this.amS);
        this.bNO.setColor(getResources().getColor(R.color.cp_bg_line_d));
        this.bNO.setStyle(Paint.Style.STROKE);
        this.bNO.setAntiAlias(true);
        this.bNP = new Paint();
        this.bNP.setStrokeWidth(this.bNN);
        this.bNP.setColor(getResources().getColor(R.color.cp_btn_a));
        this.bNP.setStyle(Paint.Style.STROKE);
        this.bNP.setAntiAlias(true);
        this.bNQ = new RectF(this.amS, this.amS, this.mWidth + this.amS, this.mWidth + this.amS);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.bNQ, 270.0f, 360.0f, false, this.bNP);
        canvas.drawArc(this.bNQ, 270.0f, (this.mValue * 360) / 100, false, this.bNO);
    }
}
