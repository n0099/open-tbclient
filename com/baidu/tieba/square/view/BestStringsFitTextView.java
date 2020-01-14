package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.android.imsdk.utils.HanziToPinyin;
/* loaded from: classes8.dex */
public class BestStringsFitTextView extends TextView {
    private String kcp;
    private float kcq;
    private String kcr;
    private boolean kcs;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.kcp = HanziToPinyin.Token.SEPARATOR;
        this.kcq = 0.0f;
        this.kcr = "";
        this.kcs = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kcp = HanziToPinyin.Token.SEPARATOR;
        this.kcq = 0.0f;
        this.kcr = "";
        this.kcs = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kcp = HanziToPinyin.Token.SEPARATOR;
        this.kcq = 0.0f;
        this.kcr = "";
        this.kcs = false;
    }

    protected void cIr() {
        this.kcq = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.kcp);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.kcq < getPaint().measureText(sb2)) {
                break;
            }
            this.kcs = true;
            this.kcr = sb2;
        }
        setText(this.kcr);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.kcs) {
            cIr();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        cIr();
    }

    public String getSeperator() {
        return this.kcp;
    }

    public void setSeperator(String str) {
        this.kcp = str;
    }
}
