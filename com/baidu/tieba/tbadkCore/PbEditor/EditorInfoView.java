package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class EditorInfoView extends TextView {
    private int arf;
    private GradientDrawable cZF;
    protected int cZG;
    protected int cZH;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.arf = 3;
        this.cZG = (int) context.getResources().getDimension(i.d.ds18);
        this.cZH = (int) context.getResources().getDimension(i.d.ds6);
        setPadding(this.cZG, this.cZH, this.cZG, this.cZH);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(i.d.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(i.d.ds48));
    }

    public void vB() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.arf) {
            this.arf = skinType;
            tc();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tc() {
        if (this.cZF == null) {
            this.cZF = new GradientDrawable();
            this.cZF.setCornerRadius(getContext().getResources().getDimension(i.d.ds24));
        }
        an.b(this, i.c.cp_cont_c, 1);
        this.cZF.setColor(an.getColor(i.c.cp_bg_line_e));
        setBackgroundDrawable(this.cZF);
    }
}
