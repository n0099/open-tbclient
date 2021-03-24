package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class BestStringsFitTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public String[] f21283e;

    /* renamed from: f  reason: collision with root package name */
    public String f21284f;

    /* renamed from: g  reason: collision with root package name */
    public float f21285g;

    /* renamed from: h  reason: collision with root package name */
    public String f21286h;
    public boolean i;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.f21284f = " ";
        this.f21285g = 0.0f;
        this.f21286h = "";
        this.i = false;
    }

    public void a() {
        this.f21285g = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f21283e.length; i++) {
            if (i > 0) {
                sb.append(this.f21284f);
            }
            sb.append(this.f21283e[i]);
            String sb2 = sb.toString();
            if (this.f21285g < getPaint().measureText(sb2)) {
                break;
            }
            this.i = true;
            this.f21286h = sb2;
        }
        setText(this.f21286h);
    }

    public String getSeperator() {
        return this.f21284f;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f21283e == null || this.i) {
            return;
        }
        a();
    }

    public void setSeperator(String str) {
        this.f21284f = str;
    }

    public void setTextArray(String[] strArr) {
        this.f21283e = strArr;
        a();
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21284f = " ";
        this.f21285g = 0.0f;
        this.f21286h = "";
        this.i = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21284f = " ";
        this.f21285g = 0.0f;
        this.f21286h = "";
        this.i = false;
    }
}
