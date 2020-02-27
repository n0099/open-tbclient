package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.android.imsdk.utils.HanziToPinyin;
/* loaded from: classes10.dex */
public class BestStringsFitTextView extends TextView {
    private String kdo;
    private float kdp;
    private String kdq;
    private boolean kdr;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.kdo = HanziToPinyin.Token.SEPARATOR;
        this.kdp = 0.0f;
        this.kdq = "";
        this.kdr = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kdo = HanziToPinyin.Token.SEPARATOR;
        this.kdp = 0.0f;
        this.kdq = "";
        this.kdr = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kdo = HanziToPinyin.Token.SEPARATOR;
        this.kdp = 0.0f;
        this.kdq = "";
        this.kdr = false;
    }

    protected void cJV() {
        this.kdp = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.kdo);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.kdp < getPaint().measureText(sb2)) {
                break;
            }
            this.kdr = true;
            this.kdq = sb2;
        }
        setText(this.kdq);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.kdr) {
            cJV();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        cJV();
    }

    public String getSeperator() {
        return this.kdo;
    }

    public void setSeperator(String str) {
        this.kdo = str;
    }
}
