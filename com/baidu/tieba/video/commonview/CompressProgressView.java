package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class CompressProgressView extends View {
    private int aoh;
    private Paint ceA;
    private RectF ceB;
    private int cey;
    private Paint cez;
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
        this.mWidth = getResources().getDimensionPixelSize(R.dimen.ds100);
        this.aoh = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.cey = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.cez = new Paint();
        this.cez.setStrokeWidth(this.aoh);
        this.cez.setColor(getResources().getColor(R.color.cp_bg_line_d));
        this.cez.setStyle(Paint.Style.STROKE);
        this.cez.setAntiAlias(true);
        this.ceA = new Paint();
        this.ceA.setStrokeWidth(this.cey);
        this.ceA.setColor(getResources().getColor(R.color.cp_cont_a));
        this.ceA.setStyle(Paint.Style.STROKE);
        this.ceA.setAntiAlias(true);
        this.ceB = new RectF(this.aoh, this.aoh, this.mWidth + this.aoh, this.mWidth + this.aoh);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.ceB, 270.0f, 360.0f, false, this.ceA);
        canvas.drawArc(this.ceB, 270.0f, (this.mValue * 360) / 100, false, this.cez);
    }
}
