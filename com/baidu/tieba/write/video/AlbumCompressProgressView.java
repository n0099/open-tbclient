package com.baidu.tieba.write.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class AlbumCompressProgressView extends View {
    private int bJU;
    private int eVc;
    private Paint eVd;
    private Paint eVe;
    private RectF eVf;
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
        this.bJU = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.eVc = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.eVd = new Paint();
        this.eVd.setStrokeWidth(this.bJU);
        this.eVd.setColor(getResources().getColor(R.color.CAM_X0201));
        this.eVd.setStyle(Paint.Style.STROKE);
        this.eVd.setAntiAlias(true);
        this.eVe = new Paint();
        this.eVe.setStrokeWidth(this.eVc);
        this.eVe.setColor(getResources().getColor(R.color.CAM_X0101));
        this.eVe.setStyle(Paint.Style.STROKE);
        this.eVe.setAntiAlias(true);
        this.eVf = new RectF(this.bJU, this.bJU, this.mWidth + this.bJU, this.mWidth + this.bJU);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.eVf, 270.0f, 360.0f, false, this.eVe);
        canvas.drawArc(this.eVf, 270.0f, (this.mValue * EncoderTextureDrawer.X264_WIDTH) / 100, false, this.eVd);
    }
}
