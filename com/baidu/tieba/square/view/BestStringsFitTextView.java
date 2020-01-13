package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.android.imsdk.utils.HanziToPinyin;
/* loaded from: classes8.dex */
public class BestStringsFitTextView extends TextView {
    private String kck;
    private float kcl;
    private String kcm;
    private boolean kcn;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.kck = HanziToPinyin.Token.SEPARATOR;
        this.kcl = 0.0f;
        this.kcm = "";
        this.kcn = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kck = HanziToPinyin.Token.SEPARATOR;
        this.kcl = 0.0f;
        this.kcm = "";
        this.kcn = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kck = HanziToPinyin.Token.SEPARATOR;
        this.kcl = 0.0f;
        this.kcm = "";
        this.kcn = false;
    }

    protected void cIp() {
        this.kcl = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.kck);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.kcl < getPaint().measureText(sb2)) {
                break;
            }
            this.kcn = true;
            this.kcm = sb2;
        }
        setText(this.kcm);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.kcn) {
            cIp();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        cIp();
    }

    public String getSeperator() {
        return this.kck;
    }

    public void setSeperator(String str) {
        this.kck = str;
    }
}
