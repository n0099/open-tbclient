package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import com.baidu.yuyinala.privatemessage.implugin.ui.theme.ThemeManager;
/* loaded from: classes11.dex */
public class RedTipImageView extends ImageView {
    private float mDensity;
    private Paint mPaint;
    private boolean peR;
    private a peZ;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        int Yh;
        int color;
        int fvN;
        float radius;

        a() {
            RedTipImageView.this.mDensity = RedTipImageView.this.getContext().getResources().getDisplayMetrics().density;
            this.radius = (float) (3.5d * RedTipImageView.this.mDensity);
            this.Yh = (int) (RedTipImageView.this.mDensity * 3.0f);
            this.fvN = (int) (RedTipImageView.this.mDensity * 3.0f);
            this.color = Color.parseColor("#F43531");
            if (ThemeManager.emw() == ThemeManager.ThemeMode.NIGHT) {
                this.color = Color.parseColor("#79251f");
            }
        }
    }

    public RedTipImageView(Context context) {
        super(context);
        this.peR = false;
        init();
    }

    public RedTipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.peR = false;
        init();
    }

    public RedTipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.peR = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.peZ = new a();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.peR) {
            float width = ((getWidth() - this.peZ.fvN) + (this.mDensity * 3.0f)) - this.peZ.radius;
            float f = (this.peZ.Yh + this.peZ.radius) - (this.mDensity * 3.0f);
            Log.d("RedTipImageView", "cx = " + width + " cy= " + f);
            int color = this.mPaint.getColor();
            this.mPaint.setColor(this.peZ.color);
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(width, f, this.peZ.radius, this.mPaint);
            this.mPaint.setColor(color);
        }
    }

    public void setTipOn(boolean z) {
        this.peR = z;
        invalidate();
    }
}
