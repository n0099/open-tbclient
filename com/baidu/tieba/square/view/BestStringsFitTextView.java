package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes22.dex */
public class BestStringsFitTextView extends TextView {
    private float bmv;
    private String mlm;
    private String mln;
    private boolean mlo;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.mlm = " ";
        this.bmv = 0.0f;
        this.mln = "";
        this.mlo = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mlm = " ";
        this.bmv = 0.0f;
        this.mln = "";
        this.mlo = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mlm = " ";
        this.bmv = 0.0f;
        this.mln = "";
        this.mlo = false;
    }

    protected void dzz() {
        this.bmv = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.mlm);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.bmv < getPaint().measureText(sb2)) {
                break;
            }
            this.mlo = true;
            this.mln = sb2;
        }
        setText(this.mln);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.mlo) {
            dzz();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        dzz();
    }

    public String getSeperator() {
        return this.mlm;
    }

    public void setSeperator(String str) {
        this.mlm = str;
    }
}
