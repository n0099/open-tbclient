package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class EditorInfoView extends TextView {
    private int amZ;
    private GradientDrawable fuN;
    protected int fuO;
    protected int fuP;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amZ = 3;
        this.fuO = (int) context.getResources().getDimension(w.f.ds18);
        this.fuP = (int) context.getResources().getDimension(w.f.ds6);
        setPadding(this.fuO, this.fuP, this.fuO, this.fuP);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(w.f.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(w.f.ds48));
    }

    public void xl() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.amZ) {
            this.amZ = skinType;
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType() {
        if (this.fuN == null) {
            this.fuN = new GradientDrawable();
            this.fuN.setCornerRadius(getContext().getResources().getDimension(w.f.ds24));
        }
        aq.c(this, w.e.cp_cont_c, 1);
        this.fuN.setColor(aq.getColor(w.e.cp_bg_line_e));
    }
}
