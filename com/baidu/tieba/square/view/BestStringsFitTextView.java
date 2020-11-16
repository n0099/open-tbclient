package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes22.dex */
public class BestStringsFitTextView extends TextView {
    private float brG;
    private String mUu;
    private String mUv;
    private boolean mUw;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.mUu = " ";
        this.brG = 0.0f;
        this.mUv = "";
        this.mUw = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mUu = " ";
        this.brG = 0.0f;
        this.mUv = "";
        this.mUw = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mUu = " ";
        this.brG = 0.0f;
        this.mUv = "";
        this.mUw = false;
    }

    protected void dIL() {
        this.brG = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.mUu);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.brG < getPaint().measureText(sb2)) {
                break;
            }
            this.mUw = true;
            this.mUv = sb2;
        }
        setText(this.mUv);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.mUw) {
            dIL();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        dIL();
    }

    public String getSeperator() {
        return this.mUu;
    }

    public void setSeperator(String str) {
        this.mUu = str;
    }
}
