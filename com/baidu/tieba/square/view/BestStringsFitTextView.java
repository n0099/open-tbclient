package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes23.dex */
public class BestStringsFitTextView extends TextView {
    private float bqi;
    private String mAN;
    private String mAO;
    private boolean mAP;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.mAN = " ";
        this.bqi = 0.0f;
        this.mAO = "";
        this.mAP = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAN = " ";
        this.bqi = 0.0f;
        this.mAO = "";
        this.mAP = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAN = " ";
        this.bqi = 0.0f;
        this.mAO = "";
        this.mAP = false;
    }

    protected void dDk() {
        this.bqi = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.mAN);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.bqi < getPaint().measureText(sb2)) {
                break;
            }
            this.mAP = true;
            this.mAO = sb2;
        }
        setText(this.mAO);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.mAP) {
            dDk();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        dDk();
    }

    public String getSeperator() {
        return this.mAN;
    }

    public void setSeperator(String str) {
        this.mAN = str;
    }
}
