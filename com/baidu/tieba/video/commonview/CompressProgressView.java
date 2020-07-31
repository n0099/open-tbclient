package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class CompressProgressView extends View {
    private int bhZ;
    private int dVR;
    private Paint dVS;
    private Paint dVT;
    private RectF dVU;
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
        this.bhZ = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.dVR = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.dVS = new Paint();
        this.dVS.setStrokeWidth(this.bhZ);
        this.dVS.setColor(getResources().getColor(R.color.cp_bg_line_d));
        this.dVS.setStyle(Paint.Style.STROKE);
        this.dVS.setAntiAlias(true);
        this.dVT = new Paint();
        this.dVT.setStrokeWidth(this.dVR);
        this.dVT.setColor(getResources().getColor(R.color.cp_cont_a));
        this.dVT.setStyle(Paint.Style.STROKE);
        this.dVT.setAntiAlias(true);
        this.dVU = new RectF(this.bhZ, this.bhZ, this.mWidth + this.bhZ, this.mWidth + this.bhZ);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.dVU, 270.0f, 360.0f, false, this.dVT);
        canvas.drawArc(this.dVU, 270.0f, (this.mValue * 360) / 100, false, this.dVS);
    }
}
