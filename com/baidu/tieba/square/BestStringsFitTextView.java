package com.baidu.tieba.square;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes.dex */
public class BestStringsFitTextView extends TextView {
    private String[] VC;
    private String bMi;
    private float bMj;
    private String bMk;
    private boolean bMl;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.bMi = " ";
        this.bMj = 0.0f;
        this.bMk = "";
        this.bMl = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bMi = " ";
        this.bMj = 0.0f;
        this.bMk = "";
        this.bMl = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bMi = " ";
        this.bMj = 0.0f;
        this.bMk = "";
        this.bMl = false;
    }

    protected void adp() {
        this.bMj = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.VC.length; i++) {
            if (i > 0) {
                sb.append(this.bMi);
            }
            sb.append(this.VC[i]);
            String sb2 = sb.toString();
            if (this.bMj < getPaint().measureText(sb2)) {
                break;
            }
            this.bMl = true;
            this.bMk = sb2;
        }
        setText(this.bMk);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.VC != null && !this.bMl) {
            adp();
        }
    }

    public void setTextArray(String[] strArr) {
        this.VC = strArr;
        adp();
    }

    public String getSeperator() {
        return this.bMi;
    }

    public void setSeperator(String str) {
        this.bMi = str;
    }
}
