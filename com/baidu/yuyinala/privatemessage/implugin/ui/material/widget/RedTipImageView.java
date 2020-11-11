package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import com.baidu.yuyinala.privatemessage.implugin.ui.theme.ThemeManager;
/* loaded from: classes4.dex */
public class RedTipImageView extends ImageView {
    private float mDensity;
    private Paint mPaint;
    private boolean oBO;
    private a oBW;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {
        int Xo;
        float bMq;
        int color;
        int fhN;

        a() {
            RedTipImageView.this.mDensity = RedTipImageView.this.getContext().getResources().getDisplayMetrics().density;
            this.bMq = (float) (3.5d * RedTipImageView.this.mDensity);
            this.Xo = (int) (RedTipImageView.this.mDensity * 3.0f);
            this.fhN = (int) (RedTipImageView.this.mDensity * 3.0f);
            this.color = Color.parseColor("#F43531");
            if (ThemeManager.eia() == ThemeManager.ThemeMode.NIGHT) {
                this.color = Color.parseColor("#79251f");
            }
        }
    }

    public RedTipImageView(Context context) {
        super(context);
        this.oBO = false;
        init();
    }

    public RedTipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oBO = false;
        init();
    }

    public RedTipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oBO = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.oBW = new a();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.oBO) {
            float width = ((getWidth() - this.oBW.fhN) + (this.mDensity * 3.0f)) - this.oBW.bMq;
            float f = (this.oBW.Xo + this.oBW.bMq) - (this.mDensity * 3.0f);
            Log.d("RedTipImageView", "cx = " + width + " cy= " + f);
            int color = this.mPaint.getColor();
            this.mPaint.setColor(this.oBW.color);
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(width, f, this.oBW.bMq, this.mPaint);
            this.mPaint.setColor(color);
        }
    }

    public void setTipOn(boolean z) {
        this.oBO = z;
        invalidate();
    }
}
