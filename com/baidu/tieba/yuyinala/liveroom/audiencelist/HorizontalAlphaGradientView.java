package com.baidu.tieba.yuyinala.liveroom.audiencelist;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class HorizontalAlphaGradientView extends View {
    private int bAz;
    private int bFV;
    private int bFW;
    private Paint bkR;

    public HorizontalAlphaGradientView(Context context) {
        super(context);
        this.bAz = 0;
        this.bFW = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bAz = 0;
        this.bFW = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bAz = 0;
        this.bFW = 0;
    }

    public void setColor(int i, int i2) {
        this.bAz = i;
        this.bFW = i2;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            this.bFV = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            this.bkR = new Paint();
            this.bkR.setStyle(Paint.Style.FILL_AND_STROKE);
            setLayerType(0, this.bkR);
            this.bkR.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.bkR.setShader(new LinearGradient(0.0f, 0.0f, this.bFV, 0.0f, this.bAz, this.bFW, Shader.TileMode.CLAMP));
        } else {
            this.bFV = 0;
            this.bkR = null;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bkR != null) {
            canvas.drawRect(0.0f, 0.0f, this.bFV, getHeight(), this.bkR);
        }
    }
}
