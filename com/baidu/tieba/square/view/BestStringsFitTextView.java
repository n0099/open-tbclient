package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class BestStringsFitTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public String[] f20797e;

    /* renamed from: f  reason: collision with root package name */
    public String f20798f;

    /* renamed from: g  reason: collision with root package name */
    public float f20799g;

    /* renamed from: h  reason: collision with root package name */
    public String f20800h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20801i;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.f20798f = " ";
        this.f20799g = 0.0f;
        this.f20800h = "";
        this.f20801i = false;
    }

    public void a() {
        this.f20799g = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < this.f20797e.length; i2++) {
            if (i2 > 0) {
                sb.append(this.f20798f);
            }
            sb.append(this.f20797e[i2]);
            String sb2 = sb.toString();
            if (this.f20799g < getPaint().measureText(sb2)) {
                break;
            }
            this.f20801i = true;
            this.f20800h = sb2;
        }
        setText(this.f20800h);
    }

    public String getSeperator() {
        return this.f20798f;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f20797e == null || this.f20801i) {
            return;
        }
        a();
    }

    public void setSeperator(String str) {
        this.f20798f = str;
    }

    public void setTextArray(String[] strArr) {
        this.f20797e = strArr;
        a();
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20798f = " ";
        this.f20799g = 0.0f;
        this.f20800h = "";
        this.f20801i = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20798f = " ";
        this.f20799g = 0.0f;
        this.f20800h = "";
        this.f20801i = false;
    }
}
