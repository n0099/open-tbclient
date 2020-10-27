package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes23.dex */
public class BestStringsFitTextView extends TextView {
    private float brX;
    private String mNx;
    private String mNy;
    private boolean mNz;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.mNx = " ";
        this.brX = 0.0f;
        this.mNy = "";
        this.mNz = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mNx = " ";
        this.brX = 0.0f;
        this.mNy = "";
        this.mNz = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mNx = " ";
        this.brX = 0.0f;
        this.mNy = "";
        this.mNz = false;
    }

    protected void dGs() {
        this.brX = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.mNx);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.brX < getPaint().measureText(sb2)) {
                break;
            }
            this.mNz = true;
            this.mNy = sb2;
        }
        setText(this.mNy);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.mNz) {
            dGs();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        dGs();
    }

    public String getSeperator() {
        return this.mNx;
    }

    public void setSeperator(String str) {
        this.mNx = str;
    }
}
