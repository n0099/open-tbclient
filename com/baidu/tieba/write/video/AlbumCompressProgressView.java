package com.baidu.tieba.write.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class AlbumCompressProgressView extends View {
    private int bLu;
    private int eWB;
    private Paint eWC;
    private Paint eWD;
    private RectF eWE;
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
        this.bLu = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.eWB = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.eWC = new Paint();
        this.eWC.setStrokeWidth(this.bLu);
        this.eWC.setColor(getResources().getColor(R.color.CAM_X0201));
        this.eWC.setStyle(Paint.Style.STROKE);
        this.eWC.setAntiAlias(true);
        this.eWD = new Paint();
        this.eWD.setStrokeWidth(this.eWB);
        this.eWD.setColor(getResources().getColor(R.color.CAM_X0101));
        this.eWD.setStyle(Paint.Style.STROKE);
        this.eWD.setAntiAlias(true);
        this.eWE = new RectF(this.bLu, this.bLu, this.mWidth + this.bLu, this.mWidth + this.bLu);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.eWE, 270.0f, 360.0f, false, this.eWD);
        canvas.drawArc(this.eWE, 270.0f, (this.mValue * EncoderTextureDrawer.X264_WIDTH) / 100, false, this.eWC);
    }
}
