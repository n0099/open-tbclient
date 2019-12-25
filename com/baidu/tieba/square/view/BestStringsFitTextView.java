package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.android.imsdk.utils.HanziToPinyin;
/* loaded from: classes7.dex */
public class BestStringsFitTextView extends TextView {
    private String jYH;
    private float jYI;
    private String jYJ;
    private boolean jYK;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.jYH = HanziToPinyin.Token.SEPARATOR;
        this.jYI = 0.0f;
        this.jYJ = "";
        this.jYK = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jYH = HanziToPinyin.Token.SEPARATOR;
        this.jYI = 0.0f;
        this.jYJ = "";
        this.jYK = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jYH = HanziToPinyin.Token.SEPARATOR;
        this.jYI = 0.0f;
        this.jYJ = "";
        this.jYK = false;
    }

    protected void cHl() {
        this.jYI = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.jYH);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.jYI < getPaint().measureText(sb2)) {
                break;
            }
            this.jYK = true;
            this.jYJ = sb2;
        }
        setText(this.jYJ);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.jYK) {
            cHl();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        cHl();
    }

    public String getSeperator() {
        return this.jYH;
    }

    public void setSeperator(String str) {
        this.jYH = str;
    }
}
