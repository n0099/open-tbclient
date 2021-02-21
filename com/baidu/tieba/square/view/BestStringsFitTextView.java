package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes8.dex */
public class BestStringsFitTextView extends TextView {
    private float bAs;
    private String ntD;
    private String ntE;
    private boolean ntF;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.ntD = " ";
        this.bAs = 0.0f;
        this.ntE = "";
        this.ntF = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ntD = " ";
        this.bAs = 0.0f;
        this.ntE = "";
        this.ntF = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ntD = " ";
        this.bAs = 0.0f;
        this.ntE = "";
        this.ntF = false;
    }

    protected void dMw() {
        this.bAs = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.ntD);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.bAs < getPaint().measureText(sb2)) {
                break;
            }
            this.ntF = true;
            this.ntE = sb2;
        }
        setText(this.ntE);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.ntF) {
            dMw();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        dMw();
    }

    public String getSeperator() {
        return this.ntD;
    }

    public void setSeperator(String str) {
        this.ntD = str;
    }
}
