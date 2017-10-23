package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class CompressProgressView extends View {
    private Paint abA;
    private RectF abB;
    private int abC;
    private int abx;
    private int aby;
    private Paint abz;
    private int mWidth;

    public CompressProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.abC = 0;
        init();
    }

    public CompressProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abC = 0;
        init();
    }

    public CompressProgressView(Context context) {
        super(context);
        this.abC = 0;
        init();
    }

    public void setProgress(int i) {
        if (i != this.abC) {
            this.abC = i;
            invalidate();
        }
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(d.f.ds100);
        this.abx = getResources().getDimensionPixelSize(d.f.ds4);
        this.aby = getResources().getDimensionPixelSize(d.f.ds2);
        this.abz = new Paint();
        this.abz.setStrokeWidth(this.abx);
        this.abz.setColor(getResources().getColor(d.e.cp_bg_line_d));
        this.abz.setStyle(Paint.Style.STROKE);
        this.abz.setAntiAlias(true);
        this.abA = new Paint();
        this.abA.setStrokeWidth(this.aby);
        this.abA.setColor(getResources().getColor(d.e.cp_cont_i_alpha40));
        this.abA.setStyle(Paint.Style.STROKE);
        this.abA.setAntiAlias(true);
        this.abB = new RectF(this.abx, this.abx, this.mWidth + this.abx, this.mWidth + this.abx);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.abB, 270.0f, 360.0f, false, this.abA);
        canvas.drawArc(this.abB, 270.0f, (this.abC * 360) / 100, false, this.abz);
    }
}
