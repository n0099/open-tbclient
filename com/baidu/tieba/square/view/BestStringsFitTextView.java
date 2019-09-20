package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class BestStringsFitTextView extends TextView {
    private String[] cyi;
    private String jfv;
    private float jfw;
    private String jfx;
    private boolean jfy;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.jfv = " ";
        this.jfw = 0.0f;
        this.jfx = "";
        this.jfy = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jfv = " ";
        this.jfw = 0.0f;
        this.jfx = "";
        this.jfy = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jfv = " ";
        this.jfw = 0.0f;
        this.jfx = "";
        this.jfy = false;
    }

    protected void cpq() {
        this.jfw = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.cyi.length; i++) {
            if (i > 0) {
                sb.append(this.jfv);
            }
            sb.append(this.cyi[i]);
            String sb2 = sb.toString();
            if (this.jfw < getPaint().measureText(sb2)) {
                break;
            }
            this.jfy = true;
            this.jfx = sb2;
        }
        setText(this.jfx);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cyi != null && !this.jfy) {
            cpq();
        }
    }

    public void setTextArray(String[] strArr) {
        this.cyi = strArr;
        cpq();
    }

    public String getSeperator() {
        return this.jfv;
    }

    public void setSeperator(String str) {
        this.jfv = str;
    }
}
