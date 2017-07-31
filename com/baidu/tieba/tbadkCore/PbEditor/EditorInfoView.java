package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class EditorInfoView extends TextView {
    private int aql;
    private GradientDrawable ggL;
    protected int ggM;
    protected int ggN;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aql = 3;
        this.ggM = (int) context.getResources().getDimension(d.f.ds18);
        this.ggN = (int) context.getResources().getDimension(d.f.ds6);
        setPadding(this.ggM, this.ggN, this.ggM, this.ggN);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(d.f.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(d.f.ds48));
    }

    public void xd() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aql) {
            this.aql = skinType;
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType() {
        if (this.ggL == null) {
            this.ggL = new GradientDrawable();
            this.ggL.setCornerRadius(getContext().getResources().getDimension(d.f.ds24));
        }
        ai.c(this, d.e.cp_cont_c, 1);
        this.ggL.setColor(ai.getColor(d.e.cp_bg_line_e));
    }
}
