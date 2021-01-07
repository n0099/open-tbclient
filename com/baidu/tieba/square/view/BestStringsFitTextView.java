package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes8.dex */
public class BestStringsFitTextView extends TextView {
    private float bBB;
    private String nnZ;
    private String noa;
    private boolean nob;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.nnZ = " ";
        this.bBB = 0.0f;
        this.noa = "";
        this.nob = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nnZ = " ";
        this.bBB = 0.0f;
        this.noa = "";
        this.nob = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nnZ = " ";
        this.bBB = 0.0f;
        this.noa = "";
        this.nob = false;
    }

    protected void dNV() {
        this.bBB = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.nnZ);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.bBB < getPaint().measureText(sb2)) {
                break;
            }
            this.nob = true;
            this.noa = sb2;
        }
        setText(this.noa);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.nob) {
            dNV();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        dNV();
    }

    public String getSeperator() {
        return this.nnZ;
    }

    public void setSeperator(String str) {
        this.nnZ = str;
    }
}
