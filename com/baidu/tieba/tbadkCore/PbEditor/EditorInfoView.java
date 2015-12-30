package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class EditorInfoView extends TextView {
    private int ahf;
    private GradientDrawable dFN;
    protected int dFO;
    protected int dFP;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ahf = 3;
        this.dFO = (int) context.getResources().getDimension(n.e.ds18);
        this.dFP = (int) context.getResources().getDimension(n.e.ds6);
        setPadding(this.dFO, this.dFP, this.dFO, this.dFP);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(n.e.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(n.e.ds48));
    }

    public void vR() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.ahf) {
            this.ahf = skinType;
            tr();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tr() {
        if (this.dFN == null) {
            this.dFN = new GradientDrawable();
            this.dFN.setCornerRadius(getContext().getResources().getDimension(n.e.ds24));
        }
        as.b(this, n.d.cp_cont_c, 1);
        this.dFN.setColor(as.getColor(n.d.cp_bg_line_e));
        setBackgroundDrawable(this.dFN);
    }
}
