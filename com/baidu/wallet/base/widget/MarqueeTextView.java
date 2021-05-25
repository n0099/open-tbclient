package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class MarqueeTextView extends TextView implements Runnable {

    /* renamed from: i  reason: collision with root package name */
    public static final int f23460i = 2000;

    /* renamed from: a  reason: collision with root package name */
    public int f23461a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f23462b;

    /* renamed from: c  reason: collision with root package name */
    public int f23463c;

    /* renamed from: d  reason: collision with root package name */
    public int f23464d;

    /* renamed from: e  reason: collision with root package name */
    public int f23465e;

    /* renamed from: f  reason: collision with root package name */
    public int f23466f;

    /* renamed from: g  reason: collision with root package name */
    public int f23467g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23468h;

    public MarqueeTextView(Context context) {
        super(context);
        this.f23462b = true;
        this.f23465e = 0;
        this.f23466f = 2;
        this.f23467g = 10;
        this.f23468h = false;
    }

    private int getTextWidth() {
        int measureText = (int) getPaint().measureText(getText().toString());
        this.f23463c = measureText;
        return measureText;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f23468h) {
            int width = getWidth();
            this.f23464d = width;
            if (width > getTextWidth()) {
                this.f23462b = true;
                return;
            }
            int scrollX = getScrollX();
            this.f23465e = scrollX;
            this.f23461a = scrollX;
            this.f23468h = false;
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        this.f23462b = true;
        removeCallbacks(this);
        int i5 = this.f23465e;
        this.f23461a = i5;
        scrollTo(i5, 0);
        super.onTextChanged(charSequence, i2, i3, i4);
        this.f23468h = true;
        this.f23462b = false;
        postDelayed(this, 2000L);
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2 = this.f23461a + this.f23466f;
        this.f23461a = i2;
        scrollTo(i2, 0);
        if (this.f23462b) {
            return;
        }
        if (getScrollX() >= this.f23463c - this.f23464d) {
            scrollTo(this.f23465e, 0);
            this.f23461a = this.f23465e;
            postDelayed(this, 2000L);
        } else if (getScrollX() >= (this.f23463c - this.f23464d) - this.f23466f) {
            postDelayed(this, 2000L);
        } else {
            postDelayed(this, this.f23467g);
        }
    }

    public void stop() {
        this.f23462b = true;
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23462b = true;
        this.f23465e = 0;
        this.f23466f = 2;
        this.f23467g = 10;
        this.f23468h = false;
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f23462b = true;
        this.f23465e = 0;
        this.f23466f = 2;
        this.f23467g = 10;
        this.f23468h = false;
    }
}
