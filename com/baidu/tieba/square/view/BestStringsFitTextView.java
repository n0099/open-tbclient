package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes4.dex */
public class BestStringsFitTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public String[] f20969e;

    /* renamed from: f  reason: collision with root package name */
    public String f20970f;

    /* renamed from: g  reason: collision with root package name */
    public float f20971g;

    /* renamed from: h  reason: collision with root package name */
    public String f20972h;
    public boolean i;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.f20970f = " ";
        this.f20971g = 0.0f;
        this.f20972h = "";
        this.i = false;
    }

    public void a() {
        this.f20971g = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f20969e.length; i++) {
            if (i > 0) {
                sb.append(this.f20970f);
            }
            sb.append(this.f20969e[i]);
            String sb2 = sb.toString();
            if (this.f20971g < getPaint().measureText(sb2)) {
                break;
            }
            this.i = true;
            this.f20972h = sb2;
        }
        setText(this.f20972h);
    }

    public String getSeperator() {
        return this.f20970f;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f20969e == null || this.i) {
            return;
        }
        a();
    }

    public void setSeperator(String str) {
        this.f20970f = str;
    }

    public void setTextArray(String[] strArr) {
        this.f20969e = strArr;
        a();
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20970f = " ";
        this.f20971g = 0.0f;
        this.f20972h = "";
        this.i = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20970f = " ";
        this.f20971g = 0.0f;
        this.f20972h = "";
        this.i = false;
    }
}
