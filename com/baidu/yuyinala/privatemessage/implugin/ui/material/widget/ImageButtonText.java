package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.baidu.yuyinala.privatemessage.implugin.ui.theme.ThemeManager;
/* loaded from: classes11.dex */
public class ImageButtonText extends ImageButton {
    Rect mBounds;
    private int mColor;
    Paint mPaint;
    private String mText;
    private boolean peR;
    private a peS;
    private float peT;

    /* loaded from: classes11.dex */
    private class a {
        int Yh;
        int color;
        int fvN;
        float radius;

        a() {
            float f = ImageButtonText.this.getContext().getResources().getDisplayMetrics().density;
            this.radius = (float) (2.5d * f);
            this.Yh = (int) (3.0f * f);
            this.fvN = (int) (f * 9.0f);
            this.color = Color.parseColor("#F43531");
            if (ThemeManager.emw() == ThemeManager.ThemeMode.NIGHT) {
                this.color = Color.parseColor("#79251f");
            }
        }
    }

    public ImageButtonText(Context context) {
        super(context);
        this.peR = false;
        this.mText = "";
        this.mColor = 0;
        this.peT = 0.0f;
        this.mPaint = new Paint();
        this.mBounds = new Rect();
        this.peS = new a();
    }

    public ImageButtonText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.peR = false;
        this.mText = "";
        this.mColor = 0;
        this.peT = 0.0f;
        this.mPaint = new Paint();
        this.mBounds = new Rect();
        this.peS = new a();
    }

    public ImageButtonText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.peR = false;
        this.mText = "";
        this.mColor = 0;
        this.peT = 0.0f;
        this.mPaint = new Paint();
        this.mBounds = new Rect();
        this.peS = new a();
    }

    public void setText(String str) {
        this.mText = str;
        invalidate();
    }

    public String getText() {
        return this.mText;
    }

    public void setColor(int i) {
        this.mColor = i;
    }

    public void setTextSize(float f) {
        this.peT = f;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int intrinsicWidth;
        super.onDraw(canvas);
        if (this.peR) {
            float width = (getWidth() - this.peS.fvN) - this.peS.radius;
            float f = this.peS.Yh + this.peS.radius;
            Drawable drawable = getDrawable();
            if (drawable != null && (intrinsicWidth = drawable.getIntrinsicWidth()) > 0) {
                width = (getWidth() / 2) + (intrinsicWidth / 2) + this.peS.radius;
            }
            int color = this.mPaint.getColor();
            this.mPaint.setColor(this.peS.color);
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(width, f, this.peS.radius, this.mPaint);
            this.mPaint.setColor(color);
        }
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setColor(this.mColor);
        this.mPaint.setTextSize(this.peT);
        this.mPaint.setTypeface(Typeface.DEFAULT_BOLD);
        this.mPaint.getTextBounds(this.mText, 0, this.mText.length(), this.mBounds);
        canvas.drawText(this.mText, getWidth() / 2.0f, ((this.mBounds.height() / 2.0f) + (getHeight() / 2.0f)) - 2.0f, this.mPaint);
    }

    public void setTipOn(boolean z) {
        this.peR = z;
        invalidate();
    }
}
