package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class BestStringsFitTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public String[] f20794e;

    /* renamed from: f  reason: collision with root package name */
    public String f20795f;

    /* renamed from: g  reason: collision with root package name */
    public float f20796g;

    /* renamed from: h  reason: collision with root package name */
    public String f20797h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20798i;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.f20795f = " ";
        this.f20796g = 0.0f;
        this.f20797h = "";
        this.f20798i = false;
    }

    public void a() {
        this.f20796g = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < this.f20794e.length; i2++) {
            if (i2 > 0) {
                sb.append(this.f20795f);
            }
            sb.append(this.f20794e[i2]);
            String sb2 = sb.toString();
            if (this.f20796g < getPaint().measureText(sb2)) {
                break;
            }
            this.f20798i = true;
            this.f20797h = sb2;
        }
        setText(this.f20797h);
    }

    public String getSeperator() {
        return this.f20795f;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f20794e == null || this.f20798i) {
            return;
        }
        a();
    }

    public void setSeperator(String str) {
        this.f20795f = str;
    }

    public void setTextArray(String[] strArr) {
        this.f20794e = strArr;
        a();
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20795f = " ";
        this.f20796g = 0.0f;
        this.f20797h = "";
        this.f20798i = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20795f = " ";
        this.f20796g = 0.0f;
        this.f20797h = "";
        this.f20798i = false;
    }
}
