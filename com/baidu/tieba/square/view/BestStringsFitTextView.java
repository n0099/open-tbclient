package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes7.dex */
public class BestStringsFitTextView extends TextView {
    private float bwP;
    private String njv;
    private String njw;
    private boolean njx;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.njv = " ";
        this.bwP = 0.0f;
        this.njw = "";
        this.njx = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.njv = " ";
        this.bwP = 0.0f;
        this.njw = "";
        this.njx = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.njv = " ";
        this.bwP = 0.0f;
        this.njw = "";
        this.njx = false;
    }

    protected void dKd() {
        this.bwP = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.njv);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.bwP < getPaint().measureText(sb2)) {
                break;
            }
            this.njx = true;
            this.njw = sb2;
        }
        setText(this.njw);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.njx) {
            dKd();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        dKd();
    }

    public String getSeperator() {
        return this.njv;
    }

    public void setSeperator(String str) {
        this.njv = str;
    }
}
