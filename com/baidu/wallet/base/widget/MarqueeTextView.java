package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class MarqueeTextView extends TextView implements Runnable {

    /* renamed from: i  reason: collision with root package name */
    public static final int f23645i = 2000;

    /* renamed from: a  reason: collision with root package name */
    public int f23646a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f23647b;

    /* renamed from: c  reason: collision with root package name */
    public int f23648c;

    /* renamed from: d  reason: collision with root package name */
    public int f23649d;

    /* renamed from: e  reason: collision with root package name */
    public int f23650e;

    /* renamed from: f  reason: collision with root package name */
    public int f23651f;

    /* renamed from: g  reason: collision with root package name */
    public int f23652g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23653h;

    public MarqueeTextView(Context context) {
        super(context);
        this.f23647b = true;
        this.f23650e = 0;
        this.f23651f = 2;
        this.f23652g = 10;
        this.f23653h = false;
    }

    private int getTextWidth() {
        int measureText = (int) getPaint().measureText(getText().toString());
        this.f23648c = measureText;
        return measureText;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f23653h) {
            int width = getWidth();
            this.f23649d = width;
            if (width > getTextWidth()) {
                this.f23647b = true;
                return;
            }
            int scrollX = getScrollX();
            this.f23650e = scrollX;
            this.f23646a = scrollX;
            this.f23653h = false;
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        this.f23647b = true;
        removeCallbacks(this);
        int i5 = this.f23650e;
        this.f23646a = i5;
        scrollTo(i5, 0);
        super.onTextChanged(charSequence, i2, i3, i4);
        this.f23653h = true;
        this.f23647b = false;
        postDelayed(this, 2000L);
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2 = this.f23646a + this.f23651f;
        this.f23646a = i2;
        scrollTo(i2, 0);
        if (this.f23647b) {
            return;
        }
        if (getScrollX() >= this.f23648c - this.f23649d) {
            scrollTo(this.f23650e, 0);
            this.f23646a = this.f23650e;
            postDelayed(this, 2000L);
        } else if (getScrollX() >= (this.f23648c - this.f23649d) - this.f23651f) {
            postDelayed(this, 2000L);
        } else {
            postDelayed(this, this.f23652g);
        }
    }

    public void stop() {
        this.f23647b = true;
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23647b = true;
        this.f23650e = 0;
        this.f23651f = 2;
        this.f23652g = 10;
        this.f23653h = false;
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f23647b = true;
        this.f23650e = 0;
        this.f23651f = 2;
        this.f23652g = 10;
        this.f23653h = false;
    }
}
