package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes10.dex */
public class BestStringsFitTextView extends TextView {
    private float bdF;
    private String lCx;
    private String lCy;
    private boolean lCz;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.lCx = " ";
        this.bdF = 0.0f;
        this.lCy = "";
        this.lCz = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lCx = " ";
        this.bdF = 0.0f;
        this.lCy = "";
        this.lCz = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lCx = " ";
        this.bdF = 0.0f;
        this.lCy = "";
        this.lCz = false;
    }

    protected void dgV() {
        this.bdF = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.lCx);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.bdF < getPaint().measureText(sb2)) {
                break;
            }
            this.lCz = true;
            this.lCy = sb2;
        }
        setText(this.lCy);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.lCz) {
            dgV();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        dgV();
    }

    public String getSeperator() {
        return this.lCx;
    }

    public void setSeperator(String str) {
        this.lCx = str;
    }
}
