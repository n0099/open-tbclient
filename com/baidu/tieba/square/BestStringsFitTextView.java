package com.baidu.tieba.square;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes.dex */
public class BestStringsFitTextView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private String[] f1718a;
    private String b;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.b = " ";
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = " ";
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = " ";
    }

    protected void a() {
        String str;
        float width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        String str2 = "";
        int i = 0;
        while (true) {
            if (i >= this.f1718a.length) {
                str = str2;
                break;
            }
            StringBuilder sb = new StringBuilder(32);
            sb.append(str2);
            if (i > 0) {
                sb.append(this.b);
            }
            sb.append(this.f1718a[i]);
            str = sb.toString();
            float measureText = getPaint().measureText(str);
            if (width < measureText) {
                if (width == measureText) {
                    break;
                }
                str = str2;
            }
            i++;
            str2 = str;
        }
        this.f1718a = null;
        setText(str);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f1718a == null) {
            super.onDraw(canvas);
        } else {
            a();
        }
    }

    public void setTextArray(String[] strArr) {
        this.f1718a = strArr;
    }

    public String getSeperator() {
        return this.b;
    }

    public void setSeperator(String str) {
        this.b = str;
    }
}
