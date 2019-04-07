package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class BestStringsFitTextView extends TextView {
    private String[] cnH;
    private String iCL;
    private float iCM;
    private String iCN;
    private boolean iCO;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.iCL = " ";
        this.iCM = 0.0f;
        this.iCN = "";
        this.iCO = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iCL = " ";
        this.iCM = 0.0f;
        this.iCN = "";
        this.iCO = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iCL = " ";
        this.iCM = 0.0f;
        this.iCN = "";
        this.iCO = false;
    }

    protected void cdm() {
        this.iCM = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.cnH.length; i++) {
            if (i > 0) {
                sb.append(this.iCL);
            }
            sb.append(this.cnH[i]);
            String sb2 = sb.toString();
            if (this.iCM < getPaint().measureText(sb2)) {
                break;
            }
            this.iCO = true;
            this.iCN = sb2;
        }
        setText(this.iCN);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cnH != null && !this.iCO) {
            cdm();
        }
    }

    public void setTextArray(String[] strArr) {
        this.cnH = strArr;
        cdm();
    }

    public String getSeperator() {
        return this.iCL;
    }

    public void setSeperator(String str) {
        this.iCL = str;
    }
}
