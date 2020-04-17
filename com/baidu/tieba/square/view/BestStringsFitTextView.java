package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes10.dex */
public class BestStringsFitTextView extends TextView {
    private String kOY;
    private float kOZ;
    private String kPa;
    private boolean kPb;
    private String[] textArray;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.kOY = " ";
        this.kOZ = 0.0f;
        this.kPa = "";
        this.kPb = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kOY = " ";
        this.kOZ = 0.0f;
        this.kPa = "";
        this.kPb = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kOY = " ";
        this.kOZ = 0.0f;
        this.kPa = "";
        this.kPb = false;
    }

    protected void cVo() {
        this.kOZ = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textArray.length; i++) {
            if (i > 0) {
                sb.append(this.kOY);
            }
            sb.append(this.textArray[i]);
            String sb2 = sb.toString();
            if (this.kOZ < getPaint().measureText(sb2)) {
                break;
            }
            this.kPb = true;
            this.kPa = sb2;
        }
        setText(this.kPa);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.textArray != null && !this.kPb) {
            cVo();
        }
    }

    public void setTextArray(String[] strArr) {
        this.textArray = strArr;
        cVo();
    }

    public String getSeperator() {
        return this.kOY;
    }

    public void setSeperator(String str) {
        this.kOY = str;
    }
}
