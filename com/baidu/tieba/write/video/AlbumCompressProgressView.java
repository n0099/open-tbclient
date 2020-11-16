package com.baidu.tieba.write.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class AlbumCompressProgressView extends View {
    private int bAZ;
    private Paint eGA;
    private RectF eGB;
    private int eGy;
    private Paint eGz;
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
        this.bAZ = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.eGy = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.eGz = new Paint();
        this.eGz.setStrokeWidth(this.bAZ);
        this.eGz.setColor(getResources().getColor(R.color.CAM_X0201));
        this.eGz.setStyle(Paint.Style.STROKE);
        this.eGz.setAntiAlias(true);
        this.eGA = new Paint();
        this.eGA.setStrokeWidth(this.eGy);
        this.eGA.setColor(getResources().getColor(R.color.CAM_X0101));
        this.eGA.setStyle(Paint.Style.STROKE);
        this.eGA.setAntiAlias(true);
        this.eGB = new RectF(this.bAZ, this.bAZ, this.mWidth + this.bAZ, this.mWidth + this.bAZ);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.eGB, 270.0f, 360.0f, false, this.eGA);
        canvas.drawArc(this.eGB, 270.0f, (this.mValue * EncoderTextureDrawer.X264_WIDTH) / 100, false, this.eGz);
    }
}
