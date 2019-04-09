package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class BestStringsFitTextView extends TextView {
    private String[] cnI;
    private String iCM;
    private float iCN;
    private String iCO;
    private boolean iCP;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.iCM = " ";
        this.iCN = 0.0f;
        this.iCO = "";
        this.iCP = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iCM = " ";
        this.iCN = 0.0f;
        this.iCO = "";
        this.iCP = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iCM = " ";
        this.iCN = 0.0f;
        this.iCO = "";
        this.iCP = false;
    }

    protected void cdm() {
        this.iCN = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.cnI.length; i++) {
            if (i > 0) {
                sb.append(this.iCM);
            }
            sb.append(this.cnI[i]);
            String sb2 = sb.toString();
            if (this.iCN < getPaint().measureText(sb2)) {
                break;
            }
            this.iCP = true;
            this.iCO = sb2;
        }
        setText(this.iCO);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cnI != null && !this.iCP) {
            cdm();
        }
    }

    public void setTextArray(String[] strArr) {
        this.cnI = strArr;
        cdm();
    }

    public String getSeperator() {
        return this.iCM;
    }

    public void setSeperator(String str) {
        this.iCM = str;
    }
}
