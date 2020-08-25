package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes17.dex */
public class BestStringsFitTextView extends TextView {
    private float bjz;
    private String mbx;
    private String mby;
    private boolean mbz;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.mbx = " ";
        this.bjz = 0.0f;
        this.mby = "";
        this.mbz = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mbx = " ";
        this.bjz = 0.0f;
        this.mby = "";
        this.mbz = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mbx = " ";
        this.bjz = 0.0f;
        this.mby = "";
        this.mbz = false;
    }

    protected void dvB() {
        this.bjz = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.mbx);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.bjz < getPaint().measureText(sb2)) {
                break;
            }
            this.mbz = true;
            this.mby = sb2;
        }
        setText(this.mby);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.mbz) {
            dvB();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        dvB();
    }

    public String getSeperator() {
        return this.mbx;
    }

    public void setSeperator(String str) {
        this.mbx = str;
    }
}
