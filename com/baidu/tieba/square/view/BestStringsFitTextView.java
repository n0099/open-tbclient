package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes23.dex */
public class BestStringsFitTextView extends TextView {
    private float bwQ;
    private String niv;
    private String niw;
    private boolean nix;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.niv = " ";
        this.bwQ = 0.0f;
        this.niw = "";
        this.nix = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.niv = " ";
        this.bwQ = 0.0f;
        this.niw = "";
        this.nix = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.niv = " ";
        this.bwQ = 0.0f;
        this.niw = "";
        this.nix = false;
    }

    protected void dOc() {
        this.bwQ = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.niv);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.bwQ < getPaint().measureText(sb2)) {
                break;
            }
            this.nix = true;
            this.niw = sb2;
        }
        setText(this.niw);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.nix) {
            dOc();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        dOc();
    }

    public String getSeperator() {
        return this.niv;
    }

    public void setSeperator(String str) {
        this.niv = str;
    }
}
