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
/* loaded from: classes11.dex */
public class RightLadderTextView extends TextView {
    private int height;
    private Path onp;
    private float onq;
    private LinearGradient ont;
    private BgColor onv;
    private LinearGradient onw;
    private Paint paint;
    private int width;

    /* loaded from: classes11.dex */
    public enum BgColor {
        BLUE,
        GRAY
    }

    public RightLadderTextView(Context context) {
        super(context);
        this.onq = 0.5f;
        this.onv = BgColor.BLUE;
        init();
    }

    public RightLadderTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.onq = 0.5f;
        this.onv = BgColor.BLUE;
        init();
    }

    public RightLadderTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.onq = 0.5f;
        this.onv = BgColor.BLUE;
        init();
    }

    private void init() {
        Log.v("LadderView", OneKeyLoginSdkCall.l);
        this.paint = new Paint();
        this.onp = new Path();
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.paint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = getWidth();
        this.height = getHeight();
        this.onw = new LinearGradient(0.0f, 0.0f, this.width, 0.0f, getResources().getColor(a.c.sdk_color_64daf5), getResources().getColor(a.c.sdk_color_0a48f3), Shader.TileMode.CLAMP);
        this.ont = new LinearGradient(0.0f, 0.0f, this.width, 0.0f, getResources().getColor(a.c.sdk_color_A2A2A2), getResources().getColor(a.c.sdk_color_717171), Shader.TileMode.CLAMP);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.v("LadderView", "onDraw");
        this.paint.reset();
        switch (this.onv) {
            case BLUE:
                this.paint.setShader(this.onw);
                break;
            case GRAY:
                this.paint.setShader(this.ont);
                break;
        }
        this.onp.moveTo((this.onq * this.height) + 0.0f, 0.0f);
        this.onp.lineTo(this.width, 0.0f);
        this.onp.lineTo(this.width, this.height);
        this.onp.lineTo(0.0f, this.height);
        this.onp.close();
        canvas.drawPath(this.onp, this.paint);
    }

    public void setBgColor(BgColor bgColor) {
        this.onv = bgColor;
    }
}
