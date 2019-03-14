package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class BestStringsFitTextView extends TextView {
    private String[] cnF;
    private String iDb;
    private float iDc;
    private String iDd;
    private boolean iDe;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.iDb = " ";
        this.iDc = 0.0f;
        this.iDd = "";
        this.iDe = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iDb = " ";
        this.iDc = 0.0f;
        this.iDd = "";
        this.iDe = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iDb = " ";
        this.iDc = 0.0f;
        this.iDd = "";
        this.iDe = false;
    }

    protected void cdq() {
        this.iDc = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.cnF.length; i++) {
            if (i > 0) {
                sb.append(this.iDb);
            }
            sb.append(this.cnF[i]);
            String sb2 = sb.toString();
            if (this.iDc < getPaint().measureText(sb2)) {
                break;
            }
            this.iDe = true;
            this.iDd = sb2;
        }
        setText(this.iDd);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cnF != null && !this.iDe) {
            cdq();
        }
    }

    public void setTextArray(String[] strArr) {
        this.cnF = strArr;
        cdq();
    }

    public String getSeperator() {
        return this.iDb;
    }

    public void setSeperator(String str) {
        this.iDb = str;
    }
}
