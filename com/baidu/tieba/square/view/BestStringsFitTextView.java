package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes17.dex */
public class BestStringsFitTextView extends TextView {
    private float bjC;
    private String mbM;
    private String mbN;
    private boolean mbO;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.mbM = " ";
        this.bjC = 0.0f;
        this.mbN = "";
        this.mbO = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mbM = " ";
        this.bjC = 0.0f;
        this.mbN = "";
        this.mbO = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mbM = " ";
        this.bjC = 0.0f;
        this.mbN = "";
        this.mbO = false;
    }

    protected void dvG() {
        this.bjC = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.mbM);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.bjC < getPaint().measureText(sb2)) {
                break;
            }
            this.mbO = true;
            this.mbN = sb2;
        }
        setText(this.mbN);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.mbO) {
            dvG();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        dvG();
    }

    public String getSeperator() {
        return this.mbM;
    }

    public void setSeperator(String str) {
        this.mbM = str;
    }
}
