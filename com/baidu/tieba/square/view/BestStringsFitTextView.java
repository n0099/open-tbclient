package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class BestStringsFitTextView extends TextView {
    private String[] cxf;
    private String jbW;
    private float jbX;
    private String jbY;
    private boolean jbZ;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.jbW = " ";
        this.jbX = 0.0f;
        this.jbY = "";
        this.jbZ = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jbW = " ";
        this.jbX = 0.0f;
        this.jbY = "";
        this.jbZ = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jbW = " ";
        this.jbX = 0.0f;
        this.jbY = "";
        this.jbZ = false;
    }

    protected void col() {
        this.jbX = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.cxf.length; i++) {
            if (i > 0) {
                sb.append(this.jbW);
            }
            sb.append(this.cxf[i]);
            String sb2 = sb.toString();
            if (this.jbX < getPaint().measureText(sb2)) {
                break;
            }
            this.jbZ = true;
            this.jbY = sb2;
        }
        setText(this.jbY);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cxf != null && !this.jbZ) {
            col();
        }
    }

    public void setTextArray(String[] strArr) {
        this.cxf = strArr;
        col();
    }

    public String getSeperator() {
        return this.jbW;
    }

    public void setSeperator(String str) {
        this.jbW = str;
    }
}
