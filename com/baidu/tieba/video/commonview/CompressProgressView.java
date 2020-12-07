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
    private int bGh;
    private int eNB;
    private Paint eNC;
    private Paint eND;
    private RectF eNE;
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
        this.bGh = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.eNB = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.eNC = new Paint();
        this.eNC.setStrokeWidth(this.bGh);
        this.eNC.setColor(getResources().getColor(R.color.CAM_X0201));
        this.eNC.setStyle(Paint.Style.STROKE);
        this.eNC.setAntiAlias(true);
        this.eND = new Paint();
        this.eND.setStrokeWidth(this.eNB);
        this.eND.setColor(getResources().getColor(R.color.CAM_X0101));
        this.eND.setStyle(Paint.Style.STROKE);
        this.eND.setAntiAlias(true);
        this.eNE = new RectF(this.bGh, this.bGh, this.mWidth + this.bGh, this.mWidth + this.bGh);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.eNE, 270.0f, 360.0f, false, this.eND);
        canvas.drawArc(this.eNE, 270.0f, (this.mValue * EncoderTextureDrawer.X264_WIDTH) / 100, false, this.eNC);
    }
}
