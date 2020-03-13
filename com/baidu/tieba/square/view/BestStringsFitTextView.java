package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.android.imsdk.utils.HanziToPinyin;
/* loaded from: classes10.dex */
public class BestStringsFitTextView extends TextView {
    private String kdC;
    private float kdD;
    private String kdE;
    private boolean kdF;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.kdC = HanziToPinyin.Token.SEPARATOR;
        this.kdD = 0.0f;
        this.kdE = "";
        this.kdF = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kdC = HanziToPinyin.Token.SEPARATOR;
        this.kdD = 0.0f;
        this.kdE = "";
        this.kdF = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kdC = HanziToPinyin.Token.SEPARATOR;
        this.kdD = 0.0f;
        this.kdE = "";
        this.kdF = false;
    }

    protected void cJY() {
        this.kdD = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.kdC);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.kdD < getPaint().measureText(sb2)) {
                break;
            }
            this.kdF = true;
            this.kdE = sb2;
        }
        setText(this.kdE);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.kdF) {
            cJY();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        cJY();
    }

    public String getSeperator() {
        return this.kdC;
    }

    public void setSeperator(String str) {
        this.kdC = str;
    }
}
