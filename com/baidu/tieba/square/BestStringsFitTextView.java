package com.baidu.tieba.square;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes.dex */
public class BestStringsFitTextView extends TextView {
    private String[] a;
    private String b;
    private float c;
    private String d;
    private boolean e;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.b = " ";
        this.c = 0.0f;
        this.d = "";
        this.e = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = " ";
        this.c = 0.0f;
        this.d = "";
        this.e = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = " ";
        this.c = 0.0f;
        this.d = "";
        this.e = false;
    }

    protected void a() {
        this.c = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.a.length; i++) {
            if (i > 0) {
                sb.append(this.b);
            }
            sb.append(this.a[i]);
            String sb2 = sb.toString();
            com.baidu.adp.lib.g.e.c(sb2);
            if (this.c < getPaint().measureText(sb2)) {
                break;
            }
            this.e = true;
            this.d = sb2;
        }
        setText(this.d);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.a != null && !this.e) {
            a();
        }
    }

    public void setTextArray(String[] strArr) {
        this.a = strArr;
        a();
    }

    public String getSeperator() {
        return this.b;
    }

    public void setSeperator(String str) {
        this.b = str;
    }
}
