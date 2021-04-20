package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class MarqueeTextView extends TextView implements Runnable {
    public static final int i = 2000;

    /* renamed from: a  reason: collision with root package name */
    public int f23549a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f23550b;

    /* renamed from: c  reason: collision with root package name */
    public int f23551c;

    /* renamed from: d  reason: collision with root package name */
    public int f23552d;

    /* renamed from: e  reason: collision with root package name */
    public int f23553e;

    /* renamed from: f  reason: collision with root package name */
    public int f23554f;

    /* renamed from: g  reason: collision with root package name */
    public int f23555g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23556h;

    public MarqueeTextView(Context context) {
        super(context);
        this.f23550b = true;
        this.f23553e = 0;
        this.f23554f = 2;
        this.f23555g = 10;
        this.f23556h = false;
    }

    private int getTextWidth() {
        int measureText = (int) getPaint().measureText(getText().toString());
        this.f23551c = measureText;
        return measureText;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f23556h) {
            int width = getWidth();
            this.f23552d = width;
            if (width > getTextWidth()) {
                this.f23550b = true;
                return;
            }
            int scrollX = getScrollX();
            this.f23553e = scrollX;
            this.f23549a = scrollX;
            this.f23556h = false;
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        this.f23550b = true;
        removeCallbacks(this);
        int i5 = this.f23553e;
        this.f23549a = i5;
        scrollTo(i5, 0);
        super.onTextChanged(charSequence, i2, i3, i4);
        this.f23556h = true;
        this.f23550b = false;
        postDelayed(this, 2000L);
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2 = this.f23549a + this.f23554f;
        this.f23549a = i2;
        scrollTo(i2, 0);
        if (this.f23550b) {
            return;
        }
        if (getScrollX() >= this.f23551c - this.f23552d) {
            scrollTo(this.f23553e, 0);
            this.f23549a = this.f23553e;
            postDelayed(this, 2000L);
        } else if (getScrollX() >= (this.f23551c - this.f23552d) - this.f23554f) {
            postDelayed(this, 2000L);
        } else {
            postDelayed(this, this.f23555g);
        }
    }

    public void stop() {
        this.f23550b = true;
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23550b = true;
        this.f23553e = 0;
        this.f23554f = 2;
        this.f23555g = 10;
        this.f23556h = false;
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f23550b = true;
        this.f23553e = 0;
        this.f23554f = 2;
        this.f23555g = 10;
        this.f23556h = false;
    }
}
