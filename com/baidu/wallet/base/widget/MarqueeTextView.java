package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class MarqueeTextView extends TextView implements Runnable {

    /* renamed from: i  reason: collision with root package name */
    public static final int f23563i = 2000;

    /* renamed from: a  reason: collision with root package name */
    public int f23564a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f23565b;

    /* renamed from: c  reason: collision with root package name */
    public int f23566c;

    /* renamed from: d  reason: collision with root package name */
    public int f23567d;

    /* renamed from: e  reason: collision with root package name */
    public int f23568e;

    /* renamed from: f  reason: collision with root package name */
    public int f23569f;

    /* renamed from: g  reason: collision with root package name */
    public int f23570g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23571h;

    public MarqueeTextView(Context context) {
        super(context);
        this.f23565b = true;
        this.f23568e = 0;
        this.f23569f = 2;
        this.f23570g = 10;
        this.f23571h = false;
    }

    private int getTextWidth() {
        int measureText = (int) getPaint().measureText(getText().toString());
        this.f23566c = measureText;
        return measureText;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f23571h) {
            int width = getWidth();
            this.f23567d = width;
            if (width > getTextWidth()) {
                this.f23565b = true;
                return;
            }
            int scrollX = getScrollX();
            this.f23568e = scrollX;
            this.f23564a = scrollX;
            this.f23571h = false;
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        this.f23565b = true;
        removeCallbacks(this);
        int i5 = this.f23568e;
        this.f23564a = i5;
        scrollTo(i5, 0);
        super.onTextChanged(charSequence, i2, i3, i4);
        this.f23571h = true;
        this.f23565b = false;
        postDelayed(this, 2000L);
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2 = this.f23564a + this.f23569f;
        this.f23564a = i2;
        scrollTo(i2, 0);
        if (this.f23565b) {
            return;
        }
        if (getScrollX() >= this.f23566c - this.f23567d) {
            scrollTo(this.f23568e, 0);
            this.f23564a = this.f23568e;
            postDelayed(this, 2000L);
        } else if (getScrollX() >= (this.f23566c - this.f23567d) - this.f23569f) {
            postDelayed(this, 2000L);
        } else {
            postDelayed(this, this.f23570g);
        }
    }

    public void stop() {
        this.f23565b = true;
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23565b = true;
        this.f23568e = 0;
        this.f23569f = 2;
        this.f23570g = 10;
        this.f23571h = false;
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f23565b = true;
        this.f23568e = 0;
        this.f23569f = 2;
        this.f23570g = 10;
        this.f23571h = false;
    }
}
