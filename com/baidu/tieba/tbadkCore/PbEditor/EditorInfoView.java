package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class EditorInfoView extends TextView {
    private int aeK;
    private GradientDrawable eWs;
    protected int eWt;
    protected int eWu;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aeK = 3;
        this.eWt = (int) context.getResources().getDimension(u.e.ds18);
        this.eWu = (int) context.getResources().getDimension(u.e.ds6);
        setPadding(this.eWt, this.eWu, this.eWt, this.eWu);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(u.e.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(u.e.ds48));
    }

    public void vm() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.aeK) {
            this.aeK = skinType;
            se();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void se() {
        if (this.eWs == null) {
            this.eWs = new GradientDrawable();
            this.eWs.setCornerRadius(getContext().getResources().getDimension(u.e.ds24));
        }
        av.c(this, u.d.cp_cont_c, 1);
        this.eWs.setColor(av.getColor(u.d.cp_bg_line_e));
    }
}
