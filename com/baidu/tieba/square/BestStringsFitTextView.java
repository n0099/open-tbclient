package com.baidu.tieba.square;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes.dex */
public class BestStringsFitTextView extends TextView {
    private String[] VG;
    private boolean bMA;
    private String bMx;
    private float bMy;
    private String bMz;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.bMx = " ";
        this.bMy = 0.0f;
        this.bMz = "";
        this.bMA = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bMx = " ";
        this.bMy = 0.0f;
        this.bMz = "";
        this.bMA = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bMx = " ";
        this.bMy = 0.0f;
        this.bMz = "";
        this.bMA = false;
    }

    protected void ads() {
        this.bMy = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.VG.length; i++) {
            if (i > 0) {
                sb.append(this.bMx);
            }
            sb.append(this.VG[i]);
            String sb2 = sb.toString();
            if (this.bMy < getPaint().measureText(sb2)) {
                break;
            }
            this.bMA = true;
            this.bMz = sb2;
        }
        setText(this.bMz);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.VG != null && !this.bMA) {
            ads();
        }
    }

    public void setTextArray(String[] strArr) {
        this.VG = strArr;
        ads();
    }

    public String getSeperator() {
        return this.bMx;
    }

    public void setSeperator(String str) {
        this.bMx = str;
    }
}
