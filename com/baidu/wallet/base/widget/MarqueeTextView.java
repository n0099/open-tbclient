package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class MarqueeTextView extends TextView implements Runnable {

    /* renamed from: i  reason: collision with root package name */
    public static final int f23531i = 2000;

    /* renamed from: a  reason: collision with root package name */
    public int f23532a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f23533b;

    /* renamed from: c  reason: collision with root package name */
    public int f23534c;

    /* renamed from: d  reason: collision with root package name */
    public int f23535d;

    /* renamed from: e  reason: collision with root package name */
    public int f23536e;

    /* renamed from: f  reason: collision with root package name */
    public int f23537f;

    /* renamed from: g  reason: collision with root package name */
    public int f23538g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23539h;

    public MarqueeTextView(Context context) {
        super(context);
        this.f23533b = true;
        this.f23536e = 0;
        this.f23537f = 2;
        this.f23538g = 10;
        this.f23539h = false;
    }

    private int getTextWidth() {
        int measureText = (int) getPaint().measureText(getText().toString());
        this.f23534c = measureText;
        return measureText;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f23539h) {
            int width = getWidth();
            this.f23535d = width;
            if (width > getTextWidth()) {
                this.f23533b = true;
                return;
            }
            int scrollX = getScrollX();
            this.f23536e = scrollX;
            this.f23532a = scrollX;
            this.f23539h = false;
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        this.f23533b = true;
        removeCallbacks(this);
        int i5 = this.f23536e;
        this.f23532a = i5;
        scrollTo(i5, 0);
        super.onTextChanged(charSequence, i2, i3, i4);
        this.f23539h = true;
        this.f23533b = false;
        postDelayed(this, 2000L);
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2 = this.f23532a + this.f23537f;
        this.f23532a = i2;
        scrollTo(i2, 0);
        if (this.f23533b) {
            return;
        }
        if (getScrollX() >= this.f23534c - this.f23535d) {
            scrollTo(this.f23536e, 0);
            this.f23532a = this.f23536e;
            postDelayed(this, 2000L);
        } else if (getScrollX() >= (this.f23534c - this.f23535d) - this.f23537f) {
            postDelayed(this, 2000L);
        } else {
            postDelayed(this, this.f23538g);
        }
    }

    public void stop() {
        this.f23533b = true;
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23533b = true;
        this.f23536e = 0;
        this.f23537f = 2;
        this.f23538g = 10;
        this.f23539h = false;
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f23533b = true;
        this.f23536e = 0;
        this.f23537f = 2;
        this.f23538g = 10;
        this.f23539h = false;
    }
}
