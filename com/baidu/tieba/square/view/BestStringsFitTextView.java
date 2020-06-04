package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes10.dex */
public class BestStringsFitTextView extends TextView {
    private String liB;
    private float liC;
    private String liD;
    private boolean liE;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.liB = " ";
        this.liC = 0.0f;
        this.liD = "";
        this.liE = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.liB = " ";
        this.liC = 0.0f;
        this.liD = "";
        this.liE = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.liB = " ";
        this.liC = 0.0f;
        this.liD = "";
        this.liE = false;
    }

    protected void dcF() {
        this.liC = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.liB);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.liC < getPaint().measureText(sb2)) {
                break;
            }
            this.liE = true;
            this.liD = sb2;
        }
        setText(this.liD);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.liE) {
            dcF();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        dcF();
    }

    public String getSeperator() {
        return this.liB;
    }

    public void setSeperator(String str) {
        this.liB = str;
    }
}
