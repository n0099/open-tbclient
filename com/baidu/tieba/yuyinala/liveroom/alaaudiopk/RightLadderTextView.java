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
public class RightLadderTextView extends TextView {
    private int height;
    private Path oiJ;
    private float oiK;
    private LinearGradient oiN;
    private BgColor oiP;
    private LinearGradient oiQ;
    private Paint paint;
    private int width;

    /* loaded from: classes10.dex */
    public enum BgColor {
        BLUE,
        GRAY
    }

    public RightLadderTextView(Context context) {
        super(context);
        this.oiK = 0.5f;
        this.oiP = BgColor.BLUE;
        init();
    }

    public RightLadderTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oiK = 0.5f;
        this.oiP = BgColor.BLUE;
        init();
    }

    public RightLadderTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oiK = 0.5f;
        this.oiP = BgColor.BLUE;
        init();
    }

    private void init() {
        Log.v("LadderView", OneKeyLoginSdkCall.l);
        this.paint = new Paint();
        this.oiJ = new Path();
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.paint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = getWidth();
        this.height = getHeight();
        this.oiQ = new LinearGradient(0.0f, 0.0f, this.width, 0.0f, getResources().getColor(a.c.sdk_color_64daf5), getResources().getColor(a.c.sdk_color_0a48f3), Shader.TileMode.CLAMP);
        this.oiN = new LinearGradient(0.0f, 0.0f, this.width, 0.0f, getResources().getColor(a.c.sdk_color_A2A2A2), getResources().getColor(a.c.sdk_color_717171), Shader.TileMode.CLAMP);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.v("LadderView", "onDraw");
        this.paint.reset();
        switch (this.oiP) {
            case BLUE:
                this.paint.setShader(this.oiQ);
                break;
            case GRAY:
                this.paint.setShader(this.oiN);
                break;
        }
        this.oiJ.moveTo((this.oiK * this.height) + 0.0f, 0.0f);
        this.oiJ.lineTo(this.width, 0.0f);
        this.oiJ.lineTo(this.width, this.height);
        this.oiJ.lineTo(0.0f, this.height);
        this.oiJ.close();
        canvas.drawPath(this.oiJ, this.paint);
    }

    public void setBgColor(BgColor bgColor) {
        this.oiP = bgColor;
    }
}
