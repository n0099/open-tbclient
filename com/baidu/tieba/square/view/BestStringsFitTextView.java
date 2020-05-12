package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes10.dex */
public class BestStringsFitTextView extends TextView {
    private String kPc;
    private float kPd;
    private String kPe;
    private boolean kPf;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.kPc = " ";
        this.kPd = 0.0f;
        this.kPe = "";
        this.kPf = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kPc = " ";
        this.kPd = 0.0f;
        this.kPe = "";
        this.kPf = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kPc = " ";
        this.kPd = 0.0f;
        this.kPe = "";
        this.kPf = false;
    }

    protected void cVm() {
        this.kPd = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.kPc);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.kPd < getPaint().measureText(sb2)) {
                break;
            }
            this.kPf = true;
            this.kPe = sb2;
        }
        setText(this.kPe);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.kPf) {
            cVm();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        cVm();
    }

    public String getSeperator() {
        return this.kPc;
    }

    public void setSeperator(String str) {
        this.kPc = str;
    }
}
