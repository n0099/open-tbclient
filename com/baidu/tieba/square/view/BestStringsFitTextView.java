package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes23.dex */
public class BestStringsFitTextView extends TextView {
    private float bts;
    private String mTA;
    private String mTB;
    private boolean mTC;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.mTA = " ";
        this.bts = 0.0f;
        this.mTB = "";
        this.mTC = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTA = " ";
        this.bts = 0.0f;
        this.mTB = "";
        this.mTC = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTA = " ";
        this.bts = 0.0f;
        this.mTB = "";
        this.mTC = false;
    }

    protected void dIU() {
        this.bts = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.mTA);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.bts < getPaint().measureText(sb2)) {
                break;
            }
            this.mTC = true;
            this.mTB = sb2;
        }
        setText(this.mTB);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.mTC) {
            dIU();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        dIU();
    }

    public String getSeperator() {
        return this.mTA;
    }

    public void setSeperator(String str) {
        this.mTA = str;
    }
}
