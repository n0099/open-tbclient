package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes17.dex */
public class BestStringsFitTextView extends TextView {
    private float bdX;
    private String lJM;
    private String lJN;
    private boolean lJO;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.lJM = " ";
        this.bdX = 0.0f;
        this.lJN = "";
        this.lJO = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lJM = " ";
        this.bdX = 0.0f;
        this.lJN = "";
        this.lJO = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lJM = " ";
        this.bdX = 0.0f;
        this.lJN = "";
        this.lJO = false;
    }

    protected void dke() {
        this.bdX = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.lJM);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.bdX < getPaint().measureText(sb2)) {
                break;
            }
            this.lJO = true;
            this.lJN = sb2;
        }
        setText(this.lJN);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.lJO) {
            dke();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        dke();
    }

    public String getSeperator() {
        return this.lJM;
    }

    public void setSeperator(String str) {
        this.lJM = str;
    }
}
