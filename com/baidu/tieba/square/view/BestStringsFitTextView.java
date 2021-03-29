package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class BestStringsFitTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public String[] f21284e;

    /* renamed from: f  reason: collision with root package name */
    public String f21285f;

    /* renamed from: g  reason: collision with root package name */
    public float f21286g;

    /* renamed from: h  reason: collision with root package name */
    public String f21287h;
    public boolean i;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.f21285f = " ";
        this.f21286g = 0.0f;
        this.f21287h = "";
        this.i = false;
    }

    public void a() {
        this.f21286g = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f21284e.length; i++) {
            if (i > 0) {
                sb.append(this.f21285f);
            }
            sb.append(this.f21284e[i]);
            String sb2 = sb.toString();
            if (this.f21286g < getPaint().measureText(sb2)) {
                break;
            }
            this.i = true;
            this.f21287h = sb2;
        }
        setText(this.f21287h);
    }

    public String getSeperator() {
        return this.f21285f;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f21284e == null || this.i) {
            return;
        }
        a();
    }

    public void setSeperator(String str) {
        this.f21285f = str;
    }

    public void setTextArray(String[] strArr) {
        this.f21284e = strArr;
        a();
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21285f = " ";
        this.f21286g = 0.0f;
        this.f21287h = "";
        this.i = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21285f = " ";
        this.f21286g = 0.0f;
        this.f21287h = "";
        this.i = false;
    }
}
