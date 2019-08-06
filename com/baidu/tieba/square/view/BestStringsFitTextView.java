package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class BestStringsFitTextView extends TextView {
    private String[] cxm;
    private String jda;
    private float jdb;
    private String jdc;
    private boolean jdd;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.jda = " ";
        this.jdb = 0.0f;
        this.jdc = "";
        this.jdd = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jda = " ";
        this.jdb = 0.0f;
        this.jdc = "";
        this.jdd = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jda = " ";
        this.jdb = 0.0f;
        this.jdc = "";
        this.jdd = false;
    }

    protected void coD() {
        this.jdb = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.cxm.length; i++) {
            if (i > 0) {
                sb.append(this.jda);
            }
            sb.append(this.cxm[i]);
            String sb2 = sb.toString();
            if (this.jdb < getPaint().measureText(sb2)) {
                break;
            }
            this.jdd = true;
            this.jdc = sb2;
        }
        setText(this.jdc);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cxm != null && !this.jdd) {
            coD();
        }
    }

    public void setTextArray(String[] strArr) {
        this.cxm = strArr;
        coD();
    }

    public String getSeperator() {
        return this.jda;
    }

    public void setSeperator(String str) {
        this.jda = str;
    }
}
