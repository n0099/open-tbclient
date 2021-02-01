package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes8.dex */
public class BestStringsFitTextView extends TextView {
    private float bAs;
    private String ntd;
    private String nte;
    private boolean ntf;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.ntd = " ";
        this.bAs = 0.0f;
        this.nte = "";
        this.ntf = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ntd = " ";
        this.bAs = 0.0f;
        this.nte = "";
        this.ntf = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ntd = " ";
        this.bAs = 0.0f;
        this.nte = "";
        this.ntf = false;
    }

    protected void dMo() {
        this.bAs = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.ntd);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.bAs < getPaint().measureText(sb2)) {
                break;
            }
            this.ntf = true;
            this.nte = sb2;
        }
        setText(this.nte);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.ntf) {
            dMo();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        dMo();
    }

    public String getSeperator() {
        return this.ntd;
    }

    public void setSeperator(String str) {
        this.ntd = str;
    }
}
