package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class BestStringsFitTextView extends TextView {
    private String[] cvP;
    private String iVC;
    private float iVD;
    private String iVE;
    private boolean iVF;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.iVC = " ";
        this.iVD = 0.0f;
        this.iVE = "";
        this.iVF = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iVC = " ";
        this.iVD = 0.0f;
        this.iVE = "";
        this.iVF = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iVC = " ";
        this.iVD = 0.0f;
        this.iVE = "";
        this.iVF = false;
    }

    protected void cls() {
        this.iVD = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.cvP.length; i++) {
            if (i > 0) {
                sb.append(this.iVC);
            }
            sb.append(this.cvP[i]);
            String sb2 = sb.toString();
            if (this.iVD < getPaint().measureText(sb2)) {
                break;
            }
            this.iVF = true;
            this.iVE = sb2;
        }
        setText(this.iVE);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cvP != null && !this.iVF) {
            cls();
        }
    }

    public void setTextArray(String[] strArr) {
        this.cvP = strArr;
        cls();
    }

    public String getSeperator() {
        return this.iVC;
    }

    public void setSeperator(String str) {
        this.iVC = str;
    }
}
