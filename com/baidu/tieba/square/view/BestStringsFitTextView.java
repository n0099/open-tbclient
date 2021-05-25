package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class BestStringsFitTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public String[] f20717e;

    /* renamed from: f  reason: collision with root package name */
    public String f20718f;

    /* renamed from: g  reason: collision with root package name */
    public float f20719g;

    /* renamed from: h  reason: collision with root package name */
    public String f20720h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20721i;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.f20718f = " ";
        this.f20719g = 0.0f;
        this.f20720h = "";
        this.f20721i = false;
    }

    public void a() {
        this.f20719g = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < this.f20717e.length; i2++) {
            if (i2 > 0) {
                sb.append(this.f20718f);
            }
            sb.append(this.f20717e[i2]);
            String sb2 = sb.toString();
            if (this.f20719g < getPaint().measureText(sb2)) {
                break;
            }
            this.f20721i = true;
            this.f20720h = sb2;
        }
        setText(this.f20720h);
    }

    public String getSeperator() {
        return this.f20718f;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f20717e == null || this.f20721i) {
            return;
        }
        a();
    }

    public void setSeperator(String str) {
        this.f20718f = str;
    }

    public void setTextArray(String[] strArr) {
        this.f20717e = strArr;
        a();
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20718f = " ";
        this.f20719g = 0.0f;
        this.f20720h = "";
        this.f20721i = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20718f = " ";
        this.f20719g = 0.0f;
        this.f20720h = "";
        this.f20721i = false;
    }
}
