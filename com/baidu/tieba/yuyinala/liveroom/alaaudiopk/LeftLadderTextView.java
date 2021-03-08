package com.baidu.tieba.yuyinala.liveroom.alaaudiopk;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
/* loaded from: classes10.dex */
public class LeftLadderTextView extends TextView {
    private int height;
    private Path ovi;
    private float ovj;
    private BgColor ovk;
    private LinearGradient ovl;
    private LinearGradient ovm;
    private Paint paint;
    private int width;

    /* loaded from: classes10.dex */
    public enum BgColor {
        RED,
        GRAY
    }

    public LeftLadderTextView(Context context) {
        super(context);
        this.ovj = 0.5f;
        this.ovk = BgColor.RED;
        init();
    }

    public LeftLadderTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ovj = 0.5f;
        this.ovk = BgColor.RED;
        init();
    }

    public LeftLadderTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ovj = 0.5f;
        this.ovk = BgColor.RED;
        init();
    }

    private void init() {
        Log.v("LadderView", OneKeyLoginSdkCall.l);
        this.paint = new Paint();
        this.ovi = new Path();
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.paint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = getWidth();
        this.height = getHeight();
        this.ovl = new LinearGradient(0.0f, 0.0f, this.width, 0.0f, getResources().getColor(a.c.sdk_color_d70471), getResources().getColor(a.c.sdk_color_ff528f), Shader.TileMode.CLAMP);
        this.ovm = new LinearGradient(0.0f, 0.0f, this.width, 0.0f, getResources().getColor(a.c.sdk_color_A2A2A2), getResources().getColor(a.c.sdk_color_717171), Shader.TileMode.CLAMP);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.v("LadderView", "onDraw");
        this.paint.reset();
        switch (this.ovk) {
            case RED:
                this.paint.setShader(this.ovl);
                break;
            case GRAY:
                this.paint.setShader(this.ovm);
                break;
        }
        this.ovi.moveTo(0.0f, 0.0f);
        this.ovi.lineTo(this.width, 0.0f);
        this.ovi.lineTo((int) (this.width - (this.ovj * this.height)), this.height);
        this.ovi.lineTo(0.0f, this.height);
        this.ovi.close();
        canvas.drawPath(this.ovi, this.paint);
    }

    public void setBgColor(BgColor bgColor) {
        this.ovk = bgColor;
    }
}
