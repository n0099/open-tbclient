package com.baidu.tieba.write.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class AlbumCompressProgressView extends View {
    private int awe;
    private int cQY;
    private Paint cQZ;
    private Paint cRa;
    private RectF cRb;
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
        this.awe = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.cQY = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.cQZ = new Paint();
        this.cQZ.setStrokeWidth(this.awe);
        this.cQZ.setColor(getResources().getColor(R.color.cp_bg_line_d));
        this.cQZ.setStyle(Paint.Style.STROKE);
        this.cQZ.setAntiAlias(true);
        this.cRa = new Paint();
        this.cRa.setStrokeWidth(this.cQY);
        this.cRa.setColor(getResources().getColor(R.color.cp_cont_a));
        this.cRa.setStyle(Paint.Style.STROKE);
        this.cRa.setAntiAlias(true);
        this.cRb = new RectF(this.awe, this.awe, this.mWidth + this.awe, this.mWidth + this.awe);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.cRb, 270.0f, 360.0f, false, this.cRa);
        canvas.drawArc(this.cRb, 270.0f, (this.mValue * 360) / 100, false, this.cQZ);
    }
}
