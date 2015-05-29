package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
public class b extends TextView {
    private int ajy;
    private GradientDrawable cpU;
    protected int cpV;
    protected int cpW;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajy = -1;
        this.cpV = (int) context.getResources().getDimension(com.baidu.tieba.o.ds18);
        this.cpW = (int) context.getResources().getDimension(com.baidu.tieba.o.ds6);
        setPadding(this.cpV, this.cpW, this.cpV, this.cpW);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(com.baidu.tieba.o.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(com.baidu.tieba.o.ds48));
    }

    public void uy() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.ajy) {
            this.ajy = skinType;
            rU();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rU() {
        if (this.cpU == null) {
            this.cpU = new GradientDrawable();
            this.cpU.setCornerRadius(getContext().getResources().getDimension(com.baidu.tieba.o.ds24));
        }
        ay.b(this, com.baidu.tieba.n.cp_cont_c, 1);
        this.cpU.setColor(ay.getColor(com.baidu.tieba.n.cp_bg_line_e));
        setBackgroundDrawable(this.cpU);
    }
}
