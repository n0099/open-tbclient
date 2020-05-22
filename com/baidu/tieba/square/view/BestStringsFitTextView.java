package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes10.dex */
public class BestStringsFitTextView extends TextView {
    private String lhs;
    private float lht;
    private String lhu;
    private boolean lhv;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.lhs = " ";
        this.lht = 0.0f;
        this.lhu = "";
        this.lhv = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lhs = " ";
        this.lht = 0.0f;
        this.lhu = "";
        this.lhv = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lhs = " ";
        this.lht = 0.0f;
        this.lhu = "";
        this.lhv = false;
    }

    protected void dcq() {
        this.lht = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.lhs);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.lht < getPaint().measureText(sb2)) {
                break;
            }
            this.lhv = true;
            this.lhu = sb2;
        }
        setText(this.lhu);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.lhv) {
            dcq();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        dcq();
    }

    public String getSeperator() {
        return this.lhs;
    }

    public void setSeperator(String str) {
        this.lhs = str;
    }
}
