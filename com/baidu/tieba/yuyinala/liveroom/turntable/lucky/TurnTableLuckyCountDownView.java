package com.baidu.tieba.yuyinala.liveroom.turntable.lucky;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class TurnTableLuckyCountDownView extends View {
    private Paint bjh;
    private RectF dXE;
    private Paint dXG;
    private float dXM;
    private float hQT;
    private float hQU;
    private String hQV;
    private float mProgress;

    public TurnTableLuckyCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setTimer(String str, float f) {
        this.hQV = str;
        this.mProgress = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Paint.FontMetricsInt fontMetricsInt = this.bjh.getFontMetricsInt();
        this.hQT = i * 0.5f;
        this.hQU = ((i2 - fontMetricsInt.top) - fontMetricsInt.bottom) * 0.5f;
        this.dXE.set(this.dXM * 0.5f, this.dXM * 0.5f, i - (this.dXM * 0.5f), i2 - (this.dXM * 0.5f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.dXE, -90.0f, this.mProgress * (-360.0f), false, this.dXG);
        canvas.drawText(this.hQV, this.hQT, this.hQU, this.bjh);
    }

    private void init() {
        ckX();
        initProgress();
    }

    private void ckX() {
        this.bjh = new Paint(1);
        this.bjh.setDither(true);
        this.bjh.setColor(-1);
        this.bjh.setStyle(Paint.Style.FILL);
        this.bjh.setTextAlign(Paint.Align.CENTER);
        this.bjh.setTextSize(getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
    }

    private void initProgress() {
        this.dXM = getResources().getDimensionPixelOffset(a.d.sdk_ds6);
        this.dXG = new Paint(1);
        this.dXG.setDither(true);
        this.dXG.setColor(-12753);
        this.dXG.setStrokeWidth(this.dXM);
        this.dXG.setStyle(Paint.Style.STROKE);
        this.dXE = new RectF();
    }
}
