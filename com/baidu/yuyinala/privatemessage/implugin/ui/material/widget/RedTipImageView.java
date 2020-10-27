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
    private a osD;
    private boolean osv;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {
        int Xo;
        float bGL;
        int color;
        int fbW;

        a() {
            RedTipImageView.this.mDensity = RedTipImageView.this.getContext().getResources().getDisplayMetrics().density;
            this.bGL = (float) (3.5d * RedTipImageView.this.mDensity);
            this.Xo = (int) (RedTipImageView.this.mDensity * 3.0f);
            this.fbW = (int) (RedTipImageView.this.mDensity * 3.0f);
            this.color = Color.parseColor("#F43531");
            if (ThemeManager.eel() == ThemeManager.ThemeMode.NIGHT) {
                this.color = Color.parseColor("#79251f");
            }
        }
    }

    public RedTipImageView(Context context) {
        super(context);
        this.osv = false;
        init();
    }

    public RedTipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.osv = false;
        init();
    }

    public RedTipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.osv = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.osD = new a();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.osv) {
            float width = ((getWidth() - this.osD.fbW) + (this.mDensity * 3.0f)) - this.osD.bGL;
            float f = (this.osD.Xo + this.osD.bGL) - (this.mDensity * 3.0f);
            Log.d("RedTipImageView", "cx = " + width + " cy= " + f);
            int color = this.mPaint.getColor();
            this.mPaint.setColor(this.osD.color);
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(width, f, this.osD.bGL, this.mPaint);
            this.mPaint.setColor(color);
        }
    }

    public void setTipOn(boolean z) {
        this.osv = z;
        invalidate();
    }
}
