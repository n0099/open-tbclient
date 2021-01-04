package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes8.dex */
public class BestStringsFitTextView extends TextView {
    private float bBB;
    private String noa;
    private String nob;
    private boolean noc;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.noa = " ";
        this.bBB = 0.0f;
        this.nob = "";
        this.noc = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.noa = " ";
        this.bBB = 0.0f;
        this.nob = "";
        this.noc = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.noa = " ";
        this.bBB = 0.0f;
        this.nob = "";
        this.noc = false;
    }

    protected void dNU() {
        this.bBB = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.noa);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.bBB < getPaint().measureText(sb2)) {
                break;
            }
            this.noc = true;
            this.nob = sb2;
        }
        setText(this.nob);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.noc) {
            dNU();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        dNU();
    }

    public String getSeperator() {
        return this.noa;
    }

    public void setSeperator(String str) {
        this.noa = str;
    }
}
