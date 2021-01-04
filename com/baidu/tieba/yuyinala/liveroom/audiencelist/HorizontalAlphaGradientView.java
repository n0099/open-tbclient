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
/* loaded from: classes11.dex */
public class HorizontalAlphaGradientView extends View {
    private int bOV;
    private int bUb;
    private int bUc;
    private Paint brr;

    public HorizontalAlphaGradientView(Context context) {
        super(context);
        this.bOV = 0;
        this.bUc = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bOV = 0;
        this.bUc = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bOV = 0;
        this.bUc = 0;
    }

    public void setColor(int i, int i2) {
        this.bOV = i;
        this.bUc = i2;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            this.bUb = getResources().getDimensionPixelSize(a.d.sdk_ds28);
            this.brr = new Paint();
            this.brr.setStyle(Paint.Style.FILL_AND_STROKE);
            setLayerType(0, this.brr);
            this.brr.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.brr.setShader(new LinearGradient(0.0f, 0.0f, this.bUb, 0.0f, this.bOV, this.bUc, Shader.TileMode.CLAMP));
        } else {
            this.bUb = 0;
            this.brr = null;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.brr != null) {
            canvas.drawRect(0.0f, 0.0f, this.bUb, getHeight(), this.brr);
        }
    }
}
