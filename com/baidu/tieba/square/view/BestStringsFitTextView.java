package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.android.imsdk.utils.HanziToPinyin;
/* loaded from: classes10.dex */
public class BestStringsFitTextView extends TextView {
    private String kff;
    private float kfg;
    private String kfh;
    private boolean kfi;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.kff = HanziToPinyin.Token.SEPARATOR;
        this.kfg = 0.0f;
        this.kfh = "";
        this.kfi = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kff = HanziToPinyin.Token.SEPARATOR;
        this.kfg = 0.0f;
        this.kfh = "";
        this.kfi = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kff = HanziToPinyin.Token.SEPARATOR;
        this.kfg = 0.0f;
        this.kfh = "";
        this.kfi = false;
    }

    protected void cKs() {
        this.kfg = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.kff);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.kfg < getPaint().measureText(sb2)) {
                break;
            }
            this.kfi = true;
            this.kfh = sb2;
        }
        setText(this.kfh);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.kfi) {
            cKs();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        cKs();
    }

    public String getSeperator() {
        return this.kff;
    }

    public void setSeperator(String str) {
        this.kff = str;
    }
}
