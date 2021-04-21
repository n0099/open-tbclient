package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class MarqueeTextView extends TextView implements Runnable {
    public static final int i = 2000;

    /* renamed from: a  reason: collision with root package name */
    public int f23557a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f23558b;

    /* renamed from: c  reason: collision with root package name */
    public int f23559c;

    /* renamed from: d  reason: collision with root package name */
    public int f23560d;

    /* renamed from: e  reason: collision with root package name */
    public int f23561e;

    /* renamed from: f  reason: collision with root package name */
    public int f23562f;

    /* renamed from: g  reason: collision with root package name */
    public int f23563g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23564h;

    public MarqueeTextView(Context context) {
        super(context);
        this.f23558b = true;
        this.f23561e = 0;
        this.f23562f = 2;
        this.f23563g = 10;
        this.f23564h = false;
    }

    private int getTextWidth() {
        int measureText = (int) getPaint().measureText(getText().toString());
        this.f23559c = measureText;
        return measureText;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f23564h) {
            int width = getWidth();
            this.f23560d = width;
            if (width > getTextWidth()) {
                this.f23558b = true;
                return;
            }
            int scrollX = getScrollX();
            this.f23561e = scrollX;
            this.f23557a = scrollX;
            this.f23564h = false;
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        this.f23558b = true;
        removeCallbacks(this);
        int i5 = this.f23561e;
        this.f23557a = i5;
        scrollTo(i5, 0);
        super.onTextChanged(charSequence, i2, i3, i4);
        this.f23564h = true;
        this.f23558b = false;
        postDelayed(this, 2000L);
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2 = this.f23557a + this.f23562f;
        this.f23557a = i2;
        scrollTo(i2, 0);
        if (this.f23558b) {
            return;
        }
        if (getScrollX() >= this.f23559c - this.f23560d) {
            scrollTo(this.f23561e, 0);
            this.f23557a = this.f23561e;
            postDelayed(this, 2000L);
        } else if (getScrollX() >= (this.f23559c - this.f23560d) - this.f23562f) {
            postDelayed(this, 2000L);
        } else {
            postDelayed(this, this.f23563g);
        }
    }

    public void stop() {
        this.f23558b = true;
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23558b = true;
        this.f23561e = 0;
        this.f23562f = 2;
        this.f23563g = 10;
        this.f23564h = false;
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f23558b = true;
        this.f23561e = 0;
        this.f23562f = 2;
        this.f23563g = 10;
        this.f23564h = false;
    }
}
