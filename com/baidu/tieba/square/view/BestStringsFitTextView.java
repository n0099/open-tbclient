package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes4.dex */
public class BestStringsFitTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public String[] f20977e;

    /* renamed from: f  reason: collision with root package name */
    public String f20978f;

    /* renamed from: g  reason: collision with root package name */
    public float f20979g;

    /* renamed from: h  reason: collision with root package name */
    public String f20980h;
    public boolean i;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.f20978f = " ";
        this.f20979g = 0.0f;
        this.f20980h = "";
        this.i = false;
    }

    public void a() {
        this.f20979g = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f20977e.length; i++) {
            if (i > 0) {
                sb.append(this.f20978f);
            }
            sb.append(this.f20977e[i]);
            String sb2 = sb.toString();
            if (this.f20979g < getPaint().measureText(sb2)) {
                break;
            }
            this.i = true;
            this.f20980h = sb2;
        }
        setText(this.f20980h);
    }

    public String getSeperator() {
        return this.f20978f;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f20977e == null || this.i) {
            return;
        }
        a();
    }

    public void setSeperator(String str) {
        this.f20978f = str;
    }

    public void setTextArray(String[] strArr) {
        this.f20977e = strArr;
        a();
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20978f = " ";
        this.f20979g = 0.0f;
        this.f20980h = "";
        this.i = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20978f = " ";
        this.f20979g = 0.0f;
        this.f20980h = "";
        this.i = false;
    }
}
