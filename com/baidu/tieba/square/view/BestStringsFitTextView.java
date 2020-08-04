package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes17.dex */
public class BestStringsFitTextView extends TextView {
    private float bdX;
    private String lJO;
    private String lJP;
    private boolean lJQ;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.lJO = " ";
        this.bdX = 0.0f;
        this.lJP = "";
        this.lJQ = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lJO = " ";
        this.bdX = 0.0f;
        this.lJP = "";
        this.lJQ = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lJO = " ";
        this.bdX = 0.0f;
        this.lJP = "";
        this.lJQ = false;
    }

    protected void dke() {
        this.bdX = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.lJO);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.bdX < getPaint().measureText(sb2)) {
                break;
            }
            this.lJQ = true;
            this.lJP = sb2;
        }
        setText(this.lJP);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.lJQ) {
            dke();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        dke();
    }

    public String getSeperator() {
        return this.lJO;
    }

    public void setSeperator(String str) {
        this.lJO = str;
    }
}
