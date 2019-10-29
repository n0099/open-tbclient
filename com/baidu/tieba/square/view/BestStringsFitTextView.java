package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.android.imsdk.utils.HanziToPinyin;
/* loaded from: classes5.dex */
public class BestStringsFitTextView extends TextView {
    private String jfm;
    private float jfn;
    private String jfo;
    private boolean jfp;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.jfm = HanziToPinyin.Token.SEPARATOR;
        this.jfn = 0.0f;
        this.jfo = "";
        this.jfp = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jfm = HanziToPinyin.Token.SEPARATOR;
        this.jfn = 0.0f;
        this.jfo = "";
        this.jfp = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jfm = HanziToPinyin.Token.SEPARATOR;
        this.jfn = 0.0f;
        this.jfo = "";
        this.jfp = false;
    }

    protected void cnh() {
        this.jfn = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.jfm);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.jfn < getPaint().measureText(sb2)) {
                break;
            }
            this.jfp = true;
            this.jfo = sb2;
        }
        setText(this.jfo);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.jfp) {
            cnh();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        cnh();
    }

    public String getSeperator() {
        return this.jfm;
    }

    public void setSeperator(String str) {
        this.jfm = str;
    }
}
