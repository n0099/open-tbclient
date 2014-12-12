package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class l extends TextView {
    private int XE;
    protected int bTA;
    protected int bTB;
    private GradientDrawable bTz;

    public l(Context context) {
        this(context, null);
    }

    public l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public l(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.XE = -1;
        this.bTA = (int) context.getResources().getDimension(com.baidu.tieba.u.ds12);
        this.bTB = (int) context.getResources().getDimension(com.baidu.tieba.u.ds6);
        setPadding(this.bTA, this.bTB, this.bTA, this.bTB);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(com.baidu.tieba.u.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(com.baidu.tieba.u.ds48));
    }

    public void qA() {
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        if (skinType != this.XE) {
            this.XE = skinType;
            wc();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wc() {
        if (this.bTz == null) {
            this.bTz = new GradientDrawable();
            this.bTz.setCornerRadius(getContext().getResources().getDimension(com.baidu.tieba.u.ds24));
        }
        com.baidu.tbadk.core.util.ax.b(this, com.baidu.tieba.t.cp_cont_c, 1);
        this.bTz.setColor(com.baidu.tbadk.core.util.ax.getColor(com.baidu.tieba.t.cp_bg_line_e));
        setBackgroundDrawable(this.bTz);
    }
}
