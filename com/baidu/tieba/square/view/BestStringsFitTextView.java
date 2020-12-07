package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes23.dex */
public class BestStringsFitTextView extends TextView {
    private float bwQ;
    private String nit;
    private String niu;
    private boolean niv;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.nit = " ";
        this.bwQ = 0.0f;
        this.niu = "";
        this.niv = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nit = " ";
        this.bwQ = 0.0f;
        this.niu = "";
        this.niv = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nit = " ";
        this.bwQ = 0.0f;
        this.niu = "";
        this.niv = false;
    }

    protected void dOb() {
        this.bwQ = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.nit);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.bwQ < getPaint().measureText(sb2)) {
                break;
            }
            this.niv = true;
            this.niu = sb2;
        }
        setText(this.niu);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.niv) {
            dOb();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        dOb();
    }

    public String getSeperator() {
        return this.nit;
    }

    public void setSeperator(String str) {
        this.nit = str;
    }
}
