package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class MarqueeTextView extends TextView implements Runnable {
    public static final int i = 2000;

    /* renamed from: a  reason: collision with root package name */
    public int f23863a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f23864b;

    /* renamed from: c  reason: collision with root package name */
    public int f23865c;

    /* renamed from: d  reason: collision with root package name */
    public int f23866d;

    /* renamed from: e  reason: collision with root package name */
    public int f23867e;

    /* renamed from: f  reason: collision with root package name */
    public int f23868f;

    /* renamed from: g  reason: collision with root package name */
    public int f23869g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23870h;

    public MarqueeTextView(Context context) {
        super(context);
        this.f23864b = true;
        this.f23867e = 0;
        this.f23868f = 2;
        this.f23869g = 10;
        this.f23870h = false;
    }

    private int getTextWidth() {
        int measureText = (int) getPaint().measureText(getText().toString());
        this.f23865c = measureText;
        return measureText;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f23870h) {
            int width = getWidth();
            this.f23866d = width;
            if (width > getTextWidth()) {
                this.f23864b = true;
                return;
            }
            int scrollX = getScrollX();
            this.f23867e = scrollX;
            this.f23863a = scrollX;
            this.f23870h = false;
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        this.f23864b = true;
        removeCallbacks(this);
        int i5 = this.f23867e;
        this.f23863a = i5;
        scrollTo(i5, 0);
        super.onTextChanged(charSequence, i2, i3, i4);
        this.f23870h = true;
        this.f23864b = false;
        postDelayed(this, 2000L);
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2 = this.f23863a + this.f23868f;
        this.f23863a = i2;
        scrollTo(i2, 0);
        if (this.f23864b) {
            return;
        }
        if (getScrollX() >= this.f23865c - this.f23866d) {
            scrollTo(this.f23867e, 0);
            this.f23863a = this.f23867e;
            postDelayed(this, 2000L);
        } else if (getScrollX() >= (this.f23865c - this.f23866d) - this.f23868f) {
            postDelayed(this, 2000L);
        } else {
            postDelayed(this, this.f23869g);
        }
    }

    public void stop() {
        this.f23864b = true;
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23864b = true;
        this.f23867e = 0;
        this.f23868f = 2;
        this.f23869g = 10;
        this.f23870h = false;
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f23864b = true;
        this.f23867e = 0;
        this.f23868f = 2;
        this.f23869g = 10;
        this.f23870h = false;
    }
}
