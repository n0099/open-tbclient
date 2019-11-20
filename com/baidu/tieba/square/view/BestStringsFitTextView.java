package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.android.imsdk.utils.HanziToPinyin;
/* loaded from: classes5.dex */
public class BestStringsFitTextView extends TextView {
    private String jev;
    private float jew;
    private String jex;
    private boolean jey;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.jev = HanziToPinyin.Token.SEPARATOR;
        this.jew = 0.0f;
        this.jex = "";
        this.jey = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jev = HanziToPinyin.Token.SEPARATOR;
        this.jew = 0.0f;
        this.jex = "";
        this.jey = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jev = HanziToPinyin.Token.SEPARATOR;
        this.jew = 0.0f;
        this.jex = "";
        this.jey = false;
    }

    protected void cnf() {
        this.jew = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.jev);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.jew < getPaint().measureText(sb2)) {
                break;
            }
            this.jey = true;
            this.jex = sb2;
        }
        setText(this.jex);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.jey) {
            cnf();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        cnf();
    }

    public String getSeperator() {
        return this.jev;
    }

    public void setSeperator(String str) {
        this.jev = str;
    }
}
