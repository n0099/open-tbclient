package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class BestStringsFitTextView extends TextView {
    private String[] cvQ;
    private String iVG;
    private float iVH;
    private String iVI;
    private boolean iVJ;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.iVG = " ";
        this.iVH = 0.0f;
        this.iVI = "";
        this.iVJ = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iVG = " ";
        this.iVH = 0.0f;
        this.iVI = "";
        this.iVJ = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iVG = " ";
        this.iVH = 0.0f;
        this.iVI = "";
        this.iVJ = false;
    }

    protected void clt() {
        this.iVH = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.cvQ.length; i++) {
            if (i > 0) {
                sb.append(this.iVG);
            }
            sb.append(this.cvQ[i]);
            String sb2 = sb.toString();
            if (this.iVH < getPaint().measureText(sb2)) {
                break;
            }
            this.iVJ = true;
            this.iVI = sb2;
        }
        setText(this.iVI);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cvQ != null && !this.iVJ) {
            clt();
        }
    }

    public void setTextArray(String[] strArr) {
        this.cvQ = strArr;
        clt();
    }

    public String getSeperator() {
        return this.iVG;
    }

    public void setSeperator(String str) {
        this.iVG = str;
    }
}
