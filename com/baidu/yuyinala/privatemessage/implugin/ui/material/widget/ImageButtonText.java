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
/* loaded from: classes4.dex */
public class ImageButtonText extends ImageButton {
    Rect mBounds;
    private int mColor;
    Paint mPaint;
    private String mText;
    private boolean osv;
    private a osw;
    private float osx;

    /* loaded from: classes4.dex */
    private class a {
        int Xo;
        float bGL;
        int color;
        int fbW;

        a() {
            float f = ImageButtonText.this.getContext().getResources().getDisplayMetrics().density;
            this.bGL = (float) (2.5d * f);
            this.Xo = (int) (3.0f * f);
            this.fbW = (int) (f * 9.0f);
            this.color = Color.parseColor("#F43531");
            if (ThemeManager.eel() == ThemeManager.ThemeMode.NIGHT) {
                this.color = Color.parseColor("#79251f");
            }
        }
    }

    public ImageButtonText(Context context) {
        super(context);
        this.osv = false;
        this.mText = "";
        this.mColor = 0;
        this.osx = 0.0f;
        this.mPaint = new Paint();
        this.mBounds = new Rect();
        this.osw = new a();
    }

    public ImageButtonText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.osv = false;
        this.mText = "";
        this.mColor = 0;
        this.osx = 0.0f;
        this.mPaint = new Paint();
        this.mBounds = new Rect();
        this.osw = new a();
    }

    public ImageButtonText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.osv = false;
        this.mText = "";
        this.mColor = 0;
        this.osx = 0.0f;
        this.mPaint = new Paint();
        this.mBounds = new Rect();
        this.osw = new a();
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
        this.osx = f;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int intrinsicWidth;
        super.onDraw(canvas);
        if (this.osv) {
            float width = (getWidth() - this.osw.fbW) - this.osw.bGL;
            float f = this.osw.Xo + this.osw.bGL;
            Drawable drawable = getDrawable();
            if (drawable != null && (intrinsicWidth = drawable.getIntrinsicWidth()) > 0) {
                width = (getWidth() / 2) + (intrinsicWidth / 2) + this.osw.bGL;
            }
            int color = this.mPaint.getColor();
            this.mPaint.setColor(this.osw.color);
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(width, f, this.osw.bGL, this.mPaint);
            this.mPaint.setColor(color);
        }
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setColor(this.mColor);
        this.mPaint.setTextSize(this.osx);
        this.mPaint.setTypeface(Typeface.DEFAULT_BOLD);
        this.mPaint.getTextBounds(this.mText, 0, this.mText.length(), this.mBounds);
        canvas.drawText(this.mText, getWidth() / 2.0f, ((this.mBounds.height() / 2.0f) + (getHeight() / 2.0f)) - 2.0f, this.mPaint);
    }

    public void setTipOn(boolean z) {
        this.osv = z;
        invalidate();
    }
}
