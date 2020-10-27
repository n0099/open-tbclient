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
    private int bwz;
    private int eCr;
    private Paint eCs;
    private Paint eCt;
    private RectF eCu;
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
        this.bwz = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.eCr = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.eCs = new Paint();
        this.eCs.setStrokeWidth(this.bwz);
        this.eCs.setColor(getResources().getColor(R.color.cp_bg_line_d));
        this.eCs.setStyle(Paint.Style.STROKE);
        this.eCs.setAntiAlias(true);
        this.eCt = new Paint();
        this.eCt.setStrokeWidth(this.eCr);
        this.eCt.setColor(getResources().getColor(R.color.cp_cont_a));
        this.eCt.setStyle(Paint.Style.STROKE);
        this.eCt.setAntiAlias(true);
        this.eCu = new RectF(this.bwz, this.bwz, this.mWidth + this.bwz, this.mWidth + this.bwz);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.eCu, 270.0f, 360.0f, false, this.eCt);
        canvas.drawArc(this.eCu, 270.0f, (this.mValue * EncoderTextureDrawer.X264_WIDTH) / 100, false, this.eCs);
    }
}
