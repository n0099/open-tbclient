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
    private int bnH;
    private int efr;
    private Paint efs;
    private Paint eft;
    private RectF efu;
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
        this.bnH = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.efr = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.efs = new Paint();
        this.efs.setStrokeWidth(this.bnH);
        this.efs.setColor(getResources().getColor(R.color.cp_bg_line_d));
        this.efs.setStyle(Paint.Style.STROKE);
        this.efs.setAntiAlias(true);
        this.eft = new Paint();
        this.eft.setStrokeWidth(this.efr);
        this.eft.setColor(getResources().getColor(R.color.cp_cont_a));
        this.eft.setStyle(Paint.Style.STROKE);
        this.eft.setAntiAlias(true);
        this.efu = new RectF(this.bnH, this.bnH, this.mWidth + this.bnH, this.mWidth + this.bnH);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.efu, 270.0f, 360.0f, false, this.eft);
        canvas.drawArc(this.efu, 270.0f, (this.mValue * EncoderTextureDrawer.X264_WIDTH) / 100, false, this.efs);
    }
}
