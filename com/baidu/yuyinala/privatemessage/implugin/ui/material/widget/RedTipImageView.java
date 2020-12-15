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
    private boolean oSA;
    private a oSI;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {
        int Yp;
        int color;
        int fov;
        float radius;

        a() {
            RedTipImageView.this.mDensity = RedTipImageView.this.getContext().getResources().getDisplayMetrics().density;
            this.radius = (float) (3.5d * RedTipImageView.this.mDensity);
            this.Yp = (int) (RedTipImageView.this.mDensity * 3.0f);
            this.fov = (int) (RedTipImageView.this.mDensity * 3.0f);
            this.color = Color.parseColor("#F43531");
            if (ThemeManager.enO() == ThemeManager.ThemeMode.NIGHT) {
                this.color = Color.parseColor("#79251f");
            }
        }
    }

    public RedTipImageView(Context context) {
        super(context);
        this.oSA = false;
        init();
    }

    public RedTipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oSA = false;
        init();
    }

    public RedTipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oSA = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.oSI = new a();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.oSA) {
            float width = ((getWidth() - this.oSI.fov) + (this.mDensity * 3.0f)) - this.oSI.radius;
            float f = (this.oSI.Yp + this.oSI.radius) - (this.mDensity * 3.0f);
            Log.d("RedTipImageView", "cx = " + width + " cy= " + f);
            int color = this.mPaint.getColor();
            this.mPaint.setColor(this.oSI.color);
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(width, f, this.oSI.radius, this.mPaint);
            this.mPaint.setColor(color);
        }
    }

    public void setTipOn(boolean z) {
        this.oSA = z;
        invalidate();
    }
}
