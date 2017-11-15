package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class EditorInfoView extends TextView {
    private int aph;
    private GradientDrawable gpl;
    protected int gpm;
    protected int gpn;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aph = 3;
        this.gpm = (int) context.getResources().getDimension(d.e.ds18);
        this.gpn = (int) context.getResources().getDimension(d.e.ds6);
        setPadding(this.gpm, this.gpn, this.gpm, this.gpn);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(d.e.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(d.e.ds48));
    }

    public void wB() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aph) {
            this.aph = skinType;
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType() {
        if (this.gpl == null) {
            this.gpl = new GradientDrawable();
            this.gpl.setCornerRadius(getContext().getResources().getDimension(d.e.ds24));
        }
        aj.c(this, d.C0080d.cp_cont_c, 1);
        this.gpl.setColor(aj.getColor(d.C0080d.cp_bg_line_e));
    }
}
