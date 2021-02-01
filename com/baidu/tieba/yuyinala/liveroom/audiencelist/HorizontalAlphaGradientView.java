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
    private int bNT;
    private int bTf;
    private int bTg;
    private Paint bqg;

    public HorizontalAlphaGradientView(Context context) {
        super(context);
        this.bNT = 0;
        this.bTg = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bNT = 0;
        this.bTg = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bNT = 0;
        this.bTg = 0;
    }

    public void setColor(int i, int i2) {
        this.bNT = i;
        this.bTg = i2;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            this.bTf = getResources().getDimensionPixelSize(a.d.sdk_ds28);
            this.bqg = new Paint();
            this.bqg.setStyle(Paint.Style.FILL_AND_STROKE);
            setLayerType(0, this.bqg);
            this.bqg.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.bqg.setShader(new LinearGradient(0.0f, 0.0f, this.bTf, 0.0f, this.bNT, this.bTg, Shader.TileMode.CLAMP));
        } else {
            this.bTf = 0;
            this.bqg = null;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bqg != null) {
            canvas.drawRect(0.0f, 0.0f, this.bTf, getHeight(), this.bqg);
        }
    }
}
