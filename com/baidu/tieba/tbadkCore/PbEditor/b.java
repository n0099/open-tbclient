package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
public class b extends TextView {
    private int aiq;
    private GradientDrawable clF;
    protected int clG;
    protected int clH;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiq = -1;
        this.clG = (int) context.getResources().getDimension(com.baidu.tieba.t.ds18);
        this.clH = (int) context.getResources().getDimension(com.baidu.tieba.t.ds6);
        setPadding(this.clG, this.clH, this.clG, this.clH);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(com.baidu.tieba.t.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(com.baidu.tieba.t.ds48));
    }

    public void tP() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.aiq) {
            this.aiq = skinType;
            rk();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rk() {
        if (this.clF == null) {
            this.clF = new GradientDrawable();
            this.clF.setCornerRadius(getContext().getResources().getDimension(com.baidu.tieba.t.ds24));
        }
        ba.b(this, com.baidu.tieba.s.cp_cont_c, 1);
        this.clF.setColor(ba.getColor(com.baidu.tieba.s.cp_bg_line_e));
        setBackgroundDrawable(this.clF);
    }
}
