package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class BestStringsFitTextView extends TextView {
    private String[] cvP;
    private String iVA;
    private float iVB;
    private String iVC;
    private boolean iVD;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.iVA = " ";
        this.iVB = 0.0f;
        this.iVC = "";
        this.iVD = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iVA = " ";
        this.iVB = 0.0f;
        this.iVC = "";
        this.iVD = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iVA = " ";
        this.iVB = 0.0f;
        this.iVC = "";
        this.iVD = false;
    }

    protected void clq() {
        this.iVB = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.cvP.length; i++) {
            if (i > 0) {
                sb.append(this.iVA);
            }
            sb.append(this.cvP[i]);
            String sb2 = sb.toString();
            if (this.iVB < getPaint().measureText(sb2)) {
                break;
            }
            this.iVD = true;
            this.iVC = sb2;
        }
        setText(this.iVC);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cvP != null && !this.iVD) {
            clq();
        }
    }

    public void setTextArray(String[] strArr) {
        this.cvP = strArr;
        clq();
    }

    public String getSeperator() {
        return this.iVA;
    }

    public void setSeperator(String str) {
        this.iVA = str;
    }
}
