package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.android.imsdk.utils.HanziToPinyin;
/* loaded from: classes10.dex */
public class BestStringsFitTextView extends TextView {
    private String kdq;
    private float kdr;
    private String kds;
    private boolean kdt;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.kdq = HanziToPinyin.Token.SEPARATOR;
        this.kdr = 0.0f;
        this.kds = "";
        this.kdt = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kdq = HanziToPinyin.Token.SEPARATOR;
        this.kdr = 0.0f;
        this.kds = "";
        this.kdt = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kdq = HanziToPinyin.Token.SEPARATOR;
        this.kdr = 0.0f;
        this.kds = "";
        this.kdt = false;
    }

    protected void cJX() {
        this.kdr = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.kdq);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.kdr < getPaint().measureText(sb2)) {
                break;
            }
            this.kdt = true;
            this.kds = sb2;
        }
        setText(this.kds);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.kdt) {
            cJX();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        cJX();
    }

    public String getSeperator() {
        return this.kdq;
    }

    public void setSeperator(String str) {
        this.kdq = str;
    }
}
