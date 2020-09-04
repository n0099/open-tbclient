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
    private int bnK;
    private int efv;
    private Paint efw;
    private Paint efx;
    private RectF efy;
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
        this.bnK = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.efv = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.efw = new Paint();
        this.efw.setStrokeWidth(this.bnK);
        this.efw.setColor(getResources().getColor(R.color.cp_bg_line_d));
        this.efw.setStyle(Paint.Style.STROKE);
        this.efw.setAntiAlias(true);
        this.efx = new Paint();
        this.efx.setStrokeWidth(this.efv);
        this.efx.setColor(getResources().getColor(R.color.cp_cont_a));
        this.efx.setStyle(Paint.Style.STROKE);
        this.efx.setAntiAlias(true);
        this.efy = new RectF(this.bnK, this.bnK, this.mWidth + this.bnK, this.mWidth + this.bnK);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.efy, 270.0f, 360.0f, false, this.efx);
        canvas.drawArc(this.efy, 270.0f, (this.mValue * EncoderTextureDrawer.X264_WIDTH) / 100, false, this.efw);
    }
}
