package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class MarqueeTextView extends TextView implements Runnable {
    public static final int i = 2000;

    /* renamed from: a  reason: collision with root package name */
    public int f23864a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f23865b;

    /* renamed from: c  reason: collision with root package name */
    public int f23866c;

    /* renamed from: d  reason: collision with root package name */
    public int f23867d;

    /* renamed from: e  reason: collision with root package name */
    public int f23868e;

    /* renamed from: f  reason: collision with root package name */
    public int f23869f;

    /* renamed from: g  reason: collision with root package name */
    public int f23870g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23871h;

    public MarqueeTextView(Context context) {
        super(context);
        this.f23865b = true;
        this.f23868e = 0;
        this.f23869f = 2;
        this.f23870g = 10;
        this.f23871h = false;
    }

    private int getTextWidth() {
        int measureText = (int) getPaint().measureText(getText().toString());
        this.f23866c = measureText;
        return measureText;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f23871h) {
            int width = getWidth();
            this.f23867d = width;
            if (width > getTextWidth()) {
                this.f23865b = true;
                return;
            }
            int scrollX = getScrollX();
            this.f23868e = scrollX;
            this.f23864a = scrollX;
            this.f23871h = false;
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        this.f23865b = true;
        removeCallbacks(this);
        int i5 = this.f23868e;
        this.f23864a = i5;
        scrollTo(i5, 0);
        super.onTextChanged(charSequence, i2, i3, i4);
        this.f23871h = true;
        this.f23865b = false;
        postDelayed(this, 2000L);
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2 = this.f23864a + this.f23869f;
        this.f23864a = i2;
        scrollTo(i2, 0);
        if (this.f23865b) {
            return;
        }
        if (getScrollX() >= this.f23866c - this.f23867d) {
            scrollTo(this.f23868e, 0);
            this.f23864a = this.f23868e;
            postDelayed(this, 2000L);
        } else if (getScrollX() >= (this.f23866c - this.f23867d) - this.f23869f) {
            postDelayed(this, 2000L);
        } else {
            postDelayed(this, this.f23870g);
        }
    }

    public void stop() {
        this.f23865b = true;
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23865b = true;
        this.f23868e = 0;
        this.f23869f = 2;
        this.f23870g = 10;
        this.f23871h = false;
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f23865b = true;
        this.f23868e = 0;
        this.f23869f = 2;
        this.f23870g = 10;
        this.f23871h = false;
    }
}
