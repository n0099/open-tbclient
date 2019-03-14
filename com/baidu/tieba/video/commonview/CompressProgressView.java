package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class CompressProgressView extends View {
    private int alY;
    private int bFl;
    private Paint bFm;
    private Paint bFn;
    private RectF bFo;
    private int mValue;
    private int mWidth;

    public CompressProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mValue = 0;
        init();
    }

    public CompressProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mValue = 0;
        init();
    }

    public CompressProgressView(Context context) {
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
        this.mWidth = getResources().getDimensionPixelSize(d.e.ds100);
        this.alY = getResources().getDimensionPixelSize(d.e.ds4);
        this.bFl = getResources().getDimensionPixelSize(d.e.ds2);
        this.bFm = new Paint();
        this.bFm.setStrokeWidth(this.alY);
        this.bFm.setColor(getResources().getColor(d.C0277d.cp_bg_line_d));
        this.bFm.setStyle(Paint.Style.STROKE);
        this.bFm.setAntiAlias(true);
        this.bFn = new Paint();
        this.bFn.setStrokeWidth(this.bFl);
        this.bFn.setColor(getResources().getColor(d.C0277d.cp_btn_a));
        this.bFn.setStyle(Paint.Style.STROKE);
        this.bFn.setAntiAlias(true);
        this.bFo = new RectF(this.alY, this.alY, this.mWidth + this.alY, this.mWidth + this.alY);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.bFo, 270.0f, 360.0f, false, this.bFn);
        canvas.drawArc(this.bFo, 270.0f, (this.mValue * 360) / 100, false, this.bFm);
    }
}
