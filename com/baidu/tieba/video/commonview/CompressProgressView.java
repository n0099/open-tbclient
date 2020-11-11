package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class CompressProgressView extends View {
    private int bCK;
    private int eIg;
    private Paint eIh;
    private Paint eIi;
    private RectF eIj;
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
        this.bCK = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.eIg = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.eIh = new Paint();
        this.eIh.setStrokeWidth(this.bCK);
        this.eIh.setColor(getResources().getColor(R.color.cp_bg_line_d));
        this.eIh.setStyle(Paint.Style.STROKE);
        this.eIh.setAntiAlias(true);
        this.eIi = new Paint();
        this.eIi.setStrokeWidth(this.eIg);
        this.eIi.setColor(getResources().getColor(R.color.cp_cont_a));
        this.eIi.setStyle(Paint.Style.STROKE);
        this.eIi.setAntiAlias(true);
        this.eIj = new RectF(this.bCK, this.bCK, this.mWidth + this.bCK, this.mWidth + this.bCK);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.eIj, 270.0f, 360.0f, false, this.eIi);
        canvas.drawArc(this.eIj, 270.0f, (this.mValue * EncoderTextureDrawer.X264_WIDTH) / 100, false, this.eIh);
    }
}
