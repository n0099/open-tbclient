package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class MarqueeTextView extends TextView implements Runnable {

    /* renamed from: i  reason: collision with root package name */
    public static final int f24286i = 2000;

    /* renamed from: a  reason: collision with root package name */
    public int f24287a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f24288b;

    /* renamed from: c  reason: collision with root package name */
    public int f24289c;

    /* renamed from: d  reason: collision with root package name */
    public int f24290d;

    /* renamed from: e  reason: collision with root package name */
    public int f24291e;

    /* renamed from: f  reason: collision with root package name */
    public int f24292f;

    /* renamed from: g  reason: collision with root package name */
    public int f24293g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24294h;

    public MarqueeTextView(Context context) {
        super(context);
        this.f24288b = true;
        this.f24291e = 0;
        this.f24292f = 2;
        this.f24293g = 10;
        this.f24294h = false;
    }

    private int getTextWidth() {
        int measureText = (int) getPaint().measureText(getText().toString());
        this.f24289c = measureText;
        return measureText;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f24294h) {
            int width = getWidth();
            this.f24290d = width;
            if (width > getTextWidth()) {
                this.f24288b = true;
                return;
            }
            int scrollX = getScrollX();
            this.f24291e = scrollX;
            this.f24287a = scrollX;
            this.f24294h = false;
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        this.f24288b = true;
        removeCallbacks(this);
        int i5 = this.f24291e;
        this.f24287a = i5;
        scrollTo(i5, 0);
        super.onTextChanged(charSequence, i2, i3, i4);
        this.f24294h = true;
        this.f24288b = false;
        postDelayed(this, 2000L);
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2 = this.f24287a + this.f24292f;
        this.f24287a = i2;
        scrollTo(i2, 0);
        if (this.f24288b) {
            return;
        }
        if (getScrollX() >= this.f24289c - this.f24290d) {
            scrollTo(this.f24291e, 0);
            this.f24287a = this.f24291e;
            postDelayed(this, 2000L);
        } else if (getScrollX() >= (this.f24289c - this.f24290d) - this.f24292f) {
            postDelayed(this, 2000L);
        } else {
            postDelayed(this, this.f24293g);
        }
    }

    public void stop() {
        this.f24288b = true;
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24288b = true;
        this.f24291e = 0;
        this.f24292f = 2;
        this.f24293g = 10;
        this.f24294h = false;
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24288b = true;
        this.f24291e = 0;
        this.f24292f = 2;
        this.f24293g = 10;
        this.f24294h = false;
    }
}
