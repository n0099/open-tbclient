package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class BestStringsFitTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public String[] f20876e;

    /* renamed from: f  reason: collision with root package name */
    public String f20877f;

    /* renamed from: g  reason: collision with root package name */
    public float f20878g;

    /* renamed from: h  reason: collision with root package name */
    public String f20879h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20880i;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.f20877f = " ";
        this.f20878g = 0.0f;
        this.f20879h = "";
        this.f20880i = false;
    }

    public void a() {
        this.f20878g = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < this.f20876e.length; i2++) {
            if (i2 > 0) {
                sb.append(this.f20877f);
            }
            sb.append(this.f20876e[i2]);
            String sb2 = sb.toString();
            if (this.f20878g < getPaint().measureText(sb2)) {
                break;
            }
            this.f20880i = true;
            this.f20879h = sb2;
        }
        setText(this.f20879h);
    }

    public String getSeperator() {
        return this.f20877f;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f20876e == null || this.f20880i) {
            return;
        }
        a();
    }

    public void setSeperator(String str) {
        this.f20877f = str;
    }

    public void setTextArray(String[] strArr) {
        this.f20876e = strArr;
        a();
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20877f = " ";
        this.f20878g = 0.0f;
        this.f20879h = "";
        this.f20880i = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20877f = " ";
        this.f20878g = 0.0f;
        this.f20879h = "";
        this.f20880i = false;
    }
}
