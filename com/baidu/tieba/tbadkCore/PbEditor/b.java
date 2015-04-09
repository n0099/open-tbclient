package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
public class b extends TextView {
    private int aiy;
    private GradientDrawable clV;
    protected int clW;
    protected int clX;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiy = -1;
        this.clW = (int) context.getResources().getDimension(com.baidu.tieba.t.ds18);
        this.clX = (int) context.getResources().getDimension(com.baidu.tieba.t.ds6);
        setPadding(this.clW, this.clX, this.clW, this.clX);
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
        if (skinType != this.aiy) {
            this.aiy = skinType;
            rk();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rk() {
        if (this.clV == null) {
            this.clV = new GradientDrawable();
            this.clV.setCornerRadius(getContext().getResources().getDimension(com.baidu.tieba.t.ds24));
        }
        ba.b(this, com.baidu.tieba.s.cp_cont_c, 1);
        this.clV.setColor(ba.getColor(com.baidu.tieba.s.cp_bg_line_e));
        setBackgroundDrawable(this.clV);
    }
}
