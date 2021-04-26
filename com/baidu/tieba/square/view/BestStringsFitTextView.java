package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class BestStringsFitTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public String[] f21553e;

    /* renamed from: f  reason: collision with root package name */
    public String f21554f;

    /* renamed from: g  reason: collision with root package name */
    public float f21555g;

    /* renamed from: h  reason: collision with root package name */
    public String f21556h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21557i;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.f21554f = " ";
        this.f21555g = 0.0f;
        this.f21556h = "";
        this.f21557i = false;
    }

    public void a() {
        this.f21555g = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < this.f21553e.length; i2++) {
            if (i2 > 0) {
                sb.append(this.f21554f);
            }
            sb.append(this.f21553e[i2]);
            String sb2 = sb.toString();
            if (this.f21555g < getPaint().measureText(sb2)) {
                break;
            }
            this.f21557i = true;
            this.f21556h = sb2;
        }
        setText(this.f21556h);
    }

    public String getSeperator() {
        return this.f21554f;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f21553e == null || this.f21557i) {
            return;
        }
        a();
    }

    public void setSeperator(String str) {
        this.f21554f = str;
    }

    public void setTextArray(String[] strArr) {
        this.f21553e = strArr;
        a();
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21554f = " ";
        this.f21555g = 0.0f;
        this.f21556h = "";
        this.f21557i = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21554f = " ";
        this.f21555g = 0.0f;
        this.f21556h = "";
        this.f21557i = false;
    }
}
