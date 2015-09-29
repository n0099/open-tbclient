package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class EditorInfoView extends TextView {
    private int apR;
    private GradientDrawable cXI;
    protected int cXJ;
    protected int cXK;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.apR = 3;
        this.cXJ = (int) context.getResources().getDimension(i.d.ds18);
        this.cXK = (int) context.getResources().getDimension(i.d.ds6);
        setPadding(this.cXJ, this.cXK, this.cXJ, this.cXK);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(i.d.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(i.d.ds48));
    }

    public void vA() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.apR) {
            this.apR = skinType;
            tc();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tc() {
        if (this.cXI == null) {
            this.cXI = new GradientDrawable();
            this.cXI.setCornerRadius(getContext().getResources().getDimension(i.d.ds24));
        }
        am.b(this, i.c.cp_cont_c, 1);
        this.cXI.setColor(am.getColor(i.c.cp_bg_line_e));
        setBackgroundDrawable(this.cXI);
    }
}
