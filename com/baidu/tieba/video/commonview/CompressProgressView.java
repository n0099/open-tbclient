package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class CompressProgressView extends View {
    private int bqF;
    private int ehK;
    private Paint ehL;
    private Paint ehM;
    private RectF ehN;
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
        this.bqF = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.ehK = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.ehL = new Paint();
        this.ehL.setStrokeWidth(this.bqF);
        this.ehL.setColor(getResources().getColor(R.color.cp_bg_line_d));
        this.ehL.setStyle(Paint.Style.STROKE);
        this.ehL.setAntiAlias(true);
        this.ehM = new Paint();
        this.ehM.setStrokeWidth(this.ehK);
        this.ehM.setColor(getResources().getColor(R.color.cp_cont_a));
        this.ehM.setStyle(Paint.Style.STROKE);
        this.ehM.setAntiAlias(true);
        this.ehN = new RectF(this.bqF, this.bqF, this.mWidth + this.bqF, this.mWidth + this.bqF);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.ehN, 270.0f, 360.0f, false, this.ehM);
        canvas.drawArc(this.ehN, 270.0f, (this.mValue * EncoderTextureDrawer.X264_WIDTH) / 100, false, this.ehL);
    }
}
