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
    private int bPt;
    private int bUF;
    private int bUG;
    private Paint brG;

    public HorizontalAlphaGradientView(Context context) {
        super(context);
        this.bPt = 0;
        this.bUG = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bPt = 0;
        this.bUG = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bPt = 0;
        this.bUG = 0;
    }

    public void setColor(int i, int i2) {
        this.bPt = i;
        this.bUG = i2;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            this.bUF = getResources().getDimensionPixelSize(a.d.sdk_ds28);
            this.brG = new Paint();
            this.brG.setStyle(Paint.Style.FILL_AND_STROKE);
            setLayerType(0, this.brG);
            this.brG.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.brG.setShader(new LinearGradient(0.0f, 0.0f, this.bUF, 0.0f, this.bPt, this.bUG, Shader.TileMode.CLAMP));
        } else {
            this.bUF = 0;
            this.brG = null;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.brG != null) {
            canvas.drawRect(0.0f, 0.0f, this.bUF, getHeight(), this.brG);
        }
    }
}
