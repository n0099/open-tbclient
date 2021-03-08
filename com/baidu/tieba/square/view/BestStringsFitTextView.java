package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes7.dex */
public class BestStringsFitTextView extends TextView {
    private float bBS;
    private String nvI;
    private String nvJ;
    private boolean nvK;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.nvI = " ";
        this.bBS = 0.0f;
        this.nvJ = "";
        this.nvK = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nvI = " ";
        this.bBS = 0.0f;
        this.nvJ = "";
        this.nvK = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nvI = " ";
        this.bBS = 0.0f;
        this.nvJ = "";
        this.nvK = false;
    }

    protected void dME() {
        this.bBS = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.nvI);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.bBS < getPaint().measureText(sb2)) {
                break;
            }
            this.nvK = true;
            this.nvJ = sb2;
        }
        setText(this.nvJ);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.nvK) {
            dME();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        dME();
    }

    public String getSeperator() {
        return this.nvI;
    }

    public void setSeperator(String str) {
        this.nvI = str;
    }
}
