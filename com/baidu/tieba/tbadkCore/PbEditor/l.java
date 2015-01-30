package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
public class l extends TextView {
    private int Yk;
    private GradientDrawable bVr;
    protected int bVs;
    protected int bVt;

    public l(Context context) {
        this(context, null);
    }

    public l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public l(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Yk = -1;
        this.bVs = (int) context.getResources().getDimension(com.baidu.tieba.u.ds12);
        this.bVt = (int) context.getResources().getDimension(com.baidu.tieba.u.ds6);
        setPadding(this.bVs, this.bVt, this.bVs, this.bVt);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(com.baidu.tieba.u.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(com.baidu.tieba.u.ds48));
    }

    public void qL() {
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        if (skinType != this.Yk) {
            this.Yk = skinType;
            wu();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wu() {
        if (this.bVr == null) {
            this.bVr = new GradientDrawable();
            this.bVr.setCornerRadius(getContext().getResources().getDimension(com.baidu.tieba.u.ds24));
        }
        bc.b(this, com.baidu.tieba.t.cp_cont_c, 1);
        this.bVr.setColor(bc.getColor(com.baidu.tieba.t.cp_bg_line_e));
        setBackgroundDrawable(this.bVr);
    }
}
