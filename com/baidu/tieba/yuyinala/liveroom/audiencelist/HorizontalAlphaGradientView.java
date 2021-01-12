package com.baidu.tieba.yuyinala.liveroom.audiencelist;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class HorizontalAlphaGradientView extends View {
    private int bKj;
    private int bPp;
    private int bPq;
    private Paint bmF;

    public HorizontalAlphaGradientView(Context context) {
        super(context);
        this.bKj = 0;
        this.bPq = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bKj = 0;
        this.bPq = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bKj = 0;
        this.bPq = 0;
    }

    public void setColor(int i, int i2) {
        this.bKj = i;
        this.bPq = i2;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            this.bPp = getResources().getDimensionPixelSize(a.d.sdk_ds28);
            this.bmF = new Paint();
            this.bmF.setStyle(Paint.Style.FILL_AND_STROKE);
            setLayerType(0, this.bmF);
            this.bmF.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.bmF.setShader(new LinearGradient(0.0f, 0.0f, this.bPp, 0.0f, this.bKj, this.bPq, Shader.TileMode.CLAMP));
        } else {
            this.bPp = 0;
            this.bmF = null;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bmF != null) {
            canvas.drawRect(0.0f, 0.0f, this.bPp, getHeight(), this.bmF);
        }
    }
}
